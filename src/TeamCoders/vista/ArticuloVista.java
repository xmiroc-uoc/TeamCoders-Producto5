package vista;

import controlador.ArticuloControlador;

public class ArticuloVista {

    public void mostrarMenuArticulo() {

        int option;

        do{
            System.out.println("=== Menú Gestión de Articulos ===");
            System.out.println("1. Añadir Articulos");
            System.out.println("2. Mostrar Articulos");
            System.out.println("0. Volver");
            
            option = EntradaUsuario.leerEnteroRango("Elige una opción: ", 0, 2);

            switch (option) {
                case 1:
                    añadirArticuloDesdeVista();
                    break;
                case 2:
                    ArticuloControlador.mostrarArticulos();
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

    private static void añadirArticuloDesdeVista() {
        System.out.println("\n--- Añadir Artículo ---");
        String codigo = EntradaUsuario.leerTexto("Código: ");
        String descripcion = EntradaUsuario.leerTexto("Descripción: ");
        double precioVenta = EntradaUsuario.leerDecimal("Precio: ");
        double gastosEnvio = EntradaUsuario.leerDecimal("Gastos de envío: ");
        int tiempoPreparacion = EntradaUsuario.leerEntero("Tiempo preparación (minutos): ");

        ArticuloControlador.añadirArticuloDesdeVista(codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion);
    }


}
