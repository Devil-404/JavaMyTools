package com.zyd.tools.custom;

import java.util.Scanner;

/**
 * @description:输出提示并获取键盘输入的值
 * @projectName:MyTool
 * @see:com.zyd.tool
 * @author:张屹东
 * @createTime:2020/7/13 20:14
 */
public final class ScannerUtils {
    /**
     * 输出提示并获取键盘输入的string值
     *
     * @param text 输出提示
     * @return 返回键盘输入的值
     */
    public static String stringScanner(String text) {
        System.out.print(text);
        return new Scanner(System.in).next();
    }

    /**
     * 输出提示并获取键盘输入的int值
     *
     * @param text 输出提示
     * @return 返回键盘输入的值
     */
    public static int intScanner(String text) {
        System.out.print(text);
        return new Scanner(System.in).nextInt();
    }

    /**
     * 输出提示并获取键盘输入的double值
     *
     * @param text 输出提示
     * @return 返回键盘输入的值
     */
    public static double doubleScanner(String text) {
        System.out.print(text);
        return new Scanner(System.in).nextDouble();
    }

    /**
     * 输出提示并获取键盘输入的long值
     *
     * @param text 输出提示
     * @return 返回键盘输入的值
     */
    public static long longScanner(String text) {
        System.out.print(text);
        return new Scanner(System.in).nextLong();
    }

    /**
     * 输出提示并获取键盘输入的float值
     *
     * @param text 输出提示
     * @return 返回键盘输入的值
     */
    public static float floatScanner(String text) {
        System.out.print(text);
        return new Scanner(System.in).nextFloat();
    }

    /**
     * 输出提示并获取键盘输入的short值
     *
     * @param text 输出提示
     * @return 返回键盘输入的值
     */
    public static short shortScanner(String text) {
        System.out.print(text);
        return new Scanner(System.in).nextShort();
    }
}
