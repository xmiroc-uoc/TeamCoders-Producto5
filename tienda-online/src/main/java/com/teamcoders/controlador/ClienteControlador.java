package com.teamcoders.controlador;

import java.sql.SQLException;
import java.util.List;

import com.teamcoders.dao.interfaces.IClienteDAO;
import com.teamcoders.factory.DAOFactory;
import com.teamcoders.modelo.Cliente;
import com.teamcoders.modelo.ClienteEstandar;
import com.teamcoders.modelo.ClientePremium;

/**
 * Clase controladora que gestiona operaciones relacionadas con los clientes.
 * Forma parte del patrón MVC y actúa como intermediaria entre la vista y el
 * modelo.
 *
 */
public class ClienteControlador {

  // Obtenemos la fábrica específica de DAOs para MySQL
  private static final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.JPA);
  private static final IClienteDAO clienteDAO = factory.getClienteDAO();

  /**
   * Añade un cliente estándar a la base de datos.
   *
   * @param nombre    Nombre del cliente.
   * @param domicilio Dirección del cliente.
   * @param nif       Número de identificación fiscal.
   * @param email     Correo electrónico (identificador único).
   * @throws RuntimeException Si ocurre un error al insertar en base de datos.
   */
  public static void añadirClienteEstandarDesdeVista(String nombre, String domicilio, String nif, String email) {
    try {
      // Se crea el objeto ClienteEstandar con los datos recibidos desde la vista
      Cliente cliente = new ClienteEstandar(nombre, domicilio, nif, email);

      // Se delega la persistencia en el DAO
      clienteDAO.crearCliente(cliente);
    } catch (SQLException e) {
      // Se encapsula la excepción en una Runtime para no obligar a manejar
      // SQLException
      throw new RuntimeException("Error al crear cliente estándar: " + e.getMessage(), e);
    }
  }

  /**
   * Añade un cliente premium a la base de datos.
   *
   * @param nombre     Nombre del cliente.
   * @param domicilio  Dirección del cliente.
   * @param nif        Número de identificación fiscal.
   * @param email      Correo electrónico del cliente.
   * @param cuotaAnual Cuota anual que paga el cliente premium.
   * @throws RuntimeException Si ocurre un error al insertar en base de datos.
   */
  public static void añadirClientePremiumDesdeVista(String nombre, String domicilio, String nif, String email,
      int cuotaAnual) {
    try {
      // Se crea el objeto ClientePremium con la cuota correspondiente
      Cliente cliente = new ClientePremium(nombre, domicilio, nif, email, cuotaAnual);

      // Se registra en base de datos mediante el DAO
      clienteDAO.crearCliente(cliente);
    } catch (SQLException e) {
      // Se encapsula la excepción en una Runtime para no obligar a manejar
      // SQLException
      throw new RuntimeException("Error al crear cliente premium: " + e.getMessage(), e);
    }
  }

  /**
   * Busca un cliente utilizando su email como clave primaria.
   *
   * @param email Correo electrónico del cliente.
   * @return Cliente correspondiente o null si no existe.
   * @throws RuntimeException Si ocurre un error al consultar.
   */
  public static Cliente buscarClientePorEmail(String email) {
    try {
      // Se delega la búsqueda en el DAO correspondiente
      return clienteDAO.buscarClientePorEmail(email);
    } catch (SQLException e) {
      throw new RuntimeException("Error buscando cliente por email: " + e.getMessage(), e);
    }
  }

  /**
   * Recupera todos los clientes registrados.
   *
   * @return Lista de todos los clientes.
   * @throws RuntimeException Si ocurre un error al obtener los datos.
   */
  public static List<Cliente> obtenerClientes() {
    try {
      // Se obtiene la lista completa desde el DAO
      return clienteDAO.obtenerTodosLosClientes();
    } catch (SQLException e) {
      throw new RuntimeException("Error al obtener lista de clientes: " + e.getMessage(), e);
    }
  }

  public static boolean eliminarClientePorEmail(String email) {
    try {
      clienteDAO.borrarCliente(email); // ← método del DAO es void
      return true; // llegó aquí ⇒ se eliminó
    } catch (Exception e) {
      throw new RuntimeException("Error borrando cliente", e);
    }
  }

  /**
   * Recupera únicamente los clientes de tipo estándar.
   *
   * @return Lista de clientes estándar.
   * @throws RuntimeException Si ocurre un error al obtener los datos.
   */
  public static List<Cliente> obtenerClientesEstandar() {
    try {
      // Se filtra por tipo 'estandar' en la consulta SQL del DAO
      return clienteDAO.buscarTodosLosClientesPorTipo("estandar");
    } catch (SQLException e) {
      throw new RuntimeException("Error al obtener clientes estándar: " + e.getMessage(), e);
    }
  }

  /**
   * Recupera únicamente los clientes de tipo premium.
   *
   * @return Lista de clientes premium.
   * @throws RuntimeException Si ocurre un error al obtener los datos.
   */
  public static List<Cliente> obtenerClientesPremium() {
    try {
      // Se filtra por tipo 'premium' en la consulta SQL del DAO
      return clienteDAO.buscarTodosLosClientesPorTipo("premium");
    } catch (SQLException e) {
      throw new RuntimeException("Error al obtener clientes premium: " + e.getMessage(), e);
    }
  }

}
