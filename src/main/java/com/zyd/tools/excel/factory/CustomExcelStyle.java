package com.zyd.tools.excel.factory;

import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import org.apache.poi.ss.usermodel.*;

import java.util.List;

/**
 * @description:自定义样式
 * @projectName:MyTool
 * @see:com.zyd.tools.excel.factory
 * @author:张屹东
 * @createTime:2020/10/4 0:42
 */
public class CustomExcelStyle implements SheetWriteHandler, CellWriteHandler {

    private int x;

    private List<String> head;

    public CustomExcelStyle() {
    }

    public CustomExcelStyle(int x) {
        this.x = x;
    }

    public CustomExcelStyle(int x, List<String> head) {
        this.x = x;
        this.head = head;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setHead(List<String> head) {
        this.head = head;
    }

    @Override
    public void beforeSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {

    }

    @Override
    public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
        Workbook workbook = writeWorkbookHolder.getWorkbook();
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 0; i < x; i++)
            sheet.setColumnWidth(i, 4240);
        // 头部样式策略
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight((short) 300);
        font.setFontName("等线");
        font.setColor(IndexedColors.BLACK.index);
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setFillBackgroundColor(IndexedColors.WHITE1.index);
        //设置标题
        Row row1 = sheet.createRow(0);
        row1.setHeight((short) 400);
        Cell cell1;
        for (String s : head) {
            cell1 = row1.createCell(head.indexOf(s));
            cell1.setCellValue(s);
            cell1.setCellStyle(cellStyle);
        }
    }

    @Override
    public void beforeCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Head head, Integer integer, Integer integer1, Boolean aBoolean) {

    }

    @Override
    public void afterCellCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Cell cell, Head head, Integer integer, Boolean aBoolean) {

    }

    @Override
    public void afterCellDataConverted(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, CellData cellData, Cell cell, Head head, Integer integer, Boolean aBoolean) {

    }

    @Override
    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<CellData> list, Cell cell, Head head, Integer integer, Boolean aBoolean) {
        int num = cell.getColumnIndex();
        String s = cell.getStringCellValue();
        IndexedColors Colors = IndexedColors.BLACK;
        IndexedColors backgroundColors = IndexedColors.WHITE1;
        if (!aBoolean) {
            if (num > 3) {
                IndexedColors color = s.equals("√") ? IndexedColors.GREEN : s.equals("入伍") ? IndexedColors.BLUE : IndexedColors.RED;
                Colors = color;
                backgroundColors = color;
            }
        }
        setColor(cell, writeSheetHolder, Colors, backgroundColors);
    }

    private void setColor(Cell cell, WriteSheetHolder writeSheetHolder, IndexedColors color, IndexedColors backgroundColors) {
        Sheet sheet = writeSheetHolder.getSheet();
        Workbook workbook = sheet.getWorkbook();
        Font font = workbook.createFont();
        //font.setColor(color.index);
        font.setBold(true);
        //20倍
        font.setFontHeight((short) 240);
        font.setFontName("等线");
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setFillForegroundColor(backgroundColors.index);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setFont(font);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cell.setCellStyle(cellStyle);
    }
}
