package com.teamcoders.dao;

import java.sql.SQLException;
import java.util.List;

import com.teamcoders.modelo.Articulo;

/**
 * Interfaz DAO para operaciones sobre la entidad Articulo.
 */
public interface IArticuloDAO {

    /**
     * Inserta un nuevo artículo en la base de datos.
     * 
     * @param articulo Artículo a insertar.
     * @throws SQLException si ocurre un error en la operación.
     */
    void crearArticulo(Articulo articulo) throws SQLException;

    /**
     * Busca un artículo por su código único.
     * 
     * @param codigo Código identificador del artículo.
     * @return Artículo encontrado o null si no existe.
     * @throws SQLException si ocurre un error en la operación.
     */
    Articulo buscarArticuloPorCodigo(String codigo) throws SQLException;

    /**
     * Recupera todos los artículos registrados en la base de datos.
     * 
     * @return Lista de artículos.
     * @throws SQLException si ocurre un error en la operación.
     */
    List<Articulo> obtenerTodosLosArticulos() throws SQLException;

    /**
     * Actualiza los datos de un artículo existente.
     * 
     * @param articulo Artículo con los datos actualizados.
     * @throws SQLException si ocurre un error en la operación.
     */
    void actualizarArticulo(Articulo articulo) throws SQLException;

    /**
     * Elimina un artículo identificado por su código.
     * 
     * @param codigo Código del artículo a eliminar.
     * @throws SQLException si ocurre un error en la operación.
     */
    void borrarArticulo(String codigo) throws SQLException;
}
