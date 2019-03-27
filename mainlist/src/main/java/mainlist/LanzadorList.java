package mainlist;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.curso.java.oo.ejercicio01oo.clases.Aula;
import com.curso.java.oo.ejercicio01oo.clases.Estudiante;
import com.curso.java.oo.ejercicio01oo.clases.Persona;
import com.curso.java.oo.ejercicio01oo.clases.Puesto;

import ejercicio01dao.ListAulaDao;
import ejercicio01negocio.logicaAula;

public class LanzadorList {

	public static void main(String[] args) throws Exception {
		Collection<Puesto> puestosEstudiantes = new HashSet<Puesto>();
		Collection<Puesto> puestosEstudiantes1 = new HashSet<Puesto>();
		Estudiante alumno1 = new Estudiante("Meidel", "Perez", "55350125G", "Universitario", true, 8);
		Estudiante alumno2 = new Estudiante("Samuel", "Perez", "55350125G", "Universitario", false, 4);
		Estudiante alumno3 = new Estudiante("Claudia", "Perez", "55350125G", "Universitario", true, 7);
		Estudiante alumno4 = new Estudiante("Maria", "Perez", "55350125G", "Universitario", false, 10);
		Puesto puesto = new Puesto("Amarilla", "silla", true);
		Puesto puesto1 = new Puesto("Amarilla", "silla", true);
//		puesto1.setPersona(alumno1);
		Puesto puesto2 = new Puesto("Amarilla", "silla", true);
//		puesto2.setPersona(alumno2);
		Puesto puesto3 = new Puesto("Amarilla", "silla", true);
//		puesto3.setPersona(alumno3);
		puestosEstudiantes.add(puesto);
		puestosEstudiantes.add(puesto1);
		puestosEstudiantes1.add(puesto2);
		puestosEstudiantes1.add(puesto3);
		Aula aula = new Aula(true, "Caliso", true, (Set<Puesto>) puestosEstudiantes);
		Aula aula1 = new Aula(true, "Ketler", true, (Set<Puesto>) puestosEstudiantes1);
		logicaAula negocio = new logicaAula(new ListAulaDao());
		negocio.crearNuevaAula(aula1);
		negocio.crearNuevaAula(aula);
		negocio.asignarAlumnoAlAula(alumno1, aula);
		negocio.asignarAlumnoAlAula(alumno2, aula);
		negocio.asignarAlumnoAlAula(alumno3, aula1);
		negocio.asignarAlumnoAlAula(alumno4, aula1);
		Collection<Persona> listaAlumnosAula = negocio.listaDeAlumnosPorAula("Caliso");
		int i = 1;
		for (Persona estudiante : listaAlumnosAula) {
			System.out.println("Nombre estudiante " + i + " " + estudiante.getName() + "en el aula Caliso");
			i++;
		}
		negocio.eliminarAula("Ketler");

	}

}
