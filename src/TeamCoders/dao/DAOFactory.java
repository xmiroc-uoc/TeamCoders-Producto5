package TeamCoders.dao;

import TeamCoders.dao.impl.ArticuloDAOImpl;
import TeamCoders.dao.impl.ClienteDAOImpl;
import TeamCoders.dao.impl.PedidoDAOImpl;

public final class DAOFactory {
  private DAOFactory() {
  }

  public static ArticuloDAO getArticuloDAO() {
    return new ArticuloDAOImpl();
  }

  public static ClienteDAO getClienteDAO() {
    return new ClienteDAOImpl();
  }

  public static PedidoDAO getPedidoDAO() {
    return new PedidoDAOImpl();
  }
}
