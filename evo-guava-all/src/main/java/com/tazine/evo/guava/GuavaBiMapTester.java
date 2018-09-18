package com.tazine.evo.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * BiMap是一种特殊的映射，其保持映射，同时确保没有重复的值是存在于该映射和一个值可以安全地用于获取键背面的倒数映射
 *
 * @author frank
 * @date 2018/09/18
 */
public class GuavaBiMapTester {

    public static void main(String args[]){
        BiMap<Integer, String> empIDNameMap = HashBiMap.create();

        empIDNameMap.put(101, "Mahesh");
        empIDNameMap.put(102, "Sohan");
        empIDNameMap.put(new Integer(103), "Ramesh");

        //Emp Id of Employee "Mahesh"
        System.out.println(empIDNameMap.inverse().get("Mahesh"));
    }

}
