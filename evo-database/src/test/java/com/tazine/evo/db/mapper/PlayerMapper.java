package com.tazine.evo.db.mapper;


import com.tazine.evo.db.model.Player;

import java.util.List;

/**
 * @author frank
 * @date 2019/06/13
 */
public interface PlayerMapper {

    Player listPlayer();

    List<Player> list();

}
