package com.infy.fromJson.DAO;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.infy.model.Patient;

@Repository
public class ProducerDataImpl implements ProducerData{

	@Override
	public Patient readData() throws Exception{
		Object obj = new JSONParser().parse(new FileReader("/home/kullu/Downloads/fromJson/src/main/resources/patient1.json")); 
        JSONObject jo = (JSONObject) obj; 
       
        int personId = Integer.parseInt((String) jo.get("personId"));
        String firstName = (String) jo.get("firstName"); 
        String lastName = (String) jo.get("lastName"); 
       
        String address = (String) jo.get("address");
        Patient p = new Patient();
       Logger logger = LoggerFactory.getLogger(this.getClass());
       logger.info("Reading data from JSON");
        p.setPersonId(personId);
        p.setFirstName(firstName);
        p.setLastName(lastName);
       
        p.setAddress(address);
//        System.out.println("first Name : "+ p.getFirstName());
//        System.out.println("last name : " + p.getLastName());
//        System.out.println("person Id : " + p.getPersonId());
        return p;
	}

}
