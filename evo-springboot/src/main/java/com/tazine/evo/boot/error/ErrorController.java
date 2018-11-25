package com.tazine.evo.boot.error;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author frank
 * @date 2018/11/25
 */
@Controller
public class ErrorController extends AbstractErrorController {



    public ErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping("/ERROR")
    @Override
    public String getErrorPath() {
        return null;
    }


}
