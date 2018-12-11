package com.tazine.evo.file.protostuff.compare;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * MapListWrapper
 *
 * @author frank
 * @date 2018/12/07
 */
@Data
@Builder
public class MapListWrapper {

    private List<Map<String, Object>> data = new ArrayList<>();

}
