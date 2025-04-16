package DAO.Interface;

import java.sql.SQLException;
import java.util.ArrayList;


public interface DAO<T> {

    ArrayList<T> getAll() throws SQLException;

    void insert(T t) throws SQLException;
    
}
