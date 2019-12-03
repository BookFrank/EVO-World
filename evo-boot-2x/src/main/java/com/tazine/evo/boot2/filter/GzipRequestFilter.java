package com.tazine.evo.boot2.filter;

import com.tazine.evo.boot2.filter.wrapper.EvoHttpRequestWrapper;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

/**
 * GZIP 请求过滤器
 *
 * @author jiaer.ly
 * @date 2019/12/03
 */
//@Order(3)
@WebFilter(urlPatterns = "/*", filterName = "A")
public class GzipRequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        System.out.println("进入 GzipRequestFilter");
        chain.doFilter(new EvoHttpRequestWrapper((HttpServletRequest) request), response);
        System.out.println("退出 GzipRequestFilter");
    }

    @Override
    public void destroy() {

    }
}
