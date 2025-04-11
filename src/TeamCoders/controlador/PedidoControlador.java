package controlador;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import modelo.Articulo;
import modelo.Cliente;
import modelo.Datos;
import modelo.Pedido;

public class PedidoControlador {
  
    public static boolean añadirPedidoDesdeVista(String email, String codigoArticulo, int cantidad) {
            Cliente cliente = ClienteControlador.buscarClientePorEmail(email);
            Articulo articulo = ArticuloControlador.buscarArticuloPorCodigo(codigoArticulo);
    
            if (cliente == null || articulo == null) {
                return false;
            }
    
            int numeroPedido = Datos.getPedidos().size() + 1;
            LocalDateTime fecha = LocalDateTime.now();
            Pedido pedido = new Pedido(numeroPedido, cantidad, fecha, cliente, articulo);
            agregarPedido(pedido);
            return true;

    }

    public static void agregarPedido(Pedido pedido) {
        Datos.agregarPedido(pedido);
        
    }
    public static void eliminarPedido(Pedido pedido) {
        Datos.eliminarPedido(pedido);
        System.out.println("Pedido eliminado correctamente.");
    }

    public static void eliminarPedidoSiNoEnviado(int numero) {
        try {
            Pedido pedidoAEliminar = buscarPedidoPorNumero(numero);

            if (pedidoAEliminar == null) {
                System.out.println("Pedido no encontrado.");
                return;
            }
    
            if (pedidoAEliminar.cancelable()) {
                eliminarPedido(pedidoAEliminar);
            } else {
                System.out.println("El pedido ya fue enviado y no puede eliminarse.");
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar pedido: " + e.getMessage());
        }
    }

    private static Pedido buscarPedidoPorNumero(int numero) {
        for (Pedido p : Datos.getPedidos()) {
            if (p.getNumeroPedido() == numero) {
                return p;
            }
        }
        return null;
    }

    public static List<Pedido> obtenerPedidos() {
        return new ArrayList<>(Datos.getPedidos());
    }

    public static void mostrarPedidos() {
        System.out.println("\n--- Lista de Todos los Pedidos ---");
        for (Pedido p : obtenerPedidos()) {
            System.out.println(p);
        }
    }

    public static void mostrarPedidosPendientesDeEnvio() {
        System.out.println("\n--- Pedidos Pendientes de Envío ---");
        for (Pedido p : obtenerPedidos()) {          
            if (p.cancelable()) {
                System.out.println(p);
            }
        }
    }

    public static void mostrarPedidosEnviados() {
        System.out.println("\n--- Pedidos Enviados ---");
        for (Pedido p : obtenerPedidos()) {
            if (!p.cancelable()) {
                System.out.println(p);
            }
        }
    }

}
