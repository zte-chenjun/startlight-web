package com.dreambird.javaBasics.demo27;

/**
 * Created by chen.jun on 2019/7/27.
 */
public class StringTest {

    /**
     *  字符串和基本数据类型之间的转换
     *
     * @author chen.jun
     * @date 2019/7/27 18:28
     */
    public static void main(String[] args) {
        // 字符串转基本数据类型
        byte b = Byte.parseByte("20");
        int i = Integer.parseInt("20");
        System.out.println(b);
        System.out.println(i);
        System.out.println(Boolean.parseBoolean("true"));
        System.out.println(Boolean.parseBoolean("false"));
        System.out.println(Boolean.parseBoolean("aaa"));
        System.out.println(Boolean.parseBoolean("1"));

        // 基本数据类型转字符串
        System.out.println(String.valueOf(b));
        System.out.println(String.valueOf(i));
        System.out.println(String.valueOf(true));
        System.out.println(String.valueOf(false));
    }
}
