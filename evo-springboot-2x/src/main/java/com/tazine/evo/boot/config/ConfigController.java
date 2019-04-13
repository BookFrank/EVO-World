package com.tazine.evo.boot.config;

import com.tazine.evo.boot.config.property.MailInitProperties;
import com.tazine.evo.boot.config.property.MailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lina on 2019-04-13.
 *
 * @author frank
 * @date 2019-04-13
 */
@RestController
public class ConfigController {

    @Autowired
    private MailProperties mailProperties;

    @Autowired
    private MailInitProperties mailInitProperties;

    @RequestMapping("/mail")
    public MailProperties getMail(){
        return mailProperties;
    }

    @RequestMapping("/email")
    public MailInitProperties getEMail(){
        return mailInitProperties;
    }
}
