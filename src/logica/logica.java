package logica;
import clases.*;

public class logica {
	public void main(String[] args) {
		// ECOMUN
		Ecomun ECOMUN = new Ecomun("+57 300 1112233");
		
		// Regiones
		Region Cundinamarca = new Region("Cundinamarca", "101 2023030", "Madrid, Vereda El Tumulto, Casa 5");
		Region Uraba = new Region("Uraba", "303 3000003", "Caucasia, Calle 13 #2-32");
		
		// Usuarios 
		Comprador PepeGrillo = new Comprador("Pepe Grillo", "123 4567890", "1234-5678-9101-1121", Cundinamarca);
		Comprador Emiliano = new Comprador("Emiliano Guerra", "350 2825442", "kek", Cundinamarca);
		
		// Productos
		
		ProductoOrganico Aguacate = new ProductoOrganico((float) 0.4, "Aguacate", "Fruta", 3100, 2, 6, 23);
		ProductoInorganico Abono = new ProductoInorganico((float) 200.0, "Abono", "Fertilizante", 100000, 750);
		ProductoOrganico Papa = new ProductoOrganico((float) 0.1, "Papa", "Hortaliza", 1600, 9, 6, 23);
		
		while (true) {
			
		}
	}
}
