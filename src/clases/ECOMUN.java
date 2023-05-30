package clases;
import java.util.ArrayList;

public final class ECOMUN extends Entidad {
	this._nombre = "ECOMUN";
	ArrayList<Region> _alcanceNacional = new ArrayList<Region>(); // no está planteado como cambiar éste atributo al eliminar una cooperativa
	ArrayList<Cooperativa> _cooperativas = new ArrayList<Cooperativa>();
	
	public void addCooperativa(Cooperativa coop) {
		this._cooperativas.add(coop);
		this._alcanceNacional.add(coop.getRegion());
	}
	
	public Boolean rmCooperativa(Cooperativa coop) {
		this._cooperativas.remove(coop);
		
		return true;}
	
	public void
}
