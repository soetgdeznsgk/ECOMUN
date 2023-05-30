package logica;
import clases.*;
import java.util.Scanner;

public class logica {
	public void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// ECOMUN
		Ecomun ECOMUN = new Ecomun("+57 300 1112233");
		
		// Regiones
		Region Cundinamarca = new Region("Cundinamarca", "101 2023030", "Madrid, Vereda El Tumulto, Casa 5");
		Region Uraba = new Region("Uraba", "303 3000003", "Caucasia, Calle 13 #2-32");
		Region Tolima = new Region("Tolima", "999 9999", "Ibague, Calle 1 # 3");
		Region Antioquia = new Region("Antioquia", "989 8989", "Medellín, Barranquilla con 3ra");
		
		// Usuarios 
		Comprador PepeGrillo = new Comprador("Pepe Grillo", "123 4567890", "1234-5678-9101-1121", Cundinamarca);
		Comprador Emiliano = new Comprador("Emiliano Guerra", "350 2825442", "kek", Cundinamarca);
		
		// Productos
		
		ProductoOrganico Aguacate = new ProductoOrganico((float) 0.4, "Aguacate", "Fruta", 3100, 2, 6, 23);
		ProductoInorganico Abono = new ProductoInorganico((float) 200.0, "Abono", "Fertilizante", 100000, 750);
		ProductoOrganico Papa = new ProductoOrganico((float) 0.1, "Papa", "Hortaliza", 1600, 9, 6, 23);
		
		// Cooperativas
		
		Cooperativa LaRoja = new Cooperativa("Cerveza Roja", "111 1111", "xxxx-yyyy-zzzz-oooo", Tolima, "Fermentados", 50);
		Cooperativa CfParamillo = new Cooperativa("Cafe Paramillo", "333 1112223", "solomillos gonorrea", Antioquia, "Agricultura", 38);
		
		// Distribuidoras
		
		Distribuidora EntregaRoja = new Distribuidora("Entrega Roja", "7700 200", "ykc", Cundinamarca, 32);
		Distribuidora LaPola = new Distribuidora("Transporte La Pola", "302 3000", "x-x-x-x", Tolima, 15);
		while (true) {
			
		}
	}
}
