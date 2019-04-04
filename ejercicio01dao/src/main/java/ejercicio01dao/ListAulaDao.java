package ejercicio01dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.curso.java.oo.ejercicio01oo.clases.Aula;

@Repository("miDao")
public class ListAulaDao implements IAulaDAO {
	@Autowired
	@Qualifier("collectionArrayList")
	private List<Aula> listAulas;

	@Override
	public void insertAula(Aula aula) {
		listAulas.add(aula);

	}

	@Override
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

	@Override
	public void createAula(Aula aula) {
		listAulas.add(aula);
	}

	@Override
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

	@Override
	public Collection<Aula> getTodasLasAulas() {
		return listAulas;
	}

	@Override
	public void deleteAula(String identificadorUnicoAula) {
		listAulas.remove(getAulaById(identificadorUnicoAula));

	}

	public ListAulaDao() {
		super();
		this.listAulas = new ArrayList<Aula>();
	}

	@Override
	public String toString() {
		return "ListAulaDao [listAulas=" + listAulas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listAulas == null) ? 0 : listAulas.hashCode());
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
		ListAulaDao other = (ListAulaDao) obj;
		if (listAulas == null) {
			if (other.listAulas != null)
				return false;
		} else if (!listAulas.equals(other.listAulas))
			return false;
		return true;
	}

	public List<Aula> getListAulas() {
		return listAulas;
	}

	public void setListAulas(List<Aula> listAulas) {
		this.listAulas = listAulas;
	}

}
