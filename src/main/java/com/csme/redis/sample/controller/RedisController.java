package com.csme.redis.sample.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.csme.redis.sample.model.ModelClass;
import com.csme.redis.sample.repo.Sample_Repository;
@EnableCaching
@RestController
public class RedisController {

	@Autowired
	private ModelClass model;
	
	@Autowired
	private Sample_Repository repo;
	
	@PostConstruct
	public void init(){
		for(int i=100000;i<=100050;i++){
		 model = new ModelClass(i+"","Customer"+i,"123456789"+i,"city"+i);
		 repo.save(model);
		}
	}
	
    @SuppressWarnings("deprecation")
	@Cacheable(key = "#cMainRef", value = "Model")
	@GetMapping("/getCustomerDetails/{cMainRef}")
	public ModelClass getCustomerDetails(@PathVariable String cMainRef) {
		try {
			model = repo.getById(cMainRef);
			System.out.println("Model "+model);
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		return model;

	}
    
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}

}
