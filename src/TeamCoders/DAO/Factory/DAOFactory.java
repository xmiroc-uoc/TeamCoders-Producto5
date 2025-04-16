package DAO.Factory;

import DAO.Implementation.ArticuloDAOImpl;
import DAO.Implementation.ClienteDAOImpl;
import DAO.Implementation.PedidoDAOImpl;
import DAO.Interface.ArticuloDAO;
import DAO.Interface.ClienteDAO;
import DAO.Interface.PedidoDAO;

public class DAOFactory {

    public ArticuloDAO getArticulo(){
        return new ArticuloDAOImpl();
    }

    public ClienteDAO getCliente(){
        return new ClienteDAOImpl();
    }

    public PedidoDAO getPedido(){
        return new PedidoDAOImpl(); 
    }
}
