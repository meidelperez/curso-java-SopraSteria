package operacionesdao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.curso.java.oo.ejercicio01oo.clases.Operaciones;

@Repository
public class operacionesDao implements IOperacionesDAO {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void borrarOperacion(Integer id) {
		Operaciones operacionParaborrar = buscar(id);
		manager.remove(operacionParaborrar);

	}

	@Override
	public void insertarOperacion(Operaciones operacion) {
		manager.persist(operacion);

	}

	@Override
	public void modificarOperacion(Operaciones operacion) {
		manager.merge(operacion);

	}

	@Override
	public List<Operaciones> listarOperaciones() {
		String query = "select o from Operaciones o";
		return manager.createQuery(query).getResultList();
	}

	@Override
	public Operaciones buscar(int id) {
		return manager.find(Operaciones.class, id);

	}

}
