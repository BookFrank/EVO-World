package com.tazine.evo.boot.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by lina on 2019-04-13.
 *
 * @author frank
 * @date 2019-04-13
 */
@Data
@Component
@ConfigurationProperties(prefix = "mail")
public class MailProperties {

    private String host;
    private int port;
    private String from;
    private String username;
    private String password;
    private Smtp smtp;

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
