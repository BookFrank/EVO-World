package com.tazine.evo.lucene;

import lombok.Data;

/**
 * @author frank
 * @date 2019/08/20
 */
@Data
public class CityGeoInfo {

    private Long cityId;

    private String name;

    private double lnt;

    private double lat;
}
