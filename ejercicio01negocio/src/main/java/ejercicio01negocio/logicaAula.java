package ejercicio01negocio;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import com.curso.java.oo.ejercicio01oo.clases.Aula;
import com.curso.java.oo.ejercicio01oo.clases.Estudiante;
import com.curso.java.oo.ejercicio01oo.clases.Persona;
import com.curso.java.oo.ejercicio01oo.clases.Profesor;
import com.curso.java.oo.ejercicio01oo.clases.Puesto;

import ejercicio01dao.IAulaDAO;

public class logicaAula {
	private IAulaDAO aulaDao;

	public void crearNuevaAula(Aula aula) {
		aulaDao.createAula(aula);
//		System.out.println("Aula "+ aula.getNombre()+" creada.");
	}

	public void eliminarAula(String identificadorUnicoAula) {
		aulaDao.deleteAula(identificadorUnicoAula);
//		System.out.println("Aula "+ identificadorUnicoAula+" eliminada.");

	}

	// terminar
	public void asignarAlumnoAlAula(Estudiante alumno, Aula aula) {
		Collection<Puesto> puestos = aula.getPuestosDeEstudiantes();
		Iterator<Puesto> iter = puestos.iterator();
		boolean encontradoLugar = false;
		Puesto puesto;
		while (!encontradoLugar && iter.hasNext()) {
			puesto = iter.next();
			if (puesto.getPersona() == null) {
				puesto.setPersona(alumno);
				encontradoLugar = true;
//				System.out.println("Alumno "+ alumno.getName().toUpperCase()+" insertado en el aula "+ aula.getNombre()+".");

			}

//		for (Puesto puesto : puestos) {
//			if(puesto.getPersona() == null) {
//				puesto.setPersona(alumno);
//				break;
//			}
		}
		if (!encontradoLugar) {
			System.out.println("No hay lugar en el aula");
		}
	}

	public Collection<Persona> listaDeAlumnosPorAula(String idAula) {
		Collection<Persona> estudiantes = new HashSet<Persona>();
		Collection<Puesto> puestos = aulaDao.getAulaById(idAula).getPuestosDeEstudiantes();
		for (Puesto puesto : puestos) {
			if (puesto.getPersona() != null) {
				estudiantes.add((Estudiante) puesto.getPersona());
			}
		}

		return estudiantes;
	}

	public Collection<Persona> listaDeProfesoresPorAula(String idAula) {
		Collection<Persona> profesores = new HashSet<Persona>();
		profesores.add((Profesor) aulaDao.getAulaById(idAula).getPuestoProfe().getPersona());
		Collection<Puesto> puestos = aulaDao.getAulaById(idAula).getPuestosDeEstudiantes();
		for (Puesto puesto : puestos) {
			if (puesto.getPersona() instanceof Profesor) {
				profesores.add((Profesor) puesto.getPersona());
			}
		}
		return profesores;
	}

	public logicaAula(IAulaDAO aulaDao) {
		super();
		this.aulaDao = aulaDao;
	}

}
