package ejercicio01dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.curso.java.oo.ejercicio01oo.clases.Aula;

public class ListAulaDao implements IAulaDAO {

	private List<Aula> listAulas;

	public void insertAula(Aula aula) {
		listAulas.add(aula);

	}

	public void updateAula(Aula aula) {
		int i = 0;
		boolean encontradaAula = false;
		while (i < listAulas.size() && !encontradaAula) {
			if (listAulas.get(i).getNombre() == aula.getNombre()) {
				listAulas.set(i, aula);
				encontradaAula = true;
			}
			i++;

		}

	}

	public void createAula(Aula aula) {
		listAulas.add(aula);
	}

	public void deleteAula(Aula aula) {
		listAulas.remove(aula);
	}

	public Aula getAulaById(String id) {
		Aula aula = null;
		int i = 0;
		boolean encontradaAula = false;
		while (i < listAulas.size() && !encontradaAula) {
			if (listAulas.get(i).getNombre() == id) {
				aula = listAulas.get(i);
				encontradaAula = true;
			}
			i++;

		}

		return aula;
	}

	public Collection<Aula> getTodasLasAulas() {
		return listAulas;
	}

	public void deleteAula(String identificadorUnicoAula) {

	}

	public ListAulaDao() {
		super();
		this.listAulas = new ArrayList<Aula>();
	}

}
