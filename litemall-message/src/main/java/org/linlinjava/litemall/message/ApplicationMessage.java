package org.linlinjava.litemall.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

@SpringBootApplication(scanBasePackages = { "org.linlinjava.litemall.message" })
public class ApplicationMessage {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        // new EmbeddedZooKeeper(2181, false).start();
        // SpringApplication.run(ApplicationMessage.class);

        new SpringApplicationBuilder(ApplicationMessage.class)
                .listeners((ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> {
                    Environment environment = event.getEnvironment();
                    int port = environment.getProperty("embedded.zookeeper.port", int.class);
                    new EmbeddedZooKeeper(port, false).start();
                }).run(args);
    }

}
