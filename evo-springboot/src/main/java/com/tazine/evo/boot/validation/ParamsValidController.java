package com.tazine.evo.boot.validation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 参数验证控制器
 *
 * @author frank
 * @date 2018/11/13
 */
@RestController
public class ParamsValidController {

    /**
     * 用户参数输入，2018-11-11，这样后台会直接报错 ConversionFailedException
     *
     * @param date date
     * @return Date
     */
    @RequestMapping("/date/test")
    public Date testDate(Date date) {
        System.out.println(date);
        return date;
    }

    /**
     * 时区错误
     *
     * @param date date
     * @return Date
     */
    @RequestMapping("/date/test1")
    public String testDate1(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) throws JsonProcessingException {
        System.out.println(date);
        return date.toString() + new ObjectMapper().writeValueAsString(date);
    }

    /**
     * 用户参数输入2018-11-11，返回
     *
     * @param date date
     * @return Date
     */
    @RequestMapping("/date/test2")
    public Date testDate2(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        System.out.println(date);
        return date;
    }
}
