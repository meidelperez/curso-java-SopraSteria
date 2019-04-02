package com.curso.java.oo.ejercicio01oo.clases;

//@Component
//@Scope(value = "prototype")
public abstract class Persona {

	private String nombre;
	private String apellidos;
	private String carnetDeIdentidad;

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

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((carnetDeIdentidad == null) ? 0 : carnetDeIdentidad.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Persona other = (Persona) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (carnetDeIdentidad == null) {
			if (other.carnetDeIdentidad != null)
				return false;
		} else if (!carnetDeIdentidad.equals(other.carnetDeIdentidad))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public Persona() {
		super();
	}

}
