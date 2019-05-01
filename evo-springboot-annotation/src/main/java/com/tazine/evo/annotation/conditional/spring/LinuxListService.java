package com.tazine.evo.annotation.conditional.spring;

/**
 * Linux 下所要创建的 Bean 的类
 *
 * @author frank
 * @date 2018/09/26
 */
public class LinuxListService implements ListFileService {
    @Override
    public String showList() {
        return "ls";
    }
}
