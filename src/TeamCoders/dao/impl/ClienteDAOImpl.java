package TeamCoders.dao.impl;

import TeamCoders.dao.ClienteDAO;
import TeamCoders.modelo.*;
import TeamCoders.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {

  @Override
  public void agregar(Cliente c) {
    final String sql = "INSERT INTO cliente(nombre,domicilio,nif,email,tipo,cuota_anual) VALUES (?,?,?,?,?,?)";
    try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

      ps.setString(1, c.getNombre());
      ps.setString(2, c.getDomicilio());
      ps.setString(3, c.getNif());
      ps.setString(4, c.getEmail());

      if (c instanceof ClientePremium cp) {
        ps.setString(5, "premium");
        ps.setInt(6, cp.getCuotaAnual());
      } else {
        ps.setString(5, "estandar");
        ps.setNull(6, Types.INTEGER);
      }
      ps.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Cliente> listar() {
    return filtrar(null);
  }

  @Override
  public List<Cliente> listarEstandar() {
    return filtrar("estandar");
  }

  @Override
  public List<Cliente> listarPremium() {
    return filtrar("premium");
  }

  private List<Cliente> filtrar(String tipo) {
    List<Cliente> lista = new ArrayList<>();
    String sql = "SELECT * FROM cliente";
    if (tipo != null)
      sql += " WHERE tipo=?";

    try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

      if (tipo != null)
        ps.setString(1, tipo);
      try (ResultSet rs = ps.executeQuery()) {
        while (rs.next())
          lista.add(map(rs));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return lista;
  }

  private Cliente map(ResultSet r) throws SQLException {
    return "premium".equals(r.getString("tipo"))
        ? new ClientePremium(r.getString("nombre"),
            r.getString("domicilio"),
            r.getString("nif"),
            r.getString("email"),
            r.getInt("cuota_anual"))
        : new ClienteEstandar(r.getString("nombre"),
            r.getString("domicilio"),
            r.getString("nif"),
            r.getString("email"));
  }
}
