package com.tazine.evo.file.protostuff.compare;

import com.alibaba.fastjson.JSON;
import com.tazine.evo.file.protostuff.ProtostuffUtils;

import java.util.*;

/**
 * TestCompare
 *
 * @author frank
 * @date 2018/12/07
 */
public class TestCompare {

    public static void main(String[] args) {

        List<Map<String, Object>> list = new ArrayList<>();
        List<MyData> myDataList = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            Map<String, Object> map = new HashMap<>();
            for (int j = 1; j < 6; j++) {
                map.put("A" + j, UUID.randomUUID().toString());
            }
            list.add(map);
            MyData myData = new MyData();
            myData.setA1(UUID.randomUUID().toString());
            myData.setA2(UUID.randomUUID().toString());
            myData.setA3(UUID.randomUUID().toString());
            myData.setA4(UUID.randomUUID().toString());
            myData.setA5(UUID.randomUUID().toString());

            myDataList.add(myData);
        }
        MapListWrapper wrapper = MapListWrapper.builder().data(list).build();
        MyDataWrapper dataWrapper = new MyDataWrapper();
        dataWrapper.setDataList(myDataList);

        System.err.println(list.size());
        System.err.println(myDataList.size());

        System.err.println("Json序列化后长度：" + JSON.toJSONString(wrapper).getBytes().length);
        byte[] bytes = ProtostuffUtils.serialize(wrapper);
        System.err.println("Protobuf序列化后长度：" + bytes.length);

        System.out.println();

        System.err.println("Json序列化后长度：" + JSON.toJSONString(dataWrapper).getBytes().length);
        byte[] newBytes = ProtostuffUtils.serialize(dataWrapper);
        System.err.println("Protobuf序列化后长度：" + newBytes.length);

        //1 protobuff只能序列化pojo类，不能直接序列化List 或者Map,如果要序列化list或者map的话，需要用一个wrapper类包装一下

        //2 在序列化Map和List<Map>上没有多大的区别，即protobuff不适合序列化map(个人意见，如有不对请不吝赐教)
    }
}
