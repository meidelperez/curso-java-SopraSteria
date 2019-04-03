package ejercicio01dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.curso.java.oo.ejercicio01oo.clases.Aula;

public class TestCaseDao {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateAula() {

		IAulaDAO auladao = new ListAulaDao();
		Aula aula = new Aula();
//		fail("Not yet implemented");
		auladao.createAula(aula);
		assertTrue("Aula no creada!!!", auladao.getTodasLasAulas().contains(aula));
	}

	@Test
	public void testEliminarAula() {

		IAulaDAO auladao = new ListAulaDao();
		Aula aula = new Aula();
		aula.setNombre("Calipso");
//		fail("Not yet implemented");
		auladao.createAula(aula);
		auladao.deleteAula(aula.getNombre());
		assertFalse("Aula no eliminada!!!!!", auladao.getTodasLasAulas().contains(aula));
	}
	
	@Test
	public void testGetAulaById() {

		IAulaDAO auladao = new ListAulaDao();
		Aula aula = new Aula();
		aula.setNombre("Calipso");
//		fail("Not yet implemented");
		auladao.createAula(aula);
		assertTrue("No devuelve el aula por su id!!!!!", auladao.getAulaById(aula.getNombre()).equals(aula));
	}
	
	@Test
	public void testUpdateAula() {

		IAulaDAO auladao = new ListAulaDao();
		Aula aula = new Aula();
		aula.setTienePizarra(true);
		aula.setNombre("Calipso");
//		fail("Not yet implemented");
		Aula aula1 = new Aula();
		aula.setTienePizarra(false);
		aula.setNombre("Calipso");
		auladao.createAula(aula);
		auladao.updateAula(aula1);
		assertFalse("No actualiza el aula!!!!!", auladao.getAulaById(aula.getNombre()).getTienePizarra());
	}
}
