package com.tazine.evo.webflux.util.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页对象
 *
 * @author jiaer.ly
 * @date 2018/05/03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    /**
     * 总数
     */
    private Integer totalNum;
    private List<T> list;
}
