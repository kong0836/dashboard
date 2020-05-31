package com.dashboard.service.impl.analysis;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.date.DateTimeUtils;
import com.dashboard.entity.analysis.AccountTotal;
import com.dashboard.entity.analysis.vo.AccountAnalysisVO;
import com.dashboard.enums.account.AccountCategoryTypeEnum;
import com.dashboard.enums.analysis.AnalysisTypeEnum;
import com.dashboard.mapper.analysis.AccountTotalMapper;
import com.dashboard.service.analysis.AccountTotalService;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.LegendType;
import com.github.abel533.echarts.code.PointerType;
import com.github.abel533.echarts.code.Position;
import com.github.abel533.echarts.code.SeriesType;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.series.Bar;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author konglinghui
 * @description 消费汇总服务
 * @date 2020/5/22 19:13
 **/
@Service
public class AccountTotalServiceImpl implements AccountTotalService {

    @Autowired
    private AccountTotalMapper accountTotalMapper;

    @Override
    public Option findAccountTotal(AccountAnalysisVO accountAnalysisVO) {
        Condition condition = new Condition(AccountTotal.class);
        Example.Criteria criteria = condition.createCriteria();
        if (AnalysisTypeEnum.CURRENT_MONTH.getType().equals(accountAnalysisVO.getType())) {
            criteria.andBetween("consumerDate",
                    DateTimeUtils.getFirstDayOfThisMonth(),
                    DateTimeUtils.getLastDayOfThisMonth());
        }
        condition.orderBy("consumerDate");

        List<AccountTotal> accountTotalList = accountTotalMapper.selectByCondition(condition);

        // 组装echarts显示数据
        Option option = this.buildGsonOption(accountTotalList);

        return option;
    }

    /**
     * 组装echarts显示数据
     *
     * @param accountTotalList
     * @return
     */
    private Option buildGsonOption(List<AccountTotal> accountTotalList) {
        Option option = new Option();
        option.tooltip().trigger(Trigger.axis).axisPointer().type(PointerType.line);
        option.legend().type(LegendType.plain).data("利润", "支出", "收入");
        option.grid().left("3%").right("4%").bottom("3%").containLabel(true);

        // x轴坐标数据
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.axisTick().show(false);
        List<String> consumerDateList = accountTotalList.stream()
                .map(accountTotal -> DateTimeUtils.timestampToString(accountTotal.getConsumerDate()))
                .distinct()
                .collect(Collectors.toList());
        consumerDateList.forEach(categoryAxis::data);
        option.xAxis(categoryAxis);

        // y轴坐标数据
        option.yAxis(new ValueAxis());

        // series
        // 收入
        Bar incomeBar = new Bar();
        incomeBar.name("收入").type(SeriesType.bar).stack("总量");
        incomeBar.label().normal().show(true);
        List<BigDecimal> incomeAmountList = accountTotalList.stream()
                .filter(accountTotal -> AccountCategoryTypeEnum.IN.getType().equals(accountTotal.getType()))
                .map(AccountTotal::getAmount)
                .collect(Collectors.toList());
        incomeAmountList.forEach(incomeBar::data);

        // 支出
        Bar expensesBar = new Bar();
        expensesBar.name("支出").type(SeriesType.bar).stack("总量");
        expensesBar.label().normal().show(true).position(Position.left);
        List<BigDecimal> expensesAmountList = accountTotalList.stream()
                .filter(accountTotal -> AccountCategoryTypeEnum.OUT.getType().equals(accountTotal.getType()))
                .map(accountTotal -> accountTotal.getAmount().negate())
                .collect(Collectors.toList());
        expensesAmountList.forEach(expensesBar::data);

        // 利润
        Bar interestBar = new Bar();
        interestBar.name("利润").type(SeriesType.bar);
        interestBar.label().normal().show(true).position(Position.inside);
        List<BigDecimal> interestAmountList = new ArrayList<>();
        for (int i = 0; i < incomeAmountList.size(); i++) {
            BigDecimal interestAmount = incomeAmountList.get(i).add(expensesAmountList.get(i));
            interestAmountList.add(interestAmount);
        }
        interestAmountList.forEach(interestBar::data);

        option.series(interestBar, incomeBar, expensesBar);

        return option;
    }
}
