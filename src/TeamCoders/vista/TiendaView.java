package TeamCoders.vista;

import TeamCoders.controlador.TiendaController;
import TeamCoders.modelo.*;

import java.util.*;

public class TiendaView {
    
    private TiendaController controlador;
    private Scanner scanner;

    public TiendaView() {
        this.controlador = new TiendaController();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ TIENDA ONLINE ---");
            System.out.println("1. Agregar cliente estándar");
            System.out.println("2. Agregar cliente premium");
            System.out.println("3. Mostrar todos los clientes");
            System.out.println("4. Mostrar clientes estandar");
            System.out.println("5. Mostrar clientes premium");
            System.out.println("6. Agregar artículo");
            System.out.println("7. Mostrar artículos");
            System.out.println("8. Agregar pedido");
            System.out.println("9. Mostrar pedidos");
            System.out.println("10. Eliminar pedido");
            System.out.println("0. Salir");
            System.out.println("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarClienteEstandar();
                case 2 -> agregarClientePremium();
                case 3 -> controlador.mostrarClientes();
                case 4 -> controlador.mostrarClientesEstandar();
                case 5 -> controlador.mostrarClientesPremium();
                case 6 -> agregarArticulo();
                case 7 -> controlador.mostrarArticulos();
                case 8 -> agregarPedido();
                case 9 -> controlador.mostrarPedidos();
                case 10 -> eliminarPedido();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0 );
    }

    private void agregarClienteEstandar() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Domicilio: ");
        String domicilio = scanner.nextLine();
        System.out.println("NIF: ");
        String nif = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();

        Cliente cliente = new ClienteEstandar(nombre, domicilio, nif, email);
        controlador.agregarCliente(cliente);
        System.out.println("Cliente estándar añadido correctamente.");
    }

    private void agregarClientePremium() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Domicilio: ");
        String domicilio = scanner.nextLine();
        System.out.println("NIF: ");
        String nif = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Cuota anual: ");
        int cuotaAnual = scanner.nextInt();

        Cliente cliente = new ClientePremium(nombre, domicilio, nif, email, cuotaAnual);
        controlador.agregarCliente(cliente);
        System.out.println("Cliente premium añadido correctamente.");
    }

    private void agregarArticulo() {
        System.out.println("Código: ");
        String codigo = scanner.nextLine();
        System.out.println("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.println("Precio de venta: ");
        float precioVenta = scanner.nextFloat();
        System.out.println("Gastos de envio: ");
        float gastosEnvio = scanner.nextFloat();
        System.out.println("Tiempo de preparación (minutos): ");
        int tiempoPreparacion = scanner.nextInt();
        scanner.nextLine();

        Articulo articulo = new Articulo(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion);
        controlador.agregarArticulo(articulo);
        System.out.println("Articulo añadido correctamente.");        
    }

    private void agregarPedido() {
        System.out.println("Número de pedido: ");
        int numero = scanner.nextInt();
        System.out.println("Unidades: ");
        int unidades = scanner.nextInt();

        List<Articulo> articulos = controlador.getArticulos();
        List<Cliente> clientes = controlador.getClientes();

        if (articulos.isEmpty() || clientes.isEmpty()) {
            System.out.println("Debe haber al menos un cliente y un artículo para realizar un pedido.");
            return;
        }

        System.out.println("Seleccione un cliente: ");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println(i + ". " + clientes.get(i).getNombre());
        }

        int idxCliente = scanner.nextInt();

        System.out.println("Seleccione un artículo: ");
        for (int i = 0; i < articulos.size(); i++) {
            System.out.println((i + ". " + articulos.get(i).getDescripcion()));
        }

        int idxArticulo = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = clientes.get(idxCliente);
        Articulo articulo = articulos.get(idxArticulo);
        Date fecha = new Date();

        Pedido pedido = new Pedido(numero, unidades, fecha, cliente, articulo);
        controlador.agregarPedido(pedido);

        float total = pedido.precioPedido();
        System.out.println("Pedido añadido. Precio total: " + total + " €");
    }

    private void eliminarPedido() {
        System.out.println("Ingrese el número del pedido a eliminar: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        List<Pedido> pedidos = controlador.getPedidos();
        Pedido pedidoEliminar = null;
        for (Pedido p : pedidos) {
            if (p.getNumeroPedido() == numero) {
                pedidoEliminar = p;
                break;
            }
        }

        if (pedidoEliminar != null) {
            controlador.eliminarPedido(pedidoEliminar);
            System.out.println("Pedido eliminado correctamente.");
        } else {
            System.out.println("Pedido no encontrado.");
        }
    }
}