package com.teamcoders.controlador;

import java.sql.SQLException;
import java.util.List;

import com.teamcoders.dao.DAOFactory;
import com.teamcoders.dao.IClienteDAO;
import com.teamcoders.modelo.Cliente;
import com.teamcoders.modelo.ClienteEstandar;
import com.teamcoders.modelo.ClientePremium;

public class ClienteControlador {

  private static final DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
  private static final IClienteDAO clienteDAO = factory.getClienteDAO();

  public static void añadirClienteEstandarDesdeVista(String nombre, String domicilio, String nif, String email) {
    try {
      Cliente cliente = new ClienteEstandar(nombre, domicilio, nif, email);

      clienteDAO.crearCliente(cliente);
    } catch (SQLException e) {

      throw new RuntimeException("Error al crear cliente estándar: " + e.getMessage(), e);
    }
  }

  public static void añadirClientePremiumDesdeVista(String nombre, String domicilio, String nif, String email,
      int cuotaAnual) {
    try {
      Cliente cliente = new ClientePremium(nombre, domicilio, nif, email, cuotaAnual);

      clienteDAO.crearCliente(cliente);
    } catch (SQLException e) {

      throw new RuntimeException("Error al crear cliente premium: " + e.getMessage(), e);
    }
  }

  public static Cliente buscarClientePorEmail(String email) {
    try {
      return clienteDAO.buscarClientePorEmail(email);
    } catch (SQLException e) {
      throw new RuntimeException("Error buscando cliente por email: " + e.getMessage(), e);
    }
  }

  public static List<Cliente> obtenerClientes() {
    try {
      return clienteDAO.obtenerTodosLosClientes();
    } catch (SQLException e) {
      throw new RuntimeException("Error al obtener lista de clientes: " + e.getMessage(), e);
    }
  }

  public static List<Cliente> obtenerClientesEstandar() {
    try {
      return clienteDAO.buscarTodosLosClientesPorTipo("estandar");
    } catch (SQLException e) {
      throw new RuntimeException("Error al obtener clientes estándar: " + e.getMessage(), e);
    }
  }

  public static List<Cliente> obtenerClientesPremium() {
    try {
      return clienteDAO.buscarTodosLosClientesPorTipo("premium");
    } catch (SQLException e) {
      throw new RuntimeException("Error al obtener clientes premium: " + e.getMessage(), e);
    }
  }
}
