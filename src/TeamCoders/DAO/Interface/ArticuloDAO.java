package DAO.Interface;

import java.sql.SQLException;

import modelo.Articulo;

public interface ArticuloDAO extends DAO<Articulo>{
    Articulo getByCodigo(String s) throws SQLException;
}
