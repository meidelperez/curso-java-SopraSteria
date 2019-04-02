package ejercicio01dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.curso.java.oo.ejercicio01oo.clases.Aula;

@Repository("miDao")
public class MapAulaDao implements IAulaDAO {
	@Autowired
	@Qualifier("collectionHashMap")
	private Map<String, Aula> mapAulas;

	public void updateAula(Aula aula) {
		mapAulas.put(aula.getNombre(), aula);
	}

	public void createAula(Aula aula) {
		mapAulas.put(aula.getNombre(), aula);

	}

	public void deleteAula(String identificadorUnicoAula) {
		mapAulas.remove(identificadorUnicoAula);
	}

	public Aula getAulaById(String id) {
		return mapAulas.get(id);

	}

	public Collection<Aula> getTodasLasAulas() {

		return mapAulas.values();
	}

	public void insertAula(Aula aula) {
		mapAulas.put(aula.getNombre(), aula);

	}

	public MapAulaDao() {
		super();
		this.mapAulas = new HashMap<String, Aula>();
	}

	@Override
	public String toString() {
		return "MapAulaDao [mapAulas=" + mapAulas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mapAulas == null) ? 0 : mapAulas.hashCode());
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
		MapAulaDao other = (MapAulaDao) obj;
		if (mapAulas == null) {
			if (other.mapAulas != null)
				return false;
		} else if (!mapAulas.equals(other.mapAulas))
			return false;
		return true;
	}

	public Map<String, Aula> getMapAulas() {
		return mapAulas;
	}

	public void setMapAulas(Map<String, Aula> mapAulas) {
		this.mapAulas = mapAulas;
	}

}
