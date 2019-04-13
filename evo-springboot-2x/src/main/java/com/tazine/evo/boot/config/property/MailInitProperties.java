package com.tazine.evo.boot.config.property;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by lina on 2019-04-13.
 *
 * @author frank
 * @date 2019-04-13
 */
@Data
@ConfigurationProperties(prefix = "email")
public class MailInitProperties implements InitializingBean {

    private String host;
    private int port;
    private String from;
    private String username;
    private String password;
    private MailProperties.Smtp smtp;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化 MailInitProperties");
    }

    public static class Smtp {
        private boolean auth;
        private boolean starttlsEnable;

        public boolean isAuth() {
            return auth;
        }

        public void setAuth(boolean auth) {
            this.auth = auth;
        }

        public boolean isStarttlsEnable() {
            return starttlsEnable;
        }

        public void setStarttlsEnable(boolean starttlsEnable) {
            this.starttlsEnable = starttlsEnable;
        }
    }

}
