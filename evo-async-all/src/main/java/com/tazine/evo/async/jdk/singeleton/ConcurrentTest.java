package com.tazine.evo.async.jdk.singeleton;

/**
 * 测试多线程下单例类的方法调用
 *
 * @author frank
 * @date 2018/11/05
 */
public class ConcurrentTest {

    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            new Thread(() -> SingleBean.getInstance().exec(), "线程" + i).start();
        }
    }
}
