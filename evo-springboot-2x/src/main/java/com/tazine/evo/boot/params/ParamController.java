package com.tazine.evo.boot.params;

import com.google.common.base.Charsets;
import com.tazine.evo.boot.params.validation.NbaDraftRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import java.io.IOException;

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

    @RequestMapping("/param/body2")
    public String bodyPost(@RequestBody String name, @RequestBody int age, @RequestBody String email)
        throws IOException {
        return name + " - " + age + " - " + email;
    }
}
