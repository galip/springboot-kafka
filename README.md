# Spring boot kafka demo application

# kafka version: kafka_2.13-3.8.0
# java version: 21


# What does this application do? 

1) Creates a topic which is "products" in this demo.

2) Sends message to this topic through producer.

3) Listens the message via consumer.


http://localhost:8080/api/v1/kafka/publish?message=heyGalip

<img width="587" alt="image" src="https://github.com/user-attachments/assets/f574d49a-a2b5-42f4-8410-7c71f299656c">


If you listen the consumer for the same topic,products,you will get the message.

This is the command for this;

kafka % bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic products --from-beginning

<img width="587" alt="image" src="https://github.com/user-attachments/assets/7d30afed-9f22-4671-9c1a-9c636aaaa564">
