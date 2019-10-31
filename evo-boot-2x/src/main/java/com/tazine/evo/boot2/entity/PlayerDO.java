package com.tazine.evo.boot2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * PlayerDO
 *
 * @author frank
 * @date 2019/10/21
 */
@Data
@AllArgsConstructor
public class PlayerDO {

    private String name;

    private String team;

    private Integer num;
}
