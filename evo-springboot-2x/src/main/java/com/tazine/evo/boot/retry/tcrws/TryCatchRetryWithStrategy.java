package com.tazine.evo.boot.retry.tcrws;

import org.springframework.util.StringUtils;

/**
 * 策略重试模式
 *
 * @author frank
 * @date 2019/03/04
 */
public class TryCatchRetryWithStrategy {

    public static void main(String[] args) throws InterruptedException {
        String result;
        try {
            result = getResult();

            // 延迟3s，重试3次
            if (StringUtils.isEmpty(result)) {
                result = retryGetResult(3000L,3);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // 又一次重试
            result = retryGetResult(3000L,3);
        }
        System.out.println(result);
    }

    private static String getResult() {
        return "Hello World";
    }

    private static String retryGetResult(long delay, int count) throws InterruptedException {
        Thread.sleep(delay);
        for (int i = 0; i<count; i++){
            String ret = getResult();
            if (!StringUtils.isEmpty(ret)){
                return ret;
            }
        }
        return null;
    }
}
