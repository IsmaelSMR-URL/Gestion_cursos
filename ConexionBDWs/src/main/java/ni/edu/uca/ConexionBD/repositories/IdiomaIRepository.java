package ni.edu.uca.ConexionBD.repositories;

import java.util.List;
import java.util.Map; 
import ni.edu.uca.ConexionBD.models.Idioma;

public interface IdiomaIRepository {
	
	public List<Map<String, Object>> ListarRegistro();
	
	public int GuardarRegistro(Idioma c);
	
	public int EditarRegistro(Idioma c);
	
	public int EliminarRegistro(int id);
	
}
