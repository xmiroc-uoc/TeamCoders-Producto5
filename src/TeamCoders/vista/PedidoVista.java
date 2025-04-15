package vista;

import java.util.List;

import controlador.PedidoControlador;
import modelo.Pedido;

/**
 * Clase de la vista responsable de la interacción con el usuario para la
 * gestión de pedidos.
 * Permite añadir y eliminar pedidos, así como mostrar distintos listados de
 * pedidos según su estado.
 */
public class PedidoVista {

    /**
     * Muestra el menú de opciones para la gestión de pedidos en consola.
     * Permite al usuario realizar acciones como añadir, eliminar y listar pedidos.
     */
    public void mostrarMenuPedido() {

        int option;

        do {
            System.out.println("=== Menú Gestión de Pedidos");
            System.out.println("1. Añadir Pedido");
            System.out.println("2. Eliminar Pedido");
            System.out.println("3. Mostrar Todos los Pedidos");
            System.out.println("4. Mostrar Pedidos Pendientes de Envío");
            System.out.println("5. Mostrar pedidos enviados");
            System.out.println("0. Volver");

            // Solicita al usuario una opción válida dentro del rango permitido
            option = EntradaUsuario.leerEnteroRango("Elige una opción: ", 0, 5);

            // Ejecuta la acción correspondiente a la opción seleccionada
            switch (option) {
                case 1:
                    añadirPedidoDesdeVista();
                    break;
                case 2:
                    eliminarPedidoDesdeVista();
                    break;
                case 3:
                    mostrarPedidos();
                    break;
                case 4:
                    mostrarPedidosPendientesDeEnvio();
                    break;
                case 5:
                    mostrarPedidosEnviados();
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

    /**
     * Solicita al usuario los datos de un pedido y lo añade si el cliente y
     * artículo existen.
     * Captura y muestra errores si alguno de los datos es inválido o no existe.
     *
     * @throws IllegalArgumentException si el cliente o artículo no existen
     * @throws Exception                si ocurre cualquier otro error inesperado
     */
    private static void añadirPedidoDesdeVista() {
        try {
            System.out.println("\n--- Añadir Pedido ---");
            String email = EntradaUsuario.leerTexto("Email del cliente: ");
            String codigoArticulo = EntradaUsuario.leerTexto("Código del artículo: ");
            int cantidad = EntradaUsuario.leerEntero("Cantidad: ");

            // Intenta registrar el pedido; puede lanzar excepciones si cliente o artículo
            // no existen
            PedidoControlador.añadirPedidoDesdeVista(email, codigoArticulo, cantidad);
            System.out.println("Pedido añadido correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado al añadir el pedido: " + e.getMessage());
        }
    }

    /**
     * Solicita al usuario el número de pedido a eliminar e intenta eliminarlo si
     * aún no ha sido enviado.
     */
    private static void eliminarPedidoDesdeVista() {
        try {
            System.out.println("\n--- Eliminar Pedido ---");
            int numero = EntradaUsuario.leerEntero("Número de pedido a eliminar: ");

            // Intenta eliminar el pedido con verificación de cancelación
            boolean pedidoEliminado = PedidoControlador.eliminarPedidoSiNoEnviado(numero);

            // Muestra el resultado al usuario
            if (pedidoEliminado) {
                System.out.println("Pedido eliminado correctamente.");
            } else {
                System.out.println("No se puede eliminar el pedido. Puede que ya haya sido enviado o no exista.");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar pedido: " + e.getMessage());
        }
    }

    /**
     * Muestra todos los pedidos registrados por consola.
     */
    public static void mostrarPedidos() {
        List<Pedido> pedidos = PedidoControlador.obtenerPedidos();
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }

    /**
     * Muestra los pedidos pendientes de envío por consola.
     */
    public static void mostrarPedidosPendientesDeEnvio() {
        List<Pedido> pedidos = PedidoControlador.obtenerPedidosPendientesDeEnvio();
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos pendientes de envío.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }

    /**
     * Muestra los pedidos que ya han sido enviados por consola.
     */
    public static void mostrarPedidosEnviados() {
        List<Pedido> pedidos = PedidoControlador.obtenerPedidosEnviados();
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos enviados.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }
}
