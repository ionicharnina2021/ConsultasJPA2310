package com.example.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Primaria extends Nino{
	@ManyToOne
	private Cabana cabana;


	public Cabana getCabana() {
		return cabana;
	}

	public void setCabana(Cabana cabana) {
		this.cabana = cabana;
	}

	public Primaria(String nombre, int edad, Grupo grupo, Cabana cabana) {
		super(nombre, edad, grupo);
		this.cabana = cabana;
	}

	public Primaria() {
	}
}
