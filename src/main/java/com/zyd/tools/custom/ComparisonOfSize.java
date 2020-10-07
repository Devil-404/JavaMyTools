package com.zyd.tools.custom;

/**
 * @description:比较值的大小
 * @projectName:MyTool
 * @see:com.zyd.tool
 * @author:张屹东
 * @createTime:2020/7/13 19:36
 */
public final class ComparisonOfSize {

    /**
     * 比较两个int值大小，comparison为0返回较小值否则返回较大值
     *
     * @param a          需要进行比较的第一个值
     * @param b          需要进行比较的另一个值
     * @param comparison 判断返回较大值或者是较小值
     * @return 返回较大值或者是较小值
     */
    public static int intOfMaxOrMin(int a, int b, int comparison) {
        return comparison > 0 ? Math.max(a, b) : Math.min(a, b);
    }

    /**
     * 比较两个float值大小，comparison为0返回较小值否则返回较大值
     *
     * @param a          需要进行比较的第一个值
     * @param b          需要进行比较的另一个值
     * @param comparison 判断返回较大值或者是较小值
     * @return 返回较大值或者是较小值
     */
    public static float floatOfMaxOrMin(float a, float b, int comparison) {
        return comparison > 0 ? Math.max(a, b) : Math.min(a, b);
    }

    /**
     * 比较两个double值大小，comparison为0返回较小值否则返回较大值
     *
     * @param a          需要进行比较的第一个值
     * @param b          需要进行比较的另一个值
     * @param comparison 判断返回较大值或者是较小值
     * @return 返回较大值或者是较小值
     */
    public static double doubleOfMaxOrMin(double a, double b, int comparison) {
        return comparison > 0 ? Math.max(a, b) : Math.min(a, b);
    }

    /**
     * 比较两个long值大小，comparison为0返回较小值否则返回较大值
     *
     * @param a          需要进行比较的第一个值
     * @param b          需要进行比较的另一个值
     * @param comparison 判断返回较大值或者是较小值
     * @return 返回较大值或者是较小值
     */
    public static long longOfMaxOrMin(long a, long b, int comparison) {
        return comparison > 0 ? Math.max(a, b) : Math.min(a, b);
    }
}
