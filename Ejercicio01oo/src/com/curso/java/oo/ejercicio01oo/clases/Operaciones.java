package com.curso.java.oo.ejercicio01oo.clases;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Operaciones")
public class Operaciones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "tipodeoperacion")
	private String tipoDeOperacion;
	@Column(name = "descripcion")
	private String descripcionOperacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipoDeOperacion() {
		return tipoDeOperacion;
	}

	public void setTipoDeOperacion(String tipoDeOperacion) {
		this.tipoDeOperacion = tipoDeOperacion;
	}

	public String getDescripcionOperacion() {
		return descripcionOperacion;
	}

	public void setDescripcionOperacion(String descripcionOperacion) {
		this.descripcionOperacion = descripcionOperacion;
	}

	public Operaciones(int id, Date fecha, String tipoDeOperacion, String descripcionOperacion) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.tipoDeOperacion = tipoDeOperacion;
		this.descripcionOperacion = descripcionOperacion;
	}

	@Override
	public String toString() {
		return "Operaciones [id=" + id + ", fecha=" + fecha + ", tipoDeOperacion=" + tipoDeOperacion
				+ ", descripcionOperacion=" + descripcionOperacion + "]";
	}

	public Operaciones() {
		super();
		// TODO Auto-generated constructor stub
	}

}
