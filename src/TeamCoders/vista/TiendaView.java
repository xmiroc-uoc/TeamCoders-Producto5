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
        String nombre = pedirTexto("Nombre: ");
        String domicilio = pedirTexto("Domicilio: ");
        String nif = pedirTexto("NIF: ");
        String email = pedirTexto("Email: ");

        Cliente cliente = new ClienteEstandar(nombre, domicilio, nif, email);
        controlador.agregarCliente(cliente);
        System.out.println("Cliente estándar añadido correctamente.");
    }

    private void agregarClientePremium() {
        String nombre = pedirTexto("Nombre: ");
        String domicilio = pedirTexto("Domicilio: ");
        String nif = pedirTexto("NIF: ");
        String email = pedirTexto("Email: ");
        int cuotaAnual = leerEntero("Cuota anual: ");

        Cliente cliente = new ClientePremium(nombre, domicilio, nif, email, cuotaAnual);
        controlador.agregarCliente(cliente);
        System.out.println("Cliente premium añadido correctamente.");
    }

    private void agregarArticulo() {
        String codigo = pedirTexto("Código: ");
        String descripcion = pedirTexto("Descripción: ");
        float precioVenta = leerDecimal("Precio de venta: ");
        float gastosEnvio = leerDecimal("Gastos de envio: ");
        int tiempoPreparacion = leerEntero("Tiempo de preparación (minutos): ");

        Articulo articulo = new Articulo(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion);
        controlador.agregarArticulo(articulo);
        System.out.println("Articulo añadido correctamente.");        
    }

    private void agregarPedido() {
        int numero = leerEntero("Número de pedido: ");
        int unidades = leerEntero("Unidades: ");

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
        int numero = leerEntero("Igrese el número del predido a eliminar: ");

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

    private int leerEntero(String mensaje) {
        int valor = -1;
        while (true) {
            try {
                System.out.println(mensaje);
                valor = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Debe ser un número entero.");
                scanner.nextLine(); // Limpiar entrada incorrecta
            }
        }
        return valor;
    }

    private float leerDecimal(String mensaje) {
        float valor = -1;
        while (true) {
            try {
                System.out.print(mensaje);
                valor = scanner.nextFloat();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Debe ser un número decimal.");
                scanner.nextLine();
            }
        }
        return valor;
    }

    private String pedirTexto(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextLine();
    }
}