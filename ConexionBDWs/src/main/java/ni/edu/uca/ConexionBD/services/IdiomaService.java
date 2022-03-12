package ni.edu.uca.ConexionBD.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ni.edu.uca.ConexionBD.models.Idioma;
import ni.edu.uca.ConexionBD.repositories.IdiomaDRepository;
import ni.edu.uca.ConexionBD.repositories.IdiomaIRepository;

@Service
public class IdiomaService implements IdiomaIRepository{

	@Autowired
	IdiomaDRepository cla;
	@Override
	public List<Map<String, Object>> ListarRegistro() {
		// TODO Auto-generated method stub
		return cla.ListarRegistro();
	}

	@Override
	public int GuardarRegistro(Idioma c) {
		// TODO Auto-generated method stub
		return cla.GuardarRegistro(c);
	}

	@Override
	public int EditarRegistro(Idioma c) {
		// TODO Auto-generated method stub
		return cla.EditarRegistro(c);
	}

	@Override
	public int EliminarRegistro(int id) {
		// TODO Auto-generated method stub
		return cla.EliminarRegistro(id);
	}

	
}
