package com.tazine.evo.boot2.rest.entity;

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
    private Integer currentPage;
    private Integer totalPage;
    private List<T> list;
}
