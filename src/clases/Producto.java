package clases;

public class Producto {

	String _nombre;
	String _categoria;
	int _precio;
	int _disponibilidad = 0; // se altera desde cada asignación en una Cooperativa y representa una cantidad global
	int _peso;
	
	
	
	
	public Producto(int peso, String nombre, String categoria, int precio){
		this._peso = peso;
		this._nombre = nombre;
		this._categoria = categoria;
		this._precio = precio;
		
	}


	public void set_disponibilidad(int dispo) {
		this._disponibilidad = dispo;
	}
	public int get_disponibilidad() {
		return this._disponibilidad;
	}


	public String get_nombre() {
		return _nombre;
	}



	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}




	public String get_categoria() {
		return ((this._categoria != null) ? 
				(this._categoria) : (new String("!")));
	}




	public void set_categoria(String _categoria) {
		this._categoria = _categoria;
	}




	public int get_precio() {
		return _precio;
	}




	public void set_precio(int _precio) {
		this._precio = _precio;
	}




	public int get_peso() {
		return _peso;
	}
	
	public void set_peso(int peso) {
		this._peso = peso;
	}
	
}
