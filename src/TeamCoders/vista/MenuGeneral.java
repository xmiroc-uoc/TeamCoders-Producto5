package vista;

import java.util.Scanner;

public class MenuGeneral {
    
    private MenuArticulo menuArticulo = new MenuArticulo();
    private MenuCliente menuCliente = new MenuCliente();
    private MenuPedido menuPedido = new MenuPedido();
    static Scanner teclado = new Scanner(System.in);

    public void printMenuGeneral(){
        String opcion = "";

        while(!opcion.equals("0")){
            System.out.println("Haga su selección\n");
            System.out.println("1. Gestión Artículos\r\n" + //
                            "2. Gestión de Clientes\r\n" + //
                            "3. Gestion de Pedidos\r\n" + //
                            "0. Salir");
            System.out.print("\n");
            opcion = teclado.nextLine();
            System.out.print("\n");
            
            switch (opcion) {
                case "1":
                    System.out.println("Ha escogido Gestión de Articulos\n");
                    menuArticulo.printMenuArticulo();
                    break;
                case "2":
                    System.out.println("Ha escogido Gestión de Clientes\n");
                    menuCliente.printMenuCliente();
                    break;
                case "3":
                    System.out.println("Ha escogido Gestión de Pedidos\n");
                    menuPedido.printMenuPedido();
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
