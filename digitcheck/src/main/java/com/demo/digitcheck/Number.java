package com.demo.digitcheck;

import lombok.Data;

import java.util.UUID;

@Data
public class Number {
    private int number;
    private String type, uuid;
    public Number(){
        super();
    }
    public Number(String uuid, int number) {
        this.uuid = uuid;
        this.number = number;
        this.setType(NumType.PENDING.name());
    }
    public int getNumber(int number)
    {
        return this.number=number;
    }
    public String getUuid(UUID uuid)
    {
        return this.uuid=uuid.toString();
    }
    public void setType(String type) {
        if (type.equals(NumType.ODD.name())||
                type.equals(NumType.EVEN.name())||
                type.equals(NumType.PENDING.name())||
                type.equals(NumType.ONE_DIGIT.name())||
                type.equals(NumType.TWO_DIGIT.name())||
                type.equals(NumType.THREE_DIGIT.name())||
                type.equals((NumType.FOUR_DIGIT.name()))) {
            this.type = type;
        }
        else {
            throw new IllegalArgumentException("Cannot set type to " + type);
        }
    }

}
