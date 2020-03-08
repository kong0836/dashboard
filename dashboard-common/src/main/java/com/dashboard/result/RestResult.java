package com.dashboard.result;

import com.dashboard.enums.RestResultEnum;

import java.io.Serializable;

/**
 * @author konglinghui
 * @description rest请求返回结果集
 * @date 2019/9/4 11:21
 **/
public final class RestResult<T> implements Serializable {

    private static final long serialVersionUID = -2888723113850871991L;

    /**
     * 结果
     */
    private String code;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 私有构造，防止被实例化
     */
    private RestResult() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 成功
     *
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> success() {
        return success(null);
    }

    /**
     * 成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> success(T data) {
        RestResult result = new RestResult();
        result.setCode(RestResultEnum.SUCCESS.getCode());
        result.setMessage(RestResultEnum.SUCCESS.getMessage());
        result.setData(data);

        return result;
    }

    /**
     * 失败
     *
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> fail() {
        return fail(RestResultEnum.FAIL);
    }

    /**
     * 失败
     *
     * @param resultEnum
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> fail(RestResultEnum resultEnum) {
        RestResult result = new RestResult();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());

        return result;
    }
}
