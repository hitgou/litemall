package org.linlinjava.litemall.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "org.linlinjava.litemall.message", "com.hitgou.common" })
public class ApplicationMessage {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        // new EmbeddedZooKeeper(2181, false).start();
        SpringApplication.run(ApplicationMessage.class);

        // new SpringApplicationBuilder(ApplicationMessage.class)
        // .listeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event
        // -> {
        // Environment environment = event.getEnvironment();
        // int port = environment.getProperty("embedded.zookeeper.port", int.class);
        // new EmbeddedZooKeeper(port, false).start();
        // }).run(args);
    }

}
