package com.curso.java.oo.ejercicio01oo.clases;

public class Estudiante extends Persona {

	private String estudiosCursados;
	private boolean atiendeEnClases;
	private Integer calificacion;

	public Estudiante(String name, String apellidos, String carnetDeIdentidad, String estudiosCursados,
			boolean atiendeEnClases, Integer calificacion) {
		super(name, apellidos, carnetDeIdentidad);
		this.estudiosCursados = estudiosCursados;
		this.atiendeEnClases = atiendeEnClases;
		this.calificacion = calificacion;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public String getEstudiosCursados() {
		return estudiosCursados;
	}

	public void setEstudiosCursados(String estudiosCursados) {
		this.estudiosCursados = estudiosCursados;
	}

	public boolean getAtiendeEnClases() {
		return atiendeEnClases;
	}

	public void setAtiendeEnClases(boolean atiendeEnClases) {
		this.atiendeEnClases = atiendeEnClases;
	}
}
