package com.tazine.evo.webflux.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.server.WebFilter;

/**
 * @author jiaer.ly
 * @date 2020/05/01
 */
//@Configuration
public class AppConfig {


    //@Bean
    //@Order(Ordered.HIGHEST_PRECEDENCE) //过滤器顺序
    //public WebFilter webFilter() {
    //    return (exchange, chain) -> chain.filter(new EvoServerWebExchangeDecorator(exchange));
    //}

}
