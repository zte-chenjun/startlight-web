package com.dreambird.javaBasics.IO;

import java.io.*;

/**
 * Created by chen.jun on 2018/2/17.
 */
public class Student {


    public static void main(String[] args){
        String[] content = {"张三","李四","王五"};
        File file = new File("E:/FileTest/word.txt");
        try {
            FileWriter writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer);
            for(int i=0;i<content.length;i++){
                bw.write(content[i]);
                bw.newLine();
            }
            bw.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            int i = 1;
            String str = null;
            while ((str = br.readLine()) != null){
                System.out.println("第"+i+"行:"+str);
                i++;
            }
            br.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
