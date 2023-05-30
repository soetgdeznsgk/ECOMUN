package clases;

public class ProductoInorganico extends Producto{
	public int _densidad;

	public int get_densidad() {
		return _densidad;
	}

	public void set_densidad(int _densidad) {
		this._densidad = _densidad;
	}

	public ProductoInorganico(int peso, String nombre, String categoria, int precio, int densidad) {
		super(peso, nombre, categoria, precio);
		this.set_densidad(densidad);
	}
}
