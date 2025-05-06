package com.teamcoders.dao;

import com.teamcoders.dao.hibernate.ArticuloDAOHibernate;
import com.teamcoders.dao.hibernate.ClienteDAOHibernate;
import com.teamcoders.dao.hibernate.PedidoDAOHibernate;

public class HibernateDAOFactory extends DAOFactory{

    @Override
    public IClienteDAO getClienteDAO(){
        return new ClienteDAOHibernate();
    }

    @Override
     public IArticuloDAO getArticuloDAO(){
        return new ArticuloDAOHibernate();
     }

    @Override
     public IPedidoDAO getPedidoDAO(){
        return new PedidoDAOHibernate();
     }
    
}
