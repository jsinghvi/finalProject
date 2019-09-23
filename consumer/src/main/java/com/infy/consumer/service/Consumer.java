package com.infy.consumer.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infy.consumer.dao.ConsumerDao;
import com.infy.consumer.model.ResultModel;

@Service
public class Consumer {

	
    @KafkaListener(topics = "Test", groupId = "group_id")
    public void consume(String message) throws IOException {
        System.out.println("rec message : " + message);
        String[] arr = message.split(",");
        
        final String uri = "http://localhost:9003/account/"+arr[0];
        RestTemplate restTemplate = new RestTemplate();
       Object result = restTemplate.getForObject(uri, String.class);
       ResultModel rm = (ResultModel) result;
        com.infy.consumer.model.Consumer con = new com.infy.consumer.model.Consumer();
        con.setPersonId(Integer.parseInt(arr[0]));
        con.setFirstName(arr[1]);
        con.setLastName(arr[2]);
        con.setAddress(arr[3]);
        con.setSalary(rm.getSalary());
        con.setDepartment(rm.getDepartment());
        con.setDesg(rm.getDesg());
        ConsumerDao cd = new ConsumerDao();
        cd.saveRecord(con);
        
        

    }
}
