package com.demo.numcheck;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
@Component
@Log4j2
public class NumChecker {
    private NumProcessor processor;

    @Autowired
    public NumChecker(NumProcessor processor){
        this.processor = processor;
    }

    @StreamListener(NumProcessor.IN)
    @SendTo(NumProcessor.OUTPUT)
    public Number numSorter(Number number) {
        if (number.getNumber() % 2 == 0) {
            number.setType(NumType.EVEN.name());
            processor.evenOutput().send(message(number));
        } else {
            number.setType(NumType.ODD.name());
            processor.oddOutput().send(message(number));
        }
        log.info("Number {} is {}, UUID = {}", number.getNumber(), number.getType(), number.getUuid());
        return number;
    }
    private static <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val).build();
    }
}
