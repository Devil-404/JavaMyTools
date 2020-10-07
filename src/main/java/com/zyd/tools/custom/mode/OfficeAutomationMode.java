package com.zyd.tools.custom.mode;

/**
 * @description:OfficeAutomation的参数类
 * @projectName:MyTool
 * @see:com.zyd.tools.custom.mode
 * @author:张屹东
 * @createTime:2020/10/6 19:11
 */
public class OfficeAutomationMode {
    //源Excel文件路径
    private String excelSourcePath;
    //源Excel文件路径
    private String excelDestPath;
    //给Excel生成新列的头名称
    private String addString;
    //需要批量拷贝遍历的文件夹
    private String sourcePath;
    //拷贝文件的目标文件夹
    private String destPath;
    //批量拷贝文件的类型
    private String fileType = ".zip|.rar";
    //sheet页名称
    private String sheetName = "0";
    //生成新列单元格内容的标识符1
    private String newRowContent = "√";
    //生成新列单元格内容的标识符2
    private String newRowContent2 = "×";
    //特殊单元格的内容
    private String exceptionName = "入伍";
    //特殊行编号
    private int exceptionNumber;

    public OfficeAutomationMode() {
    }

    public OfficeAutomationMode(String excelSourcePath, String excelDestPath, String addString, String sourcePath, String destPath, int exceptionNumber) {
        this.excelSourcePath = excelSourcePath;
        this.excelDestPath = excelDestPath;
        this.addString = addString;
        this.sourcePath = sourcePath;
        this.destPath = destPath;
        this.exceptionNumber = exceptionNumber;
    }

    public OfficeAutomationMode(String excelSourcePath, String excelDestPath, String addString, String sourcePath, String destPath, String newRowContent, String newRowContent2, String exceptionName, int exceptionNumber) {
        this.excelSourcePath = excelSourcePath;
        this.excelDestPath = excelDestPath;
        this.addString = addString;
        this.sourcePath = sourcePath;
        this.destPath = destPath;
        this.newRowContent = newRowContent;
        this.newRowContent2 = newRowContent2;
        this.exceptionName = exceptionName;
        this.exceptionNumber = exceptionNumber;
    }

    public OfficeAutomationMode(String excelSourcePath, String excelDestPath, String addString, String sourcePath, String destPath, String fileType, String sheetName, int exceptionNumber) {
        this.excelSourcePath = excelSourcePath;
        this.excelDestPath = excelDestPath;
        this.addString = addString;
        this.sourcePath = sourcePath;
        this.destPath = destPath;
        this.fileType = fileType;
        this.sheetName = sheetName;
        this.exceptionNumber = exceptionNumber;
    }

    public OfficeAutomationMode(String excelSourcePath, String excelDestPath, String addString, String sourcePath, String destPath, String fileType, String sheetName, String newRowContent, String newRowContent2, String exceptionName, int exceptionNumber) {
        this.excelSourcePath = excelSourcePath;
        this.excelDestPath = excelDestPath;
        this.addString = addString;
        this.sourcePath = sourcePath;
        this.destPath = destPath;
        this.fileType = fileType;
        this.sheetName = sheetName;
        this.newRowContent = newRowContent;
        this.newRowContent2 = newRowContent2;
        this.exceptionName = exceptionName;
        this.exceptionNumber = exceptionNumber;
    }

    public String getExcelSourcePath() {
        return excelSourcePath;
    }

    public void setExcelSourcePath(String excelSourcePath) {
        this.excelSourcePath = excelSourcePath;
    }

    public String getExcelDestPath() {
        return excelDestPath;
    }

    public void setExcelDestPath(String excelDestPath) {
        this.excelDestPath = excelDestPath;
    }

    public String getAddString() {
        return addString;
    }

    public void setAddString(String addString) {
        this.addString = addString;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getDestPath() {
        return destPath;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public int getExceptionNumber() {
        return exceptionNumber;
    }

    public void setExceptionNumber(int exceptionNumber) {
        this.exceptionNumber = exceptionNumber;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String getNewRowContent2() {
        return newRowContent2;
    }

    public void setNewRowContent2(String newRowContent2) {
        this.newRowContent2 = newRowContent2;
    }

    public String getNewRowContent() {
        return newRowContent;
    }

    public void setNewRowContent(String newRowContent) {
        this.newRowContent = newRowContent;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    @Override
    public String toString() {
        return "OfficeAutomationMode{" +
                "excelSourcePath='" + excelSourcePath + '\'' +
                ", excelDestPath='" + excelDestPath + '\'' +
                ", addString='" + addString + '\'' +
                ", sourcePath='" + sourcePath + '\'' +
                ", destPath='" + destPath + '\'' +
                ", fileType='" + fileType + '\'' +
                ", exceptionNumber=" + exceptionNumber +
                ", sheetName='" + sheetName + '\'' +
                '}';
    }
}
