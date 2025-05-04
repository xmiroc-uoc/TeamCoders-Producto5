package com.teamcoders.dao;

import java.sql.SQLException;
import java.util.List;

import com.teamcoders.modelo.Cliente;

public interface IClienteDAO {

  void crearCliente(Cliente cliente) throws SQLException;

  Cliente buscarClientePorEmail(String email) throws SQLException;

  List<Cliente> obtenerTodosLosClientes() throws SQLException;

  void actualizarCliente(Cliente cliente) throws SQLException;

  void borrarCliente(String email) throws SQLException;

  List<Cliente> buscarTodosLosClientesPorTipo(String tipo) throws SQLException;
}
