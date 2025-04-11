package vista;

import controlador.ClienteControlador;

public class ClienteVista {
    
    public void mostrarMenuClientes() {
        int option;

        do{
            System.out.println("=== Menú Gestión de Clientes");
            System.out.println("1. Añadir Cliente");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Mostrar Clientes Estándar");
            System.out.println("4. Mostrar Clientes Premium");
            System.out.println("0. Volver");

            option = EntradaUsuario.leerEnteroRango("Elige una opción: ", 0, 4);

            switch (option) {
                case 1:
                    añadirClienteDesdeVista();
                    break;
                case 2:
                    ClienteControlador.mostrarClientes();
                    break;
                case 3:
                    ClienteControlador.mostrarClientesEstandar();
                    break;
                case 4:
                    ClienteControlador.mostrarClientesPremium();
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

    private static void añadirClienteDesdeVista() {
        try {
            System.out.println("\n--- Añadir Cliente ---");
            String tipo = EntradaUsuario.leerConfirmacion("Tipo de cliente (E)standar / (P)remium: ", "E", "P");
            String nombre = EntradaUsuario.leerTexto("Nombre: ");
            String email = EntradaUsuario.leerTexto("Email: ");
            String nif = EntradaUsuario.leerTexto("NIF: ");
            String domicilio = EntradaUsuario.leerTexto("Domicilio: ");

            boolean clienteAñadido;

            if (tipo.equals("P")) {
                int cuotaAnual = EntradaUsuario.leerEntero("Cuota anual (euros): ");
                clienteAñadido = ClienteControlador.añadirClientePremiumDesdeVista(nombre, domicilio, nif, email, cuotaAnual);
            } else {
                clienteAñadido = ClienteControlador.añadirClienteEstandarDesdeVista(nombre, domicilio, nif, email);
            }

            if (clienteAñadido) {
                System.out.println("Cliente estándar añadido correctamente.");
            } else {
                System.out.println("Ya existe un cliente con este email.");
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la entrada del cliente: " + e.getMessage());
        }
        
        
    }

}
