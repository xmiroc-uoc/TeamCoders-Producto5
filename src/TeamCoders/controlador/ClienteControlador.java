package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.ClienteEstandar;
import modelo.ClientePremium;
import modelo.Datos;

public class ClienteControlador {
    
    public static void añadirClienteEstandarDesdeVista(String nombre, String domicilio, String nif, String email) {
        if (buscarClientePorEmail(email) != null) {
            System.out.println("Ya existe un cliente con este email.");
            return;
        }
        Cliente cliente = new ClienteEstandar(nombre, domicilio, nif, email);
        agregarCliente(cliente);
        System.out.println("Cliente estándar añadido correctamente.");
    }

    public static void añadirClientePremiumDesdeVista(String nombre, String domicilio, String nif, String email, int cuotaAnual) {
        if (buscarClientePorEmail(email) != null) {
            System.out.println("Ya existe un cliente con este email.");
            return;
        }
        Cliente cliente = new ClientePremium(nombre, domicilio, nif, email, cuotaAnual);
        agregarCliente(cliente);
    }

    public static void agregarCliente(Cliente cliente) {
        Datos.agregarCliente(cliente);
    }

    public static List<Cliente> obtenerClientes() {
        return new ArrayList<>(Datos.getClientes());
    }

    public static Cliente buscarClientePorEmail(String email) {
        for (Cliente c : Datos.getClientes()) {
            if (c.getEmail().equalsIgnoreCase(email)) {
                return c;
            }
        }
        return null;
    }

    public static void mostrarClientes() {
        System.out.println("\n--- Lista de Todos los Clientes ---");
        for (Cliente c : obtenerClientes()) {
            System.out.println(c);
        }
    }

    public static void mostrarClientesEstandar() {
        System.out.println("\n--- Lista de Clientes Estándar ---");
        for (Cliente c : obtenerClientes()) {
            if (c instanceof ClienteEstandar) {
                System.out.println(c);
            }
        }
    }

    public static void mostrarClientesPremium() {
        System.out.println("\n--- Lista de Clientes Premium ---");
        for (Cliente c : obtenerClientes()) {
            if (c instanceof ClientePremium) {
                System.out.println(c);
            }
        }
    }
}
