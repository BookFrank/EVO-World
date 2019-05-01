package com.tazine.evo.annotation.conditional.spring;

/**
 * Windows 下所要创建的 Bean 的类
 *
 * @author frank
 * @date 2018/09/26
 */
public class WindowsListService implements ListFileService {

    @Override
    public String showList() {
        return "dir";
    }
}
