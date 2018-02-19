package com.dreambird.javaBasics.String;

import sun.applet.Main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by chen.jun on 2018/2/9.
 */
public class MainTest {

    public static void main(String[] args){
//        double d = 3.14;
//        StringDemo stringDemo = new StringDemo();
        //×Ö·û´®µÄÉùÃ÷
//        stringDemo.method1();
//        stringDemo.method2();
//        stringDemo.method3();
//        stringDemo.method4();
        //Á¬½Ó×Ö·û´®
//        String a = "hello,word,big,total";
//        String[] myChar = a.split(",",3);
//        for (String string:myChar){
//            System.out.println(string);
//        }
//
//        for(String str:args){
//            System.out.println(str);
//        }

        MainTest mainTest = new MainTest();
        mainTest.iterator();  

    }

    public void iterator(){

        Collection<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        Iterator<String> it = list.iterator();
        while (it.hasNext())
            System.out.println(it.next());

    }

}
