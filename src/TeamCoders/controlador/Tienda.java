package controlador;

import modelo.*;
import vista.*;

import java.util.*;


public class Tienda {
   
    private Datos datos = new Datos();
    private TiendaView menu = new TiendaView();
    static Scanner teclado = new Scanner(System.in);


    public void navegarTienda(){
        String opcion = "";

        while(!opcion.equals("0")){
            System.out.println("Haga su selección\n");
            menu.printMenuGeneral();
            System.out.print("\n");
            opcion = teclado.nextLine();
            System.out.print("\n");

            switch (opcion) {
                case "1":
                    System.out.println("Ha escogido Gestión de Articulos\n");
                    navegarArticulos(opcion);
                    break;
                case "2":
                    System.out.println("Ha escogido Gestión de Clientes\n");
                    navegarClientes(opcion);
                    break;
                case "3":
                    System.out.println("Ha escogido Gestión de Pedidos\n");
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Escoja entre las opciones disponibles.\n");
                    break;
            }
        }
    }

    public void navegarArticulos(String opcion){
        while(!opcion.equals("0")){
            System.out.println("Haga su selección\n");
            menu.printMenuArticulos();
            System.out.print("\n");
            opcion = teclado.nextLine();
            System.out.print("\n");

            switch (opcion) {
                case "1":
                    agregarArticulo();
                    break;
                case "2":
                    datos.mostrarArticulo();
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

    public void navegarClientes(String opcion){
        while(!opcion.equals("0")){
            System.out.println("Haga su selección\n");
            menu.printMenuClientes();
            System.out.print("\n");
            opcion = teclado.nextLine();
            System.out.print("\n");

            switch (opcion) {
                case "1":
                    agregarCliente();
                    break;
                case "2":
                    datos.mostrarClientes();
                    System.out.print("\n");
                    break;
                case "3":
                    datos.mostrarClientesEstandar();
                    System.out.print("\n");
                    break;
                case "4":
                    datos.mostrarClientesPremium();
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

    public void navegarPedidos(String opcion){
        while(!opcion.equals("0")){
            System.out.println("Haga su selección\n");
            menu.printMenuPedidos();
            System.out.print("\n");
            opcion = teclado.nextLine();
            System.out.print("\n");

            switch (opcion) {
                case "1":
                    System.out.println("Ha escogido Añadir Pedido\n");
                    break;
                case "2":
                    System.out.println("Ha escogido Eliminar Pedido\n");
                    break;
                case "3":
                    System.out.println("Ha escogido Mostrar Pedidos Pendientes\n");
                    System.out.print("\n");
                    break;
                case "4":
                    System.out.println("Ha escogido Mostrar Pedidos Enviados\n");
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

    public void agregarArticulo(){
        String codigo = "";
        int tiempoPreparacion;
        float gastosEnvio;
        float precioVenta;
        String descripcion = "";

        System.out.println("Introduzca el codigo\n");
        codigo = teclado.nextLine();
        System.out.print("\n");

        System.out.println("Introduzca el timepo de preparación en minutos\n");
        tiempoPreparacion = teclado.nextInt();
        System.out.print("\n");

        System.out.println("Introduzca los gastos de envio\n");
        gastosEnvio = teclado.nextFloat();
        System.out.print("\n");

        System.out.println("Introduzca el precio de venta\n");
        precioVenta = teclado.nextFloat();
        System.out.print("\n");

        System.out.println("Introduzca una descripción\n");
        teclado.nextLine();
        descripcion = teclado.nextLine();
        System.out.print("\n");

        Articulo newArticulo = new Articulo(codigo, tiempoPreparacion, gastosEnvio, precioVenta, descripcion);
        
        datos.agregarArticulo(newArticulo);
    }

    public void agregarCliente(){
        String nombre = "";
        String domicilio = "";
        String nif = "";
        String email = "";
        String opcion = "";
        boolean opcionPosible = false;

        while(!opcionPosible){
            System.out.println("Que tipo de cliente quiere agregar:\r\n" + //
                            "1. Cliente Estándar\r\n" + //
                            "2. Cliente Premium");
            
            System.out.print("\n");
            opcion = teclado.nextLine();
            System.out.print("\n");

            if(opcion.equals("1") || opcion.equals("2")){
                opcionPosible = true;
            }else{
                System.out.println("Escoja entre las opciones disponibles.\\n");
            }
        }
        

        System.out.println("Introduzca el nombre\n");
        nombre = teclado.nextLine();
        System.out.print("\n");

        System.out.println("Introduzca el domicilio\n");
        domicilio = teclado.nextLine();
        System.out.print("\n");

        System.out.println("Introduzca el NIF\n");
        nif = teclado.nextLine();
        System.out.print("\n");

        System.out.println("Introduzca el mail\n");
        email = teclado.nextLine();
        System.out.print("\n");

        if(opcion.equals("1")){
            Cliente newCliente = new ClienteEstandar(nombre, domicilio, nif, email);
            datos.agregarCliente(newCliente);
        }else{
            int cuotaAnual;
            
            System.out.println("Introduzca la cuota anual\n");
            cuotaAnual = teclado.nextInt();
            teclado.nextLine();
            System.out.print("\n");

            Cliente newCliente = new ClientePremium(nombre, domicilio, nif, email, cuotaAnual);
            datos.agregarCliente(newCliente);
        }
    }

}
