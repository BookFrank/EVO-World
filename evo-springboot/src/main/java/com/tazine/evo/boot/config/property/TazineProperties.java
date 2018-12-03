package com.tazine.evo.boot.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TazineProperties
 *
 * @author frank
 * @date 2018/12/02
 */
@ConfigurationProperties(prefix = "tazine")
@Component
@Data
public class TazineProperties {

    private String est;

    private List<String> employee;
}
