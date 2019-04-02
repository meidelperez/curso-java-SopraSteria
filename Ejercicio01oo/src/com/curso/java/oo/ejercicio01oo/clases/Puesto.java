package com.curso.java.oo.ejercicio01oo.clases;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Puesto {

	@Value("Mesa chula amarillita")
	private String mesa;
	@Value("Silla molona y media rota")
	private String silla;
	@Value("false")
	private Boolean ordenador;
//	@Autowired
	Persona persona;

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

	public Boolean getOrdenador() {
		return ordenador;
	}

	public void setOrdenador(Boolean ordenador) {
		this.ordenador = ordenador;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Puesto [mesa=" + mesa + ", silla=" + silla + ", ordenador=" + ordenador + ", persona=" + persona + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mesa == null) ? 0 : mesa.hashCode());
		result = prime * result + (ordenador ? 1231 : 1237);
		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
		result = prime * result + ((silla == null) ? 0 : silla.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Puesto other = (Puesto) obj;
		if (mesa == null) {
			if (other.mesa != null)
				return false;
		} else if (!mesa.equals(other.mesa))
			return false;
		if (ordenador != other.ordenador)
			return false;
		if (persona == null) {
			if (other.persona != null)
				return false;
		} else if (!persona.equals(other.persona))
			return false;
		if (silla == null) {
			if (other.silla != null)
				return false;
		} else if (!silla.equals(other.silla))
			return false;
		return true;
	}

}
