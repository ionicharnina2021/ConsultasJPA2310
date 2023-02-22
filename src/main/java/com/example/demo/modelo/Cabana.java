package com.example.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cabana {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private boolean climatizada;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isClimatizada() {
		return climatizada;
	}
	public void setClimatizada(boolean climatizada) {
		this.climatizada = climatizada;
	}
	public Cabana(String nombre, boolean climatizada) {
		super();
		this.nombre = nombre;
		this.climatizada = climatizada;
	}
	public Cabana() {
		super();
	}
    
    
}
