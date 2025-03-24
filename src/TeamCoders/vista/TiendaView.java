package vista;

public class TiendaView {

    public void printMenuGeneral(){
        System.out.println("1. Gestión Artículos\r\n" + //
                        "2. Gestión de Clientes\r\n" + //
                        "3. Gestion de Pedidos\r\n" + //
                        "0. Salir");
    }

    public void printMenuArticulos(){
        System.out.println("1. Añadir Articulos\r\n" + //
                        "2. Mostrar Articulos\r\n" + //
                        "0. Salir");
    }

    public void printMenuClientes(){
        System.out.println("1. Añadir Clientes\r\n" + //
                        "2. Mostrar Clientes\r\n" + //
                        "3. Mostrar Clientes Estándar\r\n" + //
                        "4. Mostrar Clientes Premium\r\n" + //
                        "0. Salir");
    }

    public void printMenuPedidos(){
        System.out.println("1. Añadir Pedido.\r\n" + //
                        "2. Eliminar Pedido.\r\n" + //
                        "3. Mostar pedidos pendientes de envío.\r\n" + //
                        "4. Mostrar pedidos enviados.\r\n" + //
                        "0. Salir");
    }
}