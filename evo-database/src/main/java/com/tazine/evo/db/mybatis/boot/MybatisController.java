package com.tazine.evo.db.mybatis.boot;

import com.tazine.evo.db.mybatis.Player;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiaer.ly
 * @date 2020/04/07
 */
@RestController
public class MybatisController {

    private final TestMapper testMapper;

    public MybatisController(TestMapper testMapper) {this.testMapper = testMapper;}

    @RequestMapping("/player")
    public Player player() {
        return testMapper.selectOne();
    }
}
