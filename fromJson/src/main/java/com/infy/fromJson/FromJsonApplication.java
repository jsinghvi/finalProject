package com.infy.fromJson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infy.fromJson.DAO.ProducerDataImpl;
import com.infy.fromJson.service.Publisher;

@SpringBootApplication
public class FromJsonApplication implements CommandLineRunner {

	@Autowired
	ProducerDataImpl pd;
	@Autowired
	Publisher p;
	
	public static void main(String[] args){
		SpringApplication.run(FromJsonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		p.sendMessage();
	}
}
