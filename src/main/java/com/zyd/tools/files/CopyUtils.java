package com.zyd.tools.files;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @description:
 * @projectName:MyTool
 * @see:com.zyd.tools.files
 * @author:张屹东
 * @createTime:2020/9/28 21:03
 */
public class CopyUtils {
    /**
     * 文件拷贝
     *
     * @param sourceFile 源文件路径
     * @param destFile   目标路径
     * @throws IOException
     */
    public static void copyFolder(File sourceFile, File destFile) throws IOException {
        //Files.copy是jdk7新特性
        //Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        //FileChannel性能是Stream的2~10倍
        //较小文件copy时FileChannel性能最佳，较大文件copy时Files.copy性能最佳，但是相差不大
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(sourceFile).getChannel();
            destChannel = new FileOutputStream(destFile).getChannel();
            destChannel.transferFrom(sourceChannel, 0, Long.MAX_VALUE);
        } finally {
            IOUtils.close(sourceChannel);
            IOUtils.close(destChannel);
        }
    }
}
