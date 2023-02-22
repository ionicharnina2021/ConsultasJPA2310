package com.example.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Monitor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String apodo;

	public Monitor(String apodo) {
		super();
		this.apodo = apodo;
	}

	private Monitor() {
		super();
	}
	
	

}
