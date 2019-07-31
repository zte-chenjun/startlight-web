package com.dreambird.javaBasics.demo54_57;

import javax.sound.midi.Soundbank;
import java.io.*;

/**
 * Created by chen.jun on 2019/7/31.
 */
public class FileUtil {

    private File srcFile;
    private File desFile;

    public FileUtil(String src,String des){
        this.srcFile = new File(src);
        this.srcFile = new File(des);
    }

    public FileUtil(File srcFile,File desFile){
        this.srcFile = srcFile;
        this.srcFile = desFile;
    }

    public boolean copyDir() throws Exception{
        try {
            this.copyImpl(this.srcFile);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private void copyImpl(File file) throws IOException {
        if(file.isDirectory()){
            File[] results = file.listFiles();
            if(results!=null){
                for(File result:results ){
                    copyImpl(result);
                }
            }
        }else if(file.isFile()){
            String fileName = file.getName();
            this.copyFileImpl(this.desFile,new File(this.desFile,fileName));
        }
    }

    public boolean copyFileImpl(File srcFile,File desFile) throws IOException {
        if(!desFile.getParentFile().exists()){
            desFile.getParentFile().mkdirs();
        }
        byte[] data = new byte[1024];
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(desFile);
            int len = 0;
            while ((len = inputStream.read(data))!=-1){
                outputStream.write(data,0,len);
            }
            return true;
        }catch (Exception e){
            throw  e;
        }finally {
            if(inputStream!=null){
                inputStream.close();
            }
            if(outputStream!=null){
                outputStream.close();
            }
        }

    }

    public void copy(){
        long start = System.currentTimeMillis();
        if(!this.srcFile.exists()){
            System.out.println("fail");
        }
        if(this.srcFile.isDirectory()){
            try {
                System.out.println(this.copyDir()?"success":"fail");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(this.srcFile.isFile()){
            try {
                System.out.println(this.copyFileImpl(this.srcFile,this.desFile)?"success":"fail");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

}
