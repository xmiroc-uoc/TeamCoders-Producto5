
package TeamCoders;

import TeamCoders.controlador.ArticuloController;
import TeamCoders.controlador.ClienteController;
import TeamCoders.controlador.PedidoController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArticuloController articuloController = new ArticuloController();
        ClienteController clienteController = new ClienteController();
        PedidoController pedidoController = new PedidoController();

        int opcion;
        do {
            System.out.println("----- MENU PRINCIPAL -----");
            System.out.println("1. Gestionar Artículos");
            System.out.println("2. Gestionar Clientes");
            System.out.println("3. Gestionar Pedidos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    articuloController.gestionarArticulos();
                    break;
                case 2:
                    clienteController.gestionarClientes();
                    break;
                case 3:
                    pedidoController.gestionarPedidos();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
