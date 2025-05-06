package com.teamcoders.dao;

import java.sql.SQLException;
import java.util.List;

import com.teamcoders.modelo.Pedido;

/**
 * Interfaz DAO que define las operaciones CRUD para la entidad Pedido.
 * Incluye métodos adicionales para filtrar pedidos por estado de envío.
 */
public interface IPedidoDAO {

    /**
     * Inserta un nuevo pedido en la base de datos.
     * 
     * @param pedido Pedido a insertar.
     * @throws SQLException si ocurre un error en la operación.
     */
    void crearPedido(Pedido pedido) throws SQLException;

    /**
     * Busca un pedido a partir de su número.
     * 
     * @param numero Número del pedido.
     * @return Pedido encontrado o null si no existe.
     * @throws SQLException si ocurre un error en la operación.
     */
    Pedido buscarPedidoPorNumero(int numero) throws SQLException;

    /**
     * Recupera todos los pedidos registrados.
     * 
     * @return Lista de pedidos.
     * @throws SQLException si ocurre un error en la operación.
     */
    List<Pedido> obtenerTodosLosPedidos() throws SQLException;

    /**
     * Actualiza los datos de un pedido existente.
     * 
     * @param pedido Pedido con los datos actualizados.
     * @throws SQLException si ocurre un error en la operación.
     */
    void actualizarPedido(Pedido pedido) throws SQLException;

    /**
     * Elimina un pedido a partir de su número.
     * 
     * @param numero Número del pedido a eliminar.
     * @throws SQLException si ocurre un error en la operación.
     */
    void borrarPedido(int numero) throws SQLException;

    /**
     * Filtra los pedidos que aún no han sido enviados (cancelables).
     * 
     * @return Lista de pedidos pendientes de envío.
     * @throws SQLException si ocurre un error en la operación.
     */
    List<Pedido> buscarPedidosPendientesEnvio() throws SQLException;

    /**
     * Filtra los pedidos que ya han sido enviados (no cancelables).
     * 
     * @return Lista de pedidos enviados.
     * @throws SQLException si ocurre un error en la operación.
     */
    List<Pedido> buscarPedidosEnviados() throws SQLException;
}
