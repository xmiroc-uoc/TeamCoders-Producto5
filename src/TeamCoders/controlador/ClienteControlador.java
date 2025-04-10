package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.ClienteEstandar;
import modelo.ClientePremium;
import modelo.Datos;

public class ClienteControlador {
    
    public static void añadirClienteEstandarDesdeVista(String nombre, String domicilio, String nif, String email) {
        try {
            if (buscarClientePorEmail(email) != null) {
                System.out.println("Ya existe un cliente con este email.");
                return;
            }
            Cliente cliente = new ClienteEstandar(nombre, domicilio, nif, email);
            agregarCliente(cliente);
            System.out.println("Cliente estándar añadido correctamente.");
        } catch (Exception e) {
            System.out.println("Error al añadir cliente estándar: " + e.getMessage());
        }      
    }

    public static void añadirClientePremiumDesdeVista(String nombre, String domicilio, String nif, String email, int cuotaAnual) {
        try {
            if (buscarClientePorEmail(email) != null) {
                System.out.println("Ya existe un cliente con este email.");
                return;
            }
            Cliente cliente = new ClientePremium(nombre, domicilio, nif, email, cuotaAnual);
            agregarCliente(cliente);
            System.out.println("Cliente premium añadido correctamente.");

        } catch (Exception e) {
            System.out.println("Error al añadir cliente premium: " + e.getMessage());
        }      
    }

    public static Cliente buscarClientePorEmail(String email) {
        for (Cliente c : Datos.getClientes()) {
            if (c.getEmail().equalsIgnoreCase(email)) {
                return c;
            }
        }
        return null;
    }


    public static void agregarCliente(Cliente cliente) {
        Datos.agregarCliente(cliente);
    }

    public static List<Cliente> obtenerClientes() {
        return new ArrayList<>(Datos.getClientes());
    }

 
    public static void mostrarClientes() {
        try {
            System.out.println("\n--- Lista de Todos los Clientes ---");
            for (Cliente c : obtenerClientes()) {
                System.out.println(c);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar clientes: " + e.getMessage());
        }      
    }

    public static void mostrarClientesEstandar() {
        try {
            System.out.println("\n--- Lista de Clientes Estándar ---");
            for (Cliente c : obtenerClientes()) {
                if (c instanceof ClienteEstandar) {
                    System.out.println(c);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar clientes estándar: " + e.getMessage());
        }     
    }

    public static void mostrarClientesPremium() {
        try {
            System.out.println("\n--- Lista de Clientes Premium ---");
            for (Cliente c : obtenerClientes()) {
                if (c instanceof ClientePremium) {
                    System.out.println(c);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar clientes premium: " + e.getMessage());

        }
    }
}
