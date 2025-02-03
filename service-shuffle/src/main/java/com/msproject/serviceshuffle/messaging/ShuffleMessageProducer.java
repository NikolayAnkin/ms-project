package com.msproject.serviceshuffle.messaging;

import com.msproject.serviceshuffle.dto.ShuffleMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShuffleMessageProducer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public ShuffleMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(List<Integer> shuffledArray) {

        ShuffleMessage message = new ShuffleMessage();
        message.setShuffledArray(shuffledArray);

        rabbitTemplate.convertAndSend("serviceShuffleQueue", message);

    }
}
