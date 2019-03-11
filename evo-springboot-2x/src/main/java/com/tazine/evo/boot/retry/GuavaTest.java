package com.tazine.evo.boot.retry;

import com.github.rholder.retry.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * GuavaTest
 *
 * @author frank
 * @date 2019/3/6
 */
public class GuavaTest {

    public static void main(String[] args) throws com.github.rholder.retry.RetryException {

        Retryer<String> retryer = RetryerBuilder
            .<String>newBuilder()
            //抛出runtime异常、checked异常时都会重试，但是抛出error不会重试。
            .retryIfException()
            //返回false也需要重试
            //                .retryIfResult(Predicates.equalTo(false))
            //重调策略
            .withWaitStrategy(WaitStrategies.fixedWait(10, TimeUnit.SECONDS))
            //尝试次数
            .withStopStrategy(StopStrategies.stopAfterAttempt(3))
            .build();

        try {
            retryer.call(() -> process());
        } catch (ExecutionException e) {
            //            e.printStackTrace();
        } catch (RetryException e) {
            System.out.println("更新可代理报销人异常,需要发送提醒邮件");
            //            logger.error("更新可代理报销人异常,需要发送提醒邮件");
        }

    }

    public static String process() {
        System.out.println(System.currentTimeMillis());
        throw new RuntimeException("");
        //        return new Date().toString();
    }
}
