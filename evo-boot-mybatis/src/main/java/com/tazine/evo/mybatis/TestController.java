package com.tazine.evo.mybatis;

import com.tazine.evo.mybatis.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TestController
 *
 * @author frank
 * @date 2019/07/22
 */
@RestController
public class TestController {

    @Autowired
    private PlayerRepository playerRepository;

    @RequestMapping("/p")
    public List<NbaPlayer> players(){
        return playerRepository.list();
    }
}
