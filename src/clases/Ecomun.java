package clases;
import java.util.ArrayList;

public final class Ecomun extends Entidad{
	ArrayList<Region> _alcanceNacional = new ArrayList<Region>(); // no está planteado como cambiar éste atributo al eliminar una cooperativa
	ArrayList<Cooperativa> _cooperativas = new ArrayList<Cooperativa>();
	ArrayList<Distribuidora> _Distribuidores = new ArrayList<Distribuidora>();
	ArrayList<Comprador> _compradores; // se instancia cada loop
	
	public void setCompradores(ArrayList<Comprador> c) {
		this._compradores = c;
	}

	public ArrayList<Comprador> getCompradores(){
		return this._compradores;
	}
	
	public void addDistribuidora(Distribuidora d){
		this._Distribuidores.add(d);
		for (Region r: d.getAlcance()){
			if (!this._alcanceNacional.contains(r)){
				this._alcanceNacional.add(r);
			}
		}
	}

	public ArrayList<Distribuidora> getDistribuidoras(){
		return this._Distribuidores;
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
			/*for (int i  = 0; i < a.length(); i++){
				System.out.print(a.charAt(i) + "=" + b.charAt(i));
			}*/
			System.out.println();
			//System.out.println(a + "=" + b);
			//System.out.println(r.getNombre().toLowerCase() == nombre.toLowerCase());
			//System.out.println(String.valueOf(r.getNombre().toLowerCase().length())+ "=" +String.valueOf(nombre.toLowerCase().length()));
			if (nombre.contains(r.getNombre())) { // por qué no son iguales?
			//if (r.getNombre().toLowerCase().equals(nombre.toLowerCase())){
				return r;
			}
		}
		return null;
	}

	public Ecomun(String telContacto) {
		super("Ecomun", telContacto);
	}
	

}
