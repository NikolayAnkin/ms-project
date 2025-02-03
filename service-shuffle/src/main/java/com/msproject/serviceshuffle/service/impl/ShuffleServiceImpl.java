package com.msproject.serviceshuffle.service.impl;

import com.msproject.serviceshuffle.exception.NumberOutOfRangeException;
import com.msproject.serviceshuffle.service.ShuffleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ShuffleServiceImpl implements ShuffleService {

    public List<Integer> createShuffledArray(Integer number) {

        if (number < 1 || number > 1000) {
            throw new NumberOutOfRangeException("The number should be from 1 to 1000!");
        }

        List<Integer> array = new ArrayList<>(number);

        for (int i = 1; i <= number; i++) {
            array.add(i);
        }

        Collections.shuffle(array);

        return array;
    }
}
