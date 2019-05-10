package com.tazine.evo.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 分页对象
 *
 * @author frank
 * @date 2018/05/03
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> {
    private Integer currentPage;
    private Integer totalPage;
    private List<T> list;
}
