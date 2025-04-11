package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Articulo;
import modelo.Datos;

/**
 * Clase controladora responsable de gestionar operaciones relacionadas con los artículos,
 * incluyendo añadir nuevos artículos, buscar artículos por código y listar artículos disponibles.
 * Forma parte del patrón MVC y actúa como intermediaria entre la vista y el modelo.
 */
public class ArticuloControlador {
    
    /**
     * Añade un nuevo artículo desde la vista. La validación de duplicado se realiza en Datos.agregarArticulo.
     * @param codigo Código identificador único del artículo.
     * @param descripcion Descripción detallada del artículo.
     * @param precioVenta Precio al que se vende el artículo.
     * @param gastosEnvio Coste adicional por el envío del artículo.
     * @param tiempoPreparacion Tiempo necesario para preparar el artículo para envío (en minutos).
     * @throws IllegalArgumentException si ya existe un artículo con ese código.
     */
    public static void añadirArticuloDesdeVista(String codigo, String descripcion, double precioVenta, double gastosEnvio, int tiempoPreparacion) {
        Articulo articulo = new Articulo(codigo, tiempoPreparacion, gastosEnvio, precioVenta, descripcion);
        agregarArticulo(articulo);
    }

    /**
     * Agrega un nuevo artículo directamente al almacén de datos.
     * Este método delega la validación de duplicados a la clase Datos.
     * @param articulo Instancia del artículo que será añadida.
     * @throws IllegalArgumentException si ya existe un artículo con el mismo código.
     */
    public static void agregarArticulo(Articulo articulo) {
        Datos.agregarArticulo(articulo);
    }

    /**
     * Obtiene una lista con todos los artículos disponibles actualmente.
     * @return Lista de artículos disponibles.
     */
    public static List<Articulo> obtenerArticulos() {
        return new ArrayList<>(Datos.getArticulos());
    }

    /**
     * Busca un artículo por su código identificador.
     * @param codigo Código único del artículo a buscar.
     * @return Artículo encontrado o null si no existe.
     */
    public static Articulo buscarArticuloPorCodigo(String codigo) {
        // Recorre todos los artículos existentes en busca del código proporcionado.
        for (Articulo a : Datos.getArticulos()) {
            if (a.getCodigo().equalsIgnoreCase(codigo)) {
                return a;
            }
        }
        return null;
    }
}
