package com.tazine.evo.boot;

import com.alibaba.fastjson.JSON;
import com.tazine.evo.boot.util.SpringBindUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author frank
 * @date 2019/04/30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BindTest {

    @Autowired
    private Environment env;

    @Test
    public void test(){
        NbaPlayer kobe = SpringBindUtil.bind(env, NbaPlayer.class, "player");
        System.out.println(JSON.toJSONString(kobe));
    }

}
