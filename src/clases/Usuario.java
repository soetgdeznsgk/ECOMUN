package clases;

import java.util.ArrayList;
import java.util.Random;

public class Usuario extends Entidad{
	String _informacionDePago;
	Region _region;
	ArrayList<Producto> _listaProductos = new ArrayList<Producto>();
	
	public void setInfPago(String infPago) {
		this._informacionDePago = infPago;
	}
	
	public String getInfPago() {
		return ((this._informacionDePago != null) ? 
				(this._informacionDePago) : (new String("!")));
	}
	
	
	
	public Boolean pagar() {		// para que varíe un tris le puse que el pago a veces pasara y a veces no
		Random rand = new Random();
		Boolean i = (rand.nextInt(6) % 2 ) == 0;
		
		if (i) {
			this._listaProductos.clear();
		}
		
		return i;
	}
	
	public Boolean recibirPago(Producto producto) {		// el dinero es una ilusión
		return this.pagar();		
	}
	
	
	
	public void addToLista(Producto producto) {
		this._listaProductos.add(producto);
	}
	
	public Boolean rmFromLista(Producto p) {
		try {
			this._listaProductos.remove(p);
			return true;
		}
		catch (IndexOutOfBoundsException ex) {
			System.out.println("Fuera de limite!");
			return false;
		}
	}
	
	public Boolean rmFromLista(int indice) {
		try {
			this._listaProductos.remove(indice);
			return true;
		}
		catch (IndexOutOfBoundsException ex) {
			System.out.println("Fuera de limite!");
			return false;
		}
	}
	
	public ArrayList<Producto> getLista(){
		return this._listaProductos;
	}
	
	public final void setRegion(Region region) {
		this._region = region;
	}
	
	public final Region getRegion() {
		return this._region;
	}
	
	public Usuario(String nombre, String telContacto, String infPago, Region region) {
		super(nombre, telContacto);
		this.setInfPago(infPago);
		this.setRegion(region);
		Entidad._cantidadUsuarios++;
	}
}
