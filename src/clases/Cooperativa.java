package clases;

import java.util.ArrayList;

public class Cooperativa extends Usuario {
	String _especializacion;
	ArrayList<Cooperativa> _asociaciones = new ArrayList<Cooperativa>();
	ArrayList<Distribuidora> _distribuidoras = new ArrayList<Distribuidora>();
	int _cantidadMiembros = 0;

	public String get_especializacion() {
		return _especializacion;
	}
	public int get_cantidadMiembros() {
		return _cantidadMiembros;
	}
	public void set_especializacion(String _especializacion) {
		this._especializacion = _especializacion;
	}
	public void set_cantidadMiembros(int _cantidadMiembros) {
		this._cantidadMiembros = _cantidadMiembros;
	}

	public void addToAsociaciones(Cooperativa coop) {
		this._asociaciones.add(coop);
	}

	public void rmFromAsociaciones(Cooperativa coop){
		try {
			this._asociaciones.remove(coop);}
		catch (IndexOutOfBoundsException ex){
			System.out.println("Acceso fuera de limites!");}	
	}

	public void rmFromAsociaciones(int indice){
		try {
			this._asociaciones.remove(indice);}
		catch (IndexOutOfBoundsException ex){
			System.out.println("Acceso fuera de limites!");}		}

	public void clrAsociaciones(){
		this._asociaciones.clear();
	}

	public void addToDistribuidoras(Distribuidora Distri){
		this._distribuidoras.add(Distri);
	}

	public void rmFromDistribuidoras(Distribuidora Distri){
		try {
			this._distribuidoras.remove(Distri);}
		catch (IndexOutOfBoundsException ex){
			System.out.println("Acceso fuera de limites!");}	
	}

	public void rmFromDistribuidoras(int indice){
		try {
			this._distribuidoras.remove(indice);}
		catch (IndexOutOfBoundsException ex){
			System.out.println("Acceso fuera de limites!");}	
	}
	
	@Override
	public void addToLista(Producto p1) {
		super.addToLista(p1);
		p1._disponibilidad++;
	}
	@Override
	public Boolean rmFromLista(Producto p1) {
		p1._disponibilidad--;
		return super.rmFromLista(p1);
	}
	@Override
	public Boolean rmFromLista(int i){
		try {
			this._listaProductos.get(i)._disponibilidad--;}
		catch (IndexOutOfBoundsException ex) {
			;	
		}
		return super.rmFromLista(i);
		
	}
	public Cooperativa(String infPago, Region region, String esp, int cantidadMiembros) {
		super(infPago, region);
		this.set_cantidadMiembros(cantidadMiembros);
		this.set_especializacion(esp);
	}
	

	
}
