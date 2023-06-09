package clases;
import java.util.ArrayList;

public class Distribuidora extends Usuario{
	ArrayList<Region> _alcance = new ArrayList<Region>();
	int _cantidadMiembros;
	
	
	public int get_cantidadMiembros() {
		return _cantidadMiembros;
	}
	
	public void set_cantidadMiembros(int _cantidadMiembros) {
		this._cantidadMiembros = _cantidadMiembros;
	}
	
	public Boolean rmFromAlcance(int indice) {
		try {
			this._alcance.remove(indice);
			return true;
		}
		catch (IndexOutOfBoundsException ex) {
			System.out.println("Fuera de limite!");
			return false;
		}
	}
	
	public Boolean rmFromAlcance(Region region) {
		return (this._alcance.remove(region));
	}
	
	public void addToAlcance(Region region) {
		this._alcance.add(region);
		Ecomun.addRegion(region);
	}
	
	public void clrAlcance() {
		this._alcance.clear();
	}

	public ArrayList<Region> getAlcance() {
		return this._alcance;
	}

	public Distribuidora(String nombre, String telContacto, String infPago, Region region, int cantidadMiembros) {
		super(nombre, telContacto, infPago, region);
		this.set_cantidadMiembros(cantidadMiembros);
		Ecomun.addDistribuidora(this);;
	}
	
	/*public String alcanceToString() {
		String temp = "";
		for (Region r: this._alcance) {
			temp += r.getNombre() + ",";
		}
		return temp;
	}*/
	
	
	
}
