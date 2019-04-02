package mainlist;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.java.oo.ejercicio01oo.clases.Aula;
import com.curso.java.oo.ejercicio01oo.clases.Estudiante;
import com.curso.java.oo.ejercicio01oo.clases.Puesto;

import ejercicio01negocio.LogicaAula;

public class LanzadorList {
	public static ApplicationContext context;

	static {
		context = new ClassPathXmlApplicationContext("beanAnotaciones.xml");
	}

	public static void main(String[] args) throws Exception {

		Estudiante alumno1 = context.getBean(Estudiante.class);
		Estudiante alumno2 = context.getBean(Estudiante.class);
		Estudiante alumno3 = context.getBean(Estudiante.class);
		Estudiante alumno4 = context.getBean(Estudiante.class);
		Puesto puesto1 = context.getBean(Puesto.class);
		puesto1.setPersona(alumno1);
		Puesto puesto2 = context.getBean(Puesto.class);
		puesto2.setPersona(alumno2);
		Puesto puesto3 = context.getBean(Puesto.class);
		puesto3.setPersona(alumno3);
		Aula aula = context.getBean(Aula.class);
		aula.setNombre("Caliso");
		Aula aula1 = context.getBean(Aula.class);
		aula1.setNombre("Ketler");
		LogicaAula negocio = context.getBean(LogicaAula.class);

		negocio.crearNuevaAula(aula1);
		negocio.crearNuevaAula(aula);
		negocio.asignarAlumnoAlAula(alumno1, aula);
		negocio.asignarAlumnoAlAula(alumno2, aula);
		negocio.asignarAlumnoAlAula(alumno3, aula1);
		negocio.asignarAlumnoAlAula(alumno4, aula1);
//		Collection<Persona> listaAlumnosAula = negocio.listaDeAlumnosPorAula("Caliso");
		negocio.eliminarAula("Ketler");
		System.out.println(negocio.listaDeAlumnosPorAula("Caliso"));

	}

}
