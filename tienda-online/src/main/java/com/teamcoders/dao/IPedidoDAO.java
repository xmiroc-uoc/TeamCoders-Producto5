package com.teamcoders.dao;

import java.sql.SQLException;
import java.util.List;

import com.teamcoders.modelo.Pedido;

public interface IPedidoDAO {

  void crearPedido(Pedido pedido) throws SQLException;

  Pedido buscarPedidoPorNumero(int numero) throws SQLException;

  List<Pedido> obtenerTodosLosPedidos() throws SQLException;

  void actualizarPedido(Pedido pedido) throws SQLException;

  void borrarPedido(int numero) throws SQLException;

  List<Pedido> buscarPedidosPendientesEnvio() throws SQLException;

  List<Pedido> buscarPedidosEnviados() throws SQLException;
}
