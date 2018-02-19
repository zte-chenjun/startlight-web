package com.dreambird.javaBasics.String;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.net.SocketTimeoutException;

/**
 * Created by chen.jun on 2018/2/9.
 */
public class StringDemo {

    /**
     * 用一个字符数组转String
     */
    public void method1(){
        char a[] = {'d','e','m','o'};
        String s = new String(a);
        System.out.println(s);
    }

    /**
     * 提取字符数组a中的一部分创建一个字符串对象
     */
    public void method2(){
        char a[] = {'s','t','u','d','e','n','t'};
        String s = new String(a,2,4);
        System.out.println(s);
    }

    /**
     * 字符数组转字符串
     */
    public void method3(){
        char a[] = {'a','b','c'};
        String s = new String(a);
        System.out.println(s);
    }

    /**
     * 引用字符串常量创建字符串变量
     */
    public void method4(){
        String str1,str2;
        str1 = "dreambird";
        str2 = "starlight";
        System.out.println("str1:"+str1+"----"+"str2:"+str2);
    }
}
