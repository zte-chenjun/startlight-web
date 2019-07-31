package com.dreambird.javaBasics.demo54_57;

import com.mchange.v2.io.IndentedWriter;

import javax.sound.midi.Soundbank;
import java.io.*;

/**
 * Created by chen.jun on 2019/7/28.
 */
public class FileStreamTest {

    public static void main(String[] args) throws IOException {
//        fileoutputStreamTest();
//        fileputStreamTest();
//        fileWriter();
//        fileReader();
        outputStreamWriter();
        inoutStreamWriter();
    }


    /**
     * 文件输出流
     *
     * @author chen.jun
     * @date 2019/7/29 0:04
     */
    public static void fileoutputStreamTest() throws IOException {
        File file = new File("D:" + File.separator + "FILE_TEST" + File.separator + "chenjun.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
//        OutputStream outputStream = new FileOutputStream(file);
//        String info = "你好呀";
//        outputStream.write(info.getBytes("UTF-8"));
//        outputStream.close();
        //流自动关闭
        try (OutputStream outputStream = new FileOutputStream(file)) {
            String info = "你好呀";
            outputStream.write(info.getBytes("UTF-8"));
        }
    }

    /**
     * 文件输入流
     *
     * @author chen.jun
     * @date 2019/7/29 0:04
     */
    public static void fileputStreamTest() throws IOException {
        File file = new File("D:" + File.separator + "FILE_TEST" + File.separator + "chenjun.txt");
        try (InputStream inputStream = new FileInputStream(file)) {
            byte[] bytes = new byte[1024];
            int len = inputStream.read(bytes);
            System.out.println(new String(bytes, 0, len));
        }
    }

    /**
     * 文件字符输出流
     *
     * @author chen.jun
     * @date 2019/7/29 0:17
     */
    public static void fileWriter() throws IOException {
        File file = new File("D:" + File.separator + "FILE_TEST" + File.separator + "chenjun.txt");
        try (Writer writer = new FileWriter(file)) {
            String info = "文件字符输出流";
            writer.write(info);
        }

    }

    /**
     * 文件字符输入流
     *
     * @author chen.jun
     * @date 2019/7/29 0:17
     */
    public static void fileReader() throws IOException {
        File file = new File("D:" + File.separator + "FILE_TEST" + File.separator + "chenjun.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try (Reader reader = new FileReader(file)) {
            char[] chars = new char[1024];
            int len = reader.read(chars);
            System.out.println(new String(chars, 0, len));
        }
    }

    /**
     * 字符转字节
     *
     * @author chen.jun
     * @date 2019/7/29 0:26
     */
    public static void outputStreamWriter() throws IOException {
        File file = new File("D:" + File.separator + "FILE_TEST" + File.separator + "chenjun.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try (OutputStream outputStream = new FileOutputStream(file)) {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            outputStreamWriter.write("字符转字节");
            outputStreamWriter.append("字符转字节");
            outputStreamWriter.close();
        }
    }

    /**
     * 字符转字节
     *
     * @author chen.jun
     * @date 2019/7/29 0:26
     */
    public static void inoutStreamWriter() throws IOException {
        File file = new File("D:" + File.separator + "FILE_TEST" + File.separator + "chenjun.txt");
        try (InputStream inputStream = new FileInputStream(file)) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            char[] chars = new char[1024];
            int len = inputStreamReader.read(chars);
            System.out.println(new String(chars, 0, len));
        }
    }
}
