package operacionesdao;

import java.util.List;

import com.curso.java.oo.ejercicio01oo.clases.Operaciones;

public interface IOperacionesDAO {

	public void borrarOperacion(Integer Id);

	public void insertarOperacion(Operaciones operacion);

	public void modificarOperacion(Operaciones operacion);

	public List<Operaciones> listarOperaciones();

	public Operaciones buscar(int id);

}
