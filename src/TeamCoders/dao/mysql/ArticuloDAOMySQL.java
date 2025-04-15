package dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IArticuloDAO;
import dao.util.ConexionBD;
import modelo.Articulo;

/**
 * Implementación del DAO para artículos usando JDBC y MySQL.
 */
public class ArticuloDAOMySQL implements IArticuloDAO {

    /**
     * Inserta un nuevo artículo en la base de datos.
     *
     * @param articulo El artículo a registrar.
     * @throws SQLException Si ocurre un error SQL.
     */
    @Override
    public void crearArticulo(Articulo articulo) throws SQLException {
        String sqlInsertarCliente = "INSERT INTO articulos (codigo, descripcion, precio_venta, gastos_envio, tiempo_preparacion) VALUES (?, ?, ?, ?, ?)";
        Connection conexion = null;
        PreparedStatement sentenciaPreparada = null;

        try {
            conexion = ConexionBD.getConnection();
            sentenciaPreparada = conexion.prepareStatement(sqlInsertarCliente);

            sentenciaPreparada.setString(1, articulo.getCodigo());
            sentenciaPreparada.setString(2, articulo.getDescripcion());
            sentenciaPreparada.setDouble(3, articulo.getPrecioVenta());
            sentenciaPreparada.setDouble(4, articulo.getGastosEnvio());
            sentenciaPreparada.setInt(5, articulo.getTiempoPreparacion());

            sentenciaPreparada.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (sentenciaPreparada != null) {
                try {
                    sentenciaPreparada.close();
                } catch (SQLException ex2) {
                    throw ex2;
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex2) {
                    throw ex2;
                }
            }
        }
    }

    /**
     * Busca un artículo por su código.
     *
     * @param codigo Código único del artículo.
     * @return Artículo encontrado o null si no existe.
     * @throws SQLException Si ocurre un error SQL.
     */
    @Override
    public Articulo buscarArticuloPorCodigo(String codigo) throws SQLException {
        String sqlBuscarArticuloPorCodigo = "SELECT * FROM articulos WHERE codigo = ?";

        Connection conexion = null;
        PreparedStatement sentenciaPreparada = null;
        ResultSet conjuntoResultados = null;

        try {
            conexion = ConexionBD.getConnection();
            sentenciaPreparada = conexion.prepareStatement(sqlBuscarArticuloPorCodigo);
            sentenciaPreparada.setString(1, codigo);
            conjuntoResultados = sentenciaPreparada.executeQuery();

            if (conjuntoResultados.next()) {
                return construirArticulo(conjuntoResultados);
            }
            return null;
        } catch (SQLException ex) {
            throw ex;
        } finally {
            if (conjuntoResultados != null) {
                try {
                    conjuntoResultados.close();
                } catch (SQLException ex2) {
                    throw ex2;
                }
            }
            if (sentenciaPreparada != null) {
                try {
                    sentenciaPreparada.close();
                } catch (SQLException ex2) {
                    throw ex2;
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex2) {
                    throw ex2;
                }
            }
        }
    }

    /**
     * Obtiene todos los artículos de la base de datos.
     *
     * @return Lista de artículos.
     * @throws SQLException Si ocurre un error SQL.
     */
    @Override
    public List<Articulo> obtenerTodosLosArticulos() throws SQLException {
        String sqlObtenerTodosLosArticulos = "SELECT * FROM articulos";

        Connection conexion = null;
        PreparedStatement sentenciaPreparada = null;
        ResultSet conjuntoResultados = null;
        List<Articulo> listaArticulos = new ArrayList<>();

        try {
            conexion = ConexionBD.getConnection();
            sentenciaPreparada = conexion.prepareStatement(sqlObtenerTodosLosArticulos);
            conjuntoResultados = sentenciaPreparada.executeQuery();

            while (conjuntoResultados.next()) {
                listaArticulos.add(construirArticulo(conjuntoResultados));
            }
            return listaArticulos;
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
     * Actualiza un artículo existente.
     *
     * @param articulo Artículo con los datos actualizados.
     * @throws SQLException Si ocurre un error SQL.
     */
    @Override
    public void actualizarArticulo(Articulo articulo) throws SQLException {
        String sqlActualizarCliente = "UPDATE articulos SET descripcion=?, precio_venta=?, gastos_envio=?, tiempo_preparacion=? WHERE codigo=?";

        Connection conexion = null;
        PreparedStatement sentenciaPreparada = null;

        try {
            conexion = ConexionBD.getConnection();
            sentenciaPreparada = conexion.prepareStatement(sqlActualizarCliente);

            sentenciaPreparada.setString(1, articulo.getDescripcion());
            sentenciaPreparada.setDouble(2, articulo.getPrecioVenta());
            sentenciaPreparada.setDouble(3, articulo.getGastosEnvio());
            sentenciaPreparada.setInt(4, articulo.getTiempoPreparacion());
            sentenciaPreparada.setString(5, articulo.getCodigo());

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
     * Elimina un artículo por su código.
     *
     * @param codigo Código del artículo a eliminar.
     * @throws SQLException Si ocurre un error SQL.
     */
    @Override
    public void borrarArticulo(String codigo) throws SQLException {
        String sqlBorrarArticulo = "DELETE FROM articulos WHERE codigo=?";

        Connection conexion = null;
        PreparedStatement sentenciaPreparada = null;

        try {
            conexion = ConexionBD.getConnection();
            sentenciaPreparada = conexion.prepareStatement(sqlBorrarArticulo);
            sentenciaPreparada.setString(1, codigo);
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
     * Método privado para reconstruir un objeto Articulo
     * a partir de la fila en el ResultSet.
     */
    private Articulo construirArticulo(ResultSet conjuntoResultados) throws SQLException {
        return new Articulo(
                conjuntoResultados.getString("codigo"),
                conjuntoResultados.getInt("tiempo_preparacion"),
                conjuntoResultados.getDouble("gastos_envio"),
                conjuntoResultados.getDouble("precio_venta"),
                conjuntoResultados.getString("descripcion"));
    }
}
