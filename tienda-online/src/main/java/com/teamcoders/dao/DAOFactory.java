package com.teamcoders.dao;

public abstract class DAOFactory {
  public static final int MYSQL = 1;

  public abstract IClienteDAO getClienteDAO();

  public abstract IArticuloDAO getArticuloDAO();

  public abstract IPedidoDAO getPedidoDAO();

  public static DAOFactory getDAOFactory(int tipo) {
    switch (tipo) {
      case MYSQL:
        return new JPADAOFactory();
      default:
        throw new RuntimeException("Tipo de DAOFactory no válido");
    }
  }
}
