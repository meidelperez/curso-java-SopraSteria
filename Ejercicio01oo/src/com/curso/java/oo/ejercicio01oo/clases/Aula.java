package com.curso.java.oo.ejercicio01oo.clases;

import java.util.Set;

public class Aula {

	// Profesor profe;
	private boolean tienePizarra;
	private String nombre;
	private boolean tieneProyector;
	private Puesto puestoProfe;
	private Set<Puesto> puestosDeEstudiantes;

	public Aula(boolean tienePizarra, String nombre, boolean tieneProyector, Set<Puesto> estudiantes) {
		super();
		this.tienePizarra = tienePizarra;
		this.nombre = nombre;
		this.tieneProyector = tieneProyector;
		this.puestosDeEstudiantes = estudiantes;

	}

	public boolean isTienePizarra() {
		return tienePizarra;
	}

	public void setTienePizarra(boolean tienePizarra) {
		this.tienePizarra = tienePizarra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isTieneProyector() {
		return tieneProyector;
	}

	public void setTieneProyector(boolean tieneProyector) {
		this.tieneProyector = tieneProyector;
	}

	public Puesto getPuestoProfe() {
		return puestoProfe;
	}

	public void setPuestoProfe(Puesto puestoProfe) {
		this.puestoProfe = puestoProfe;
	}

	public Set<Puesto> getPuestosDeEstudiantes() {
		return puestosDeEstudiantes;
	}

	public void setPuestosDeEstudiantes(Set<Puesto> puestosDeEstudiantes) {
		this.puestosDeEstudiantes = puestosDeEstudiantes;
	}

	

}
