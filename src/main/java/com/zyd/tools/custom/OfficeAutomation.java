package com.zyd.tools.custom;

import com.zyd.tools.custom.mode.OfficeAutomationMode;
import com.zyd.tools.excel.ExcelUtilsV2;
import com.zyd.tools.files.FilesCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @description:自动化办公（自动操作Excel）
 * @projectName:MyTool
 * @see:com.zyd.tools.custom
 * @author:张屹东
 * @createTime:2020/10/6 18:54
 */
public class OfficeAutomation {

    /**
     * 根据File数组对目标Excel进行相关操作，实现自动化办公
     *
     * @param mode 参数模型
     * @throws IOException
     */
    public void automaticMarkingHomework(OfficeAutomationMode mode) throws IOException {
        //assert过滤中断
        assert mode.getExcelDestPath() != null;
        assert mode.getExcelSourcePath() != null;
        assert mode.getSourcePath() != null;
        assert mode.getDestPath() != null;
        assert mode.getExceptionNumber() != 0;
        assert mode.getAddString() != null;
        //判断文件夹或者文件是否存在
        try {
            System.out.print("\033[1;95m");
            System.out.println(mode.getSourcePath() + "状态码: " + isFolderExist(new File(mode.getSourcePath())));
            System.out.println(mode.getDestPath() + "状态码: " + isFolderExist(new File(mode.getDestPath())));
            System.out.println(mode.getExcelSourcePath() + "状态码: " + isFileExist(new File(mode.getExcelSourcePath())));
            System.out.println(mode.getExcelDestPath() + "状态码: " + isFileExist(new File(mode.getExcelDestPath())));
            System.out.print("\033[0m");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        //实例化文件拷贝工具类
        FilesCopyUtils fcu =
                new FilesCopyUtils(mode.getSourcePath(), mode.getDestPath(), mode.getFileType());

        //拷贝文件到目标文件夹并得到文件数组
        List<File> files = fcu.traverseFolder();
        //读取源Excel内容并存进数组
        List<Map<Integer, Object>> list =
                ExcelUtilsV2.read(mode.getExcelSourcePath(), 0);
        //Excel头表数组
        List<String> headList = new ArrayList<>();
        //Excel内容数组
        List<List<Object>> code = new ArrayList<>();
        //遍历源Excel内容并进行相关操作
        //线程安全，但损耗少量资源
        for (Map<Integer, Object> map : list) {
            //创建临时数组，存放每一行数据
            List<Object> codeList = new LinkedList<>();
            //如果是第一行则插入头标数组，
            //也就是源Excel（list）的第一个Map对象插入到头标数组
            //否则内容添加到临时数组
            for (Map.Entry<Integer, Object> entry : map.entrySet())
                if (list.indexOf(map)==0)
                    headList.add(entry.getValue().toString());
                else
                    codeList.add(entry.getValue());
            //先把所有新的一列标记成“×”
            codeList.add(mode.getNewRowContent2());
            //遍历文件数组，判断每个文件夹名是否包含当前单元格的字符串（i,2）
            //也就是判断一个文件名是否能和一个表中的姓名相匹配
            //如果匹配当前行最新的单元格修改成“√”
            for (File file : files)
                if (file.getName().contains((String) map.get(2))) {
                    codeList.set(codeList.size() - 1, mode.getNewRowContent());
                    break;
                }
            //如果当前不为第一行则将临时数组添加到单元内容数组
            if (list.indexOf(map) > 0) {
                code.add(codeList);
                if (list.indexOf(map) == mode.getExceptionNumber())
                    codeList.set(codeList.size() - 1, mode.getExceptionName());
            }
        }

        //相应的给头也添加一格新的单元格
        headList.add(mode.getAddString());
        //将头标数组和内容数组写入目标Excel文件，
        //并放入头标数组长度，以修改单元格样式
        ExcelUtilsV2.write(mode.getSheetName(), mode.getExcelDestPath(), headList, code, headList.size());
    }

    //判断文件夹是否存在，如果不存在则创建
    private int isFolderExist(File folderPath) {
        return !folderPath.exists() ? (folderPath.mkdirs() ? 1 : 0) : -1;
    }

    //判断文件夹是否存在，如果不存在则创建
    private int isFileExist(File filePath) throws IOException {
        return !filePath.exists() ? (filePath.createNewFile() ? 1 : 0) : -1;
    }
}
