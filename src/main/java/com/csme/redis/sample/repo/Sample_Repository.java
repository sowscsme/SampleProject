package com.csme.redis.sample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csme.redis.sample.model.ModelClass;

@Repository
public interface Sample_Repository extends JpaRepository<ModelClass,String>{

}
