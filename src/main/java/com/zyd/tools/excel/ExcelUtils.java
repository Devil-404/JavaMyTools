package com.zyd.tools.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @description:使用poi编写的Excel工具类
 * @projectName:MyTool
 * @see:com.zyd.tool
 * @author:张屹东
 * @createTime:2020/9/27 1:30
 */
public class ExcelUtils {
    private XSSFSheet sheet = null;
    private XSSFWorkbook book = null;
    private FileInputStream excelFileInputStream = null;//"D:/10班JS作业登记情况.xlsx"

    /**
     * 读取Excel内容
     *
     * @param path
     * @return
     * @throws IOException
     */
    public List<Map<String, String>> findExcelCode(String path) throws IOException {
        // 创建 Excel 文件的输入流对象
        excelFileInputStream = new FileInputStream(path);

        //HSSFCellStyle cellStyle = book.createCellStyle();
        // 创建其对象，打开这个 Excel 文件
        book = new XSSFWorkbook(excelFileInputStream);
        // 输入流使用后，及时关闭！
        //excelFileInputStream.close();

        IOUtils.close(excelFileInputStream);
        // XSSFSheet 代表Excel中的一张表格
        // 通过 getSheetAt(0)指定表格索引来获取对应表格
        sheet = book.getSheetAt(0);
        //定义list接收
        List<Map<String, String>> list = new ArrayList<>();
        // 开始循环表格数据,表格的行索引从 0 开始
        // 第一行是标题行，从第二行开始, 对应的行索引是 1
        // sheet.getLastRowNum() : 获取当前表格中最后一行数据对应的行索引
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            // XSSFRow 代表一行数据
            XSSFRow row = sheet.getRow(rowIndex);
            if (row == null) {
                continue;
            }
            int i = 0;
            Map<String, String> map = new LinkedHashMap<>();
            while (sheet.getRow(0).getCell(i) != null) {
                XSSFCell CellColumn = sheet.getRow(0).getCell(i);
                XSSFCell CellRow = row.getCell(i);
                map.put(CellColumn.toString(), CellRow != null ? CellRow.getStringCellValue() : "null");
                //code +=CellRow==null?(CellColumn+": null; "):(CellColumn+": "+CellRow.getStringCellValue()+"; ");
                i++;
            }
            list.add(map);
        }
        // 操作完毕后，将XSSFWorkbook关闭
        book.close();
        return list;
    }

    /**
     * 修改某一单元格的内容
     *
     * @param path 地址
     * @param list 源数据集合
     * @param row  需要修改的行
     * @param col  需要修改的列
     * @param text 修改后的内容
     * @throws IOException
     */
    public void modifyExcel(String path, List<String> list, int row, int col, Object text) throws IOException {
        // 创建 Excel 文件的输入流对象
        excelFileInputStream = new FileInputStream(path);//"D:/10班JS作业登记情况.xlsx"
        // XSSFWorkbook 就代表一个 Excel 文件
        // 创建其对象，就打开这个 Excel 文件
        book = new XSSFWorkbook(excelFileInputStream);
        // 输入流使用后，及时关闭！
        excelFileInputStream.close();
        // XSSFSheet 代表 Excel 文件中的一张表格
        // 通过 getSheetAt(0) 指定表格索引来获取对应表格
        // 注意表格索引从 0 开始！
        sheet = book.getSheetAt(0);

        // 创建一行新的数据
        // 指定行索引，创建一行数据, 行索引为当前最后一行的行索引 + 1
        //int currentLastRowIndex = sheet.getLastRowNum();
        //int newRowIndex = currentLastRowIndex + 1;
        XSSFRow newRow = sheet.createRow(row);
        // 开始创建并设置该行每一单元格的信息，该行单元格的索引从 0 开始
        //int cellIndex = 0;
        // 创建一个单元格，设置其内的数据格式为字符串，并填充内容，其余单元格类同
        for (String i : list) {
            System.out.println(i + list.indexOf(i));
            newRow.createCell(list.indexOf(i), CellType.STRING).setCellValue(i);
        }
        System.out.println(col);
        XSSFCell newNameCell = newRow.createCell(col, CellType.STRING);
        newNameCell.setCellValue(text.toString());
        // 将最新的 Excel 数据写回到原始 Excel 文件中
        // 首先要创建一个原始Excel文件的输出流对象！
        FileOutputStream excelFileOutPutStream = new FileOutputStream(path);
        // 将最新的 Excel 文件写入到文件输出流中，更新文件信息！
        book.write(excelFileOutPutStream);
        // 执行 flush 操作， 将缓存区内的信息更新到文件上
        excelFileOutPutStream.flush();
        // 使用后，关闭这个输出流对象
        excelFileOutPutStream.close();
        book.close();
    }


    public void print_excel() {

        //获取excel表格的行数
        int last_row_number = sheet.getLastRowNum();
        String ret;
        //获取数据
        for (int a = 0; a < last_row_number; a++) {
            XSSFRow row = sheet.getRow(a);
            //获取excel表格的列数
            int last_cell_num = row.getLastCellNum();
            for (int b = 0; b < last_cell_num; b++) {
                XSSFCell cell = row.getCell(b);
                //判断cell返回的类型并赋值给ret
                ret = ExcelUtils.getExcelCellValue(cell);
                System.out.print(ret + " ");
            }
            System.out.println();
        }

    }


    public void set_ExcelCell(int i, int j, String str) {
        //获取行的信息
        XSSFRow row = sheet.getRow(i - 1);
        //获取列的信息
        XSSFCell cell = row.getCell(j - 1);
        //获取被修改单元格的内容
        String string = ExcelUtils.getExcelCellValue(cell);
        //修改单元格的内容为str
        cell.setCellValue(str);
        System.out.println("已将" + string + "改为" + str);
    }

    private static String getExcelCellValue(XSSFCell cell) {
        String ret = "";
        try {
            //当返回值的类型为空返回空格
            if (cell == null) {
                ret = "";
                //当返回值的类型为字符串类型
            } else if (cell.getCellType() == CellType.STRING) {
                ret = cell.getStringCellValue();

                //当返回值的类型为数值类型
            } else if (cell.getCellType() == CellType.NUMERIC) {
                ret = "" + cell.getNumericCellValue();

                //当返回值的类型为表达式类型
            } else if (cell.getCellType() == CellType.FORMULA) {
                ret = cell.getCellFormula();

                //当返回值的类型为异常类型
            } else if (cell.getCellType() == CellType.ERROR) {
                ret = "" + cell.getErrorCellValue();

                //当返回值的类型为布尔类型
            } else if (cell.getCellType() == CellType.BOOLEAN) {
                ret = "" + cell.getBooleanCellValue();

                //当返回值的类型为空的时候
            } else if (cell.getCellType() == CellType.BLANK) {
                ret = "";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ret = "";
        }
        return ret;
    }
}