package com.tazine.evo.boot.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * EvoBootFilter
 *
 * @author frank
 * @date 2018/11/07
 */
@WebFilter(urlPatterns = "/*")
public class EvoBootFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        System.err.println("进入 EvoBootFilter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.err.println("退出 EvoBootFilter");
    }

    @Override
    public void destroy() {

    }
}
