package clases;

import java.util.ArrayList;
import org.javatuples.Pair;

public class Comprador extends Usuario{
	ArrayList<Producto> _historialDeCompra = new ArrayList<Producto>(); // no se ha usado hasta ahora
	ArrayList<Pair<Cooperativa, Producto>> _carrito = new ArrayList<Pair<Cooperativa,Producto>>(); // guarda la cooperativa de la que proviene el producto
	
	float _precioCarritoCompra = 0;

	@Override
	
	public Boolean pagar() {
		for (Producto p: this.getLista()) {
			this._historialDeCompra.add(p);
		}
		return super.pagar();
	}
	
	/*@Override
	
	public void addToLista(Producto p) {
		super.addToLista(p);
		this._precioCarritoCompra += p.get_precio();
	}
	
	@Override
	
	public Boolean rmFromLista(Producto p) {
		this._precioCarritoCompra -= p.get_precio();		
		return super.rmFromLista(p);
	}
	
	@Override*/
	
	public void addToCarrito(Cooperativa c, Producto p) {
		Pair<Cooperativa, Producto> tupla = new Pair<Cooperativa, Producto>(c, p);
		this._carrito.add(tupla);
		this._precioCarritoCompra += p.get_precio();
	}
	
	public void rmFromCarrito(int indice) {
		this._precioCarritoCompra -= this.getCarrito().get(indice).getValue1().get_precio();
		this._carrito.remove(indice);
		//return super.rmFromLista(indice);
	}
	
	public ArrayList<Pair<Cooperativa, Producto>> getCarrito() {
		return this._carrito;
	}
	
	public ArrayList<Producto> getHistorial(){
		return this._historialDeCompra;
	}
	
	public float getPrecioCarrito() {
		return this._precioCarritoCompra;
	}
	
	
	public Comprador(String nombre, String telContacto, String infPago, Region region) {
		super(nombre, telContacto, infPago, region);
	}
	
	@Override
	
	public String toString() {
		//System.out.print(this.getNombre())// debug
		return (this.getNombre() + "," + this.getInfPago() + "," + this.getTel() + "," + this.getRegion().getNombre() + "\n");
	}

}
