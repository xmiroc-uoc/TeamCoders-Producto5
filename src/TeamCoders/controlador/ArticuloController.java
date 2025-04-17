package TeamCoders.controlador;

import TeamCoders.dao.*;
import TeamCoders.modelo.Articulo;
import java.util.List;

public class ArticuloController {
  private final ArticuloDAO dao = DAOFactory.getArticuloDAO();

  public void agregar(Articulo a) {
    dao.agregar(a);
  }

  public List<Articulo> listar() {
    return dao.listar();
  }
}
