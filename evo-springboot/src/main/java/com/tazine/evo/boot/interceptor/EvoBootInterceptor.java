package com.tazine.evo.boot.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * EvoBootInterceptor
 *
 * @author jiaer.ly
 * @date 2018/11/07
 */
@Component
public class EvoBootInterceptor implements HandlerInterceptor {

    /**
     * 在请求处理之前进行调用
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @param handler  Object
     * @return boolean
     * @throws Exception e
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        System.err.println("EvoBootInterceptor preHandle");
        // 这里的 true or false 将决定请求向不向后面转发
        return true;
    }

    /**
     * 当 preHandle 返回为true，且控制器处理完请求之后进行调用，但是它会在 DispatcherServlet 进行视图返回渲染之前被调用， 可以在这个方法中对 Controller 处理之后的
     * ModelAndView 对象进行操作
     *
     * @param request      HttpServletRequest
     * @param response     HttpServletResponse
     * @param handler      Object
     * @param modelAndView mv
     * @throws Exception e
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.err.println("EvoBootInterceptor postHandle");
    }

    /**
     * 当 preHandle 返回为true 时才会执行，在整个请求结束之后，也就是在 DispatcherServlet 渲染了对应的视图之后执行， 主要作用是用于进行资源清理工作
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @param handler  Object
     * @param ex       e
     * @throws Exception e
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
        throws Exception {
        System.out.println("EvoBootInterceptor afterCompletion");
    }
}
