package com.tazine.evo.mysql;

import java.util.LinkedList;

/**
 * LinkedList
 *
 * @author frank
 * @date 2019/1/13
 */
public class LinkedListDemo {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }

        for (int i = 0; i < 15; i++) {
            // removerFirst 会把元素从list中移除
            System.out.println(list.removeFirst());

        }
    }
}
