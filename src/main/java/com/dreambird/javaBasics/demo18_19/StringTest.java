package com.dreambird.javaBasics.demo18_19;

import java.io.UnsupportedEncodingException;

/**
 * Created by chen.jun on 2019/7/27.
 */
public class StringTest {

    public static void main(String[] args) {
        demo1();
        isNumber("4564564");
        isNumber("45a64564");
        demo2("helloworld");
        demo3("");
        demo4();
        demo5();
        demo6();
    }


    /**
     * 字符串与字符
     *
     * @author chen.jun
     * @date 2019/7/27 17:17
     */
    public static void demo1() {
        char[] chars = {'a', 'b', 'c', 'd', 'e'};
        String charStr1 = new String(chars);
        String charStr2 = new String(chars, 1, 2);
        System.out.println(charStr1);
        System.out.println(charStr2);
        System.out.println(charStr1.charAt(0));
        System.out.println("hello".toCharArray() instanceof char[]);
    }

    /**
     * 字符串是否由数字组成
     *
     * @author chen.jun
     * @date 2019/7/27 17:23
     */
    public static void isNumber(String str) {
        char[] chars = str.toCharArray();
        boolean flag = true;
        for (char ch : chars) {
            if (ch < '0' || ch > '9') {
                flag = false;
            }
        }
        System.out.println(flag);
    }

    public static void demo2(String str) {
        byte[] data = str.getBytes();
        for (int i = 0; i < data.length; i++) {
            data[i] -= 32;
        }
        String str1 = new String(data);
        String str2 = new String(data, 0, 2);
        System.out.println(str1);
        System.out.println(str2);
        String str3 = "";
        try {
            str3 = new String(str.getBytes("GBK"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            System.out.println(str3);
        }
    }

    /**
     * 19.4 字符串比较
     * a.大小比较
     * b.相等比较
     *
     * @author chen.jun
     * @date 2019/7/27 17:39
     */
    public static void demo3(String str) {
        String strA = "chenjun";
        String strB = "CHENJUN";
        System.out.println(strA.equals(strB));
        System.out.println(strA.equalsIgnoreCase(strB));
        System.out.println(strA.compareTo(strB));
        System.out.println(strA.compareToIgnoreCase(strB));
    }

    /**
     * 字符串查找
     *
     * @author chen.jun
     * @date 2019/7/27 17:45
     */
    public static void demo4() {
        String s = "www.baidu.com";
        System.out.println(s.contains("baidu"));
        System.out.println(s.indexOf(".b"));
        System.out.println(s.indexOf("aa"));
        System.out.println(s.indexOf(".b", 3));
        System.out.println(s.lastIndexOf(".b"));
        System.out.println(s.lastIndexOf(".", 2));
        System.out.println(s.startsWith("www"));
        System.out.println(s.startsWith(".b", 3));
        System.out.println(s.endsWith("com"));
    }

    /**
     * 字符串替换、拆分、截取
     *
     * @author chen.jun
     * @date 2019/7/27 18:09
     */
    public static void demo5() {
        String s = "www.chenjun.com.com";
        System.out.println(s.replaceAll("com","cn"));
        System.out.println(s.replaceFirst("com","cn"));
        String[] strs =s.split("\\.");
        for(String s1:strs){
            System.out.println(s1);
        }
        String[] strss =s.split("\\.",3);
        for(String s1:strss){
            System.out.println(s1);
        }
        System.out.println(s.substring(4));
        System.out.println(s.substring(4,11));
    }

    /**
     *  其他操作方法
     *
     * @author chen.jun
     * @date 2019/7/27 18:18
     */
    public static void demo6() {
        String s1 = "aaa";
        String s2 = "   bbb   ccc";
        String s3 = s1.concat(s2);
        System.out.println(s3);
        System.out.println("".isEmpty());
        System.out.println(s2.trim());
        String s4 = s1.toUpperCase();
        System.out.println(s4);
        System.out.println(s4.toLowerCase());
        System.out.println(s4.length());

    }
}
