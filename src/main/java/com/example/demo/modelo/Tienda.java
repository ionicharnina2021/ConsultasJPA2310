package com.example.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private float temperaturaMinima;
	public Tienda(String nombre, float temperatura) {
		super();
		this.nombre = nombre;
		this.temperaturaMinima = temperatura;
	}
	public Tienda() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getTemperaturaMinima() {
		return temperaturaMinima;
	}
	public void setTemperaturaMinima(float temperatura) {
		this.temperaturaMinima = temperatura;
	}
    
    
}
