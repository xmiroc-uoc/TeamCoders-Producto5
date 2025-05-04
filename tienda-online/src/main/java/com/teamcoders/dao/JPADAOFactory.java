package com.teamcoders.dao;

import com.teamcoders.dao.jpa.ArticuloDAOJPA;
import com.teamcoders.dao.jpa.ClienteDAOJPA;
import com.teamcoders.dao.jpa.PedidoDAOJPA;

public class JPADAOFactory extends DAOFactory {

  @Override
  public IClienteDAO getClienteDAO() {
    return new ClienteDAOJPA();
  }

  @Override
  public IArticuloDAO getArticuloDAO() {
    return new ArticuloDAOJPA();
  }

  @Override
  public IPedidoDAO getPedidoDAO() {
    return new PedidoDAOJPA();
  }
}
