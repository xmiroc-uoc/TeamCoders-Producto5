
package TeamCoders.vista;

import TeamCoders.modelo.Pedido;

import java.util.ArrayList;
import java.util.Scanner;

public class PedidoView {

    private Scanner sc;

    public PedidoView() {
        sc = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("----- Gestión de Pedidos -----");
        System.out.println("1. Añadir Pedido");
        System.out.println("2. Listar Pedidos");
        System.out.println("0. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
    }

    public int leerOpcion() {
        return sc.nextInt();
    }

    public Pedido pedirDatosPedido() {
        System.out.print("Código Pedido: ");
        String codigo = sc.next();
        System.out.print("DNI Cliente: ");
        String dni = sc.next();
        System.out.print("Código Artículo: ");
        String codigoArticulo = sc.next();
        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();

        return new Pedido(codigo, dni, codigoArticulo, cantidad);
    }

    public void mostrarPedidos(ArrayList<Pedido> lista) {
        for (Pedido p : lista) {
            System.out.println(p);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
