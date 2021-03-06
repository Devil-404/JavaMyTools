package excelTest;

import com.zyd.tools.beans.StudentExcel;
import com.zyd.tools.custom.OfficeAutomation;
import com.zyd.tools.custom.mode.OfficeAutomationMode;
import com.zyd.tools.excel.ExcelUtilsV2;
import com.zyd.tools.files.FileUtils;
import com.zyd.tools.files.FilesCopyUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @description:
 * @projectName:MyTool
 * @see:excelTest
 * @author:张屹东
 * @createTime:2020/9/29 21:18
 */
public class ExcelUtilsV2Test {

    public static void main(String[] args) {
        System.out.println(11111);
    }

    String file = "D:/10班JS作业登记情况.xlsx";
    String s_n = "第二次作业";

    @Test
    public void ExcelTest1() throws Exception {
        InputStream fileInputStream = FileUtils.getResourcesFileInputStream(file);
        List<Object> list = ExcelUtilsV2.read(fileInputStream, 0);
        IOUtils.close(fileInputStream);
        list.forEach(System.out::println);
    }

    @Test
    public void ExcelTest2() {
        //File filePath = FileUtils.getFile(file);
        List<Map<Integer, Object>> list = ExcelUtilsV2.read(file, 1);
        list.forEach(System.out::println);
    }

    @Test
    public void ExcelTest3() {
        List<Map<Integer, Object>> list = ExcelUtilsV2.read(file, 0);
        List<String> headList = new ArrayList<>();
        List<List<Object>> code = new ArrayList<>();
        //List<String> head = new LinkedList<>();
        //head.add(s_n);
        //list.forEach(System.out::println);
        for (int i = 0; i < list.size(); i++) {
            StudentExcel studentExcel = new StudentExcel();
            List<Object> codeList = new LinkedList<>();
            for (int z = 0; z < list.get(i).size(); z++) {
                if (i == 0) {
                    headList.add(list.get(i).get(z).toString());
                    /*List<String> tempList = new LinkedList<>();
                    tempList.add(list.get(i).get(z).toString());
                    headList.add(tempList);*/
                } else {
                    codeList.add(list.get(i).get(z));
                }

            }
            System.out.println(list.get(i).get(2));
            if (i > 0)
                code.add(codeList);
        }
        headList.add(s_n);
        System.out.println(headList);
        System.out.println(code);
        //ExcelUtilsV2.write("D:\\123.xlsx",headList,code);
        ExcelUtilsV2.write("js作业表","D:\\123.xlsx", headList, code, headList.size());
    }

    @Test
    public void ExcelTest4() throws IOException {
        //实例化文件拷贝工具类
        FilesCopyUtils fcu =
                new FilesCopyUtils("E:\\js\\2020-09-24", "E:\\js\\aa", ".zip|.rar");
        //拷贝文件到目标文件夹并得到文件数组
        List<File> files = fcu.traverseFolder();
        //读取源Excel内容并存进数组
        List<Map<Integer, Object>> list =
                ExcelUtilsV2.read(file, 0);
        //Excel头表数组
        List<String> headList = new ArrayList<>();
        //Excel内容数组
        List<List<Object>> code = new ArrayList<>();

        //遍历源Excel内容并进行相关操作
        for (int i = 0; i < list.size(); i++) {
            //创建临时数组，存放每一行数据
            List<Object> codeList = new LinkedList<>();

            //遍历所有列的长度
            for (int z = 0; z < list.get(i).size(); z++) {
                //如果是第一行则插入头标数组，
                //也就是源Excel（list）的第一个Map对象插入到头标数组
                //否则内容添加到临时数组
                if (i == 0) {
                    headList.add(list.get(i).get(z).toString());
                } else {
                    codeList.add(list.get(i).get(z));
                }
            }
            //先把所有新的一列标记成“×”
            codeList.add("×");
            //遍历文件数组，判断每个文件夹名是否包含当前单元格的字符串（i,2）
            //也就是判断一个文件名是否能和一个表中的姓名相匹配
            //如果匹配当前行最新的单元格修改成“√”
            for (File file : files) {
                if (file.getName().contains((String) list.get(i).get(2))) {
                    codeList.set(codeList.size() - 1, "√");
                    break;
                }
            }
            //如果当前不为第一行则将临时数组添加到单元内容数组
            if (i > 0) {
                code.add(codeList);
                if (i == 47)
                    codeList.set(codeList.size() - 1, "入伍");
            }
        }
        //相应的给头也添加一格新的单元格
        headList.add(s_n);
        //将头标数组和内容数组写入目标Excel文件，
        //并放入头标数组长度，以修改单元格样式
        ExcelUtilsV2.write("js作业审核表","D:\\123.xlsx", headList, code, headList.size());
    }

    @Test
    public void ExcelTest5() throws IOException {
        //4489288400 4236695200
        //3797248400 3854292500
        //4375803300 4065223000
        //3787685800
        long startTime = System.nanoTime();
        OfficeAutomationMode mode = new OfficeAutomationMode();

        //新加列的名称
        mode.setAddString("10.12课后作业");
        //需要批量提取文件的目录
        mode.setSourcePath("E:\\js\\10.12作业");
        //批量提取文件存放的目录
        mode.setDestPath("E:\\js\\10.12");
        //需要操作的excel
        mode.setExcelSourcePath("E:\\js\\123.xlsx");
        //操作后存档的excel
        mode.setExcelDestPath("E:\\js\\123.xlsx");
        //例外行的下标（如：入伍同学的行数）
        mode.setExceptionNumber(47);
        //例外行新加列的内容
        mode.setExceptionName("入伍");
        mode.setNewRowContent("√");
        mode.setNewRowContent2("×");
        //sheet页的名称
        mode.setSheetName("作业登记表");
        //需要批量拷贝的文件类型
        mode.setFileType(".zip|.rar");

        new OfficeAutomation().automaticMarkingHomework(mode);
        long endTime = System.nanoTime();
        System.out.println("耗时：" + (endTime - startTime));
    }

    @Test
    public void assertTest(){
        System.out.print("\033[1;95m");
        System.out.println(12313123);
        System.out.println("我滴个什");
        System.out.print("\033[0m");
        OfficeAutomationMode mode = new OfficeAutomationMode();
        mode.setAddString("test2");
        mode.setSourcePath("E:\\js\\2020-09-24");
        System.out.println(mode.getSheetName());
    }
}
