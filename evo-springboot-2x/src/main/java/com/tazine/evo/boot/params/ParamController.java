package com.tazine.evo.boot.params;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Charsets;
import com.tazine.evo.boot.params.validation.NbaDraftRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * ParamController
 *
 * @author frank
 * @date 2018/03/15
 */
@RestController
public class ParamController {

    /**
     * 通过 raw 上传的可以通过二进制流拿到
     *
     * @param request ServletRequest
     * @return Object
     * @throws IOException e
     */
    @RequestMapping("/param/raw")
    public Object rawPost(ServletRequest request, String name) throws IOException {
        System.out.println("content-type: " + request.getContentType());
        System.out.println("req.getParameterMap():" + request.getParameterMap() + " 无法获得头为 json Post来的数据");
        System.out.println("URL中接收参数：" + name);

        // req.getInputStream() 中可以拿到头为 text/plain 和 application/json 的请求POST来的数据
        String s = IOUtils.toString(request.getInputStream(), Charsets.UTF_8);
        JSONObject jsonObject = JSON.parseObject(s);
        // 当参数为数组时，class 为 JSONArray
        System.out.println(jsonObject.get("name").getClass().getName());
        System.out.println(jsonObject.getString("name"));

        System.out.println("req.getInputStream():" + s + " , 可以获取到 json");
        return s;
    }

    /**
     * 使用 @Request 将json请求体直接转换为 POJO
     *
     * @param draftRequest NbaDraftRequest
     * @return NbaDraftRequest
     * @throws IOException e
     */
    @RequestMapping("/param/body1")
    public NbaDraftRequest bodyPost(@RequestBody NbaDraftRequest draftRequest, String id) throws IOException {
        // @RequestBody 注解无法转换 text/plain 头请求，只能处理 application/json
        System.out.println(id);
        return draftRequest;
    }

    /**
     * - @RequestBody 和 @RequestParam 同时使用问题
     *
     * @param draftRequest NbaDraftRequest
     * @param names        names
     * @return s
     */
    @RequestMapping("/param/body2")
    public List<String> jsonPost(@RequestBody NbaDraftRequest draftRequest, @RequestParam("names") List<String> names) {
        //return name + " - " + age + " - " + email;
        System.out.println(JSON.toJSONString(draftRequest));
        return names;
    }

    /**
     * request.getParameterMap 可以获得URL中的参数和 application/x-www-form-urlencoded 以及 application/form-data 中传递的参数
     *
     * @param request ServletRequest
     * @return Map
     */
    @RequestMapping("/param/map")
    public Map<String, String[]> request(ServletRequest request) {
        //return name + " - " + age + " - " + email;
        // getParameterMap 可以同时获得URL传参和 form-data
        System.out.println(request.getParameter("name"));

        // 127.0.0.1:7001/param/map?name=kobe&name=james
        // request.getParameter("name") 只能得到kobe
        // request.getParameterMap() 可以得到 name:[kobe,james]

        return request.getParameterMap();
    }
}