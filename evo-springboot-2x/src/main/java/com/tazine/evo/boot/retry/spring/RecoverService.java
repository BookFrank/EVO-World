package com.tazine.evo.boot.retry.spring;

import org.springframework.retry.annotation.Recover;
import org.springframework.stereotype.Service;

/**
 * RecoverService
 *
 * @author frank
 * @date 2019/3/12
 */
@Service
public class RecoverService {

    /**
     * recover方法须有返回值
     *
     * @param e RetryException
     * @return e
     */
    @Recover
    public String recover(RetryException e) {
        System.out.println("调用 recover 方法，打印异常日志");
//        System.out.println(e.getMsg());
//        throw e;
        return "hello recover";
    }
}
