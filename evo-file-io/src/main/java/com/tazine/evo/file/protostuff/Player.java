package com.tazine.evo.file.protostuff;

import lombok.Builder;
import lombok.Data;

/**
 * NBA Player
 *
 * @author frank
 * @date 2018/11/29
 */
@Data
@Builder
public class Player {

    private String name;

    private String team;

    private int num;
}
