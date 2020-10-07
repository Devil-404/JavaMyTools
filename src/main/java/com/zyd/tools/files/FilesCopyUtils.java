package com.zyd.tools.files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @description:批量获取源文件夹以及子文件夹下的.zip或.rar文件拷贝到目标文件夹
 * @projectName:MyTool
 * @see:com.zyd.tool
 * @author:张屹东
 * @createTime:2020/9/26 10:22
 */

public class FilesCopyUtils {

    //源文件夹地址
    private String path;
    //目标文件夹地址
    private String destPath;
    //文件类型，如：.zip或者.zip|.rar等
    private String fileType;
    //文件夹数量
    private int folderNum;
    //复制的文件数量
    private int fileNum;
    //记录被移动的文件
    private final List<File> list = new ArrayList<>();

    public FilesCopyUtils() {
        super();
    }

    public FilesCopyUtils(String path, String destPath, String fileType) {
        this.path = path;
        this.destPath = destPath;
        this.fileType = fileType;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public int getFolderNum() {
        return folderNum;
    }

    public int getFileNum() {
        return fileNum;
    }

    /**
     * 遍历文件夹和文件并拷贝的方法
     */
    public List<File> traverseFolder() throws IOException {
        File file = new File(this.path);
        if (file.exists()) {
            LinkedList<File> tempList = new LinkedList<>();
            File[] files = file.listFiles();
            assert files != null;
            forFile(files, tempList);
            File temp_file;
            while (!tempList.isEmpty()) {
                temp_file = tempList.removeFirst();
                files = temp_file.listFiles();
                assert files != null;
                forFile(files, tempList);
            }
        }
        return this.list;
    }


    /**
     * 遍历文件夹和文件并拷贝到目标目录，为traverseFolder()服务
     *
     * @param files 需要遍历的文件数组
     * @param list  记录文件数量
     * @throws IOException
     */
    private void forFile(File[] files, LinkedList<File> list) throws IOException {
        int folderNum, fileNum;
        String reg = ".+(" + this.fileType + ")$";
        for (File file : files) {
            if (file.isDirectory()) {
                list.add(file);
                this.folderNum++;
            } else if (Pattern.compile(reg).matcher(file.getName().toLowerCase()).find() &&
                    !file.getParent().equals(this.destPath)) {
                File destFile = new File(this.destPath + "\\" + file.getName());
                CopyUtils.copyFolder(file, destFile);
                this.list.add(destFile);
                this.fileNum++;
            }
        }
    }


}
