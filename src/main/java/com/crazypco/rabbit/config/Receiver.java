package com.crazypco.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
//      @Autowired
//      Mailer mailer;
        //외부와 연결되는 Queue 객체를 빈으로 등록한다.
        @Bean
        Queue queue() {
                return new Queue("CustomerQ", false);
        }
        //만약 외부 큐에서 이벤트가 발생하면(@RabbitListener)
        //해당 메소드를 수행한다.
        @RabbitListener(queues = "CustomerQ")
    public void processMessage(String email) {
       System.out.println("Rabbitmq-receive Massage :::: "+email);
//       mailer.sendMail(email);
    }
        
}
