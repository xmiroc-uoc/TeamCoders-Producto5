package com.dao.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.IClienteDAO;
import com.dao.util.ConexionBD;
import com.modelo.Cliente;
import com.modelo.ClienteEstandar;
import com.modelo.ClientePremium;

/**
 * Implementación del DAO para clientes usando JDBC y MySQL.
 */
public class ClienteDAOMySQL implements IClienteDAO {

    /**
     * Inserta un nuevo cliente en la base de datos.
     * 
     * @param cliente Cliente a crear.
     * @throws SQLException si ocurre un error SQL.
     */
    @Override
    public void crearCliente(Cliente cliente) throws SQLException {
        String sqlCrearCliente = "{CALL insertar_cliente(?, ?, ?, ?, ?, ?)}";

        try (Connection conexion = ConexionBD.getConnection()) {
            conexion.setAutoCommit(false); // Inicia la transacción

            try (CallableStatement callPreparada = conexion.prepareCall(sqlCrearCliente)) {
                callPreparada.setString(1, cliente.getEmail());
                callPreparada.setString(2, cliente.getNombre());
                callPreparada.setString(3, cliente.getDomicilio());
                callPreparada.setString(4, cliente.getNif());

                boolean esPremium = (cliente instanceof ClientePremium);
                callPreparada.setString(5, esPremium ? "premium" : "estandar");
                int cuota = 0;
                if (esPremium) {
                    cuota = ((ClientePremium) cliente).getCuotaAnual();
                }
                callPreparada.setInt(6, cuota);

                callPreparada.execute();
            } catch (SQLException e) {
                conexion.rollback(); // Deshacer si algo falla dentro del bloque de CallableStatement
                throw new RuntimeException("Error al crear cliente: " + e.getMessage(), e);
            }

            conexion.commit(); // Confirmar la transacción
        } catch (SQLException e) {
            // Atención: si usamos try-with-resources, no podemos hacer rollback desde
            // aquí directamente
            throw new RuntimeException("Error al crear cliente: " + e.getMessage(), e);
        }
    }

    /**
     * Busca un cliente por su email.
     * 
     * @param email Email del cliente.
     * @return Cliente encontrado o null si no existe.
     * @throws SQLException si ocurre un error SQL.
     */
    @Override
    public Cliente buscarClientePorEmail(String email) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE email = ?";
        try (Connection conexion = ConexionBD.getConnection();
                PreparedStatement sentenciaPreparada = conexion.prepareStatement(sql)) {
            sentenciaPreparada.setString(1, email);
            try (ResultSet conjuntoResultados = sentenciaPreparada.executeQuery()) {
                if (conjuntoResultados.next()) {
                    return construirCliente(conjuntoResultados);
                }
                return null;
            }
        }
    }

    /**
     * Obtiene todos los clientes registrados.
     * 
     * @return Lista de clientes.
     * @throws SQLException si ocurre un error SQL.
     */
    @Override
    public List<Cliente> obtenerTodosLosClientes() throws SQLException {
        List<Cliente> listaClientes = new ArrayList<>();
        String sqlObtenerTodosLosClientes = "SELECT * FROM clientes";
        try (Connection conexion = ConexionBD.getConnection();
                PreparedStatement sentenciaPreparada = conexion.prepareStatement(sqlObtenerTodosLosClientes);
                ResultSet conjuntoResultados = sentenciaPreparada.executeQuery()) {
            while (conjuntoResultados.next()) {
                listaClientes.add(construirCliente(conjuntoResultados));
            }
        }
        return listaClientes;
    }

    /**
     * Actualiza los datos de un cliente.
     * 
     * @param cliente Cliente actualizado.
     * @throws SQLException si ocurre un error SQL.
     */
    @Override
    public void actualizarCliente(Cliente cliente) throws SQLException {
        String sqlActualizarCliente = "UPDATE clientes SET nombre=?, domicilio=?, nif=?, tipo=?, cuota_anual=? WHERE email=?";
        try (Connection conexion = ConexionBD.getConnection();
                PreparedStatement sentenciaPreparada = conexion.prepareStatement(sqlActualizarCliente)) {

            sentenciaPreparada.setString(1, cliente.getNombre());
            sentenciaPreparada.setString(2, cliente.getDomicilio());
            sentenciaPreparada.setString(3, cliente.getNif());

            boolean esPremium = (cliente instanceof ClientePremium);
            sentenciaPreparada.setString(4, esPremium ? "premium" : "estandar");
            int cuota = 0;
            if (esPremium) {
                cuota = ((ClientePremium) cliente).getCuotaAnual();
            }
            sentenciaPreparada.setInt(5, cuota);

            sentenciaPreparada.setString(6, cliente.getEmail());

            sentenciaPreparada.executeUpdate();
        }
    }

    /**
     * Elimina un cliente por su email.
     * 
     * @param email Email del cliente.
     * @throws SQLException si ocurre un error SQL.
     */
    @Override
    public void borrarCliente(String email) throws SQLException {
        String sqlBorrarCliente = "DELETE FROM clientes WHERE email=?";
        try (Connection conexion = ConexionBD.getConnection();
                PreparedStatement sentenciaPreparada = conexion.prepareStatement(sqlBorrarCliente)) {
            sentenciaPreparada.setString(1, email);
            sentenciaPreparada.executeUpdate();
        }
    }

    /**
     * Filtra clientes por su tipo (estándar o premium).
     * 
     * @param tipo Tipo de cliente (estandar o premium).
     * @return Lista de clientes filtrados.
     * @throws SQLException si ocurre un error SQL.
     */
    @Override
    public List<Cliente> buscarTodosLosClientesPorTipo(String tipo) throws SQLException {
        List<Cliente> listaClientes = new ArrayList<>();
        String sqlBuscarTodosLosClientePorTipo = "SELECT * FROM clientes WHERE tipo = ?";
        try (Connection conexion = ConexionBD.getConnection();
                PreparedStatement sentenciaPreparada = conexion.prepareStatement(sqlBuscarTodosLosClientePorTipo)) {

            sentenciaPreparada.setString(1, tipo);
            try (ResultSet conjuntoResultados = sentenciaPreparada.executeQuery()) {
                while (conjuntoResultados.next()) {
                    listaClientes.add(construirCliente(conjuntoResultados));
                }
            }
        }
        return listaClientes;
    }

    /**
     * Construye un objeto Cliente a partir de un ResultSet.
     * 
     * @param conjuntoResultados ResultSet con datos del cliente.
     * @return Cliente construido.
     * @throws SQLException si ocurre un error SQL.
     */
    private Cliente construirCliente(ResultSet conjuntoResultados) throws SQLException {
        String tipo = conjuntoResultados.getString("tipo"); // "E" o "P"
        if ("premium".equalsIgnoreCase(tipo)) {
            return new ClientePremium(
                    conjuntoResultados.getString("nombre"),
                    conjuntoResultados.getString("domicilio"),
                    conjuntoResultados.getString("nif"),
                    conjuntoResultados.getString("email"),
                    conjuntoResultados.getInt("cuota_anual"));
        } else {
            return new ClienteEstandar(
                    conjuntoResultados.getString("nombre"),
                    conjuntoResultados.getString("domicilio"),
                    conjuntoResultados.getString("nif"),
                    conjuntoResultados.getString("email"));
        }
    }
}
