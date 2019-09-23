package com.infy.consumer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.introspect.WithMember;
import com.infy.consumer.entity.ConsumerEntity;
import com.infy.consumer.model.Consumer;


@Repository
@Transactional
public class ConsumerDao {
	@PersistenceContext
	EntityManager entity;
	
	public String saveRecord(Consumer consumer) {
		ConsumerEntity ce = new ConsumerEntity();
		ce.setAddress(consumer.getAddress());
		ce.setDepartment(consumer.getDepartment());
		ce.setDesg(consumer.getDesg());
		ce.setFirstname(consumer.getFirstName());
		ce.setLastname(consumer.getLastName());
		ce.setPersonid(consumer.getPersonId());
		entity.persist(ce);
		return "Person with id "+consumer.getPersonId()+" is added";
	}
}
