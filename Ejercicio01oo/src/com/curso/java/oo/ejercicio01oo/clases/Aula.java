package com.curso.java.oo.ejercicio01oo.clases;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Aula {

	// Profesor profe;
	@Value("false")
	private Boolean tienePizarra;
	private String nombre;
	@Value("false")
	private Boolean tieneProyector;
	@Autowired
	private Puesto puestoProfe;
	@Autowired
	@Qualifier("collectionArrayList")
	private Collection<Puesto> puestosDeEstudiantes;

	public Boolean getTienePizarra() {
		return tienePizarra;
	}

	public void setTienePizarra(Boolean tienePizarra) {
		this.tienePizarra = tienePizarra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getTieneProyector() {
		return tieneProyector;
	}

	public void setTieneProyector(Boolean tieneProyector) {
		this.tieneProyector = tieneProyector;
	}

	public Puesto getPuestoProfe() {
		return puestoProfe;
	}

	public void setPuestoProfe(Puesto puestoProfe) {
		this.puestoProfe = puestoProfe;
	}

	public Collection<Puesto> getPuestosDeEstudiantes() {
		return puestosDeEstudiantes;
	}

	public void setPuestosDeEstudiantes(Collection<Puesto> puestosDeEstudiantes) {
		this.puestosDeEstudiantes = puestosDeEstudiantes;
	}

	@Override
	public String toString() {
		return "Aula [tienePizarra=" + tienePizarra + ", nombre=" + nombre + ", tieneProyector=" + tieneProyector
				+ ", puestoProfe=" + puestoProfe + ", puestosDeEstudiantes=" + puestosDeEstudiantes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((puestoProfe == null) ? 0 : puestoProfe.hashCode());
		result = prime * result + ((puestosDeEstudiantes == null) ? 0 : puestosDeEstudiantes.hashCode());
		result = prime * result + (tienePizarra ? 1231 : 1237);
		result = prime * result + (tieneProyector ? 1231 : 1237);
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
		Aula other = (Aula) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (puestoProfe == null) {
			if (other.puestoProfe != null)
				return false;
		} else if (!puestoProfe.equals(other.puestoProfe))
			return false;
		if (puestosDeEstudiantes == null) {
			if (other.puestosDeEstudiantes != null)
				return false;
		} else if (!puestosDeEstudiantes.equals(other.puestosDeEstudiantes))
			return false;
		if (tienePizarra != other.tienePizarra)
			return false;
		if (tieneProyector != other.tieneProyector)
			return false;
		return true;
	}

}
