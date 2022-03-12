package ni.edu.uca.ConexionBD.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ni.edu.uca.ConexionBD.models.Pelicula;
import ni.edu.uca.ConexionBD.repositories.PeliculaDRepository;
import ni.edu.uca.ConexionBD.repositories.PeliculaIRepository;

@Service
public class PeliculaService implements PeliculaIRepository{

	@Autowired
	PeliculaDRepository cla;
	@Override
	public List<Map<String, Object>> ListarRegistro() {
		// TODO Auto-generated method stub
		return cla.ListarRegistro();
	}

	@Override
	public int GuardarRegistro(Pelicula c) {
		// TODO Auto-generated method stub
		return cla.GuardarRegistro(c);
	}

	@Override
	public int EditarRegistro(Pelicula c) {
		// TODO Auto-generated method stub
		return cla.EditarRegistro(c);
	}

	@Override
	public int EliminarRegistro(int id) {
		// TODO Auto-generated method stub
		return cla.EliminarRegistro(id);
	}

	

	
}
