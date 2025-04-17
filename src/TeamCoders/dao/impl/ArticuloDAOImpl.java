package TeamCoders.dao.impl;

import TeamCoders.dao.ArticuloDAO;
import TeamCoders.modelo.Articulo;
import TeamCoders.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticuloDAOImpl implements ArticuloDAO {

  @Override
  public void agregar(Articulo a) {
    final String sql = "INSERT INTO articulo (codigo,descripcion,precio_venta,gastos_envio,tiempo_preparacion) " +
        "VALUES (?,?,?,?,?)";
    try (Connection c = DBConnection.getConnection();
        PreparedStatement ps = c.prepareStatement(sql)) {

      ps.setString(1, a.getCodigo());
      ps.setString(2, a.getDescripcion());
      ps.setFloat(3, a.getPrecioVenta());
      ps.setFloat(4, a.getGastosEnvio());
      ps.setInt(5, a.getTiempoPreparacion());
      ps.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Articulo> listar() {
    List<Articulo> lista = new ArrayList<>();
    try (Connection c = DBConnection.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM articulo")) {

      while (rs.next()) {
        lista.add(new Articulo(
            rs.getString("codigo"),
            rs.getInt("tiempo_preparacion"),
            rs.getFloat("gastos_envio"),
            rs.getFloat("precio_venta"),
            rs.getString("descripcion")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return lista;
  }
}
