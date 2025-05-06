package com.teamcoders.controlador;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.teamcoders.dao.DAOFactory;
import com.teamcoders.dao.IArticuloDAO;
import com.teamcoders.dao.IClienteDAO;
import com.teamcoders.dao.IPedidoDAO;
import com.teamcoders.modelo.Articulo;
import com.teamcoders.modelo.Cliente;
import com.teamcoders.modelo.Pedido;

/**
 * Clase controladora que gestiona operaciones relacionadas con los pedidos.
 * Actúa como intermediaria entre la vista y la lógica de negocio (modelo).
 * 
 */
public class PedidoControlador {

    // Fábrica de DAOs para MySQL
    private static final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE);

    // DAO específico para pedidos
    private static final IPedidoDAO pedidoDAO = factory.getPedidoDAO();
    private static final IClienteDAO clienteDAO = factory.getClienteDAO();
    private static final IArticuloDAO articuloDAO = factory.getArticuloDAO();

    /**
     * Añade un nuevo pedido desde la vista.
     * Verifica que el cliente y el artículo existan antes de crear el pedido.
     *
     * @param emailCliente   Email del cliente que realiza el pedido.
     * @param codigoArticulo Código del artículo solicitado.
     * @param cantidad       Número de unidades pedidas.
     * @throws IllegalArgumentException si el cliente o el artículo no existen,
     *                                  si la cantidad es inválida,
     *                                  o si ocurre un error al crear el pedido.
     */
    public static void añadirPedidoDesdeVista(String emailCliente, String codigoArticulo, int cantidad) {
        try {
            // Validación de unidades
            if (cantidad <= 0) {
                throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
            }

            // Obtener el cliente
            Cliente cliente = clienteDAO.buscarClientePorEmail(emailCliente);
            if (cliente == null) {
                throw new IllegalArgumentException("El cliente con email " + emailCliente + " no existe.");
            }

            // Obtener el artículo
            Articulo articulo = articuloDAO.buscarArticuloPorCodigo(codigoArticulo);
            if (articulo == null) {
                throw new IllegalArgumentException("El artículo con código " + codigoArticulo + " no existe.");
            }

            // Generar número de pedido
            // int numeroPedido = generarNumeroPedido();

            // Crear el pedido con la fecha actual
            Pedido nuevoPedido = new Pedido(0, cantidad, LocalDateTime.now(), cliente, articulo);

            // Guardar el pedido en la base de datos
            pedidoDAO.crearPedido(nuevoPedido);

        } catch (Exception e) {
            throw new RuntimeException("Error al crear pedido: " + e.getMessage(), e);
        }
    }

    /**
     * Elimina un pedido si aún no ha sido enviado (cancelable).
     *
     * @param numero Número identificador del pedido.
     * @return true si fue eliminado, false si no existe o ya fue enviado.
     */
    public static boolean eliminarPedidoSiNoEnviado(int numero) {
        try {
            Pedido pedido = pedidoDAO.buscarPedidoPorNumero(numero);

            if (pedido == null) {
                return false;
            }

            // Solo se elimina si aún es cancelable
            if (pedido.cancelable()) {
                pedidoDAO.borrarPedido(numero);
                return true;
            }

            return false;
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar pedido: " + e.getMessage(), e);
        }
    }

    /**
     * Recupera todos los pedidos registrados.
     *
     * @return Lista completa de pedidos.
     */
    public static List<Pedido> obtenerPedidos() {
        try {
            return pedidoDAO.obtenerTodosLosPedidos();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener pedidos: " + e.getMessage(), e);
        }
    }

    /**
     * Recupera los pedidos pendientes de envío (cancelables).
     *
     * @return Lista de pedidos pendientes.
     */
    public static List<Pedido> obtenerPedidosPendientesDeEnvio() {
        try {
            List<Pedido> pendientes = new ArrayList<>();
            for (Pedido p : pedidoDAO.obtenerTodosLosPedidos()) {
                if (p.cancelable()) {
                    pendientes.add(p);
                }
            }
            return pendientes;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener pedidos pendientes: " + e.getMessage(), e);
        }
    }

    /**
     * Recupera los pedidos que ya han sido enviados (no cancelables).
     *
     * @return Lista de pedidos enviados.
     */
    public static List<Pedido> obtenerPedidosEnviados() {
        try {
            List<Pedido> enviados = new ArrayList<>();
            for (Pedido p : pedidoDAO.obtenerTodosLosPedidos()) {
                if (!p.cancelable()) {
                    enviados.add(p);
                }
            }
            return enviados;
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener pedidos enviados: " + e.getMessage(), e);
        }
    }
}
