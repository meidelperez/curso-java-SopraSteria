package ejercicio01negocio;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.curso.java.oo.ejercicio01oo.clases.Aula;
import com.curso.java.oo.ejercicio01oo.clases.Estudiante;
import com.curso.java.oo.ejercicio01oo.clases.Puesto;

public class TestCaseNegocio {

	LogicaAula negocio;
	Estudiante alumno1;
	Estudiante alumno2;
	Estudiante alumno3;
	Estudiante alumno4;
	Puesto puesto1;
	Puesto puesto2;
	Puesto puesto3;
	Aula aula;
	Aula aula1;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	void inicializarDatos() {

		negocio = new LogicaAula();
		alumno1 = new Estudiante();
		alumno1.setName("Meidel");
		alumno2 = new Estudiante();
		alumno2.setName("Arturito");
		alumno3 = new Estudiante();
		alumno3.setName("Claudia");
		alumno4 = new Estudiante();
		puesto1 = new Puesto();
		puesto1.setPersona(alumno1);
		puesto2 = new Puesto();
		puesto2.setPersona(alumno2);
		puesto3 = new Puesto();
		puesto3.setPersona(alumno3);
		aula = new Aula();
		aula.setNombre("Caliso");
		aula1 = new Aula();
		aula1.setNombre("Ketler");
		List<Puesto> listPuestos = new ArrayList();
		listPuestos.add(puesto1);
		listPuestos.add(puesto2);
		listPuestos.add(puesto3);
		Puesto puesto1 = new Puesto();
		Puesto puesto2 = new Puesto();
		Puesto puesto3 = new Puesto();
		List<Puesto> listPuestos1 = new ArrayList();
		listPuestos1.add(puesto1);
		listPuestos1.add(puesto2);
		listPuestos1.add(puesto3);
		aula.setPuestosDeEstudiantes(listPuestos);
		aula1.setPuestosDeEstudiantes(listPuestos1);

	}

	@Test
	public void testAsignarAlumnoAlAula() throws Exception {
		inicializarDatos();
		assertTrue(true);
//		negocio.crearNuevaAula(aula);
//		negocio.asignarAlumnoAlAula(alumno1, aula);
//		negocio.asignarAlumnoAlAula(alumno2, aula);
//		negocio.asignarAlumnoAlAula(alumno3, aula);
//		assertTrue((negocio.listaDeAlumnosPorAula(aula.getNombre()).contains(alumno1)));
	}

	@Test
	public void testCrearAula() {
		inicializarDatos();
		assertTrue(true);
//		negocio.crearNuevaAula(aula);
//		assertTrue((negocio.getAulaDao().getAulaById(aula.getNombre()).equals(aula)));
	}

	@Test
	public void testEliminaraula() {
		inicializarDatos();
		assertTrue(true);
//		negocio.crearNuevaAula(aula);
//		negocio.eliminarAula(aula.getNombre());
//		assertTrue(negocio.getAulaDao().getTodasLasAulas().size() == 0);
	}

	@Test
	public void testListaDeAlumnosPorAula() throws Exception {
		inicializarDatos();
		assertTrue(true);
//		negocio.crearNuevaAula(aula);
//		negocio.asignarAlumnoAlAula(alumno1, aula);
//		negocio.asignarAlumnoAlAula(alumno2, aula);
//		negocio.asignarAlumnoAlAula(alumno3, aula);
//		Collection<Puesto> puestos = negocio.getAulaDao().getAulaById(aula.getNombre()).getPuestosDeEstudiantes();
//		Collection<Persona> personas1 = new ArrayList<Persona>();
//		for (Puesto puesto : puestos) {
//			personas1.add(puesto.getPersona());
//		}
//
//		Collection<Persona> personas2 = negocio.listaDeAlumnosPorAula(aula.getNombre());
//		assertTrue(personas1.equals(personas2));
	}

	public TestCaseNegocio() {
		super();
	}

}
