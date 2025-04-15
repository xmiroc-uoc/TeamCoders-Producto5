package controlador;

import modelo.Articulo;
import modelo.Datos;
import java.util.List;

public class ArticuloController {
  private Datos datos;

  public ArticuloController(Datos datos) {
    this.datos = datos;
  }

  public void agregar(Articulo articulo) {
    datos.agregarArticulo(articulo);
  }

  public List<Articulo> listar() {
    return datos.getArticulos();
  }
}
