package com.curso.java.oo.ejercicio01oo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.curso.java.oo.ejercicio01oo.clases.Aula;
import com.curso.java.oo.ejercicio01oo.clases.Estudiante;
import com.curso.java.oo.ejercicio01oo.clases.Profesor;
import com.curso.java.oo.ejercicio01oo.clases.Puesto;

public class LanzadorAulaKepler {
	public static void main(String[] args) {

		Aula aula = new Aula(true, "Kepler", true, new HashSet<Puesto>());
		aula.setPuestoProfe(new Puesto("Mesa amarilla", "Silla negra y azul", true));
		for (int i = 0; i < 14; i++) {
			aula.getPuestosDeEstudiantes().add(new Puesto("Mesa amarilla", "Silla negra y azul", true));
		}
		aula.getPuestosDeEstudiantes().add(new Puesto("Mesa amarilla", "Silla negra y azul", false));
		System.out.println("algo");
		aula.getPuestoProfe().setPersona(new Profesor("Titular", "Ruben", "Garcia", "55350125"));
		Set<Puesto> puestos = aula.getPuestosDeEstudiantes();
		Iterator<Puesto> iterator = puestos.iterator();
		int numeroDeAlumnos = 12;
		while (iterator.hasNext() && numeroDeAlumnos > 0) {
			Puesto puestoActual = iterator.next();
			if (puestoActual.isOrdenador())
				;
			{
				puestoActual.setPersona(new Estudiante("Meidel", "Perez", "5535", "Universitario", true, 10));
				numeroDeAlumnos--;
			}

		}
	}

}
