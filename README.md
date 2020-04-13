# Event-driven Microservice using Spring Cloud Stream with Kafka demonstration

This repository consists of 3 applications, which are Kafkatest(producer), Numcheck(consumer), and Digitcheck(consumer). 

It is compulsory to utilize Docker if Kafka is not configured on your computer.

## How to run the application

Git bash on/to the root folder containing docker-compose yml, and use the following command

>docker-compose up

Make sure that the container is running and stable via Docker's dashboard.

Next, launch the applications in the following order

1.Kafkatest
2.Numcheck
3.Digitcheck

