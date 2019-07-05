package com.dreambird.javaBasics.IO;


import java.io.*;

/**
 * Created by chen.jun on 2018/2/17.
 */
public class FileTest {

    public void createNewFile(){
        File file = new File("E://FileTest//word.txt");
        if(file.exists()){
//            file.delete();
//            System.out.println("该文件已被删除");
            String name = file.getName();
            String path = file.getAbsolutePath();
            long length = file.length();
            boolean hidden = file.isHidden();
            System.out.println(name);
            System.out.println(length);
            System.out.println(hidden);
            System.out.println(path);
        }else{
            try {
                file.createNewFile();
                System.out.println("该文件已被创建");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void operator(){
        File file = new File("E://FileTest//word.txt");
        try {
            FileOutputStream output = new FileOutputStream(file);
            byte[] buy = "我有一只小毛驴，我从来才也不骑".getBytes();
            output.write(buy);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileInputStream input = new FileInputStream(file);
            byte[] buy = new byte[1024];
            int length = input.read(buy);
            System.out.println(buy.toString());
            System.out.println(new String(buy,0,length));
            System.out.println(new String(buy));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        FileTest fileTest = new FileTest();
        fileTest.operator();
    }
}
