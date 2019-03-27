package ejercicio04factry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import ejercicio01dao.IAulaDAO;

public class FabricaAulasDAO {

	public static IAulaDAO getAulaDAOInstance()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		String nombreDeinstancia = GetNombredeInstanciDeFichero();
		return (IAulaDAO) Class.forName(nombreDeinstancia).newInstance();
	}

	private static String GetNombredeInstanciDeFichero() throws IOException {
		// TODO leer de fichero
		File file = new File("fichero.txt");
		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);
		String claseACrear = br.readLine();
		br.close();
		return claseACrear;
	}
}
