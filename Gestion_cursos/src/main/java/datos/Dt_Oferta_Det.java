package datos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Oferta;
import entidades.Oferta_Detalle;

public class Dt_Oferta_Det {
	poolConexion pc = poolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsOferta = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public void llena_rsFacultad(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.oferta_detalle WHERE estado<>3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsOferta = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Oferta: "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Oferta_Detalle> listaOD_id(int id){
		ArrayList<Oferta_Detalle> listFac = new ArrayList<Oferta_Detalle>();
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT * FROM gc_mcgofe.oferta_detalle WHERE id_oferta = "+ id, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			while(rs.next()){
				Oferta_Detalle ofd = new Oferta_Detalle(); //instanciamos a rol
				ofd.setId_oferta(rs.getInt("id_oferta"));
				ofd.setFecha_inicial(rs.getDate("fecha_inicial"));
				ofd.setFecha_final(rs.getDate("fecha_final"));
				ofd.setHora_inicio(rs.getString("hora_inicio"));
				ofd.setHora_final(rs.getString("hora_final"));
				ofd.setDias(rs.getString("dias"));
				ofd.setPublico(rs.getInt("publico"));
				ofd.setId_oferta(rs.getInt("id_oferta"));
				ofd.setId_capacitacion(rs.getInt("id_capacitacion"));
				ofd.setId_facilitador(rs.getInt("id_facilitador"));
				listFac.add(ofd);
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
	
	public int getid_oferta(){
		int x = 0;
		try{
			c = poolConexion.getConnection(); //obtenemos una conexion del pool
			ps = c.prepareStatement("SELECT id_oferta from gc_mc_gofe.oferta where estado != 3 Order by id_oferta DESC Limit 1", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			rs.next();
			
			x = rs.getInt("id_oferta");
			
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
		return x;
	}

	
	public boolean addOferta(Oferta fc){
		boolean guardado = false;
		
		try{
			c = poolConexion.getConnection();
			this.llena_rsFacultad(c);
			this.rsOferta.moveToInsertRow();
			rsOferta.updateString("nombre", fc.getNombre());
			rsOferta.updateInt("estado", 1);
			rsOferta.updateDate("fecha_inicial", fc.getFecha_inicial());
			rsOferta.updateDate("fecha_final", fc.getFecha_final());
			rsOferta.updateString("periodo", fc.getPeriodo());
			rsOferta.updateString("descripcion", fc.getDescripcion());
			rsOferta.insertRow();
			rsOferta.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR OFERTA: "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsOferta != null){
					rsOferta.close();
				}
				if(c != null){
					poolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return guardado;
	}
}
