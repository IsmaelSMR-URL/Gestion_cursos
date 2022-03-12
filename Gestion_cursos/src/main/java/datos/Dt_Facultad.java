package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.Facultad;

public class Dt_Facultad {
	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsRol = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public void llena_rsRol(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.facultad WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsRol = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR ROLES "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Facultad> listaFacActivos(){
		ArrayList<Facultad> listFac = new ArrayList<Facultad>();
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.facultad WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Facultad fac = new Facultad(); //instanciamos a rol
				fac.setId_facultad(rs.getInt("id_facultad"));
				fac.setNombre_facultad(rs.getString("nombre_facultad"));
				fac.setEstado(rs.getInt("estado"));
				listFac.add(fac);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Facultades: "+ e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
				if(c != null){
					poolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return listFac;
	}
}
