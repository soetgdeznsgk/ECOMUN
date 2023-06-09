package clases;
import java.util.ArrayList;

public final class Ecomun extends Entidad{
	static ArrayList<Region> _alcanceNacional = new ArrayList<Region>(); // no está planteado como cambiar éste atributo al eliminar una cooperativa
	static ArrayList<Cooperativa> _cooperativas = new ArrayList<Cooperativa>();
	static ArrayList<Distribuidora> _Distribuidores = new ArrayList<Distribuidora>();
	static ArrayList<Comprador> _compradores; // se instancia cada loop
	static int _miembrxs = 0;
	
	public static void setCompradores(ArrayList<Comprador> c) {
		_compradores = c;
	}

	public static ArrayList<Comprador> getCompradores(){
		return _compradores;
	}
	
	public static void addDistribuidora(Distribuidora d){
		_Distribuidores.add(d);
		_miembrxs += d.get_cantidadMiembros();

		for (Region r: d.getAlcance()){
			addRegion(r);
		}
	}
	
	public static void addRegion(Region r) {
		if (!_alcanceNacional.contains(r)) {
			_alcanceNacional.add(r);
		}
	}

	public static ArrayList<Distribuidora> getDistribuidoras(){
		return _Distribuidores;
	}

	public static void addCooperativa(Cooperativa coop) {
		_miembrxs += coop.get_cantidadMiembros();
		_cooperativas.add(coop);
		_alcanceNacional.add(coop.getRegion());
	}
	
	public static Boolean rmCooperativa(Cooperativa coop) {
		_cooperativas.remove(coop);
		_miembrxs -= coop.get_cantidadMiembros();
		
		return true;}
	
	public static Boolean rmCooperativa(int indice) {
		Cooperativa temp;
		try {
			temp = _cooperativas.remove(indice);
			_miembrxs -= temp.get_cantidadMiembros();
			return true;}
		
		catch(IndexOutOfBoundsException ex) {
			return false;}
	}
	
	public static int getCantidadMiembrxs() {
		return _miembrxs;
	}
	public static void clrCoops() {
		_cooperativas.clear();
		_miembrxs = 0;
	}
	
	public static ArrayList<Cooperativa> getCooperativas(){
		return _cooperativas;
	}
	
	public static ArrayList<Region> getRegiones(){
		return _alcanceNacional;
	}
	
	public Region getRegion(String nombre) {
		
		for (Region r: _alcanceNacional) {
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
