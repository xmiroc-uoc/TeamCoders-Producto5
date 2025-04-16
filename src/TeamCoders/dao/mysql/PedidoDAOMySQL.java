package dao.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.DAOFactory;
import dao.IClienteDAO;
import dao.IPedidoDAO;
import dao.util.ConexionBD;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Pedido;

/**
 * Implementación del DAO para pedidos usando JDBC y MySQL.
 */
public class PedidoDAOMySQL implements IPedidoDAO {

    /**
     * Inserta un nuevo pedido en la base de datos.
     *
     * @param pedido El pedido a insertar.
     * @throws SQLException Si ocurre un error SQL.
     */
    @Override
    public void crearPedido(Pedido pedido) throws SQLException {
        String sqlInsertarPedido = "{CALL insertar_pedido(?, ?, ?, ?)}";

        Connection conexion = null;
        CallableStatement callPreparada = null;

        try {
            // Obtiene la conexión
            conexion = ConexionBD.getConnection();

            // Desactivar autocommit (inicia la transacción manualmente)
            conexion.setAutoCommit(false);

            // Prepara la sentencia con la llamada SQL
            callPreparada = conexion.prepareCall(sqlInsertarPedido);

            // Asigna los parametros al procedimineto
            callPreparada.setInt(1, pedido.getUnidades());

            // Convierte LocalDateTime a Timestamp
            Timestamp timestampFecha = Timestamp.valueOf(pedido.getFechaPedido());
            callPreparada.setTimestamp(2, timestampFecha);

            // Se almacenan las claves foráneas: email del cliente y código del artículo
            // Suponemos que la tabla "pedido" guarda estos valores para relacionarse con
            // las tablas correspondientes
            callPreparada.setString(3, pedido.getCliente().getEmail());
            // Se asume que Articulo tiene el método getCodigo() para identificarlo
            callPreparada.setString(4, pedido.getArticulo().getCodigo());

            // Ejecuta la llamada
            callPreparada.execute();

            // Confirmar la transacción (todo ha ido bien)
            conexion.commit();

        } catch (SQLException ex) {
            try {
                // Si hay error, deshacer los cambios
                if (conexion != null)
                    conexion.rollback();
            } catch (SQLException rollbackEx) {
                System.err.println("Error al hacer rollback: " + rollbackEx.getMessage());
            }
            throw new RuntimeException("Error al crear pedido: " + ex.getMessage(), ex);
        } finally {
            if (callPreparada != null) {
                try {
                    callPreparada.close();
                } catch (SQLException ex2) {
                    throw ex2;
                }
            }
            if (conexion != null) {
                try {
                    // Reestablecer autocommit
                    conexion.setAutoCommit(true);
                    conexion.close();
                } catch (SQLException ex2) {
                    throw ex2;
                }
            }
        }
    }

    /**
     * Busca un pedido por su número.
     *
     * @param numero Número del pedido.
     * @return Pedido encontrado o null si no existe.
     * @throws SQLException Si ocurre un error SQL.
     */
    @Override
    public Pedido buscarPedidoPorNumero(int numero) throws SQLException {
        String sqlBuscarPedidoPorNumero = "SELECT * FROM pedidos WHERE numero = ?";

        Connection conexion = null;
        PreparedStatement sentenciaPreparada = null;
        ResultSet conjuntoResultados = null;

        try {
            conexion = ConexionBD.getConnection();
            sentenciaPreparada = conexion.prepareStatement(sqlBuscarPedidoPorNumero);
            sentenciaPreparada.setInt(1, numero);
            conjuntoResultados = sentenciaPreparada.executeQuery();

            if (conjuntoResultados.next()) {
                return construirPedido(conjuntoResultados);
            }
            return null;

        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (conjuntoResultados != null) {
                try {
                    conjuntoResultados.close();
                } catch (SQLException ex2) {
                }
            }
            if (sentenciaPreparada != null) {
                try {
                    sentenciaPreparada.close();
                } catch (SQLException ex2) {
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex2) {
                }
            }
        }
    }

    /**
     * Obtiene todos los pedidos registrados.
     *
     * @return Lista de pedidos.
     * @throws SQLException Si ocurre un error SQL.
     */
    @Override
    public List<Pedido> obtenerTodosLosPedidos() throws SQLException {
        String sqlBuscarTodosLosPedidos = "SELECT * FROM pedidos";

        Connection conexion = null;
        PreparedStatement sentenciaPreparada = null;
        ResultSet conjuntoResultados = null;
        List<Pedido> listaPedidos = new ArrayList<>();

        try {
            conexion = ConexionBD.getConnection();
            sentenciaPreparada = conexion.prepareStatement(sqlBuscarTodosLosPedidos);
            conjuntoResultados = sentenciaPreparada.executeQuery();

            while (conjuntoResultados.next()) {
                listaPedidos.add(construirPedido(conjuntoResultados));
            }
            return listaPedidos;

        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (conjuntoResultados != null) {
                try {
                    conjuntoResultados.close();
                } catch (SQLException ex2) {
                }
            }
            if (sentenciaPreparada != null) {
                try {
                    sentenciaPreparada.close();
                } catch (SQLException ex2) {
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex2) {
                }
            }
        }
    }

