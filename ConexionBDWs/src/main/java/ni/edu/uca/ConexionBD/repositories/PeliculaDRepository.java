package ni.edu.uca.ConexionBD.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ni.edu.uca.ConexionBD.models.Pelicula;

@Repository
public class PeliculaDRepository implements PeliculaIRepository {

	@Autowired
	JdbcTemplate operacion;
	
	@Override
	public List<Map<String, Object>> ListarRegistro() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> lista = operacion.queryForList("Select p.idPelicula,p.titulo,p.tipoMetraje,n.nombre as 'nacionalidad',"
				+ "c.nombre as 'clasificacion',p.duracion,p.sinopsis from Pelicula p"
				+ "	inner join Nacionalidad n on p.nacionalidad = n.idNacionalidad"
				+ "	inner join Clasificacion c on p.clasificacion = c.idClasificacion");
		
		int s =0;
		//lista.add();
		return lista;
	}

	@Override
	public int GuardarRegistro(Pelicula c) {
		// TODO Auto-generated method stub
		int b = 0;
		b = operacion.update("INSERT INTO [Pelicula] ([titulo] ,[tipoMetraje],[nacionalidad],[clasificacion],[duracion],[sinopsis]) "
				+ "VALUES (?,?,?,?,?,?)",
				 c.getTitulo(), c.getTipoMetraje(),c.getNacionalidad(),c.getClasificacion(), c.getDuracion(), c.getSinopsis() );
		return b;
	}

	@Override
	public int EditarRegistro(Pelicula c) {
		// TODO Auto-generated method stub
		int b = 0;
		b = operacion.update("UPDATE [dbo].[Pelicula] SET [titulo] = ?, "
        		+ "[tipoMetraje] = ? ,[nacionalidad] = ? ,[clasificacion] = ? ,[duracion] = ?, "
        		+ "[sinopsis] = ? WHERE idPelicula = ?",
				c.getTitulo(), c.getTipoMetraje(),c.getNacionalidad(),c.getClasificacion(), c.getDuracion(), c.getSinopsis(), c.getIdPelicula());
		return b;
	}

	@Override
	public int EliminarRegistro(int id) {
		// TODO Auto-generated method stub
		int b = 0;
		b = operacion.update("Delete from Pelicula where idPelicula = ?", id);
		return b;
	}

	

}
