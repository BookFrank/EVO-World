package com.tazine.evo.guava;

import com.google.common.base.CaseFormat;

/**
 * CaseFormatDemo
 *
 * @author frank
 * @date 2018/12/31
 */
public class CaseFormatDemo {

    public static void main(String args[]){
        CaseFormatDemo tester = new CaseFormatDemo();
        tester.testCaseFormat();
    }

    private void testCaseFormat(){
        String data = "test_data";
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));
    }

}
