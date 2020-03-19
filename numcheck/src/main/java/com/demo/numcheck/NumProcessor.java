package com.demo.numcheck;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface NumProcessor {

    String IN = "output";
    String ODD_OUT = "odd";
    String EVEN_OUT = "even";

    @Input(IN)
    SubscribableChannel numSource();

    @Output(ODD_OUT)
    MessageChannel oddOutput();

    @Output(EVEN_OUT)
    MessageChannel evenOutput();
}
