package com.zyd.tools.beans;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @projectName:MyTool
 * @see:com.zyd.tools.beans
 * @author:张屹东
 * @createTime:2020/9/29 9:03
 */
@Data
public class StudentExcel {
    private String className;
    private String stuId;
    private String stuName;
    private String sex;
    private List<?> task;

    public StudentExcel(){}

    public StudentExcel(String className, String stuId, String stuName, String sex, List<?> task) {
        this.className = className;
        this.stuId = stuId;
        this.stuName = stuName;
        this.sex = sex;
        this.task = task;
    }
}
