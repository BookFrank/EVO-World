package com.tazine.evo.boot.config;

import com.tazine.evo.boot.config.property.MailInitProperties;
import com.tazine.evo.boot.config.property.MailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by frank on 2019-04-13.
 *
 * @author frank
 * @date 2019-04-13
 */
@RestController
public class ConfigPropertyController {

    @Autowired
    private MailProperties mailProperties;

    @Autowired
    @Qualifier("anotherMail")
    private MailProperties anotherMailProperties;

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

    @RequestMapping("/amail")
    public MailProperties getAMail(){
        return anotherMailProperties;
    }
}
