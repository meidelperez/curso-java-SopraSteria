package ejercicio01dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.curso.java.oo.ejercicio01oo.clases.Aula;

@Repository
public interface IAulaDAO {
	public void insertAula(Aula aula);

	public void updateAula(Aula aula);

	public void createAula(Aula aula);

	public void deleteAula(String identificadorUnicoAula);

	public Aula getAulaById(String id);

	public Collection<Aula> getTodasLasAulas();

}
