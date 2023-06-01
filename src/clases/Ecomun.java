package clases;
import java.util.ArrayList;

public final class Ecomun extends Entidad{
	ArrayList<Region> _alcanceNacional = new ArrayList<Region>(); // no está planteado como cambiar éste atributo al eliminar una cooperativa
	ArrayList<Cooperativa> _cooperativas = new ArrayList<Cooperativa>();
	ArrayList<Comprador> _compradores; // se instancia cada loop
	
	public void setCompradores(ArrayList<Comprador> c) {
		this._compradores = c;
	}
	
	public void addCooperativa(Cooperativa coop) {
		this._cooperativas.add(coop);
		this._alcanceNacional.add(coop.getRegion());
	}
	
	public Boolean rmCooperativa(Cooperativa coop) {
		this._cooperativas.remove(coop);
		
		return true;}
	
	public Boolean rmCooperativa(int indice) {
		try {
			this._cooperativas.remove(indice);
			return true;}
		
		catch(IndexOutOfBoundsException ex) {
			return false;}
	}
	
	public void clrCoops() {
		this._cooperativas.clear();
	}
	
	public ArrayList<Cooperativa> getCooperativas(){
		return this._cooperativas;
	}
	
	public ArrayList<Region> getRegiones(){
		return this._alcanceNacional;
	}
	
	public Region getRegion(String nombre) {
		for (Region r: this._alcanceNacional) {
			if (r.getNombre().toLowerCase() == nombre.toLowerCase()) {
				return r;
			}
		}
		return null;
	}

	public Ecomun(String telContacto) {
		super("Ecomun", telContacto);
	}
	

}
