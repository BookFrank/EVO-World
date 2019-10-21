package com.tazine.evo.boot2.service;

import com.tazine.evo.boot2.dao.TestDAO;
import com.tazine.evo.boot2.entity.PlayerDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author frank
 * @date 2019/10/21
 */
@Service
public class TestService {

    @Autowired
    private TestDAO testDAO;

    public List<PlayerDO> players() {
        throw new RuntimeException("service exception");
        //return testDAO.listPlayers();
    }
}
