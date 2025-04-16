package controlador;

import java.sql.SQLException;
import java.util.List;

import DAO.Factory.DAOFactory;
import DAO.Interface.ArticuloDAO;
import modelo.Articulo;

/**
 * Clase controladora responsable de gestionar operaciones relacionadas con los artículos,
 * incluyendo añadir nuevos artículos, buscar artículos por código y listar artículos disponibles.
 * Forma parte del patrón MVC y actúa como intermediaria entre la vista y el modelo.
 */
public class ArticuloControlador {

    private static DAOFactory factory = new DAOFactory();
    private static ArticuloDAO articuloDAO= factory.getArticulo();
    

    public static void añadirArticuloDesdeVista(String codigo, String descripcion, double precioVenta, double gastosEnvio, int tiempoPreparacion) {
        Articulo articulo = new Articulo(codigo, tiempoPreparacion, gastosEnvio, precioVenta, descripcion);
        
        try {
            articuloDAO.insert(articulo);
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear artículo en BD: " + e.getMessage(), e);
        }
    }


    public static List<Articulo> obtenerArticulos() {
        try {
            return articuloDAO.getAll();
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la lista de artículos: " + e.getMessage(), e);
        }
    }

    public static Articulo buscarArticuloPorCodigo(String codigo) {
        try {
            return articuloDAO.getByCodigo(codigo);
        } catch (SQLException e) {
            throw new RuntimeException("Error buscando artículo por codigo: " + e.getMessage(), e);
        }
    }
}
