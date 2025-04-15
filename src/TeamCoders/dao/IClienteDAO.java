package dao;

import java.sql.SQLException;
import java.util.List;

import modelo.Cliente;

/**
 * Interfaz DAO para operaciones sobre la entidad Cliente.
 */
public interface IClienteDAO {

    /**
     * Crea un nuevo cliente en la base de datos.
     * 
     * @param cliente Objeto Cliente a insertar.
     * @throws SQLException si ocurre un error SQL.
     */
    void crearCliente(Cliente cliente) throws SQLException;

    /**
     * Busca un cliente por su email.
     * 
     * @param email Email del cliente.
     * @return Cliente encontrado o null si no existe.
     * @throws SQLException si ocurre un error SQL.
     */
    Cliente buscarClientePorEmail(String email) throws SQLException;

    /**
     * Obtiene la lista de todos los clientes.
     * 
     * @return Lista de clientes.
     * @throws SQLException si ocurre un error SQL.
     */
    List<Cliente> obtenerTodosLosClientes() throws SQLException;

    /**
     * Actualiza los datos de un cliente.
     * 
     * @param cliente Cliente actualizado.
     * @throws SQLException si ocurre un error SQL.
     */
    void actualizarCliente(Cliente cliente) throws SQLException;

    /**
     * Elimina un cliente por su email.
     * 
     * @param email Email del cliente a borrar.
     * @throws SQLException si ocurre un error SQL.
     */
    void borrarCliente(String email) throws SQLException;

    /**
     * Busca todos los clientes según el tipo (estandar o premium).
     * 
     * @param tipo Tipo de cliente.
     * @return Lista de clientes filtrados por tipo.
     * @throws SQLException si ocurre un error SQL.
     */
    List<Cliente> buscarTodosLosClientesPorTipo(String tipo) throws SQLException;
}
