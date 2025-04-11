package controlador;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.ClienteEstandar;
import modelo.ClientePremium;
import modelo.Datos;

/**
 * Clase controladora responsable de gestionar operaciones relacionadas con los clientes,
 * incluyendo añadir clientes estándar o premium, buscar clientes y listar clientes según su tipo.
 * Forma parte del patrón MVC y actúa como intermediaria entre la vista y el modelo.
 */
public class ClienteControlador {
    
    /**
     * Añade un cliente estándar si no existe uno con el mismo email.
     * La validación de duplicado se realiza en Datos.agregarCliente.
     * @param nombre Nombre del cliente.
     * @param domicilio Dirección del cliente.
     * @param nif Número de identificación fiscal.
     * @param email Correo electrónico del cliente.
     * @throws IllegalArgumentException si ya existe un cliente con ese email.
     */
    public static void añadirClienteEstandarDesdeVista(String nombre, String domicilio, String nif, String email) {
        Cliente cliente = new ClienteEstandar(nombre, domicilio, nif, email);
        agregarCliente(cliente);
    }

    /**
     * Añade un cliente premium si no existe uno con el mismo email.
     * La validación de duplicado se realiza en Datos.agregarCliente.
     * @param nombre Nombre del cliente.
     * @param domicilio Dirección del cliente.
     * @param nif Número de identificación fiscal.
     * @param email Correo electrónico del cliente.
     * @param cuotaAnual Cuota anual en euros.
     * @throws IllegalArgumentException si ya existe un cliente con ese email.
     */
    public static void añadirClientePremiumDesdeVista(String nombre, String domicilio, String nif, String email, int cuotaAnual) {
        Cliente cliente = new ClientePremium(nombre, domicilio, nif, email, cuotaAnual);
        agregarCliente(cliente);
    }

    /**
     * Busca un cliente por su email.
     * @param email Correo electrónico del cliente.
     * @return Cliente encontrado o null si no existe.
     */
    public static Cliente buscarClientePorEmail(String email) {
        for (Cliente c : Datos.getClientes()) {
            if (c.getEmail().equalsIgnoreCase(email)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Agrega un cliente a la lista de clientes.
     * Este método delega la validación de duplicados a la clase Datos.
     * @param cliente Cliente a agregar.
     * @throws IllegalArgumentException si ya existe un cliente con ese email.
     */
    public static void agregarCliente(Cliente cliente) {
        Datos.agregarCliente(cliente);
    }

    /**
     * Devuelve la lista actual de clientes.
     * @return Lista de todos los clientes.
     */
    public static List<Cliente> obtenerClientes() {
        return new ArrayList<>(Datos.getClientes());
    }
    
    /**
     * Devuelve la lista de clientes registrados de tipo estándar.
     * @return Lista de clientes estándar.
     */
    public static List<Cliente> obtenerClientesEstandar() {
        List<Cliente> estandar = new ArrayList<>();
        for (Cliente c : obtenerClientes()) {
            if (c instanceof ClienteEstandar) {
                estandar.add(c);
            }
        }
        return estandar;
    }

    /**
     * Devuelve la lista de clientes registrados de tipo premium.
     * @return Lista de clientes premium.
     */
    public static List<Cliente> obtenerClientesPremium() {
        List<Cliente> premium = new ArrayList<>();
        for (Cliente c : obtenerClientes()) {
            if (c instanceof ClientePremium) {
                premium.add(c);
            }
        }
        return premium;
    }
}
