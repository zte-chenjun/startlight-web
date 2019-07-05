package com.dreambird.javaBasics.Container;

import com.sun.org.apache.xpath.internal.SourceTree;
import sun.applet.Main;
import sun.reflect.generics.tree.Tree;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * Created by chen.jun on 2018/2/17.
 */
public class UpdateStu implements Comparable<Object> {

    Long id;

    String name;

    public UpdateStu(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        UpdateStu updateStu = (UpdateStu) o;
        int result = id.longValue()>updateStu.getId().longValue() ? 1 : (id.longValue() == updateStu.getId().longValue() ? 0:-1);
        return result;
    }

    public static void main(String[] args){
        UpdateStu stu1 = new UpdateStu(1001L,"张三");
        UpdateStu stu2 = new UpdateStu(1002L,"李四");
        UpdateStu stu3 = new UpdateStu(1000L,"周六");
        UpdateStu stu4 = new UpdateStu(1003L,"王五");

        TreeSet<UpdateStu> treeSet = new TreeSet<UpdateStu>();
        treeSet.add(stu1);
        treeSet.add(stu2);
        treeSet.add(stu3);
        treeSet.add(stu4);
        System.out.println("遍历TreeSet集合开始----------");
        Iterator<UpdateStu> it = treeSet.iterator();
        while (it.hasNext()){
            UpdateStu stu = it.next();
            System.out.println(stu.getId()+"---------"+stu.getName());
        }
        System.out.println("截取前面部分的集合：");
        it = treeSet.headSet(stu2).iterator();
        while (it.hasNext()){
            UpdateStu stu = it.next();
            System.out.println(stu.getId()+"---------"+stu.getName());
        }
        it = treeSet.subSet(stu3,stu4).iterator();
        System.out.println("截取中间部分的集合");
        while (it.hasNext()){
            UpdateStu stu = it.next();
            System.out.println(stu.getId()+"---------"+stu.getName());
        }

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("01","张三");
        map.put("02","李四");
        map.put("03","王五");
        Set<String> keys = map.keySet();
        for(String str:keys){
            System.out.println(map.get(str));
        }

        Collection<Object> values = map.values();
        Iterator<Object> its = values.iterator();
        while (its.hasNext())
            System.out.println(its.next());
    }
}
