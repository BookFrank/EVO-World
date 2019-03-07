package com.tazine.evo.boot.retry.spring;

import lombok.Getter;
import lombok.Setter;

/**
 * RetryException
 *
 * @author frank
 * @date 2019/03/04
 */
@Getter
@Setter
public class RetryException extends RuntimeException {

    private int code;
    private String msg;
}
