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
     * Añade un cliente estándar desde la vista si no existe otro con el mismo email.
     * @param nombre Nombre del cliente.
     * @param domicilio Dirección del cliente.
     * @param nif Número de identificación fiscal.
     * @param email Correo electrónico único del cliente.
     * @return true si el cliente se añadió correctamente, false si ya existía.
     */
    public static boolean añadirClienteEstandarDesdeVista(String nombre, String domicilio, String nif, String email) {
        // Verifica que no exista ya un cliente con ese email.
        if (buscarClientePorEmail(email) != null) {
            return false;
        }
        Cliente cliente = new ClienteEstandar(nombre, domicilio, nif, email);
        agregarCliente(cliente);
        return true;
    }

    /**
     * Añade un cliente premium desde la vista si no existe otro con el mismo email.
     * @param nombre Nombre del cliente.
     * @param domicilio Dirección del cliente.
     * @param nif Número de identificación fiscal.
     * @param email Correo electrónico único del cliente.
     * @param cuotaAnual Cuota anual pagada por el cliente premium.
     * @return true si el cliente se añadió correctamente, false si ya existía.
     */
    public static boolean añadirClientePremiumDesdeVista(String nombre, String domicilio, String nif, String email, int cuotaAnual) {
        // Verifica que no exista ya un cliente con ese email.
        if (buscarClientePorEmail(email) != null) {
            return false;
        }
        Cliente cliente = new ClientePremium(nombre, domicilio, nif, email, cuotaAnual);
        agregarCliente(cliente);
        return true;  
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
     * Agrega un cliente al almacén de datos.
     * @param cliente Cliente a agregar.
     */
    public static void agregarCliente(Cliente cliente) {
        Datos.agregarCliente(cliente);
    }

    /**
     * Obtiene la lista completa de clientes.
     * @return Lista de todos los clientes registrados.
     */
    public static List<Cliente> obtenerClientes() {
        return new ArrayList<>(Datos.getClientes());
    }
    
    /**
     * Obtiene la lista de clientes estándar.
     * @return Lista de clientes tipo estándar.
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
     * Obtiene la lista de clientes premium.
     * @return Lista de clientes tipo premium.
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
