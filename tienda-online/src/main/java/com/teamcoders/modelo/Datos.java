package com.teamcoders.modelo;

import java.util.*;

public class Datos {

  private static ArrayList<Articulo> articulos = new ArrayList<>();
  private static ArrayList<Cliente> clientes = new ArrayList<>();
  private static ArrayList<Pedido> pedidos = new ArrayList<>();

  public static ArrayList<Articulo> getArticulos() {
    return articulos;
  }

  public static ArrayList<Cliente> getClientes() {
    return clientes;
  }

  public static ArrayList<Pedido> getPedidos() {
    return pedidos;
  }

  public static void agregarArticulo(Articulo articulo) {

    for (Articulo a : articulos) {
      if (a.getCodigo().equalsIgnoreCase(articulo.getCodigo())) {
        throw new IllegalArgumentException("Ya existe un artículo con el código: " + articulo.getCodigo());
      }
    }
    articulos.add(articulo);
  }

  public static void agregarCliente(Cliente cliente) {

    for (Cliente c : clientes) {
      if (c.getEmail().equalsIgnoreCase(cliente.getEmail())) {
        throw new IllegalArgumentException("Ya existe un cliente con el email: " + cliente.getEmail());
      }
    }
    clientes.add(cliente);
  }

  public static void agregarPedido(Pedido pedido) {
    pedidos.add(pedido);
  }

  public static void eliminarPedido(Pedido pedido) {
    pedidos.remove(pedido);
  }
}
