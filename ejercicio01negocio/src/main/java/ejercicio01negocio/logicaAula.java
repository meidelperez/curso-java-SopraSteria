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

	public void asignarAlumnoAlAula(Estudiante alumno, Aula aula) throws Exception {
		Collection<Puesto> puestos = aula.getPuestosDeEstudiantes();
		Iterator<Puesto> iter = puestos.iterator();
		boolean encontradoLugar = false;
		Puesto puesto;
		while (!encontradoLugar && iter.hasNext()) {
			puesto = iter.next();
			if (puesto.getPersona() == null) {
				puesto.setPersona(alumno);
				encontradoLugar = true;
			}
		}
		if (!encontradoLugar) {
			throw new Exception("No hay espacio para el alumno");
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

	public logicaAula(IAulaDAO miDao) {
		super();
		this.aulaDao = miDao;
	}

	@Override
	public String toString() {
		return "logicaAula [aulaDao=" + aulaDao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aulaDao == null) ? 0 : aulaDao.hashCode());
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
		logicaAula other = (logicaAula) obj;
		if (aulaDao == null) {
			if (other.aulaDao != null)
				return false;
		} else if (!aulaDao.equals(other.aulaDao))
			return false;
		return true;
	}

	public logicaAula() {
		super();
	}
	

}
