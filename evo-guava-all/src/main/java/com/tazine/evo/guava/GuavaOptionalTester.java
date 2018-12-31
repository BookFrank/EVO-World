package com.tazine.evo.guava;

import com.google.common.base.Optional;

/**
 * Guava Optional 相关实践
 *
 * @author frank
 * @date 2018/09/15
 */
public class GuavaOptionalTester {

    public static void main(String[] args) {
        // 不采用 Guava
        Integer a = null;
        Integer b = 10;
        //System.out.println(sum(a, b));

        // 使用 Guava
        //Optional.fromNullable - allows passed parameter to be null.
        Optional<Integer> c = Optional.fromNullable(a);
        //Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> d = Optional.of(b);
        System.out.println(guavaSum(c, d));
    }

    public static Integer sum(Integer a, Integer b) {
        return a + b;
    }

    public static Integer guavaSum(Optional<Integer> a, Optional<Integer> b){
        //Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());

        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.or - returns the value if present otherwise returns
        //the default value passed.
        Integer value1 = a.or(0);

        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();

        return value1 + value2;
    }
}
