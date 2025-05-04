package com.teamcoders.controlador;

import java.sql.SQLException;
import java.util.List;

import com.teamcoders.dao.DAOFactory;
import com.teamcoders.dao.IArticuloDAO;
import com.teamcoders.modelo.Articulo;

public class ArticuloControlador {

  private static final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
  private static final IArticuloDAO articuloDAO = factory.getArticuloDAO();

  public static void añadirArticuloDesdeVista(String codigo, String descripcion, double precioVenta,
      double gastosEnvio, int tiempoPreparacion) {
    try {
      Articulo articulo = new Articulo(codigo, tiempoPreparacion, gastosEnvio, precioVenta, descripcion);

      articuloDAO.crearArticulo(articulo);
    } catch (SQLException e) {
      throw new RuntimeException("Error al crear artículo en BD: " + e.getMessage(), e);
    }
  }

  public static List<Articulo> obtenerArticulos() {
    try {
      return articuloDAO.obtenerTodosLosArticulos();
    } catch (SQLException e) {
      throw new RuntimeException("Error al obtener la lista de artículos: " + e.getMessage(), e);
    }
  }

  public static Articulo buscarArticuloPorCodigo(String codigo) {
    try {
      return articuloDAO.buscarArticuloPorCodigo(codigo);
    } catch (SQLException e) {
      throw new RuntimeException("Error buscando artículo por codigo: " + e.getMessage(), e);
    }
  }
}
