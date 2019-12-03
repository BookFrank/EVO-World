package com.tazine.evo.boot2.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * EvoBootFilter
 *
 * @author frank
 * @date 2018/11/07
 */
@WebFilter(urlPatterns = "/*", filterName = "C")
public class RtMetricFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        String uri = req.getRequestURI();
        String clientKey = req.getParameter("clientKey");

        long start = System.currentTimeMillis();
        System.out.println("进入 rt filter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.err.println(uri + ", rt=" + (System.currentTimeMillis() - start));
        System.out.println("退出 rt filter");
        //System.err.println("退出 EvoBootFilter");
    }

    @Override
    public void destroy() {

    }
}
