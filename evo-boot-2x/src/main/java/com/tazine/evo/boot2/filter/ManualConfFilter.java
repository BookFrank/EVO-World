package com.tazine.evo.boot2.filter;

import org.springframework.util.StopWatch;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * ManualConfFilter
 *
 * @author frank
 * @date 2018/11/07
 */
public class ManualConfFilter implements Filter {
    private final static StopWatch stopWatch = new StopWatch("RT-Watch");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;

        System.err.println("进入 ManualConfFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.err.println("退出 ManualConfFilter");
    }

    @Override
    public void destroy() {

    }
}
