package com.tazine.evo.boot2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author jiaer.ly
 * @date 2019/12/19
 */
@Service
public class ConstructService {

    public static String author;

    @Value("${evo.author}")
    private String confAuthor;

    /**
     * 初始化操作顺序 Constructor->@Autowired->@PostConstruct
     * 如果生成对象的时候需要完成某些初始化操作，而这些初始化操作又依赖于依赖注入，那么就无法在构造函数中实现；
     * 为此，可以使用 @PostConstruct 注解一个方法来完成初始化，@PostConstruct 注解的方法会在依赖注入完成后被调用
     */
    @PostConstruct
    public void init() {
        author = confAuthor;
    }
}
