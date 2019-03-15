package com.tazine.evo.boot.params;

import com.google.common.base.Charsets;
import org.apache.commons.io.IOUtils;
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
    public Object rawPost(ServletRequest request) throws IOException {
        System.out.println(request.getParameterMap());

        String s = IOUtils.toString(request.getInputStream(), Charsets.UTF_8);
        System.out.println(s);
        return s;
    }

}
