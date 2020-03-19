package com.demo.numcheck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
@Component
public class NumChecker {

    public static final Logger log = LoggerFactory.getLogger(NumChecker.class);
    private NumProcessor processor;

    @Autowired
    public NumChecker(NumProcessor processor){
        this.processor = processor;
    }

    @StreamListener(NumProcessor.IN)
    public void numSorter(Number number)
    {
        log.info("Number {} is {}", number.getNumber(), number.getType());
        if (number.getNumber() % 2 == 0)
        {
            number.setType(NumType.EVEN.name());
            processor.evenOutput().send(message(number));
        } else
            {
                number.setType(NumType.ODD.name());
                processor.oddOutput().send(message(number));
            }
        log.info("Number {} is {}", number.getNumber(), number.getType());
    }
    private static <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val).build();
    }
}
