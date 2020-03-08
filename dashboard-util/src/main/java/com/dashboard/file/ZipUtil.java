package com.dashboard.file;

import com.google.common.io.Files;
import org.apache.commons.lang3.StringUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @author konglinghui
 * @description zip文件压缩工具
 * @date 2019/12/17 10:15
 **/
public final class ZipUtil {

    public static final Logger LOGGER = LoggerFactory.getLogger(ZipUtil.class);

    private ZipUtil() {
    }

    /**
     * 压缩文件或文件夹
     *
     * @param srcFile 源文件
     */
    public static File zip(File srcFile) throws IOException {
        // 创建临时压缩文件
        File tempDir = Files.createTempDir();
        File destFile = new File(tempDir, UUID.randomUUID() + "." + "zip");
        return zip(srcFile, destFile);
    }

    /**
     * 压缩文件或文件夹
     *
     * @param srcFile  源文件
     * @param destFile 目标文件
     * @throws IOException
     */
    public static File zip(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists() || !destFile.exists()) {
            throw new IOException();
        }

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(destFile))) {
            // 设置文件编码
            zipOutputStream.setEncoding(StandardCharsets.UTF_8.name());
            zip(srcFile, zipOutputStream);
        } catch (IOException e) {
            LOGGER.info("文件压缩失败：{}", e.getMessage());
            throw new IOException();
        }

        return destFile;
    }

    /**
     * 压缩文件或文件夹
     *
     * @param srcFile         源文件
     * @param zipOutputStream 目标文件
     */
    private static void zip(File srcFile, ZipOutputStream zipOutputStream) throws IOException {
        if (srcFile.isDirectory()) {
            zipDir(srcFile, null, zipOutputStream);
        } else if (srcFile.isFile()) {
            zipFile(srcFile, zipOutputStream);
        }
    }

    /**
     * 压缩文件夹
     *
     * @param srcFile         源文件
     * @param dir
     * @param zipOutputStream 目标文件
     */
    private static void zipDir(File srcFile, String dir, ZipOutputStream zipOutputStream)
            throws IOException {
        File[] listFiles = srcFile.listFiles();
        assert listFiles != null;
        for (File file : listFiles) {
            String fileName = file.getName();
            if (StringUtils.isNotBlank(dir)) {
                fileName = dir + "/" + fileName;
            }
            if (file.isDirectory()) {
                zipDir(file, fileName, zipOutputStream);
            } else {
                zipOutputStream.putNextEntry(new ZipEntry(fileName));
                zipFile(file, zipOutputStream);
            }
        }
    }

    /**
     * 压缩文件
     *
     * @param srcFile         源文件
     * @param zipOutputStream 输出流
     * @throws IOException
     */
    private static void zipFile(File srcFile, ZipOutputStream zipOutputStream) throws IOException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFile))) {
            int len;
            byte[] bytes = new byte[2048];
            while ((len = bufferedInputStream.read(bytes)) > 0) {
                zipOutputStream.write(bytes, 0, len);
                zipOutputStream.flush();
            }
        } catch (IOException e) {
            LOGGER.info("压缩文件异常:{}", e.getMessage());
            throw new IOException();
        }
    }

    public static void main(String[] args) {
        String tmpDir = System.getProperty("java.io.tmpDir");
        System.out.println(tmpDir);
    }
}
