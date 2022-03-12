package ni.edu.uca.ConexionBD.models;

public class Idioma {
	private int id_Idioma;
	private String nombre;
	private boolean activo;
	
	
	public Idioma() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Idioma(int id_Idioma, String nombre, boolean activo) {
		super();
		this.id_Idioma = id_Idioma;
		this.nombre = nombre;
		this.activo = activo;
	}
	
	public int getId_Idioma() {
		return id_Idioma;
	}
	public void setId_Idioma(int id_Idioma) {
		this.id_Idioma = id_Idioma;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	@Override
	public String toString() {
		return "Idioma [id_Idioma=" + id_Idioma + ", " + nombre + ", activo=" + activo + "]";
	}
}
