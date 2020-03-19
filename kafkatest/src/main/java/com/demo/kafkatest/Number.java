package com.demo.kafkatest;

import lombok.Data;

import java.util.Objects;
@Data
public class Number {
    private int number;
    private String type, uuid;
    public void setType(String type)
    {
        if (type.equals(NumType.ODD.name())||type.equals(NumType.EVEN.name())||type.equals(NumType.PENDING.name()))
        {
            this.type = type;
        }
        else
        {
            throw new IllegalArgumentException("Cannot set type to " + type);
        }
    }
    public Number(String uuid, int number) {
        this.uuid = uuid;
        this.number = number;
        this.setType(NumType.PENDING.name());
    }
}
