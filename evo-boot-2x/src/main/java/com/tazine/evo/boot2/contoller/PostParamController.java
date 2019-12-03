package com.tazine.evo.boot2.contoller;

import com.tazine.evo.boot2.entity.PlayerDO;
import com.tazine.evo.boot2.util.GzipUtil;
import org.apache.commons.compress.compressors.gzip.GzipUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author jiaer.ly
 * @date 2019/12/03
 */
@RestController
@RequestMapping("/post")
public class PostParamController {

    @RequestMapping("/gzip")
    public List<PlayerDO> gzip(@RequestBody List<PlayerDO> players){
        return players;
    }

    @RequestMapping("/raw")
    public String raw(HttpServletRequest request, @RequestHeader("Content-Encoding") String contentEncoding) throws Exception {
        System.out.println("encoding=" + contentEncoding);
        byte[] bs = GzipUtil.decompress(IOUtils.toByteArray(request.getInputStream()));
        return new String(bs);
    }
}
