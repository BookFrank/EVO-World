package com.tazine.evo.boot.retry;

import org.springframework.util.StringUtils;

/**
 * TryCatchRedo-简单重试模式
 *
 * @author frank
 * @date 2019/03/04
 */
public class TryCatchRetry {

    /**
     * try-catch-redo 重试模式有可能出现重试无效，解决办法是尝试增加重试次数 retrycount 以及重试间隔周期 interval， 达到增加重试有效的可能性。
     *
     * @param args args
     */
    public static void main(String[] args) {
        String result;
        try {
            result = getResult();

            // 一次重试
            if (StringUtils.isEmpty(result)) {
                result = getResult();
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 又一次重试
            result = getResult();
        }
        System.out.println(result);
    }

    private static String getResult() {
        return "Hello World";
    }
}
