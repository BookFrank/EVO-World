package com.tazine.evo.http.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PlayerController
 *
 * @author frank
 * @date 2018/03/02
 */
@RestController
public class PlayerController {

    @RequestMapping("/player/{num}")
    public NbaPlayer getPlayerByNum(int num){
        System.out.println("请求参数：" + num);

        NbaPlayer kobe = new NbaPlayer("kobe", 24, "lakers");
        NbaPlayer james = new NbaPlayer("james", 23, "lakers");
        NbaPlayer curry = new NbaPlayer("curry", 33, "warriors");

        if (num == 24){
            return kobe;
        }else if (num == 23){
            return james;
        }else {
            return curry;
        }
    }
}
