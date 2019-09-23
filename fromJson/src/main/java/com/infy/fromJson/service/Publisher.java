package com.infy.fromJson.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.infy.fromJson.DAO.ProducerData;
import com.infy.model.Patient;

@Service
public class Publisher {

	@Autowired
	ProducerData pd;
	private static final String TOPIC = "Test";

	@Autowired

	private KafkaTemplate<String,String> kafkaTemplate;

	public void sendMessage(){
	Patient p = new Patient();
	try {
		p = pd.readData();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Message<Patient> message = MessageBuilder
            .withPayload(p)
            .setHeader(KafkaHeaders.TOPIC, TOPIC)
            .build();

    Logger logger = LoggerFactory.getLogger(this.getClass());
    logger.info("Sending data from Producer to Kafka");
    logger.info("Message = "+p.toString());
    
    kafkaTemplate.send(TOPIC,p.toString());

	}
}
