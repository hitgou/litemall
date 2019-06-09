package org.linlinjava.litemall.qwfb.net;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.corundumstudio.socketio.SocketIOServer;

@Component
@Order(value = 1) // 执行顺序控制
public class SocketRunner implements ApplicationRunner {
    // private final Logger logger = LogManager.getLogger();
    private final Log logger = LogFactory.getLog(SocketRunner.class);

    @Autowired
    private SocketIOServer server;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        server.start();
    }
}
