package com.tazine.evo.netty.codec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author jiaer.ly
 * @date 2019/01/09
 */
@Component
public class CodecServerBootstrap implements CommandLineRunner {

    @Autowired
    private CodecServer codecServer;

    @Override
    public void run(String... args) throws Exception {
        codecServer.start(8088);
    }
}
