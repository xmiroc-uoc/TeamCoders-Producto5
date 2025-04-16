package controlador;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import DAO.Factory.DAOFactory;
import DAO.Interface.PedidoDAO;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Pedido;

/**
 * Clase controladora responsable de gestionar operaciones relacionadas con los pedidos,
 * incluyendo añadir, eliminar y listar pedidos según distintos criterios.
 * Forma parte del patrón MVC y actúa como intermediaria entre la vista y el modelo.
 */
public class PedidoControlador {

    private static DAOFactory factory = new DAOFactory();
    private static PedidoDAO pedidoDAO = factory.getPedido();
    
    public static void añadirPedidoDesdeVista(String email, String codigoArticulo, int cantidad) {
        Cliente cliente = ClienteControlador.buscarClientePorEmail(email);
        Articulo articulo = ArticuloControlador.buscarArticuloPorCodigo(codigoArticulo);

        if (cliente == null) {
            throw new IllegalArgumentException("No se encontró un cliente con el email: " + email);
        }
        if (articulo == null) {
            throw new IllegalArgumentException("No se encontró un artículo con el código: " + codigoArticulo);
        }

        LocalDateTime fecha = LocalDateTime.now();
        Pedido pedido = new Pedido(0, cantidad, fecha, cliente, articulo);
        
        try {
            pedidoDAO.insert(pedido);
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear pedido: " + e.getMessage(), e);
        }
    }
    

    public static boolean eliminarPedidoSiNoEnviado(int numero) {
        try {
            Pedido pedido = pedidoDAO.getByID(numero);

            if (pedido == null) {
                return false;
            }

            if (pedido.cancelable()) {
                pedidoDAO.delete(pedido);
                return true;
            }
            return false;
            
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar pedido: " + e.getMessage(), e);
        }
    }

    
    public static List<Pedido> obtenerPedidos() {
        try {
            return pedidoDAO.getAll();
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener pedidos: " + e.getMessage(), e);
        }
    }

    
    public static List<Pedido> obtenerPedidosPendientesDeEnvio() {
        List<Pedido> pendientes = new ArrayList<>();
        for (Pedido p : obtenerPedidos()) {
            if (p.cancelable()) {
                pendientes.add(p);
            }
        }
        return pendientes;
    }

    public static List<Pedido> obtenerPedidosEnviados() {
        List<Pedido> enviados = new ArrayList<>();
        for (Pedido p : obtenerPedidos()) {
            if (!p.cancelable()) {
                enviados.add(p);
            }
        }
        return enviados;
    }

}
