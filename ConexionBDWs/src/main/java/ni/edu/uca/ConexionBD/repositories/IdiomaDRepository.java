package ni.edu.uca.ConexionBD.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ni.edu.uca.ConexionBD.models.Idioma;

@Repository
public class IdiomaDRepository implements IdiomaIRepository {

	@Autowired
	JdbcTemplate operacion;
	
	@Override
	public List<Map<String, Object>> ListarRegistro() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> lista = operacion.queryForList("Select * from Idioma");
		return lista;
	}

	@Override
	public int GuardarRegistro(Idioma c) {
		// TODO Auto-generated method stub
		int b = 0;
		b = operacion.update("Insert into Idioma( nombre, activo) values( ?, ?)",
				 c.getNombre(), c.isActivo());
		return b;
	}

	@Override
	public int EditarRegistro(Idioma c) {
		// TODO Auto-generated method stub
		int b = 0;
		b = operacion.update("Update Idioma set nombre = ?, activo = ? where idIdioma = ?",
				 c.getNombre(), c.isActivo(), c.getId_Idioma());
		return b;
	}

	@Override
	public int EliminarRegistro(int id) {
		// TODO Auto-generated method stub
		int b = 0;
		b = operacion.update("Delete from Idioma where idIdioma = ?", id);
		return b;
	}

}
