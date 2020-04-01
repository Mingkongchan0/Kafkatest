package com.demo.digitcheck;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface NumProcessor {

    String INPUT = "digitcheck";
    String DIGIT_OUT = "digit";

    @Input(INPUT)
    SubscribableChannel digitcheck();

    @Output(DIGIT_OUT)
    MessageChannel digitOutput();
}
