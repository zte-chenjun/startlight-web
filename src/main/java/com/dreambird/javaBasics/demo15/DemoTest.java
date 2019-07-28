package com.dreambird.javaBasics.demo15;

import java.util.Arrays;

/**
 * Created by chen.jun on 2019/7/27.
 */
public class DemoTest {

    public static void main(String[] args) {
        arraysPrint1(new int[]{1, 2, 3});
        getSumAndMaxAndMixAndAvg(new int[]{1, 2, 3, 4});
        sort(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
        reset1(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
        reset2(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
        arraysSort(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
    }

    /**
     * 数组打印
     *
     * @author chen.jun
     * @date 2019/7/27 13:45
     */
    public static void arraysToString(int[] data) {
        String str = "";
        for (int a : data) {
            str = str + a + ",";
        }
        System.out.println(showClassAndMethod() + str.substring(0, str.lastIndexOf(",")));
    }

    /**
     * 打印当前方法名跟类名
     *
     * @author chen.jun
     * @date 2019/7/27 13:52
     */
    public static String showClassAndMethod() {
        return DemoTest.class.getName() + ":"
                + new Exception().getStackTrace()[2].getMethodName() + ": ";
    }

    public static void arraysPrint1(int[] data) {
        int[] data1 = new int[3];
        data1[0] = 1;
        data1[1] = 2;
        data1[2] = 3;
        for (int a : data1) {
            System.out.println(a);
        }
        int data2[] = new int[3];
        data2[0] = 1;
        data2[1] = 2;
        data2[2] = 3;
        for (int a = 0; a < data2.length; a++) {
            System.out.println(data2[a]);
        }
        int[] data3 = new int[]{1, 2, 3};
        for (int a : data3) {
            System.out.println(a);
        }
        int[] data4 = {1, 2, 3};
        for (int a : data4) {
            System.out.println(a);
        }
        data[0] = 0;
        for (int a : data) {
            System.out.println(a);
            System.out.println(data.length);
        }

        int[][] data5 = new int[3][3];
        System.out.println("data5:" + data5.length);
        System.out.println("data5:" + data5[1].length);
        for (int i = 0; i < data5.length; i++) {
            for (int j = 0; j < data5[i].length; j++) {
                data5[i][j] = j;
            }
        }
        for (int i = 0; i < data5.length; i++) {
            for (int j = 0; j < data5[i].length; j++) {
                System.out.println("data5[" + i + "][" + j + "]:" + data5[i][j]);
            }
        }
    }

    public static void getSumAndMaxAndMixAndAvg(int[] data) {
        int sum = 0;
        int max = data[0];
        int min = data[0];
        double avg = 0.0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
            if (data[i] > max) {
                max = data[i];
            }
            if (data[i] < min) {
                min = data[i];
            }
        }
        avg = sum / data.length;
        System.out.println("sum=" + sum);
        System.out.println("max=" + max);
        System.out.println("min=" + min);
        System.out.println("avg=" + avg);
    }

    /**
     * 冒泡排序
     *
     * @author chen.jun
     * @date 2019/7/27 13:18
     */
    public static void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        String str = "";
        for (int a : data) {
            str = str + a + ",";
        }
        System.out.println(str.substring(0, str.lastIndexOf(",")));
    }

    /**
     * 数组转置
     *
     * @author chen.jun
     * @date 2019/7/27 13:36
     */
    public static void reset1(int[] data) {
        int[] otherData = new int[data.length];
        for (int i = data.length - 1; i >= 0; i--) {
            otherData[data.length - 1 - i] = data[i];
        }
        arraysToString(otherData);
    }

    /**
     * 数组转置
     *
     * @author chen.jun
     * @date 2019/7/27 13:36
     */
    public static void reset2(int[] data) {
        int start = 0;
        int end = data.length - 1;
        int center = data.length / 2;
        for (int i = 0; i < center; i++) {
            int temp = data[start];
            data[start] = data[end];
            data[end] = temp;
            start++;
            end--;
        }
        arraysToString(data);
    }


    public static void arraysSort(int[] data) {
        int[] copyData = new int[data.length];
        System.arraycopy(data, 0, copyData, 0, data.length);
        Arrays.sort(data);
        arraysToString(data);
        arraysToString(copyData);

    }

    /**
     * 方法可变参数
     *
     * @author chen.jun
     * @date 2019/7/27 16:39
     */
    public static void sum(int... data) {
        int sum = 0;
        for (int a : data
                ) {
            sum += a;
        }
        System.out.println(sum);
    }


}
