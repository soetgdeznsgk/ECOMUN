package clases;
import java.util.ArrayList;

public class Comprador extends Usuario{
	ArrayList<Producto> _historialDeCompra = new ArrayList<Producto>();
	float _precioCarritoCompra = 0;

	@Override
	
	public Boolean pagar() {
		for (Producto p: this.getLista()) {
			this._historialDeCompra.add(p);
		}
		return super.pagar();
	}
	
	@Override
	
	public void addToLista(Producto p) {
		super.addToLista(p);
		this._precioCarritoCompra += p.get_precio();
	}
	
	@Override
	
	public Boolean rmFromLista(Producto p) {
		this._precioCarritoCompra -= p.get_precio();		
		return super.rmFromLista(p);
	}
	
	@Override
	
	public Boolean rmFromLista(int indice) {
		this._precioCarritoCompra -= this.getLista().get(indice).get_precio();
		return super.rmFromLista(indice);
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
		return (this.getNombre() + "," + this.getInfPago() + "," + this.getTel() + "," + this.getRegion().getNombre() + "\n");
	}

}
