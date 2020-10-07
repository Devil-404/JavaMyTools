package com.zyd.tools.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @description:
 * @projectName:MyTool
 * @see:com.zyd.tools.files
 * @author:张屹东
 * @createTime:2020/9/29 20:04
 */
public class FileUtils {
    public static InputStream getResourcesFileInputStream(String path) throws FileNotFoundException {
        return new FileInputStream(path);
    }

    public static File getFile(String path) {
        return new File(path);
    }
}
