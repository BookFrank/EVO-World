package com.tazine.evo.boot.retry.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * RetryService
 *
 * @author frank
 * @date 2019/03/04
 */
@Slf4j
@Service
public class RetryService {

    @Autowired
    private RetryApi retryApi;

    private static int i = 1;

    /**
     * @return string
     * @Retryable 注解被注解的方法发生异常时会重试
     * @value 指定发生的异常进行重试
     * @include 和value一样，默认空，当exclude也为空时，所有异常都重试
     * @exclude 指定异常不重试，默认空，当include也为空时，所有异常都重试
     * @maxAttemps 重试次数，默认3
     * @Backoff backoff:重试补偿机制，默认没有 delay:指定延迟后重试 multiplier:指定延迟的倍数，比如delay=5000l,
     * multiplier=2时，第一次重试为5秒后，第二次为10秒，第三次为20秒
     * @Recover 当重试到达指定次数时，被注解的方法将被回调，可以在该方法中进行日志处理。需要注意的是发生的异常和入参类型一致时才会回调
     * <p>
     * backoff：重试等待策略，默认使用@Backoff，@Backoff的value默认为1000L，我们设置为2000L multiplier（指定延迟倍数）默认为0，表示固定暂停1秒后进行重试，
     * 如果把multiplier设置为1.5，则第一次重试为2秒，第二次为3秒，第三次为4.5秒。
     */
    //@Retryable(value = {RuntimeException.class}, maxAttempts = 3, backoff = @Backoff(delay = 5000L, multiplier = 1))
    @Retryable(value = {RetryException.class}, maxAttempts = 3, backoff = @Backoff(delay = 1000L, multiplier = 1))
    public String getResultFromHttp() {
        String ret = null;
        ret = retryApi.getHttpResult();
        if (StringUtils.isEmpty(ret)) {
            log.info("重试请求...");
            i++;
            log.info("i========={}", i);

            RetryException retryException = new RetryException();
            retryException.setCode(9999);
            retryException.setMsg("连接超时");
            throw retryException;
        } else {
            return ret;
        }
        //throw new RuntimeException("请求接口失败");
    }

    /**
     * recover方法须有返回值
     *
     * @param e RetryException
     * @return
     */
    @Recover
    public String recover(RetryException e) {
        System.out.println("调用 recover 方法");
        System.out.println(e.getMsg());
        return "recover被调用";
    }

    //@Recover
    //public void recover(RuntimeException e) {
    //    System.out.println("调用 recover 方法");
    //    System.out.println(e.getMessage());
    //}
}
