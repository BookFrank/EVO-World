package com.tazine.evo.mybatis.repository;

import com.tazine.evo.mybatis.NbaPlayer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * PlayerRepository
 *
 * @author frank
 * @date 2019/07/10
 */
@Mapper
public interface PlayerRepository {

    @Select({
            "SELECT name, team FROM player"
    })
    List<NbaPlayer> list();
}
