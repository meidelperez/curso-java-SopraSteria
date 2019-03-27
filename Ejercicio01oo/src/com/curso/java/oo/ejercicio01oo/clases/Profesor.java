package com.curso.java.oo.ejercicio01oo.clases;

public class Profesor extends Persona {

	private String gradoDeProfesor;


	public Profesor(String gradoDeProfesor, String nombre, String apellidos, String carnetDeIdentidad) {
		super(nombre, apellidos, carnetDeIdentidad);
		this.gradoDeProfesor = gradoDeProfesor;
	}

	public String getGradoDeProfesor() {
		return gradoDeProfesor;
	}

	public void setGradoDeProfesor(String gradoDeProfesor) {
		this.gradoDeProfesor = gradoDeProfesor;
	}
}
