package TeamCoders.dao.impl;

import TeamCoders.dao.PedidoDAO;
import TeamCoders.modelo.*;
import TeamCoders.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAOImpl implements PedidoDAO {

  /* ==================== utilidades internas ==================== */

  private Cliente mapCliente(ResultSet r) throws SQLException {
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

  private Articulo mapArticulo(ResultSet r) throws SQLException {
    return new Articulo(r.getString("codigo"),
        r.getInt("tiempo_preparacion"),
        r.getFloat("gastos_envio"),
        r.getFloat("precio_venta"),
        r.getString("descripcion"));
  }

  private int idCliente(Cliente cli, Connection con) throws SQLException {
    /* devuelve id; inserta si no existe */
    try (PreparedStatement sel = con.prepareStatement("SELECT id FROM cliente WHERE nif=?")) {
      sel.setString(1, cli.getNif());
      try (ResultSet rs = sel.executeQuery()) {
        if (rs.next())
          return rs.getInt(1);
      }
    }
    String ins = "INSERT INTO cliente(nombre,domicilio,nif,email,tipo,cuota_anual) VALUES (?,?,?,?,?,?)";
    try (PreparedStatement ps = con.prepareStatement(ins, Statement.RETURN_GENERATED_KEYS)) {
      ps.setString(1, cli.getNombre());
      ps.setString(2, cli.getDomicilio());
      ps.setString(3, cli.getNif());
      ps.setString(4, cli.getEmail());
      if (cli instanceof ClientePremium cp) {
        ps.setString(5, "premium");
        ps.setInt(6, cp.getCuotaAnual());
      } else {
        ps.setString(5, "estandar");
        ps.setNull(6, Types.INTEGER);
      }
      ps.executeUpdate();
      try (ResultSet rs = ps.getGeneratedKeys()) {
        rs.next();
        return rs.getInt(1);
      }
    }
  }

  /* ==================== interface PedidoDAO ==================== */

  @Override
  public void agregar(Pedido p) {
    final String call = "{CALL InsertarPedido(?,?,?,?,?)}";
    try (Connection con = DBConnection.getConnection();
        CallableStatement cs = con.prepareCall(call)) {

      cs.setInt(1, p.getNumeroPedido());
      cs.setInt(2, p.getUnidades());
      cs.setTimestamp(3, new Timestamp(p.getFechaPedido().getTime()));
      cs.setInt(4, idCliente(p.getCliente(), con));
      cs.setString(5, p.getArticulo().getCodigo());
      cs.execute();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void eliminar(Pedido p) {
    final String sql = "DELETE FROM pedido WHERE numero_pedido=?";
    try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {

      ps.setInt(1, p.getNumeroPedido());
      ps.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Pedido> listar() {
    return filtrar("ALL");
  }

  @Override
  public List<Pedido> listarPendientes() {
    return filtrar("PEND");
  }

  @Override
  public List<Pedido> listarEnviados() {
    return filtrar("ENV");
  }

  private List<Pedido> filtrar(String tipo) {
    List<Pedido> lista = new ArrayList<>();
    final String sql = """
        SELECT p.*, a.*, c.*
        FROM pedido p
        JOIN articulo a ON p.articulo_codigo=a.codigo
        JOIN cliente  c ON p.cliente_id=c.id
        """;

    try (Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql)) {

      while (rs.next()) {
        Articulo art = mapArticulo(rs);
        Cliente cli = mapCliente(rs);
        Pedido ped = new Pedido(
            rs.getInt("numero_pedido"),
            rs.getInt("unidades"),
            rs.getTimestamp("fecha_pedido"),
            cli, art);
        boolean enviado = System.currentTimeMillis() - ped.getFechaPedido().getTime() > art.getTiempoPreparacion()
            * 60_000L;

        if ("ALL".equals(tipo) ||
            ("PEND".equals(tipo) && !enviado) ||
            ("ENV".equals(tipo) && enviado)) {
          lista.add(ped);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return lista;
  }
}
