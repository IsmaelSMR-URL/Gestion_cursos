package ni.edu.uca.ConexionBD.repositories;

import java.util.List;
import java.util.Map;

import ni.edu.uca.ConexionBD.models.Genero; 

public interface GeneroIRepository {
	
	public List<Map<String, Object>> ListarRegistro();
	
	public int GuardarRegistro(Genero c);
	
	public int EditarRegistro(Genero c);
	
	public int EliminarRegistro(int id);
	
}
