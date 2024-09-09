package com.demo.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kafka.kafka.JsonKafkaProducer;
import com.demo.kafka.kafka.payload.Product;

@RestController
@RequestMapping("/api/v1/kafkajson")
public class JsonMessageController {
	
	private JsonKafkaProducer jsonKafkaProducer;

	public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
		this.jsonKafkaProducer = jsonKafkaProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody Product product) {
		jsonKafkaProducer.sendMessage(product);
		return ResponseEntity.ok("Json is successfully sent to kafka topic!");
	}
	

}
