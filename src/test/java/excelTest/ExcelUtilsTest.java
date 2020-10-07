package excelTest;

import com.zyd.tools.excel.ExcelUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @projectName:MyTool
 * @see:PACKAGE_NAME
 * @author:张屹东
 * @createTime:2020/9/29 9:37
 */
public class ExcelUtilsTest {

    @Test
    public void ExcelTest() throws IOException {
        ExcelUtils excelUtils = new ExcelUtils();
        for (Map<String, String> s : excelUtils.findExcelCode("D:/10班JS作业登记情况.xlsx")) {
            System.out.println(s.get("学号") + ": " + s.get("姓名")+"--->"+s.size());
        }
    }

    @Test
    public void ExcelTest2() throws IOException {
        ExcelUtils excelUtils = new ExcelUtils();
        List<String> list = new ArrayList<>();
        List<Map<String, String>> s = excelUtils.findExcelCode("D:/10班JS作业登记情况.xlsx");
        List<String> studentList = new ArrayList<>();

        for (Map<String, String> a : s) {
            list.add(a.get("姓名"));
            //StudentExcel studentExcel = new StudentExcel(a.get("班级"),a.get("学号"),a.get("姓名"),a.get("性别"));
            //studentList.add(studentExcel);
            for (String key : a.keySet()){
                if (a.get("姓名").equals("李澳")){
                    studentList.add(a.get(key));
                }
            }
        }
        System.out.println(studentList+""+studentList.size());
        System.out.println(list.indexOf("李澳")+1);
        excelUtils.modifyExcel("D:/10班JS作业登记情况.xlsx", studentList, list.indexOf("李澳")+1, studentList.size(),"√");
    }
}
