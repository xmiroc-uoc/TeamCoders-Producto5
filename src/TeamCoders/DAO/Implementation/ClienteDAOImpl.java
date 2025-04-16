package DAO.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.Connection.DBConnection;
import DAO.Interface.ClienteDAO;
import modelo.Cliente;
import modelo.ClienteEstandar;
import modelo.ClientePremium;

public class ClienteDAOImpl implements ClienteDAO{

    @Override
    public Cliente getByEmail(String s) throws SQLException {
        Connection con = DBConnection.getConnection();
        Cliente cliente = null;

        String sql = "SELECT * FROM clientes WHERE email = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, s);

        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            String tipoCliente = rs.getString("tipo");
            if(tipoCliente.equals("estandar")){
                cliente = new ClienteEstandar(rs.getString("nombre"), rs.getString("domicilio"), rs.getString("nif"), rs.getString("email"));
            }else{
                cliente = new ClientePremium(rs.getString("nombre"), rs.getString("domicilio"), rs.getString("nif"), rs.getString("email"), rs.getInt("cuota_anual"));
            }
        }

        return cliente;
    }

    @Override
    public ArrayList<Cliente> getAll() throws SQLException {
        Connection con = DBConnection.getConnection();
        ArrayList<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM clientes";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            String tipoCliente = rs.getString("tipo");
            if(tipoCliente.equals("estandar")){
                ClienteEstandar cliente = new ClienteEstandar(rs.getString("nombre"), rs.getString("domicilio"), rs.getString("nif"), rs.getString("email"));
                clientes.add(cliente);
            }else{
                ClientePremium cliente = new ClientePremium(rs.getString("nombre"), rs.getString("domicilio"), rs.getString("nif"), rs.getString("email"), rs.getInt("cuota_anual"));
                clientes.add(cliente);
            }
        }

        return clientes;
    }

    @Override
    public void insert(Cliente cliente) throws SQLException {
        Connection con = DBConnection.getConnection();

        String sql = "INSERT INTO clientes (email, nombre, domicilio, nif, tipo, cuota_anual) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, cliente.getEmail());
        ps.setString(2, cliente.getNombre());
        ps.setString(3, cliente.getDomicilio());
        ps.setString(4, cliente.getNif());

        if(cliente instanceof ClienteEstandar){
            ps.setString(5, "estandar");
            ps.setDouble(6, 0);
        }else{
            ps.setString(5, "premium");
            ps.setDouble(6, ((ClientePremium) cliente).getCuotaAnual());
        }

        ps.executeUpdate();

        ps.close();
        con.close();
    }

}
