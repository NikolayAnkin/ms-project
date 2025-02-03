package com.msproject.servicelog.messaging;

import com.msproject.servicelog.dto.ShuffleMessage;
import com.msproject.servicelog.service.LogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShuffleMessageConsumer {

    private final LogService logService;

    @Autowired
    public ShuffleMessageConsumer(LogService logService){
        this.logService=logService;
    }

    @RabbitListener(queues = "serviceShuffleQueue")
    public void consumeMessage(ShuffleMessage shuffleMessage){
        logService.print(shuffleMessage);
    }

}
