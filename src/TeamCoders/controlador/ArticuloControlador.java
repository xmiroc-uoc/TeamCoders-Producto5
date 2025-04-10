package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Articulo;
import modelo.Datos;

public class ArticuloControlador {
    
    public static void añadirArticuloDesdeVista(String codigo, String descripcion, double precioVenta, double gastosEnvio, int tiempoPreparacion) {
        if (buscarArticuloPorCodigo(codigo) != null) {
            System.out.println("Ya existe un artículo con ese código.");
            return;
        }
        Articulo articulo = new Articulo(codigo, tiempoPreparacion, gastosEnvio, precioVenta, descripcion);
        agregarArticulo(articulo);
        System.out.println("Artículo añadido correctamente.");
    }

    public static void agregarArticulo(Articulo articulo) {
        Datos.agregarArticulo(articulo);
    }

    public static List<Articulo> obtenerArticulos() {
        return new ArrayList<>(Datos.getArticulos());
    }

    public static Articulo buscarArticuloPorCodigo(String codigo) {
        for (Articulo a : Datos.getArticulos()) {
            if (a.getCodigo().equalsIgnoreCase(codigo)) {
                return a;
            }
        }
        return null;
    }

    public static void mostrarArticulos() {
        System.out.println("\n--- Lista de Artículos ---");
        for (Articulo a : obtenerArticulos()) {
            System.out.println(a);
        }
    }
}
