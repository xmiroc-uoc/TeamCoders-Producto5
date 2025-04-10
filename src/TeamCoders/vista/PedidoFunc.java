package vista;

import java.util.Scanner;

import controlador.ControladorArticulo;
import controlador.ControladorCliente;

public class PedidoFunc {

    private ControladorCliente controladorCliente = new ControladorCliente();
    private ControladorArticulo controladorArticulo = new ControladorArticulo();

    static Scanner teclado = new Scanner(System.in);

    public int introducirNumPedido(){
        int numPedido;
        System.out.println("Introduzca numero de pedido\n");
        numPedido = teclado.nextInt();
        System.out.print("\n");
        return numPedido;
    }

    public int introducirUnidades(){
        int unidades;
        System.out.println("Introduzca el numero de unidades\n");
        unidades = teclado.nextInt();
        System.out.print("\n");
        return unidades;
    }

    public String existenteOAgreagar(){
        String opcion = "";
        System.out.println("1. Seleccionar entre los clientes existentes\r\n" + //
                            "2. Agregar nuevo cliente");
            
        System.out.print("\n");
        teclado.nextLine();
        opcion = teclado.nextLine();
        System.out.print("\n");

        if(opcion.equals("1") || opcion.equals("2")){
            return opcion;
        }else{
            System.out.println("Escoja entre las opciones disponibles.");
            return "";
        }
    }

    public void handleInputMismatch(){
        System.out.print("\n");
        System.out.println("Tipo de dato erroneo");
        System.out.print("\n");
        teclado.nextLine();
        return;
    }

    public void handleException(Exception e){
        System.out.println(e.getMessage());
        System.out.print("\n");
        return;
    }

    public int seleccionarCliente(int size){
        int opcionCliente = 0;
        System.out.println("Seleccione un cliente");
        controladorCliente.mostrarCliente();
        System.out.println("\n");
        opcionCliente = teclado.nextInt();
        if(opcionCliente > 0 && opcionCliente <= size){
            return opcionCliente;
        }else{
            System.out.println("Escoja entre las opciones disponibles.");
            return 0;
        }
    } 

    public int seleccionarArticulo(int size){
        int opcionArticulo = 0;
        System.out.println("Seleccione un articulo");
        controladorArticulo.mostrarArticulo();
        System.out.println("\n");
        opcionArticulo = teclado.nextInt();
        if(opcionArticulo > 0 && opcionArticulo <= size){
            return opcionArticulo;
        }else{
            System.out.println("Escoja entre las opciones disponibles.");
            return 0;
        }
    } 

    public int seleccionarPedido(int size){
        int opcionPedido = 0;
        opcionPedido = teclado.nextInt();
        if(opcionPedido>0 && opcionPedido <= size){
            return opcionPedido;
        }else{
            System.out.println("Escoja entre las opciones disponibles.");
            return 0;
        }

    }

    public void pedidoNoCancelable(){
        System.out.println("Este pedido no se puede eliminar");
        teclado.nextLine();
    }

    public void printPedidos(int count, int num){
        System.out.println(count + ". " + "Pedido #" + num);
    }

    public void seleccion(){
        System.out.println("Seleccione un pedido");
    }
}
