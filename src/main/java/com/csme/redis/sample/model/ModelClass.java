package com.csme.redis.sample.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Component
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ModelClass implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
	private String cMainRef;
	private String name;
	private String city;
	private String contact;

	public ModelClass() {
	}

	public ModelClass(String cMainRef, String name, String city, String contact) {
		super();
		this.cMainRef = cMainRef;
		this.name = name;
		this.city = city;
		this.contact = contact;
	}

	public String getcMainRef() {
		return cMainRef;
	}

	public void setcMainRef(String cMainRef) {
		this.cMainRef = cMainRef;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
