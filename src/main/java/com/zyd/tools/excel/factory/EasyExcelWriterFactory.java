package com.zyd.tools.excel.factory;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import org.apache.poi.ss.formula.functions.T;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

/**
 * @description:
 * @projectName:MyTool
 * @see:com.zyd.tools.excel
 * @author:张屹东
 * @createTime:2020/9/29 23:07
 */
public class EasyExcelWriterFactory {
    private int sheetNo = 0;
    private final ExcelWriter excelWriter;

    public EasyExcelWriterFactory(OutputStream outputStream) {
        excelWriter = EasyExcel.write(outputStream).build();
    }

    public EasyExcelWriterFactory(File file) {
        excelWriter = EasyExcel.write(file).build();
    }

    public EasyExcelWriterFactory(String filePath) {
        excelWriter = EasyExcel.write(filePath).build();
    }

    /**
     * 链式模板表头写入
     *
     * @param headClazz 表头格式
     * @param data      数据 List<ExcelModel> 或者List<List<Object>>
     * @return
     */
    public EasyExcelWriterFactory writeModel(Class<T> headClazz, List<T> data, String sheetName) {
        excelWriter.write(data, EasyExcel.writerSheet(this.sheetNo++, sheetName).head(headClazz).build());
        return this;
    }

    /**
     * 链式自定义表头写入
     *
     * @param head
     * @param data      数据 List<ExcelModel> 或者List<List<Object>>
     * @param sheetName
     * @return
     */
    public EasyExcelWriterFactory write(List<List<String>> head, List<T> data, String sheetName) {
        excelWriter.write(data, EasyExcel.writerSheet(this.sheetNo++, sheetName).head(head).build());
        return this;
    }

    public void finish() {
        excelWriter.finish();
    }

}