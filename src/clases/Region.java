package clases;

import java.util.ArrayList;

public class Region extends Entidad{
	String _direccionDeRecogida;
	ArrayList<Cooperativa> _coopsPresentes = new ArrayList<Cooperativa>(); // da error mientras escribimos la clase Cooperativa
	
	public void setDireccion(String direccion) {
		this._direccionDeRecogida = direccion;
	}
	
	public String getDireccion() {
		return ((this._direccionDeRecogida != null) ? 
				(this._direccionDeRecogida) : (new String("!")));
		}
		
	public void addCoop(Cooperativa coop) {
		this._coopsPresentes.add(coop);
	}
	
	public void addCoop(Cooperativa coop1, Cooperativa coop2) {
		this._coopsPresentes.add(coop1);
		this._coopsPresentes.add(coop2);
	}
	
	public void addCoop(Cooperativa coop1, Cooperativa coop2, Cooperativa coop3) {
		this._coopsPresentes.add(coop1);
		this._coopsPresentes.add(coop2);
		this._coopsPresentes.add(coop3);
	}
	
	public Boolean rmCoop(Cooperativa coop) {
		Boolean valor = this._coopsPresentes.remove(coop);
		return valor;
	}
	
	public Boolean rmCoop(int indice) {
		try{
			this._coopsPresentes.remove(indice);
			return true;}
		catch (IndexOutOfBoundsException ex) {
			return false;}
		}
	
	public void clrCoop() {
		this._coopsPresentes.clear();
	}
}
