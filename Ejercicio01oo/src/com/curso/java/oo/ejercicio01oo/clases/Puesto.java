package com.curso.java.oo.ejercicio01oo.clases;

public class Puesto {

	private String mesa;
	private String silla;
	private boolean ordenador;
	Persona persona;

	public Puesto(String mesa, String silla, boolean ordenador) {
		super();
		this.mesa = mesa;
		this.silla = silla;
		this.ordenador = ordenador;

	}

	public String getMesa() {
		return mesa;
	}

	public void setMesa(String mesa) {
		this.mesa = mesa;
	}

	public String getSilla() {
		return silla;
	}

	public void setSilla(String silla) {
		this.silla = silla;
	}

	public boolean isOrdenador() {
		return ordenador;
	}

	public void setOrdenador(boolean ordenador) {
		this.ordenador = ordenador;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
