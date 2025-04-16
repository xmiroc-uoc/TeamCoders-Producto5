package DAO.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Connection.DBConnection;
import DAO.Interface.ArticuloDAO;
import modelo.Articulo;

public class ArticuloDAOImpl implements ArticuloDAO{

    @Override
    public Articulo getByCodigo(String s) throws SQLException{
        Connection con = DBConnection.getConnection();
        Articulo articulo = null;

        String sql = "SELECT * FROM articulos WHERE codigo = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, s);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            articulo = new Articulo(rs.getString("codigo"), rs.getInt("tiempo_preparacion"), rs.getDouble("gastos_envio"), rs.getDouble("precio_venta"), rs.getString("descripcion"));
        }

        return articulo;

    }

    @Override
    public ArrayList<Articulo> getAll() throws SQLException {
        Connection con = DBConnection.getConnection();
        ArrayList<Articulo> articulos = new ArrayList<>();

        String sql = "SELECT * FROM articulos";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            Articulo articulo = new Articulo(rs.getString("codigo"), rs.getInt("tiempo_preparacion"), rs.getDouble("gastos_envio"), rs.getDouble("precio_venta"), rs.getString("descripcion"));
            articulos.add(articulo);
        }

        return articulos;
    }

    @Override
    public void insert(Articulo articulo) throws SQLException {
        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO articulos (codigo, descripcion, precio_venta, gastos_envio, tiempo_preparacion) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, articulo.getCodigo());
        ps.setString(2, articulo.getDescripcion());
        ps.setDouble(3, articulo.getPrecioVenta());
        ps.setDouble(4, articulo.getGastosEnvio());
        ps.setInt(5, articulo.getTiempoPreparacion());

        ps.executeUpdate();

        ps.close();
        con.close();

    }

}
