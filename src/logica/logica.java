package logica;
import clases.*;
import UI.ui;

import java.util.Scanner;

public class logica {
	
	public static Comprador registroComprador(Scanner sc, Ecomun e) {
		System.out.println("Ingrese su nombre");
		String nombre = sc.nextLine();
		System.out.println("Ingrese su teléfono de contacto");
		String telContacto = sc.nextLine();
		System.out.println("Ingrese su información de pago");
		String infPago = sc.nextLine();
		System.out.println("Seleccione alguna de las siguientes regiones");
		ui.Regiones(e);
		int eleccion = sc.nextInt();
		Region region = e.getRegiones().get(eleccion);
		
		
		return new Comprador(nombre, telContacto, infPago, region);
	}
	
	
	
	public static void main(String[] args) {
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
		ProductoOrganico CervezaArtesanal = new ProductoOrganico((float) 0.2, "Cerveza Artesanal", "Fermentado", 3000, 10, 10, 24);
		ProductoOrganico VinoArtesanal = new ProductoOrganico((float) 1, "Vino Artesanal", "Fermentado", 45000, 10, 10, 24);
		
		// Cooperativas
		
		Cooperativa LaRoja = new Cooperativa("Cerveza Roja", "111 1111", "xxxx-yyyy-zzzz-oooo", Tolima, "Fermentados", 50, ECOMUN);
		LaRoja.addToLista(CervezaArtesanal);
		LaRoja.addToLista(VinoArtesanal);
		Cooperativa CfParamillo = new Cooperativa("Cafe Paramillo", "333 1112223", "solomillos gonorrea", Antioquia, "Agricultura", 38, ECOMUN);
		
		// Distribuidoras
		
		Distribuidora EntregaRoja = new Distribuidora("Entrega Roja", "7700 200", "ykc", Cundinamarca, 32);
		LaRoja.addToDistribuidoras(EntregaRoja);
		Distribuidora LaPola = new Distribuidora("Transporte La Pola", "302 3000", "x-x-x-x", Tolima, 15);
		
		// main
		
		while (true) {
			ui.Bienvenida();
			int input1 = sc.nextInt();
			
			switch (input1) {
			case 0:
				continue;
			case 1:
				ui.Coops(ECOMUN);
				break;
			case 2:
				break;
			case 3:
				Comprador usuario = registroComprador(sc, ECOMUN);
				break;
			
			ui.ProductosPorCoop(ECOMUN.getCooperativas().get(i));
			}
		}
	}
}
