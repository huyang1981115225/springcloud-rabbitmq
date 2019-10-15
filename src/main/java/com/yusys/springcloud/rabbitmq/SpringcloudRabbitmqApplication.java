package com.yusys.springcloud.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 */
@EnableRabbit //开启基于注解的RabbitMq模式
@SpringBootApplication
public class SpringcloudRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudRabbitmqApplication.class, args);
    }
}
