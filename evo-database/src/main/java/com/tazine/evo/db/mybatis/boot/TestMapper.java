package com.tazine.evo.db.mybatis.boot;

import com.tazine.evo.db.mybatis.Player;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author jiaer.ly
 * @date 2020/04/07
 */
@EvoMapper
//@Mapper
//@Repository
public interface TestMapper {

    @Select({
        "SELECT * FROM tb_nba_player LIMIT 1"
    })
    Player selectOne();
}
