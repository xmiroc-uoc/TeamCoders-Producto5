package vista;

import java.util.List;

import controlador.ArticuloControlador;
import modelo.Articulo;

/**
 * Clase de la vista responsable de la interacción con el usuario para la gestión de artículos.
 * Permite añadir nuevos artículos y mostrar todos los artículos registrados en la tienda.
 */
public class ArticuloVista {

    /**
     * Muestra el menú de opciones para la gestión de artículos en consola.
     */
    public void mostrarMenuArticulo() {

        int option;

        do{
            System.out.println("=== Menú Gestión de Articulos ===");
            System.out.println("1. Añadir Articulos");
            System.out.println("2. Mostrar Articulos");
            System.out.println("0. Volver");
            
            // Solicita al usuario una opción válida dentro del rango permitido
            option = EntradaUsuario.leerEnteroRango("Elige una opción: ", 0, 2);

            // Ejecuta la opción correspondiente según la entrada del usuario
            switch (option) {
                case 1:
                    añadirArticuloDesdeVista();
                    break;
                case 2:
                    mostrarArticulos();
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
            
        } while (option != 0);
    }

    /**
     * Solicita al usuario los datos necesarios y añade un nuevo artículo si el código no está duplicado.
     */
    private static void añadirArticuloDesdeVista() {
        try {
            System.out.println("\n--- Añadir Artículo ---");
            String codigo = EntradaUsuario.leerTexto("Código: ");
            String descripcion = EntradaUsuario.leerTexto("Descripción: ");
            double precioVenta = EntradaUsuario.leerDecimal("Precio: ");
            double gastosEnvio = EntradaUsuario.leerDecimal("Gastos de envío: ");
            int tiempoPreparacion = EntradaUsuario.leerEntero("Tiempo preparación (minutos): ");
            
            // Intenta añadir el artículo usando el controlador
            boolean articuloAñadido = ArticuloControlador.añadirArticuloDesdeVista(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion);

            // Informa al usuario del resultado del intento de inserción
            if (articuloAñadido) {
                System.out.println("Artículo añadido correctamente.");
            } else {
                System.out.println("Ya existe un artículo con ese código.");
            }

        } catch (Exception e) {
            System.out.println("Error al añadir artículo: " + e.getMessage());
        }
    }

    /**
     * Muestra todos los artículos registrados por consola.
     */
    public static void mostrarArticulos() {
        List<Articulo> articulos = ArticuloControlador.obtenerArticulos();
        System.out.println("\n--- Lista de Artículos ---");
        if (articulos.isEmpty()) {
            System.out.println("No hay artículos registrados.");
        } else {
            for (Articulo articulo : articulos) {
                System.out.println(articulo);
            }
        }
    }
}
