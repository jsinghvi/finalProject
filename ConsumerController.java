package com.infy.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.client.RestTemplate;

import com.infy.consumer.model.Account;
import com.infy.consumer.model.Patient;
import com.infy.consumer.service.ConsumerService;

public class ConsumerController {
	
	@Autowired
	ConsumerService consumerService;
	
	 
	
	 @StreamListener(ProducerDataStream.INPUT)
	 public void consume(@Payload Patient patient) {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		try {

			logger.info("Data received from Producer " + patient);
			
			int patientId=consumerService.consume(patient);
			

			final String uri = "http://localhost:9003/account/" + patientId;
			RestTemplate restTemplate = new RestTemplate();
			Account account = restTemplate.getForObject(uri, Account.class);
			
			
			Integer pId=consumerService.saveRecord(account);
			
			logger.info("Recored Saved for Patient Id: "+pId);
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
			logger.error("Exception occured in consumer " + e.getMessage());
		}

	}

}
