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

public class PedidoControlador {

  private static final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

  private static final IPedidoDAO pedidoDAO = factory.getPedidoDAO();
  private static final IClienteDAO clienteDAO = factory.getClienteDAO();
  private static final IArticuloDAO articuloDAO = factory.getArticuloDAO();

  public static void añadirPedidoDesdeVista(String emailCliente, String codigoArticulo, int cantidad) {
    try {
      if (cantidad <= 0) {
        throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
      }

      Cliente cliente = clienteDAO.buscarClientePorEmail(emailCliente);
      if (cliente == null) {
        throw new IllegalArgumentException("El cliente con email " + emailCliente + " no existe.");
      }

      Articulo articulo = articuloDAO.buscarArticuloPorCodigo(codigoArticulo);
      if (articulo == null) {
        throw new IllegalArgumentException("El artículo con código " + codigoArticulo + " no existe.");
      }

      Pedido nuevoPedido = new Pedido(0, cantidad, LocalDateTime.now(), cliente, articulo);

      pedidoDAO.crearPedido(nuevoPedido);

    } catch (Exception e) {
      throw new RuntimeException("Error al crear pedido: " + e.getMessage(), e);
    }
  }

  public static boolean eliminarPedidoSiNoEnviado(int numero) {
    try {
      Pedido pedido = pedidoDAO.buscarPedidoPorNumero(numero);

      if (pedido == null) {
        return false;
      }

      if (pedido.cancelable()) {
        pedidoDAO.borrarPedido(numero);
        return true;
      }

      return false;
    } catch (Exception e) {
      throw new RuntimeException("Error al eliminar pedido: " + e.getMessage(), e);
    }
  }

  public static List<Pedido> obtenerPedidos() {
    try {
      return pedidoDAO.obtenerTodosLosPedidos();
    } catch (Exception e) {
      throw new RuntimeException("Error al obtener pedidos: " + e.getMessage(), e);
    }
  }

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
