package clases;

public abstract class Entidad {

	String _nombre;
	String _telContacto;
	static int _cantidadUsuarios = 0;
	
	public void setNombre(String nombre) {
		this._nombre = nombre;
	}
	
	public String getNombre() {
		return ((this._nombre != null) ? 
				(this._nombre) : (new String("!")));
	}
	
	
	
	
	public void setTel(String numero) {
		this._telContacto = numero;
	}
	
	public String getTel() {
		return ((this._telContacto != null) ? 
				(this._telContacto) : (new String("!")));
	}
}
