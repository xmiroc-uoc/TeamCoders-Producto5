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
     * Añade un nuevo artículo desde la vista, verificando previamente que no exista ya un artículo con el mismo código.
     * @param codigo Código identificador único del artículo.
         * @param descripcion Descripción detallada del artículo.
     * @param precioVenta Precio al que se vende el artículo.
     * @param gastosEnvio Coste adicional por el envío del artículo.
     * @param tiempoPreparacion Tiempo necesario para preparar el artículo para envío (en minutos).
     * @return true si el artículo se añadió correctamente, false si ya existía uno con ese código.
     */
    public static boolean añadirArticuloDesdeVista(String codigo, String descripcion, double precioVenta, double gastosEnvio, int tiempoPreparacion) {
        // Comprueba si ya existe un artículo con el mismo código para evitar duplicados.
        if (buscarArticuloPorCodigo(codigo) != null) {
            return false;
        }
        Articulo articulo = new Articulo(codigo, tiempoPreparacion, gastosEnvio, precioVenta, descripcion);
        agregarArticulo(articulo);
        return true;
    }

    /**
     * Agrega un nuevo artículo directamente al almacén de datos.
     * @param articulo Instancia del artículo que será añadida.
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
