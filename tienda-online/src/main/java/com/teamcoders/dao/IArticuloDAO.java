package com.teamcoders.dao;

import java.sql.SQLException;
import java.util.List;

import com.teamcoders.modelo.Articulo;

public interface IArticuloDAO {

  void crearArticulo(Articulo articulo) throws SQLException;

  Articulo buscarArticuloPorCodigo(String codigo) throws SQLException;

  List<Articulo> obtenerTodosLosArticulos() throws SQLException;

  void actualizarArticulo(Articulo articulo) throws SQLException;

  void borrarArticulo(String codigo) throws SQLException;
}
