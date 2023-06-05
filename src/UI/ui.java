package UI;
import clases.*;
import logica.*;

public class ui {
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
				+ "\n2. Para registrarse como comprador"
				+ "\n3. Para iniciar sesión como comprador"
				+ ((user == null) ? "" : "\n4. Consultar información de cuenta \n5. Cerrar sesión")
				+ "\nEn cualquier momento puede ingresar el índice -1 para volver al menú de inicio");
	}
	
	public static void Coops(Ecomun ECOMUN) {
		for(Cooperativa c: ECOMUN.getCooperativas()) {
			System.out.println(Integer.toString(ECOMUN.getCooperativas().indexOf(c)) + ". "
					+ c.getNombre() + " (" + c.get_especializacion() + ") - " + c.getRegion().getNombre());
		}
	}
	
	public static void ProductosPorCoop(Cooperativa coop) {
		System.out.println(coop.getNombre() + ", teléfono de contacto " + coop.getTel());
		for(Producto p: coop.getLista()) {
			System.out.println(Integer.toString(coop.getLista().indexOf(p)) + ". "
					+ p.get_nombre() + " (" + p.get_categoria() +") "+ p.get_precio() + "$ ," + p.get_disponibilidad() + "disponibles");
		}
	}
	
	public static void Regiones(Ecomun E) {
		for (Region r: E.getRegiones()) {
			System.out.println(Integer.toString(E.getRegiones().indexOf(r)) + ". "
					+ r.getNombre() + " Punto de Recogida: " + r.getDireccion());
		}
	}
	
	public static void InfoCuenta(Comprador c) {
		System.out.println("Nombre de cuenta : " + c.getNombre());
		System.out.println("")
	}
	
}
