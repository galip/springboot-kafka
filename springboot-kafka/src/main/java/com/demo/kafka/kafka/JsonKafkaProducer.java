package com.demo.kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.demo.kafka.kafka.payload.Product;

@Service
public class JsonKafkaProducer {
	
	@Value("${spring.kafka.topic.json.name}")
	private String jsonTopicName;
	
	private static final Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	private KafkaTemplate<String, Product> kafkaTemplate;

	public JsonKafkaProducer(KafkaTemplate<String, Product> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(Product product) {
		Message<Product> message = MessageBuilder.withPayload(product)
				.setHeader(KafkaHeaders.TOPIC, jsonTopicName)
				.build();
		
		kafkaTemplate.send(message);
		logger.info("Message successfully sent. {}", product.toString());
	}
	

}
