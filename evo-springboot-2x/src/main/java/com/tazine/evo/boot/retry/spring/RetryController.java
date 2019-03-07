package com.tazine.evo.boot.retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RetryController
 *
 * @author frank
 * @date 2019/03/04
 */
@RestController
public class RetryController {

    @Autowired
    private RetryService retryService;

    @RequestMapping("/retry")
    public String hello() {
        try {
            return retryService.getResultFromHttp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "请求失败";
    }
}
