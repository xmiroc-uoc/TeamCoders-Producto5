package TeamCoders.controlador;

import TeamCoders.dao.*;
import TeamCoders.modelo.Pedido;
import java.util.List;

public class PedidoController {
  private final PedidoDAO dao = DAOFactory.getPedidoDAO();

  public void agregar(Pedido p) {
    dao.agregar(p);
  }

  public void eliminar(Pedido p) {
    dao.eliminar(p);
  }

  public List<Pedido> listar() {
    return dao.listar();
  }

  public List<Pedido> listarPendientes() {
    return dao.listarPendientes();
  }

  public List<Pedido> listarEnviados() {
    return dao.listarEnviados();
  }
}
