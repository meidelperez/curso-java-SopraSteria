package ejercicio01negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.java.oo.ejercicio01oo.clases.Aula;
import com.curso.java.oo.ejercicio01oo.clases.Operaciones;
import com.curso.java.oo.ejercicio01oo.clases.Persona;
import com.curso.java.oo.ejercicio01oo.clases.Profesor;
import com.curso.java.oo.ejercicio01oo.clases.Puesto;

import ejercicio01dao.IAulaDAO;
import ejercicio01dao.ListAulaDao;
import operacionesdao.IOperacionesDAO;

@Service
public class LogicaAula {
	@Autowired
	@Qualifier("miDao")
	private IAulaDAO aulaDao;
	@Autowired
	private IOperacionesDAO operacionesDao;
	@Autowired
	private Operaciones operacion;

	public void crearNuevaAula(Aula aula) {
		aulaDao.createAula(aula);
		operacion.setFecha(new Date());
		operacion.setDescripcionOperacion("Se ha creado un aula nueva con el nombre: " + aula.getNombre());
		operacion.setTipoDeOperacion("Crear Aula");
		operacionesDao.insertarOperacion(operacion);
//		System.out.println("Aula "+ aula.getNombre()+" creada.");
	}

	@Transactional
	public void eliminarAula(String identificadorUnicoAula) {
		aulaDao.deleteAula(identificadorUnicoAula);
		operacion.setFecha(new Date());
		operacion.setDescripcionOperacion("Se ha eliminado un aula nueva con el nombre: " + identificadorUnicoAula);
		operacion.setTipoDeOperacion("Eliminar Aula");
		operacionesDao.insertarOperacion(operacion);

//		System.out.println("Aula "+ identificadorUnicoAula+" eliminada.");

	}

	@Transactional
	public void asignarAlumnoAlAula(Persona alumno, Aula aula) throws Exception {
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
//			throw new Exception("No hay espacio para el alumno");
		}

		operacion.setFecha(new Date());
		operacion.setDescripcionOperacion(
				"Se ha asignado el alumno: " + alumno.getName() + " al aula: " + aula.getNombre());
		operacion.setTipoDeOperacion("Insertar alumno en aula");
		operacionesDao.insertarOperacion(operacion);

	}

	@Transactional
	public Collection<Persona> listaDeAlumnosPorAula(String idAula) {
		Collection<Persona> estudiantes = new ArrayList<Persona>();
		Collection<Puesto> puestos = aulaDao.getAulaById(idAula).getPuestosDeEstudiantes();
		for (Puesto puesto : puestos) {
			if (puesto.getPersona() != null) {
				estudiantes.add(puesto.getPersona());
			}
		}

		return estudiantes;
	}

	@Transactional
	public Collection<Persona> listaDeProfesoresPorAula(String idAula) {
		Collection<Persona> profesores = new HashSet<Persona>();
		profesores.add(aulaDao.getAulaById(idAula).getPuestoProfe().getPersona());
		Collection<Puesto> puestos = aulaDao.getAulaById(idAula).getPuestosDeEstudiantes();
		for (Puesto puesto : puestos) {
			if (puesto.getPersona() instanceof Profesor) {
				profesores.add(puesto.getPersona());
			}
		}
		return profesores;
	}

	public LogicaAula(IAulaDAO miDao) {
		super();
		this.aulaDao = miDao;
	}

	public LogicaAula() {
		aulaDao = new ListAulaDao();
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
		LogicaAula other = (LogicaAula) obj;
		if (aulaDao == null) {
			if (other.aulaDao != null)
				return false;
		} else if (!aulaDao.equals(other.aulaDao))
			return false;
		return true;
	}

	public IAulaDAO getAulaDao() {
		return aulaDao;
	}

	public void setAulaDao(IAulaDAO aulaDao) {
		this.aulaDao = aulaDao;
	}

}
