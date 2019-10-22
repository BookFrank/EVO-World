package com.tazine.evo.boot2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author frank
 * @date 2019/10/22
 */
@Slf4j
//@ControllerAdvice
//@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest req, HttpServletResponse resp, Exception e) {
        log.error("------------------>捕捉到全局异常", e);
        return JSON.toJSONString(e);
    }

    //@ExceptionHandler(value = Exception.class)
    //public ModelAndView defaultErrorHandler(HttpServletRequest req, HttpServletResponse resp, Exception e) {
    //    log.error("------------------>捕捉到全局异常", e);
    //
    //    if (req.getHeader("accept").contains("application/json")  || (req.getHeader("X-Requested-With")!= null
    //        && req.getHeader("X-Requested-With").contains("XMLHttpRequest") )) {
    //        try {
    //            System.out.println(e.getMessage());
    //            Result result = Result.fail(e.getMessage(), "some error data");
    //
    //            resp.setCharacterEncoding("utf-8");
    //            PrintWriter writer = resp.getWriter();
    //            writer.write(JSONUtil.toJsonStr(result));
    //            writer.flush();
    //        } catch (IOException i) {
    //            i.printStackTrace();
    //        }
    //        return null;
    //    }
    //
    //    if(e instanceof HwException) {
    //        //...
    //    }
    //
    //    ModelAndView mav = new ModelAndView();
    //    mav.addObject("exception", e);
    //    mav.addObject("message", e.getMessage());
    //    mav.addObject("url", req.getRequestURL());
    //    mav.setViewName("error");
    //    return mav;
    //}
}
