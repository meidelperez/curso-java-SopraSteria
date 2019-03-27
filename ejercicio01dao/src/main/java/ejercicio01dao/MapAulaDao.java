package ejercicio01dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.curso.java.oo.ejercicio01oo.clases.Aula;

public class MapAulaDao implements IAulaDAO {

	Map<String, Aula> aulas;

	public void updateAula(Aula aula) {
		aulas.put(aula.getNombre(), aula);
	}

	public void createAula(Aula aula) {
		aulas.put(aula.getNombre(), aula);

	}

	public void deleteAula(String identificadorUnicoAula) {
		aulas.remove(identificadorUnicoAula);
	}

	public Aula getAulaById(String id) {
		return aulas.get(id);

	}

	public Collection<Aula> getTodasLasAulas() {

		return  aulas.values();
	}

	public void insertAula(Aula aula) {
		aulas.put(aula.getNombre(), aula);

	}

	public MapAulaDao() {
		super();
		this.aulas = new HashMap<String, Aula>();
	}

}
