package com.tazine.evo.boot2.error.controller;

import com.alibaba.fastjson.JSONObject;
import com.tazine.evo.boot2.error.EvoRequestException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author frank
 * @date 2019/10/21
 */
@RestController
public class EvoErrorController extends AbstractErrorController {

    private final static String ERROR_PATH = "/error";

    private ErrorAttributes errorAttributes;

    public EvoErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
        //System.out.println(JSON.toJSONString(errorAttributes));
        this.errorAttributes = errorAttributes;
    }

    public String getErrorPath() {
        return ERROR_PATH;
    }

    // 实现一
    //@RequestMapping(value = ERROR_PATH)
    //public Map<String, Object> error(HttpServletRequest request, HttpServletRequest response) {
    //    // 1. 校验输入参数中是否有 debug 参数
    //    boolean debug = StringUtils.equalsIgnoreCase("true", request.getParameter("debug"));
    //    // 2. 通过 debug=true 来判断是否需要输出堆栈错误信息
    //    Map<String, Object> body = getErrorAttributes(request, debug);
    //    return body;
    //}

    // 实现二
    //@RequestMapping(value = ERROR_PATH)
    //public JSONObject error(HttpServletRequest request, HttpServletRequest response) {
    //    // 1. 校验输入参数中是否有 debug 参数
    //    boolean debug = StringUtils.equalsIgnoreCase("true", request.getParameter("debug"));
    //
    //    // 2. 通过 debug=true 来判断是否需要输出堆栈错误信息
    //    Map<String, Object> body = getErrorAttributes(request, debug);
    //
    //    // 3. 组装成业务自定义的通用响应
    //    int status = (int)body.get("status");  // 获取标准 HTTP 响应状态
    //    String message = (String)body.get("message"); // 程序执行过程中的错误信息
    //    Throwable cause = getCause(request); // 获取异常，有可能为空
    //    String errorMessage; // 友好提示信息
    //    if (null != cause) {
    //        errorMessage = getErrorMessage(cause);
    //    } else {
    //        errorMessage = (String)body.get("error");
    //    }
    //
    //    JSONObject jsonObject = new JSONObject();
    //    jsonObject.put("code", status);
    //    jsonObject.put("msg", errorMessage);
    //    jsonObject.put("data", message);
    //    return jsonObject;
    //}

    // 实现三
    //@RequestMapping(value = ERROR_PATH)
    //public JSONObject error(HttpServletRequest request, HttpServletRequest response) {
    //    Map<String, Object> body = getErrorAttributes(request, true);
    //    System.out.println();
    //
    //    // 3. 组装成业务自定义的通用响应
    //    int status = (int)body.get("status");  // 获取标准 HTTP 响应状态
    //    String message = (String)body.get("message"); // 程序执行过程中的错误信息
    //    Throwable cause = getCause(request); // 获取异常，有可能为空
    //    String errorMessage; // 友好提示信息
    //    if (null != cause) {
    //        errorMessage = getErrorMessage(cause);
    //    } else {
    //        errorMessage = (String)body.get("error");
    //    }
    //    String trace = (String)body.get("trace");
    //
    //    System.err.println(trace);
    //    // 1. 校验输入参数中是否有 debug 参数
    //    // 2. 通过 debug=true 来判断是否需要输出堆栈错误信息
    //    boolean debug = StringUtils.equalsIgnoreCase("true", request.getParameter("debug"));
    //
    //    JSONObject jsonObject = new JSONObject();
    //    jsonObject.put("code", status);
    //    jsonObject.put("msg", errorMessage);
    //    if (debug){
    //        jsonObject.put("data", trace);
    //    }
    //    return jsonObject;
    //}

    // 实现四
    @RequestMapping(value = ERROR_PATH)
    public JSONObject error(HttpServletRequest request, HttpServletRequest response) {
        JSONObject jsonObject = new JSONObject();
        try {
            Map<String, Object> body = getErrorAttributes(request, true);

            // 3. 组装成业务自定义的通用响应
            int status = (int)body.get("status");  // 获取标准 HTTP 响应状态
            String message = (String)body.get("message"); // 程序执行过程中的错误信息
            String errorMessage = (String)body.get("error");
            String trace = (String)body.get("trace");

            // 测试出异常了怎么办
            String frank = (String)body.get("frank");
            System.err.println(frank.startsWith("CEO"));

            // 1. 校验输入参数中是否有 debug 参数
            // 2. 通过 debug=true 来判断是否需要输出堆栈错误信息
            boolean debug = StringUtils.equalsIgnoreCase("true", request.getParameter("debug"));

            jsonObject.put("code", status);
            jsonObject.put("msg", errorMessage);
            jsonObject.put("data", message);
            if (debug){
                jsonObject.put("trace", trace);
            }
        }catch (Exception e){
            jsonObject.put("code", 500);
            jsonObject.put("msg", e.getMessage());
            jsonObject.put("data", e.getLocalizedMessage());
            jsonObject.put("trace", e.getStackTrace());
            //e.printStackTrace();
        }
        return jsonObject;
    }

    protected String getErrorMessage(Throwable throwable) {
        if (throwable instanceof EvoRequestException) {
            // 如果 自定义异常信息可以显示给用户
            return ((EvoRequestException)throwable).getMessage();
        }
        return throwable.getMessage();
    }

    /**
     * 获取应用系统的异常
     *
     * @return Throwable
     */
    protected Throwable getCause(HttpServletRequest request) {
        Throwable error = (Throwable)request.getAttribute("javax.servlet.error.exception");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        if (null != error) {
            // SpringMvc 的异常可能会封装成 ServletException，需要调用 getCause 才能获取真正的异常
            while (error instanceof ServletException && null != error.getCause()) {
                error = ((ServletException)error).getCause();
            }
        }
        return error;
    }
}
