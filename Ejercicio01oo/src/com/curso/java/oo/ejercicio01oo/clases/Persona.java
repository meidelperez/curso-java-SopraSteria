package com.curso.java.oo.ejercicio01oo.clases;

public abstract class Persona {

	private String nombre;
	private String apellidos;
	private String carnetDeIdentidad;

	public Persona(String name, String apellidos, String carnetDeIdentidad) {
		super();
		this.nombre = name;
		this.apellidos = apellidos;
		this.carnetDeIdentidad = carnetDeIdentidad;
	}

	public String getName() {
		return nombre;
	}

	public void setName(String name) {
		nombre = name;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCarnetDeIdentidad() {
		return carnetDeIdentidad;
	}

	public void setCarnetDeIdentidad(String carnetDeIdentidad) {
		this.carnetDeIdentidad = carnetDeIdentidad;
	}

}
