package com.example.demo.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public  class Actividad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descripcion;
	private int duracion;
	
	@OneToMany(mappedBy = "actividad")
	private List<ActividadGrupoMonitor> actividades=new ArrayList<>();

	public List<ActividadGrupoMonitor> getActividades() {
		return actividades;
	}


	public boolean add(ActividadGrupoMonitor e) {
		return actividades.add(e);
	}

	@Override
	public String toString() {
		return descripcion;
	}

	public Long getID() {
		return id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Actividad(String descripcion, int duracion) {
		super();
		this.descripcion = descripcion;
		this.duracion = duracion;
	}

	public Actividad() {
		super();
	}
	
}
