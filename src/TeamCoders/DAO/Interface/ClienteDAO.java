package DAO.Interface;

import java.sql.SQLException;

import modelo.Cliente;

public interface ClienteDAO extends DAO<Cliente>{
    Cliente getByEmail(String s) throws SQLException;
}
