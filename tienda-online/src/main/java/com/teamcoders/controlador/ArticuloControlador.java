package com.teamcoders.controlador;

import java.sql.SQLException;
import java.util.List;

import com.teamcoders.dao.interfaces.IArticuloDAO;
import com.teamcoders.factory.DAOFactory;
import com.teamcoders.modelo.Articulo;

/**
 * Clase controladora responsable de gestionar operaciones relacionadas con los
 * artículos.
 * Forma parte del patrón MVC y actúa como intermediaria entre la vista y el
 * modelo.
 * 
 */
public class ArticuloControlador {

    // Obtenemos la fábrica de DAOs específica para MySQL
    private static final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.JPA);
    private static final IArticuloDAO articuloDAO = factory.getArticuloDAO();

    /**
     * Añade un nuevo artículo desde la vista.
     * 
     * @param codigo            Código identificador único del artículo.
     * @param descripcion       Descripción detallada del artículo.
     * @param precioVenta       Precio al que se vende el artículo.
     * @param gastosEnvio       Coste adicional por el envío del artículo.
     * @param tiempoPreparacion Tiempo necesario para preparar el artículo para
     *                          envío (en minutos).
     * @throws RuntimeException Si ocurre un error al insertar en base de datos.
     */
    public static void añadirArticuloDesdeVista(String codigo, String descripcion, double precioVenta,
            double gastosEnvio, int tiempoPreparacion) {
        try {
            // Creamos el objeto artículo con los datos proporcionados por la vista
            Articulo articulo = new Articulo(codigo, tiempoPreparacion, gastosEnvio, precioVenta, descripcion);

            // Guardamos el artículo a través del DAO correspondiente
            articuloDAO.crearArticulo(articulo);
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear artículo en BD: " + e.getMessage(), e);
        }
    }

    /**
     * Recupera todos los artículos disponibles desde la base de datos.
     * 
     * @return Lista de artículos.
     * @throws RuntimeException Si ocurre un error al obtener los datos.
     */
    public static List<Articulo> obtenerArticulos() {
        try {
            return articuloDAO.obtenerTodosLosArticulos();
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la lista de artículos: " + e.getMessage(), e);
        }
    }

    /**
     * Busca un artículo en la base de datos usando su código identificador.
     * 
     * @param codigo Código del artículo a buscar.
     * @return Artículo encontrado o null si no existe.
     * @throws RuntimeException Si ocurre un error en la búsqueda.
     */
    public static Articulo buscarArticuloPorCodigo(String codigo) {
        try {
            return articuloDAO.buscarArticuloPorCodigo(codigo);
        } catch (SQLException e) {
            throw new RuntimeException("Error buscando artículo por codigo: " + e.getMessage(), e);
        }
    }
}
