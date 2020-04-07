package com.tazine.evo.db.mybatis.annotated.mapper;

import com.tazine.evo.db.mybatis.Player;
import org.apache.ibatis.annotations.Select;

/**
 * PlayerMapper
 *
 * @author jiaer.ly
 * @date 2020/04/07
 */
public interface PlayerMapper {

    @Select({
        "SELECT name, team, num FROM tb_nba_player where id=#{id}"
    })
    Player findById(Integer id);
}
