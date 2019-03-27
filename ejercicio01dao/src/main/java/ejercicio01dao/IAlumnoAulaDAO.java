package ejercicio01dao;

import java.util.Collection;

import com.curso.java.oo.ejercicio01oo.clases.Aula;
import com.curso.java.oo.ejercicio01oo.clases.Estudiante;

public interface IAlumnoAulaDAO {

	public void insertEstudiante(Estudiante estudiante);
	public void updateEstudiante(Estudiante estudiante);
	public void createEstudiante(Estudiante estudiante);
	public void deleteEstudiante(String identificadorUnicoEstudiante);
	public Aula getEstudianteById(String id);
	public Collection<Estudiante> getEstudiantes();
	
}
