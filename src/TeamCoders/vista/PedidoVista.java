package vista;

import controlador.PedidoControlador;

public class PedidoVista {
    
    public void mostrarMenuPedido() {
        
        int option;

        do{
            System.out.println("=== Menú Gestión de Pedidos");
            System.out.println("1. Añadir Pedido");
            System.out.println("2. Eliminar Pedido");
            System.out.println("3. Mostrar Todos los Pedidos");
            System.out.println("4. Mostrar Pedidos Pendientes de Envío");
            System.out.println("5. Mostrar pedidos enviados");
            System.out.println("0. Volver");

            option = EntradaUsuario.leerEnteroRango("Elige una opción: ", 0, 5);

            switch (option) {
                case 1:
                    añadirPedidoDesdeVista();
                    break;
                case 2:
                    eliminarPedidoDesdeVista();
                    break;
                case 3:
                    PedidoControlador.mostrarPedidos();
                    break;
                case 4:
                    PedidoControlador.mostrarPedidosPendientesDeEnvio();
                    break;
                case 5:
                    PedidoControlador.mostrarPedidosEnviados();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
            
        } while (option != 0);
    }

    private static void añadirPedidoDesdeVista() {
        System.out.println("\n--- Añadir Pedido ---");
        String email = EntradaUsuario.leerTexto("Email del cliente: ");
        String codigoArticulo = EntradaUsuario.leerTexto("Código del artículo: ");
        int cantidad = EntradaUsuario.leerEntero("Cantidad: ");

        PedidoControlador.añadirPedidoDesdeVista(email, codigoArticulo, cantidad);
    }

    private static void eliminarPedidoDesdeVista() {
        System.out.println("\n--- Eliminar Pedido ---");
        int numero = EntradaUsuario.leerEntero("Número de pedido a eliminar: ");
        PedidoControlador.eliminarPedidoSiNoEnviado(numero);
    }
}
