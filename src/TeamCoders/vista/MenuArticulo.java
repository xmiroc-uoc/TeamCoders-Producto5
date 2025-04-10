package vista;

import controlador.ControladorArticulo;

import java.util.Scanner;
import java.util.InputMismatchException;

public class MenuArticulo {
    
    private ControladorArticulo controladorArticulo = new ControladorArticulo();
    static Scanner teclado = new Scanner(System.in);

    
    public void printMenuArticulo(){

        String opcion = "";

        while(!opcion.equals("0")){
            System.out.println("Haga su selección\n");
            
            System.out.println("1. Añadir Articulos\r\n" + //
                            "2. Mostrar Articulos\r\n" + //
                            "0. Salir");

            System.out.print("\n");
            opcion = teclado.nextLine();
            System.out.print("\n");

            switch (opcion) {
                case "1":
                    try {
                        controladorArticulo.agregarArticulo();
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
                    controladorArticulo.mostrarArticulo();
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
