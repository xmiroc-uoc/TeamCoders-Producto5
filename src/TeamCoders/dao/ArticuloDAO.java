package TeamCoders.dao;

import TeamCoders.modelo.Articulo;
import java.util.List;

public interface ArticuloDAO {
  void agregar(Articulo articulo);

  List<Articulo> listar();
}
