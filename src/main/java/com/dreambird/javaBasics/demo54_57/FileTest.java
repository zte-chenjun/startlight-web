package com.dreambird.javaBasics.demo54_57;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by chen.jun on 2019/7/28.
 */
public class FileTest {

    public static void main(String[] args) {
//        createFile("D:" + File.separator + "FILE_TEST" + File.separator + "chenjun.text");
//        listDir(new File("D:" + File.separator + "FILE_TEST"));
        renameFile(new File("D:" + File.separator + "FILE_TEST" + File.separator + "chenjun.text"));
    }

    /**
     * 文件的创建
     *
     * @author chen.jun
     * @date 2019/7/28 23:16
     */
    public static void createFile(String pathname) {
        File file = new File(pathname);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            System.out.println("文件是否可读:" + file.canRead());
            System.out.println("文件是否可写:" + file.canWrite());
            System.out.println("文件大小:" + file.length());
            System.out.println("文件最后修改时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(file.lastModified())));
            System.out.println("是文件吗？:" + file.isFile());
            System.out.println("是目录吗？:" + file.isDirectory());
            file.delete();
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 列出目录结构
     *
     * @author chen.jun
     * @date 2019/7/28 23:23
     */
    public static void listDir(File file) {
        if (file.isDirectory()) {
            File[] results = file.listFiles();
            if (results != null && results.length > 0) {
                for (File childrenFile : results) {
                    listDir(childrenFile);
                }
            }
        }
        System.out.println(file);
    }

    public static void renameFile(File file) {
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File childrenFile:files){
                renameFile(childrenFile);
            }
        }else if(file.isFile()){
            String filename = "";
            if(file.getName().contains(".")){
                filename = file.getName().substring(0,file.getName().lastIndexOf("."))+".doc";
            }else{
                filename = file.getName()+".doc";
            }
            File newFile = new File(file.getParentFile(),filename);
            file.renameTo(newFile);
        }
    }

}
