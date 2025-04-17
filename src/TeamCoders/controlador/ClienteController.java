package TeamCoders.controlador;

import TeamCoders.dao.*;
import TeamCoders.modelo.Cliente;
import java.util.List;

public class ClienteController {
  private final ClienteDAO dao = DAOFactory.getClienteDAO();

  public void agregar(Cliente c) {
    dao.agregar(c);
  }

  public List<Cliente> listar() {
    return dao.listar();
  }

  public List<Cliente> listarEstandar() {
    return dao.listarEstandar();
  }

  public List<Cliente> listarPremium() {
    return dao.listarPremium();
  }
}
