package clases;
import java.time.LocalDate;

public class ProductoOrganico extends Producto{
	public LocalDate _fechaVencimiento;

	public LocalDate get_fechaVencimiento() {
		return _fechaVencimiento;
	}

	public void set_fechaVencimiento(LocalDate _fechaVencimiento) {
		this._fechaVencimiento = _fechaVencimiento;
	}
	
	public void set_fechaVencimiento(int y, int m, int d) {
		this._fechaVencimiento = LocalDate.of(y, m, d);
	}

	public ProductoOrganico(int peso, String nombre, String categoria, int precio, int y, int m, int d) {
		super(peso, nombre, categoria, precio);
		this.set_fechaVencimiento(y, m, d);
		
		// TODO Auto-generated constructor stub
	}
	
	
	
}
