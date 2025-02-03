package com.msproject.servicelog.service.impl;

import com.msproject.servicelog.dto.ShuffleMessage;
import com.msproject.servicelog.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    private static final Logger LOGGER= LoggerFactory.getLogger(LogServiceImpl.class);

    public void print (ShuffleMessage shuffleMessage){
        LOGGER.info("Message received: {}", shuffleMessage.getShuffledArray().toString());
    }
}
