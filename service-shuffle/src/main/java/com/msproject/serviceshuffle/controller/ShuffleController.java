package com.msproject.serviceshuffle.controller;

import com.msproject.serviceshuffle.messaging.ShuffleMessageProducer;
import com.msproject.serviceshuffle.service.ShuffleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shuffle")
public class ShuffleController {

    private final ShuffleService shuffleService;
    private final ShuffleMessageProducer messageProducer;

    @Autowired
    public ShuffleController(ShuffleService shuffleService, ShuffleMessageProducer messageProducer){
        this.shuffleService = shuffleService;
        this.messageProducer=messageProducer;
    }

    @PostMapping
    public ResponseEntity<String> createShuffledArray(@RequestParam Integer number) {

        List<Integer>shuffledArray= shuffleService.createShuffledArray(number);
        messageProducer.sendMessage(shuffledArray);

        return ResponseEntity.ok(shuffledArray.toString());
    }


}
