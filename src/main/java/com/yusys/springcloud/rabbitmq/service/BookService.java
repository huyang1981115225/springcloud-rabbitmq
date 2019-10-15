package com.yusys.springcloud.rabbitmq.service;

import com.yusys.springcloud.rabbitmq.entity.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Created by huyang on 2019/10/15.
 */
@Service
public class BookService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book) {
        System.out.println("收到消息：  "+book);
    }

    @RabbitListener(queues = "atguigu")
    public void receive(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
