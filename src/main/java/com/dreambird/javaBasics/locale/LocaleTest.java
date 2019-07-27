package com.dreambird.javaBasics.locale;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by chen.jun on 2019/7/7.
 */
public class LocaleTest {

    public static void main(String[] args){
//        Locale locale = Locale.getDefault();
        Locale locale = new Locale("en","US");
        System.out.println(Locale.CHINA);

        //ResourceBundle读取资源文件
        ResourceBundle resourceBundle = ResourceBundle.getBundle("locale.messages",locale);
        String info = resourceBundle.getString("info");
        System.out.println(MessageFormat.format(info,"chenjun",new SimpleDateFormat("yyyy-MM-dd").format(new Date())));

    }
}
