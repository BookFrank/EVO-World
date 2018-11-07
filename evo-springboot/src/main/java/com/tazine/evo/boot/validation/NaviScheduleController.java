package com.tazine.evo.boot.validation;

import com.alibaba.fastjson.JSON;
import com.tazine.evo.boot.RestResponseBuilder;
import com.tazine.evo.boot.entity.HttpResult;
import com.tazine.evo.boot.entity.enums.HttpAnswerCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 导航调度相关接口
 *
 * @author jiaer.ly
 * @date 2018/11/06
 */
@RestController
public class NaviScheduleController {

    private static final Logger logger = LoggerFactory.getLogger(NaviScheduleController.class);

    /**
     * 单点抓路：根据左边获取周围的 Link
     *
     * @param lon longtitude
     * @param lat latitude
     * @return HttpResult
     */
    public HttpResult getAroundLinks(@RequestParam(value = "lon", required = true) Float lon,
                                     @RequestParam(value = "lat", required = true) Float lat) {
        return null;
    }

    @RequestMapping("/param/valid")
    public HttpResult congestHandle(@Valid NaviPublishRequest naviPublishRequest, BindingResult bindingResult) {
        logger.info(JSON.toJSONString(naviPublishRequest));
        HttpResult httpResult;
        try {
            if (bindingResult.hasErrors()) {
                httpResult = RestResponseBuilder.buildErrorResponse(
                    HttpAnswerCode.PARAMS_ERROR, bindingResult.getFieldError().getDefaultMessage());
            } else {
                httpResult = RestResponseBuilder.buildSuccessResponse("Hello World");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            httpResult = RestResponseBuilder.buildErrorResponse(HttpAnswerCode.UNEXPECTED_ERROR, e.getMessage());
        }
        return httpResult;
    }
}
