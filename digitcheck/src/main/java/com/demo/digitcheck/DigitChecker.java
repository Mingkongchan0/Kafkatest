package com.demo.digitcheck;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.Range;
import org.apache.kafka.common.internals.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class DigitChecker {
    private NumProcessor processor;
    @Autowired
    public DigitChecker(NumProcessor processor) {
        this.processor=processor;
    }

    @StreamListener(NumProcessor.INPUT)
    public void digitSorter(Number number) {
        if(Range.between(0,9).contains(number.getNumber())){
            number.setType(NumType.ONE_DIGIT.name());
        }
        if(Range.between(10,99).contains(number.getNumber())){
            number.setType(NumType.TWO_DIGIT.name());
        }
        if(Range.between(100,999).contains(number.getNumber())){
            number.setType(NumType.THREE_DIGIT.name());
        }
        if(Range.between(1000,2000).contains(number.getNumber())){
            number.setType(NumType.FOUR_DIGIT.name());
        }
        processor.digitOutput().send(message(number));
        log.info("Number {} has {}, UUID = {}", number.getNumber(), number.getType(), number.getUuid());
    }
    private static <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val).build();
    }
}
