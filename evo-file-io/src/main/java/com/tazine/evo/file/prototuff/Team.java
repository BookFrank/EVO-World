package com.tazine.evo.file.prototuff;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * NBA Team
 *
 * @author frank
 * @date 2018/11/29
 */
@Data
@Builder
public class Team {

    private List<Player> players;
}
