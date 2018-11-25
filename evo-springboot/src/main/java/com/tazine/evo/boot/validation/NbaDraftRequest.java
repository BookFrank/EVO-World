package com.tazine.evo.boot.validation;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

/**
 * 请求对象
 *
 * @author frank
 * @date 2018/11/14
 */
public class NbaDraftRequest {


    private String name;

    @Min(value = 18)
    private int age;

    @Email
    private String email;
}
