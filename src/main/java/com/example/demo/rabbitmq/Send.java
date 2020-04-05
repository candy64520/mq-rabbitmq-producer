package com.example.demo.rabbitmq;

import com.example.demo.common.RabbitmqConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Package: com.example.demo.rabbitmq
 * @ClassName: Send
 * @Author: 86150
 * @Description: 生产者
 * @Date: 2020/4/5 17:56
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Send {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void sendMsgByTopic(){
        for (int i=0;i<5;i++){
            String msg = "恭喜您，注册成功！userID="+i;
            rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_NAME,"topic.sms.email",msg);
            System.out.println("send '"+msg+"'");

        }
    }
}