    /**
     * Actualiza los datos de un pedido.
     *
     * @param pedido Pedido actualizado.
     * @throws SQLException Si ocurre un error SQL.
     */
    @Override
    public void actualizarPedido(Pedido pedido) throws SQLException {
        String sqlActualizarPedido = "UPDATE pedidos SET unidades=?, fecha_pedido=?, cliente_email=?, articulo_codigo=? WHERE numero=?";

        Connection conexion = null;
        PreparedStatement sentenciaPreparada = null;

        try {
            conexion = ConexionBD.getConnection();
            sentenciaPreparada = conexion.prepareStatement(sqlActualizarPedido);

            sentenciaPreparada.setInt(1, pedido.getUnidades());
            Timestamp timestampFecha = Timestamp.valueOf(pedido.getFechaPedido());
            sentenciaPreparada.setTimestamp(2, timestampFecha);
            sentenciaPreparada.setString(3, pedido.getCliente().getEmail());
            sentenciaPreparada.setString(4, pedido.getArticulo().getCodigo());
            sentenciaPreparada.setInt(5, pedido.getNumeroPedido());

            sentenciaPreparada.executeUpdate();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (sentenciaPreparada != null) {
                try {
                    sentenciaPreparada.close();
                } catch (SQLException ex2) {
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex2) {
                }
            }
        }
    }

    /**
     * Elimina un pedido por su número.
     *
     * @param numero Número del pedido.
     * @throws SQLException Si ocurre un error SQL.
     */
    @Override
    public void borrarPedido(int numero) throws SQLException {
        String sqlBorrarPedido = "DELETE FORM pedidos WHERE numero=?";

        Connection conexion = null;
        PreparedStatement sentenciaPreparada = null;

        try {
            conexion = ConexionBD.getConnection();
            sentenciaPreparada = conexion.prepareStatement(sqlBorrarPedido);

            sentenciaPreparada.setInt(1, numero);
            sentenciaPreparada.executeQuery();

        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (sentenciaPreparada != null) {
                try {
                    sentenciaPreparada.close();
                } catch (SQLException ex2) {
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex2) {
                }
            }
        }

    }

    /**
     * Filtra pedidos pendientes de envío (cancelables).
     *
     * @return Lista de pedidos pendientes.
     * @throws SQLException Si ocurre un error SQL.
     */
    @Override
    public List<Pedido> buscarPedidosPendientesEnvio() throws SQLException {
        List<Pedido> todosLosPedidos = obtenerTodosLosPedidos();
        List<Pedido> pedidosPendientes = new ArrayList<>();
        for (Pedido pedido : todosLosPedidos) {
            if (pedido.cancelable()) {
                pedidosPendientes.add(pedido);
            }
        }
        return pedidosPendientes;
    }

    /**
     * Filtra pedidos ya enviados (no cancelables).
     *
     * @return Lista de pedidos enviados.
     * @throws SQLException Si ocurre un error SQL.
     */
    @Override
    public List<Pedido> buscarPedidosEnviados() throws SQLException {
        List<Pedido> todosLosPedidos = obtenerTodosLosPedidos();
        List<Pedido> pedidosEnviados = new ArrayList<>();
        for (Pedido pedido : todosLosPedidos) {
            if (!pedido.cancelable()) {
                pedidosEnviados.add(pedido);
            }
        }
        return pedidosEnviados;
    }

    /**
     * Construye un objeto Pedido a partir del ResultSet.
     *
     * @param conjuntoResultados ResultSet con los datos de un pedido.
     * @return Objeto Pedido.
     * @throws SQLException Si ocurre un error al acceder a los datos.
     */
    private Pedido construirPedido(ResultSet conjuntoResultados) throws SQLException {

        // Se extraen los valores básicos de la tabla pedido
        int numeroPedido = conjuntoResultados.getInt("numero");
        int unidades = conjuntoResultados.getInt("unidades");

        // Se obtiene la fecha como Timestamp y se convierte a LocalDateTime
        Timestamp timestampFecha = conjuntoResultados.getTimestamp("fecha_pedido");
        LocalDateTime fechaPedido = timestampFecha.toLocalDateTime();

        // Se obtienen las claves foráneas
        String emailDelCliente = conjuntoResultados.getString("cliente_email");
        String codigoDelArticulo = conjuntoResultados.getString("articulo_codigo");

        // Se obtienen los objetos Cliente y Articulo utilizando sus DAOs
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        IClienteDAO clienteDAO = factory.getClienteDAO();
        // Se asume que existe un DAO para Artículo similar al de Cliente
        dao.IArticuloDAO articuloDAO = factory.getArticuloDAO();

        Cliente cliente = clienteDAO.buscarClientePorEmail(emailDelCliente);
        Articulo articulo = articuloDAO.buscarArticuloPorCodigo(codigoDelArticulo);

        // Se construye el objeto Pedido utilizando el constructor adecuado
        return new Pedido(numeroPedido, unidades, fechaPedido, cliente, articulo);
    }
}
