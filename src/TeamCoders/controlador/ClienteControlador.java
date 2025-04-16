package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.Factory.DAOFactory;
import DAO.Interface.ClienteDAO;
import modelo.Cliente;
import modelo.ClienteEstandar;
import modelo.ClientePremium;

/**
 * Clase controladora responsable de gestionar operaciones relacionadas con los clientes,
 * incluyendo añadir clientes estándar o premium, buscar clientes y listar clientes según su tipo.
 * Forma parte del patrón MVC y actúa como intermediaria entre la vista y el modelo.
 */
public class ClienteControlador {

    private static DAOFactory factory = new DAOFactory();
    private static ClienteDAO clienteDAO = factory.getCliente();
    

    public static void añadirClienteEstandarDesdeVista(String nombre, String domicilio, String nif, String email) {
        Cliente cliente = new ClienteEstandar(nombre, domicilio, nif, email);
        
        try{
            clienteDAO.insert(cliente);
        }catch (SQLException e){
            throw new RuntimeException("Error al crear cliente estándar: " + e.getMessage(), e);
        }
        
    }

    public static void añadirClientePremiumDesdeVista(String nombre, String domicilio, String nif, String email, int cuotaAnual) {
        Cliente cliente = new ClientePremium(nombre, domicilio, nif, email, cuotaAnual);
        
        try{
            clienteDAO.insert(cliente);
        }catch (SQLException e){
            throw new RuntimeException("Error al crear cliente premium: " + e.getMessage(), e);
        }
    }


    public static Cliente buscarClientePorEmail(String email) {
        try {
            return clienteDAO.getByEmail(email);
        } catch (SQLException e) {
            throw new RuntimeException("Error buscando cliente por email: " + e.getMessage(), e);
        }
    }

    public static List<Cliente> obtenerClientes() {
        try {
            return clienteDAO.getAll();
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener lista de clientes: " + e.getMessage(), e);
        }
    }
    
    public static List<Cliente> obtenerClientesEstandar() {
        List<Cliente> estandar = new ArrayList<>();
        for (Cliente c : obtenerClientes()) {
            if (c instanceof ClienteEstandar) {
                estandar.add(c);
            }
        }
        return estandar;
    }

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
