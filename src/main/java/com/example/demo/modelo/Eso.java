package com.example.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Eso extends Nino{
	@ManyToOne
	private Tienda tienda;

	public Eso(String nombre, int edad, Grupo grupo, Tienda tienda) {
		super(nombre, edad, grupo);
		this.tienda = tienda;
	}

	public Eso() {
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
}
