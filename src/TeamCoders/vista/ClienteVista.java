package vista;

import java.util.List;

import controlador.ClienteControlador;
import modelo.Cliente;

/**
 * Clase de la vista responsable de la interacción con el usuario para la gestión de clientes.
 * Permite añadir clientes y mostrar clientes registrados, filtrando por tipo si se desea.
 */
public class ClienteVista {
   
    /**
     * Muestra el menú de opciones para la gestión de clientes en consola.
     */
    public void mostrarMenuClientes() {
        int option;

        do{
            System.out.println("=== Menú Gestión de Clientes");
            System.out.println("1. Añadir Cliente");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Mostrar Clientes Estándar");
            System.out.println("4. Mostrar Clientes Premium");
            System.out.println("0. Volver");

            // Solicita al usuario una opción válida dentro del rango
            option = EntradaUsuario.leerEnteroRango("Elige una opción: ", 0, 4);

            // Ejecuta la funcionalidad correspondiente según la opción elegida
            switch (option) {
                case 1:
                    añadirClienteDesdeVista();
                    break;
                case 2:
                    mostrarClientes();
                    break;
                case 3:
                    mostrarClientesEstandar();
                    break;
                case 4:
                    mostrarClientesPremium();
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
     * Solicita los datos al usuario y añade un cliente estándar o premium.
     */
    private static void añadirClienteDesdeVista() {
        try {
            System.out.println("\n--- Añadir Cliente ---");
            // Determina el tipo de cliente a registrar
            String tipo = EntradaUsuario.leerConfirmacion("Tipo de cliente (E)standar / (P)remium: ", "E", "P");
            String nombre = EntradaUsuario.leerTexto("Nombre: ");
            String email = EntradaUsuario.leerTexto("Email: ");
            String nif = EntradaUsuario.leerTexto("NIF: ");
            String domicilio = EntradaUsuario.leerTexto("Domicilio: ");

            boolean clienteAñadido;

            // Crea y registra el cliente según el tipo seleccionado
            if (tipo.equals("P")) {
                int cuotaAnual = EntradaUsuario.leerEntero("Cuota anual (euros): ");
                clienteAñadido = ClienteControlador.añadirClientePremiumDesdeVista(nombre, domicilio, nif, email, cuotaAnual);
            } else {
                clienteAñadido = ClienteControlador.añadirClienteEstandarDesdeVista(nombre, domicilio, nif, email);
            }

            // Notifica al usuario si el cliente se registró correctamente o si ya existía
            if (clienteAñadido) {
                System.out.println("Cliente estándar añadido correctamente.");
            } else {
                System.out.println("Ya existe un cliente con este email.");
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la entrada del cliente: " + e.getMessage());
        }
    }

    /**
     * Muestra todos los clientes registrados por consola.
     */
    public static void mostrarClientes() {
        List<Cliente> clientes = ClienteControlador.obtenerClientes();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    /**
     * Muestra solo los clientes de tipo estándar por consola.
     */
    public static void mostrarClientesEstandar() {
        List<Cliente> clientes = ClienteControlador.obtenerClientesEstandar();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes estándar registrados.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    /**
     * Muestra solo los clientes de tipo premium por consola.
     */
    public static void mostrarClientesPremium() {
        List<Cliente> clientes = ClienteControlador.obtenerClientesPremium();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes premium registrados.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }
}
