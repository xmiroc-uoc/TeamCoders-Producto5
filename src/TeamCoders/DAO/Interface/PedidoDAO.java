package DAO.Interface;

import java.sql.SQLException;

import modelo.Pedido;

public interface PedidoDAO extends DAO<Pedido>{

    Pedido getByID(int numero) throws SQLException;
    void delete(Pedido pedido) throws SQLException;
    
}
