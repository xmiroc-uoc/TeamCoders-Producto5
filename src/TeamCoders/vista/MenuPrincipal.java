package vista;

public class MenuPrincipal {
    
    private ClienteVista clienteVista = new ClienteVista();
    private ArticuloVista articuloVista = new ArticuloVista();
    private PedidoVista pedidoVista = new PedidoVista();

    public void mostrarMenuPrincipal() {
        int option;
        do {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Artículos");
            System.out.println("3. Gestión de Pedidos");
            System.out.println("0. Salir");
            
            option = EntradaUsuario.leerEnteroRango("Elige una opción: ", 0,3);

            switch (option) {
                case 1:
                    clienteVista.mostrarMenuClientes();
                    break;
                case 2:
                    articuloVista.mostrarMenuArticulo();
                    break;
                case 3:
                    pedidoVista.mostrarMenuPedido();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación... ");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (option != 0);
    }

}
