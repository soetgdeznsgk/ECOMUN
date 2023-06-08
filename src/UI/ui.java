package UI;
import clases.*;
import java.util.ArrayList;
import org.javatuples.*;
import logica.*;

public final class ui {
	private static int contador = 0; //solamente para imprimir los índices de las listas
	
	
	public static void Bienvenida(Comprador user) {
		for(int i = 0; i < 30; i++) {
			System.out.print("/\\");
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("\nSesion actual : " + ((user == null) ? "Invitadx" : user.getNombre()));
		
		System.out.println("Bienvenidx al catálogo virtual de ECOMUN (Economías Sociales del Común)\n"
				+ "\n0. Ver tiendas por región"
				+ "\n1. Ver Producto por región"
				+ ((user == null) ? 
						"\n2. Para registrarse como comprador\n3. Para iniciar sesión como comprador" : 
							"\n2. Consultar información de cuenta \n3. Cerrar sesión")
				+ "\nEn cualquier momento puede ingresar el índice -1 para volver al menú de inicio");
	}
	
	public static void opcionesDentroDeInfo() {
		System.out.println("0. Para eliminar productos del carrito de compras");
		System.out.println("1. Para proceder a pagar");
	}
	
	public static void Coops(Ecomun ECOMUN) {
		contador = 0;
		for(Cooperativa c: ECOMUN.getCooperativas()) {
			System.out.println(contador++ + ". "
					+ c.getNombre() + " (" + c.get_especializacion() + ") - " + c.getRegion().getNombre());
		}
	}
	
	public static void ProductosPorCoop(Cooperativa coop) {
		contador = 0;
		System.out.println(coop.getNombre() + ", teléfono de contacto " + coop.getTel());
		for(Producto p: coop.getLista()) {
			System.out.println(contador++ + ". "
					+ p.get_nombre() + " (" + p.get_categoria() +") "+ p.get_precio() + "$ ," + p.get_disponibilidad() + "disponibles");
		}
	}
	
	public static void Regiones(Ecomun E) {
		for (Region r: E.getRegiones()) {
			System.out.println(Integer.toString(E.getRegiones().indexOf(r)) + ". "
					+ r.getNombre() + " Punto de Recogida: " + r.getDireccion());
		}
	}
	
	public static void InfoCuenta(Comprador c) { // queda pendiente si se puede eliminar o no la cuenta
		System.out.println("Nombre de cuenta : " + c.getNombre());
		System.out.println("Teléfono de contacto: " + c.getTel());
		System.out.println("Información de pago: " + c.getInfPago());
		System.out.print("Actualmente en el carrito: \n\n");
		imprimirProductosDesdeCarrito(c.getCarrito());
		System.out.println();
		
		System.out.println("Precio total del carrito: $" + Float.toString(c.getPrecioCarrito()));
		
		
	}
	
	public static Boolean pagar(Comprador c) {
		Boolean valor = c.pagar();
		System.out.println(valor ? "Pago exitoso!" : "Error en el pago" );
		return valor;
	}
	
	public static void imprimirProductosDesdeCarrito(ArrayList<Pair<Cooperativa, Producto>> carrito) {
		contador = 0;
		
		for (Pair<Cooperativa, Producto> Tupla : carrito) {
			System.out.println(contador++ + ". " + Tupla.getValue1().get_nombre() + " $" + Tupla.getValue1().get_precio());
		}
		
	}
	
	
	
}
