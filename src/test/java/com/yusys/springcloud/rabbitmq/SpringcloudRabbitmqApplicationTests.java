package com.yusys.springcloud.rabbitmq;

import com.yusys.springcloud.rabbitmq.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcloudRabbitmqApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 单播(点对点)
     */
    @Test
    public void contextLoads() {
        // meaasge:需要自己构造一个;定义消息体内容和消息头
//        rabbitTemplate.send(exchange,routKey,message);

        // object:默认当成消息体，只需要传入要发送的对象，自动序列发送给rabbitmq
//        rabbitTemplate.convertAndSend(exchange,routKey,object);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("hello rabbitmq", 123, true));
//        // 对象被默认序列化以后发送出去
//        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);

        // 对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", new Book("C++", 120.00));
    }

    /**
     * 接收数据，如何将数据自动转为json发送出去
     */
    @Test
    public void receive() {
        Object object = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(object.getClass());
        System.out.println(object);
    }

    /**
     * 广播
     */
    @Test
    public void sendMsg() {
        rabbitTemplate.convertAndSend("exchange.fanout", "", new Book("Python", 150.00));
    }
}

