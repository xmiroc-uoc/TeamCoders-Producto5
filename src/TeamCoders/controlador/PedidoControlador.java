package controlador;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import modelo.Articulo;
import modelo.Cliente;
import modelo.Datos;
import modelo.Pedido;

/**
 * Clase controladora responsable de gestionar operaciones relacionadas con los pedidos,
 * incluyendo añadir, eliminar y listar pedidos según distintos criterios.
 * Forma parte del patrón MVC y actúa como intermediaria entre la vista y el modelo.
 */
public class PedidoControlador {
    
    /**
     * Añade un pedido desde la vista si el cliente y el artículo existen.
     * @param email Email del cliente que realiza el pedido.
     * @param codigoArticulo Código del artículo solicitado.
     * @param cantidad Cantidad de unidades del artículo.
     * @return true si se añadió correctamente, false si el cliente o artículo no existen.
     */
    public static boolean añadirPedidoDesdeVista(String email, String codigoArticulo, int cantidad) {
            Cliente cliente = ClienteControlador.buscarClientePorEmail(email);
            Articulo articulo = ArticuloControlador.buscarArticuloPorCodigo(codigoArticulo);
    
            // Comprueba si el cliente y artículo existen.
            if (cliente == null || articulo == null) {
                return false;
            }
    
            int numeroPedido = Datos.getPedidos().size() + 1;
            LocalDateTime fecha = LocalDateTime.now();
            Pedido pedido = new Pedido(numeroPedido, cantidad, fecha, cliente, articulo);
            agregarPedido(pedido);
            return true;
    }

    /**
     * Agrega un pedido a la lista de pedidos.
     * @param pedido Pedido a agregar.
     */
    public static void agregarPedido(Pedido pedido) {
        Datos.agregarPedido(pedido); 
    }

    /**
     * Eliminar un pedido de la lista de pedidos.
     * @param pedido Pedido a eliminar.
     */
    public static void eliminarPedido(Pedido pedido) {
        Datos.eliminarPedido(pedido);
    }

    /**
     * Elimina un pedido si aún no ha sido enviado.
     * @param numero Número del pedido a eliminar.
     * @return true si se eliminó correctamente, false si no existe o ya fue enviado.
     */
    public static boolean eliminarPedidoSiNoEnviado(int numero) {
        Pedido pedidoAEliminar = buscarPedidoPorNumero(numero);

        // Verifica si el pedido existe y aún es cancelable.
        if (pedidoAEliminar == null) {
            return false;
        }
        if (pedidoAEliminar.cancelable()) {
            eliminarPedido(pedidoAEliminar);
            return true;
        }
        return false;
    }

    /**
     * Busca un pedido por su número.
     * @param numero Número del pedido.
     * @return El pedido encontrado o null si no existe.
     */
    private static Pedido buscarPedidoPorNumero(int numero) {
        for (Pedido p : Datos.getPedidos()) {
            if (p.getNumeroPedido() == numero) {
                return p;
            }
        }
        return null;
    }

    /**
     * Obtiene la lista completa de pedidos.
     * @return Lista de todos los pedidos registrados.
     */
    public static List<Pedido> obtenerPedidos() {
        return new ArrayList<>(Datos.getPedidos());
    }

    /**
     * Obtiene la lista de pedidos que aún no han sido enviados.
     * @return Lista de pedidos pendientes de envío.
     */
    public static List<Pedido> obtenerPedidosPendientesDeEnvio() {
        List<Pedido> pendientes = new ArrayList<>();
        for (Pedido p : Datos.getPedidos()) {
            if (p.cancelable()) {
                pendientes.add(p);
            }
        }
        return pendientes;
    }

    /**
     * Obtiene la lista de pedidos que ya han sido enviados.
     * @return Lista de pedidos enviados.
     */
    public static List<Pedido> obtenerPedidosEnviados() {
        List<Pedido> enviados = new ArrayList<>();
        for (Pedido p : Datos.getPedidos()) {
            if (!p.cancelable()) {
                enviados.add(p);
            }
        }
        return enviados;
    }

}
