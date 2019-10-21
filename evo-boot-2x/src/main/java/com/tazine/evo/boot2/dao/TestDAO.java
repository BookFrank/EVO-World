package com.tazine.evo.boot2.dao;

import com.tazine.evo.boot2.entity.PlayerDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author frank
 * @date 2019/10/21
 */
@Mapper
public interface TestDAO {

    @Select({
       "SELECT *, dd FROM `player`"
    })
    List<PlayerDO> listPlayers();
}
