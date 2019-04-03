package com.curso.java.oo.ejercicio01oo.clases;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Profesor extends Persona {

	private String gradoDeProfesor;
	@Value("false")
	private Boolean esMajo;

	public String getGradoDeProfesor() {
		return gradoDeProfesor;
	}

	public void setGradoDeProfesor(String gradoDeProfesor) {
		this.gradoDeProfesor = gradoDeProfesor;
	}

	@Override
	public String toString() {
		return "Profesor [gradoDeProfesor=" + gradoDeProfesor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((gradoDeProfesor == null) ? 0 : gradoDeProfesor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		if (gradoDeProfesor == null) {
			if (other.gradoDeProfesor != null)
				return false;
		} else if (!gradoDeProfesor.equals(other.gradoDeProfesor))
			return false;
		return true;
	}

	public Boolean getEsMajo() {
		return esMajo;
	}

	public void setEsMajo(Boolean esMajo) {
		this.esMajo = esMajo;
	}

}
