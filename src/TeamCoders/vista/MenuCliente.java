package vista;

import controlador.ControladorCliente;

import java.util.Scanner;
import java.util.InputMismatchException;

public class MenuCliente {
    
    private ControladorCliente controladorCliente = new ControladorCliente();
    static Scanner teclado = new Scanner(System.in);

    
    public void printMenuCliente(){

        String opcion = "";

        while(!opcion.equals("0")){
            System.out.println("Haga su selección\n");
            
            System.out.println("1. Añadir Clientes\r\n" + //
            "2. Mostrar Clientes\r\n" + //
            "3. Mostrar Clientes Estándar\r\n" + //
            "4. Mostrar Clientes Premium\r\n" + //
            "0. Salir");

            System.out.print("\n");
            opcion = teclado.nextLine();
            System.out.print("\n");

            switch (opcion) {
                case "1":
                    try{
                        controladorCliente.agregarCliente();
                    }
                    catch (InputMismatchException ime){
                        System.out.print("\n");
                        System.out.println("Tipo de dato erroneo");
                        System.out.print("\n");
                        teclado.nextLine();
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                        System.out.print("\n");
                    }
                    break;
                case "2":
                    controladorCliente.mostrarCliente();
                    System.out.print("\n");
                    break;
                case "3":
                    controladorCliente.mostrarClienteEstandar();
                    System.out.print("\n");
                    break;
                case "4":
                    controladorCliente.mostrarClientePremium();
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
