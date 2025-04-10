
package TeamCoders.vista;

import TeamCoders.modelo.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class ClienteView {

    private Scanner sc;

    public ClienteView() {
        sc = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("----- Gestión de Clientes -----");
        System.out.println("1. Añadir Cliente");
        System.out.println("2. Listar Clientes");
        System.out.println("0. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
    }

    public int leerOpcion() {
        return sc.nextInt();
    }

    public Cliente pedirDatosCliente() {
        System.out.print("Nombre: ");
        sc.nextLine();
        String nombre = sc.nextLine();
        System.out.print("DNI: ");
        String dni = sc.next();
        System.out.print("Tipo (Estandar/Premium): ");
        String tipo = sc.next();

        return new Cliente(nombre, dni, tipo);
    }

    public void mostrarClientes(ArrayList<Cliente> lista) {
        for (Cliente c : lista) {
            System.out.println(c);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
