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
@WebFilter(urlPatterns = "/b/*")
public class EvoBootFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        System.out.println("经过 EvoBootFilter");
    }
}
