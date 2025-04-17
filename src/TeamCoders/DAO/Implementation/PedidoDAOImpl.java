package DAO.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import DAO.Connection.DBConnection;
import DAO.Factory.DAOFactory;
import DAO.Interface.ArticuloDAO;
import DAO.Interface.ClienteDAO;
import DAO.Interface.PedidoDAO;
import modelo.Articulo;
import modelo.Cliente;
import modelo.Pedido;

public class PedidoDAOImpl implements PedidoDAO{

    @Override
    public Pedido getByID(int numero) throws SQLException {
        Connection con = DBConnection.getConnection();
        Pedido pedido = null;

        String sql = "SELECT * FROM pedidos WHERE numero = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, numero);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            //Convertimos fecha de TimeStamp a LocalDateTime
            Timestamp timestampFecha = rs.getTimestamp("fecha_pedido");
            LocalDateTime fechaPedido = timestampFecha.toLocalDateTime();

            //Obtenemos Cliente y Articulo
            DAOFactory factory = new DAOFactory();
            ArticuloDAO articuloDAO = factory.getArticulo();
            ClienteDAO clienteDAO = factory.getCliente();
            Articulo articulo = articuloDAO.getByCodigo(rs.getString("articulo_codigo"));
            Cliente cliente = clienteDAO.getByEmail(rs.getString("cliente_email"));

            pedido = new Pedido(rs.getInt("numero"), rs.getInt("unidades"), fechaPedido, cliente, articulo);
        }

        return pedido;
    }

    @Override
    public ArrayList<Pedido> getAll() throws SQLException {
        Connection con = DBConnection.getConnection();
        ArrayList<Pedido> pedidos = new ArrayList<>();

        String sql = "SELECT * FROM pedidos";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            //Convertimos fecha de TimeStamp a LocalDateTime
            Timestamp timestampFecha = rs.getTimestamp("fecha_pedido");
            LocalDateTime fechaPedido = timestampFecha.toLocalDateTime();

            //Obtenemos Cliente y Articulo
            DAOFactory factory = new DAOFactory();
            ArticuloDAO articuloDAO = factory.getArticulo();
            ClienteDAO clienteDAO = factory.getCliente();
            Articulo articulo = articuloDAO.getByCodigo(rs.getString("articulo_codigo"));
            Cliente cliente = clienteDAO.getByEmail(rs.getString("cliente_email"));

            Pedido pedido = new Pedido(rs.getInt("numero"), rs.getInt("unidades"), fechaPedido, cliente, articulo);
            pedidos.add(pedido);
        }

        return pedidos;
    }

    @Override
    public void insert(Pedido pedido) throws SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = null;

        try {
            con.setAutoCommit(false);
            String sql = "INSERT INTO pedidos (numero, unidades, fecha_pedido, cliente_email, articulo_codigo) VALUES (?, ?, ?, ?, ?)";

            ps = con.prepareStatement(sql);
    
            ps.setInt(1, pedido.getNumeroPedido());
            ps.setInt(2, pedido.getUnidades());
    
            Timestamp timestampFecha = Timestamp.valueOf(pedido.getFechaPedido());
            ps.setTimestamp(3, timestampFecha);
            ps.setString(4, pedido.getCliente().getEmail());
            ps.setString(5, pedido.getArticulo().getCodigo());
    
            ps.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            con.rollback();
        } finally {
            con.setAutoCommit(true);
            ps.close();
            con.close();
        }
    }

    @Override
    public void delete(Pedido pedido) throws SQLException{
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = null;

        try {
            con.setAutoCommit(false);
            String sql = "DELETE FROM pedidos WHERE numero = ?";

            ps = con.prepareStatement(sql);
    
            ps.setInt(1, pedido.getNumeroPedido());
    
            ps.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            con.rollback();
        } finally{
            con.setAutoCommit(true);
            ps.close();
            con.close();
        }
    }

    

}
