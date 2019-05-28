package com.tazine.evo.infrastructure;

import lombok.Data;

import java.util.Map;

/**
 * 事件影响结果对象
 *
 * @author frank
 * @date 2019/04/25
 */
@Data
public class EventImpactVO {

    private String sEventId;

    private String source;

    private int total;

    private Map<Integer, Integer> detail;
}
