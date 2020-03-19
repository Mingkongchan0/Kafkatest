package com.demo.numcheck;

import java.util.Objects;
public class Number {
    private int number;
    private String type, uuid;

    public Number(){}

    public Number(String uuid, int number) {
        this.uuid = uuid;
        this.number = number;
        this.setType(NumType.PENDING.name());
    }

    public int getNumber()
    {
        return number;
    }
    public String getType()
    {
        return type;
    }
    public String getUuid(){
        return uuid;
    }
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
    @Override
    public String toString() {
        return "Number{" +
                "Number='" + number + '\'' +
                ", uuid=" + uuid +
                ", type='" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number that = (Number) o;
        return number == that.number &&
                uuid.equals(that.uuid) &&
                Objects.equals(type, that.type);
    }
    @Override
    public int hashCode() {
        return Objects.hash(uuid, number, type);
    }

}