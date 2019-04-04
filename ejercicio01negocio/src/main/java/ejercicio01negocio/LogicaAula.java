package ejercicio01negocio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
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
import operacionesdao.IOperacionesDAO;

@Service
public class LogicaAula {
	@Autowired
	@Qualifier("miDao")
	private IAulaDAO aulaDao;
	@Autowired
	private IOperacionesDAO operacionesDao;
	private Operaciones operacion;

	public void crearNuevaAula(Aula aula) {
		aulaDao.createAula(aula);
		String descripcionOperacion = "Se ha creado un aula nueva con el nombre: " + aula.getNombre();
		String tipoDeOperacion = "Crear Aula";
		insertarEnOperaciones(new Date(new java.util.Date().getTime()), descripcionOperacion, tipoDeOperacion);

//		System.out.println("Aula "+ aula.getNombre()+" creada.");
	}

	@Transactional
	public void eliminarAula(String identificadorUnicoAula) {
		aulaDao.deleteAula(identificadorUnicoAula);
		operacion.setFecha(Calendar.getInstance().getTime());
		String descripcionOperacion = "Se ha eliminado un aula nueva con el nombre: " + identificadorUnicoAula;
		String tipoDeOperacion = "Eliminar Aula";
		insertarEnOperaciones(new Date(new java.util.Date().getTime()), descripcionOperacion, tipoDeOperacion);

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

		String descripcionOperacion = "Se ha asignado el alumno: " + alumno.getName() + " al aula: " + aula.getNombre();
		String tipoDeOperacion = "Insertar alumno en aula";
		insertarEnOperaciones(new Date(new java.util.Date().getTime()), descripcionOperacion, tipoDeOperacion);

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

		super();
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

	private void insertarEnOperaciones(Date fechaDeOperacion, String descripcionOperacion, String tipoDeOperacion) {
		operacion = new Operaciones();
		operacion.setFecha(fechaDeOperacion);
		operacion.setDescripcionOperacion(descripcionOperacion);
		operacion.setTipoDeOperacion(tipoDeOperacion);
		operacionesDao.insertarOperacion(operacion);
	}
}
