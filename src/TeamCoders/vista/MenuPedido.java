package vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import controlador.ControladorPedido;

public class MenuPedido {
    
    private ControladorPedido controladorPedido = new ControladorPedido();
    static Scanner teclado = new Scanner(System.in);

    
    public void printMenuPedido(){

        String opcion = "";

        while(!opcion.equals("0")){
            System.out.println("Haga su selección\n");
            
            System.out.println("1. Añadir Pedido.\r\n" + //
                        "2. Eliminar Pedido.\r\n" + //
                        "3. Mostar pedidos pendientes de envío.\r\n" + //
                        "4. Mostrar pedidos enviados.\r\n" + //
                        "0. Salir");

            System.out.print("\n");
            opcion = teclado.nextLine();
            System.out.print("\n");

            switch (opcion) {
                case "1":
                    controladorPedido.agregarPedido();
                    break;
                case "2":
                    try{
                        controladorPedido.eliminarPedido();
                    }
                    catch (InputMismatchException ime){
                        System.out.print("\n");
                        System.out.println("Tipo de dato erroneo");
                        System.out.print("\n");
                        teclado.nextLine();
                    }
                    break;
                case "3":
                    controladorPedido.mostrarPedidosPendientes();
                    System.out.print("\n");
                    break;
                case "4":
                    controladorPedido.mostrarPedidosEnviados();
                    System.out.print("\n");
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Escoja entre las opciones disponibles.\n");
                    break;
            }
        }
    }
}