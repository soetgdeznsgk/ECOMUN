package logica;
import clases.*;
import UI.ui;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class logica {

	static Scanner sc = new Scanner(System.in);
	static String directorioActual = System.getProperty("user.dir");
	static String ubicacionDeDatos = directorioActual + File.separator + "src" + File.separator + "datos_usuarios.txt";
	
	
	
	
	public static void mercar(Cooperativa coop, Comprador comp) {
		int temp;
		int cuenta = 0;
		
		while (true) {
			temp = sc.nextInt();
			sc.nextLine(); // limpieza de buffer
			
			try {
				comp.addToLista(coop.getLista().get(temp));
				System.out.println("Lista actual: ");
				for (Producto p: comp.getLista()) {
					System.out.println(Integer.toString(cuenta++) + ". "
							+ p.get_nombre() + " " + p.get_precio() + "$");
				}
				cuenta = 0;
				
			}
			
			catch (IndexOutOfBoundsException ex) {
				System.out.println("Saliendo del menú");
				break;}
				
			catch (InputMismatchException ex) {
				System.out.println("Sólo números!");
				break;
			}
		}
	}
	
	
	
	public static void eliminarDeLista(Comprador comp) {
		int temp;
		int cuenta = 0;
		
		while (true) {
			temp = sc.nextInt();
			sc.nextLine(); // limpieza de buffer
			
			try {
				comp.rmFromLista(temp);
				System.out.println("Lista actual: ");
				for (Producto p: comp.getLista()) {
					System.out.println(Integer.toString(cuenta++) + ". "
							+ p.get_nombre() + " " + p.get_precio() + "$");
				}
				cuenta = 0;
			}
			
			catch (IndexOutOfBoundsException ex) {
				System.out.println("Saliendo del menú");
				break;}
			catch (InputMismatchException ex) {
				System.out.println("Sólo números!");
				break;}
		}
	}
	
	
	
	public static Boolean registroComprador(Ecomun e) {
		String nombre;
		int eleccion;
		
		System.out.println("Su usuario no se registrará en caso de que ECOMUN no tenga cobertura en su área");
		System.out.println("Ingrese su nombre");
		nombre = sc.nextLine();
		System.out.println("Ingrese su teléfono de contacto");
		String telContacto = sc.nextLine();
		System.out.println("Ingrese su información de pago");
		String infPago = sc.nextLine();
		System.out.println("Seleccione alguna de las siguientes regiones");
		ui.Regiones(e);
		
		
		
		try {
			eleccion = sc.nextInt();
			sc.nextLine(); // limpieza de buffer
		}
		
		catch (InputMismatchException ex) {
			return false;
		}
		
		Region region = e.getRegiones().get(eleccion);
		
		try {
			FileWriter fw = new FileWriter(ubicacionDeDatos, true);
			Comprador comprador = new Comprador(nombre, telContacto, infPago, region);
			fw.write(comprador.toString());
			fw.close();
			return true;}
		
		catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}
		
	}
	
	
	
	
	public static ArrayList<Comprador> lecturaCompradores(Ecomun e) {
		FileReader ar;
		ArrayList<Comprador> compradores = new ArrayList<Comprador>();
		Comprador compradorTemp;
		
		
		try {
			ar = new FileReader(ubicacionDeDatos);
			Scanner sc = new Scanner(ar);
			int r;
			String temp = "";
			String[] outTemp;
			String nombre, infPago, tel;
			Region region;
			
			while ((r = ar.read()) != -1) { 
				//System.out.print((char)r);
				if ((char) r != '\n') {
					//System.out.print((char) r);
					temp += String.valueOf((char) r);
				}
				else {
					outTemp = temp.split(",");
					nombre = outTemp[0];
					infPago = outTemp[1];
					tel = outTemp[2];
					//System.out.println(outTemp[3]); // debug
					//System.out.println(e.getRegion(outTemp[3]).getNombre()); // debug
					region = e.getRegion(outTemp[3]);
					
					compradorTemp = new Comprador(nombre, infPago, tel, region);
					compradores.add(compradorTemp);
					
					temp = "";
				}
			}
			
			
			sc.close();
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			return null;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return compradores;
	}
	
	
	
	
	public static Comprador iniciarSesion(Ecomun e, Boolean b) {
		Comprador usuarioActual = null;
		String nombre;
		
		if (b) {
			return null;
		}
		
		System.out.println("Ingrese su nombre, si está registrado, se iniciará su sesión");
		nombre = sc.nextLine();
		
		for (Comprador c: e.getCompradores()) {
			if (c.getNombre().toLowerCase().equals(nombre.toLowerCase())) {
				usuarioActual = c;
			}
		}
		
		if (usuarioActual == null) {
			System.out.println("No se encuentra la información de comprador, se inicia sesión como invitadx");
		}
		
		return usuarioActual;
	}
	
	
	
	public static void main(String[] args) {
		//System.out.println("-aca comienza- \n"+ubicacionDeDatos+"\n-aca termina"); debug
		// ECOMUN
		Ecomun ECOMUN = new Ecomun("+57 300 1112233");
		
		// Regiones
		Region Cundinamarca = new Region("Cundinamarca", "101 2023030", "Madrid, Vereda El Tumulto, Casa 5");
		Region Uraba = new Region("Uraba", "303 3000003", "Caucasia, Calle 13 #2-32");
		Region Tolima = new Region("Tolima", "999 9999", "Ibague, Calle 1 # 3");
		Region Antioquia = new Region("Antioquia", "989 8989", "Medellín, Barranquilla con 3ra");
		Region Guajira = new Region("Guajira", "999 8765", "Riohacha, 2da con 5ta ed. Maria Paulina apto 302");
		
		// Usuarios 
		//Comprador PepeGrillo = new Comprador("Pepe Grillo", "123 4567890", "1234-5678-9101-1121", Cundinamarca);
		//Comprador Emiliano = new Comprador("Emiliano Guerra", "350 2825442", "kek", Cundinamarca);
		
		// Productos
		
		ProductoOrganico Aguacate = new ProductoOrganico((float) 0.4, "Aguacate", "Fruta", 3100, 2, 6, 23);
		ProductoOrganico Papa = new ProductoOrganico((float) 0.1, "Papa", "Hortaliza", 1600, 9, 6, 23);
		ProductoOrganico CervezaArtesanal = new ProductoOrganico((float) 0.2, "Cerveza Artesanal", "Fermentado", 3000, 10, 10, 24);
		ProductoOrganico VinoArtesanal = new ProductoOrganico((float) 1, "Vino Artesanal", "Fermentado", 45000, 10, 10, 24);
		
		ProductoInorganico Mochilas = new ProductoInorganico((float) 0.5, "Mochila", "Textil", 20000, 1);
		ProductoInorganico Abono = new ProductoInorganico((float) 200.0, "Abono", "Fertilizante", 100000, 750);
		//ProductoInorganico CafeEnPolvo = new ProductoInorganico(());
		
		// Cooperativas
		
		Cooperativa LaRoja = new Cooperativa("Cerveza Roja", "111 1111", "xxxx-yyyy-zzzz-oooo", Tolima, "Fermentados", 50, ECOMUN);
		LaRoja.addToLista(CervezaArtesanal);
		LaRoja.addToLista(VinoArtesanal);
		Cooperativa CfParamillo = new Cooperativa("Cafe Paramillo", "333 1112223", "solomillos gonorrea", Antioquia, "Agricultura", 38, ECOMUN);
		Cooperativa Manusm = new Cooperativa("Mercado Artesanal Nacional de Usme", "101 0101", "solo usme gono", Cundinamarca, "Agricultura", 14, ECOMUN);
		// Distribuidoras
		
		Distribuidora EntregaRoja = new Distribuidora("Entrega Roja", "7700 200", "ykc", Cundinamarca, 32);
		LaRoja.addToDistribuidoras(EntregaRoja);
		Distribuidora LaPola = new Distribuidora("Transporte La Pola", "302 3000", "x-x-x-x", Tolima, 15);
		
		// main
		
		Boolean seHaIniciado = false;
		Comprador user = null;
		
		while (true) {
			
			System.out.println("REINICIO");// debug 
			ECOMUN.setCompradores(lecturaCompradores(ECOMUN));
			
			if (user == null) {
				user = iniciarSesion(ECOMUN, seHaIniciado);
			}
			
			seHaIniciado = true;

			ui.Bienvenida(user);
			

			int input1;
		
			
			try {
				input1 = sc.nextInt();
				sc.nextLine(); // limpieza de buffer
				}
			catch (InputMismatchException ex) {
				System.out.println("Sólo números!");
				continue;}
			
			int input2, input3;
			
			switch (input1) {
				case -1:
					continue;
					
					
				case 0:
					ui.Coops(ECOMUN);			
					try {
						input2 = sc.nextInt();
						sc.nextLine(); // limpieza de buffer
						Cooperativa cooperativaActual = ECOMUN.getCooperativas().get(input2);
						ui.ProductosPorCoop(cooperativaActual);
						if (user != null) {
							System.out.println("Para añadir un producto al carrito, ingrese su indice, para dejar de mercar: cualquier otro numero");
							mercar(cooperativaActual, user);
							
						}
						}
					catch (IndexOutOfBoundsException ex) {
						System.out.println("Fuera de límites!");
					}
					catch (InputMismatchException ex) {
						System.out.println("Sólo números!");
					}
					break;
					
					
				case 1:
					input2 = sc.nextInt();
					sc.nextLine(); // limpieza de buffer
					break;
					
					
				case 2:
					if (user != null) {
						ui.InfoCuenta(user);		// TODAVÍA NO ESTÁ TESTEADO
						System.out.println("\nSi desea eliminar algún producto del carrito, ingrese su índice, para volver al menú: cualquier otro numero\n");
						ui.opcionesDentroDeInfo();
						input2 = sc.nextInt();
						sc.nextLine(); // limpieza de buffer
						
						switch (input2) {
							case 0: 
								eliminarDeLista(user);
							break;
							
							case 1:
								ui.pagar(user);
								break;
							}
					}
					
					else {
						registroComprador(ECOMUN);
					}
					break;
					
				case 3:
					if (user != null) {
						user = null;
						continue;}
					else {
						user = iniciarSesion(ECOMUN, false);
					}
			}
			
		}
	}
}
