
package TeamCoders.vista;

import TeamCoders.modelo.Articulo;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticuloView {

    private Scanner sc;

    public ArticuloView() {
        sc = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("----- Gestión de Artículos -----");
        System.out.println("1. Añadir Artículo");
        System.out.println("2. Listar Artículos");
        System.out.println("0. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
    }

    public int leerOpcion() {
        return sc.nextInt();
    }

    public Articulo pedirDatosArticulo() {
        System.out.print("Código: ");
        String codigo = sc.next();
        System.out.print("Descripción: ");
        sc.nextLine();
        String descripcion = sc.nextLine();
        System.out.print("Precio Venta: ");
        float precioVenta = sc.nextFloat();
        System.out.print("Gastos Envío: ");
        float gastosEnvio = sc.nextFloat();
        System.out.print("Tiempo Preparación (días): ");
        int tiempoPreparacion = sc.nextInt();

        return new Articulo(codigo, tiempoPreparacion, gastosEnvio, precioVenta, descripcion);
    }

    public void mostrarArticulos(ArrayList<Articulo> lista) {
        for (Articulo a : lista) {
            System.out.println(a);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
