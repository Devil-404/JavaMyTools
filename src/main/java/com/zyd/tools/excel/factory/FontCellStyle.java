package com.zyd.tools.excel.factory;

import org.apache.poi.ss.usermodel.*;

/**
 * @description:原生样式
 * @projectName:MyTool
 * @see:com.zyd.tools.excel.factory
 * @author:张屹东
 * @createTime:2020/10/7 22:49
 */
public class FontCellStyle {

    public static Font setFont(
            Workbook workbook,
            IndexedColors fontColor,
            boolean bold,
            String fontName,
            short fontHeight) {
        fontColor = (fontColor == null) ? IndexedColors.BLACK : fontColor;
        fontName = (fontName == null) ? "等线" : fontName;
        fontHeight = (fontHeight == 0) ? (short) 240 : fontHeight;
        Font font = getFont(workbook);
        font.setBold(bold);
        font.setFontName(fontName);
        font.setColor(fontColor.index);
        font.setFontHeight(fontHeight);
        return font;
    }

    public static Font setFont(
            Workbook workbook,
            boolean bold,
            short fontHeight) {
        fontHeight = (fontHeight == 0) ? (short) 240 : fontHeight;
        Font font = getFont(workbook);
        font.setBold(bold);
        font.setFontHeight(fontHeight);
        return font;
    }

    public static Font setFont(
            Workbook workbook,
            String fontName,
            short fontHeight) {
        fontName = (fontName == null) ? "等线" : fontName;
        fontHeight = (fontHeight == 0) ? (short) 240 : fontHeight;
        Font font = getFont(workbook);
        font.setFontName(fontName);
        font.setFontHeight(fontHeight);
        return font;
    }

    public static Font setFont(
            Workbook workbook) {
        Font font = getFont(workbook);
        font.setFontName("等线");
        font.setColor(IndexedColors.BLACK.index);
        font.setFontHeight((short) 240);
        return font;
    }

    public static CellStyle setCellStyle(
            Workbook workbook,
            HorizontalAlignment horizontalAlignment,
            VerticalAlignment verticalAlignment,
            Font font,
            BorderStyle border,
            boolean isWrap) {
        horizontalAlignment = horizontalAlignment == null ? HorizontalAlignment.CENTER : horizontalAlignment;
        verticalAlignment = verticalAlignment == null ? VerticalAlignment.CENTER : verticalAlignment;
        border = border == null ? BorderStyle.THIN : border;
        CellStyle cellStyle = getCellStyle(workbook);
        cellStyle.setAlignment(horizontalAlignment);
        cellStyle.setVerticalAlignment(verticalAlignment);
        if (font != null) cellStyle.setFont(font);
        cellStyle.setBorderTop(border);
        cellStyle.setBorderBottom(border);
        cellStyle.setBorderLeft(border);
        cellStyle.setBorderRight(border);
        cellStyle.setWrapText(isWrap);
        return cellStyle;
    }

    public static CellStyle setCellStyle(
            Workbook workbook,
            IndexedColors backgroundColors,
            HorizontalAlignment horizontalAlignment,
            VerticalAlignment verticalAlignment,
            Font font,
            boolean isWrap) {
        backgroundColors = backgroundColors == null ? IndexedColors.WHITE : backgroundColors;
        horizontalAlignment = horizontalAlignment == null ? HorizontalAlignment.CENTER : horizontalAlignment;
        verticalAlignment = verticalAlignment == null ? VerticalAlignment.CENTER : verticalAlignment;
        CellStyle cellStyle = getCellStyle(workbook);
        cellStyle.setFillBackgroundColor(backgroundColors.index);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setFillForegroundColor(backgroundColors.index);
        cellStyle.setAlignment(horizontalAlignment);
        cellStyle.setVerticalAlignment(verticalAlignment);
        if (font != null) cellStyle.setFont(font);
        cellStyle.setWrapText(isWrap);
        return cellStyle;
    }

    public static CellStyle setCellStyle(
            Workbook workbook,
            IndexedColors backgroundColors,
            Font font) {
        backgroundColors = backgroundColors == null ? IndexedColors.WHITE : backgroundColors;
        CellStyle cellStyle = getCellStyle(workbook);
        cellStyle.setFillBackgroundColor(backgroundColors.index);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setFillForegroundColor(backgroundColors.index);
        assert font !=null;
        cellStyle.setFont(font);
        cellStyle.setWrapText(false);
        return cellStyle;
    }

    public static CellStyle setCellStyle(
            Workbook workbook,
            BorderStyle border,
            Font font) {
        CellStyle cellStyle = getCellStyle(workbook);
        border = border == null ? BorderStyle.THIN : border;
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        assert font!=null;
        cellStyle.setFont(font);
        cellStyle.setBorderTop(border);
        cellStyle.setBorderBottom(border);
        cellStyle.setBorderLeft(border);
        cellStyle.setBorderRight(border);
        cellStyle.setWrapText(false);
        return cellStyle;
    }


    public static CellStyle setCellStyle(Workbook workbook) {
        CellStyle cellStyle = getCellStyle(workbook);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setWrapText(false);
        return cellStyle;
    }

    public static void setColumnsWidth(Sheet sheet,int s,int s1,int columnsWidth){
        for (int i=s;i<s1;i++){
            sheet.setColumnWidth(i, columnsWidth);
        }
    }

    public static void setColumnsWidth(Sheet sheet,int s1,int columnsWidth){
        for (int i=0;i<s1;i++){
            sheet.setColumnWidth(i, columnsWidth);
        }
    }

    public static void setColumnsWidth(Sheet sheet,int s1){
        for (int i=0;i<s1;i++){
            sheet.setColumnWidth(i, sheet.getColumnWidth(i));
        }
    }

    public static Font getFont(Workbook workbook) {
        return workbook.createFont();
    }

    public static CellStyle getCellStyle(Workbook workbook) {
        return workbook.createCellStyle();
    }


}
