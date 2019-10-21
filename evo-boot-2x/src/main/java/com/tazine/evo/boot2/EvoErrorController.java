package com.tazine.evo.boot2;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author frank
 * @date 2019/10/21
 */
//@RestController
public class EvoErrorController extends AbstractErrorController {

    public EvoErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @Override
    protected Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        return super.getErrorAttributes(request, includeStackTrace);
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
