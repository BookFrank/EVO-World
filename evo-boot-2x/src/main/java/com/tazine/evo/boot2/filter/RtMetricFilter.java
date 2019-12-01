package com.tazine.evo.boot2.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.StopWatch;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * EvoBootFilter
 *
 * @author frank
 * @date 2018/11/07
 */
@WebFilter(urlPatterns = "/*")
public class RtMetricFilter implements Filter {

    private final static StopWatch stopWatch = new StopWatch("RT-Watch");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String uri = req.getRequestURI();
        String clientKey = req.getParameter("clientKey");

        long start = System.currentTimeMillis();
        stopWatch.start(uri);
        filterChain.doFilter(servletRequest, servletResponse);
        stopWatch.stop();
        System.err.println(uri + ", rt=" + (System.currentTimeMillis() - start) + " watch=" + stopWatch.getTotalTimeMillis());
        //System.err.println("退出 EvoBootFilter");
    }

    @Override
    public void destroy() {

    }
}
