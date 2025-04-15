package controlador;

import modelo.Pedido;
import modelo.Datos;
import java.util.List;

public class PedidoController {
  private Datos datos;

  public PedidoController(Datos datos) {
    this.datos = datos;
  }

  public void agregar(Pedido pedido) {
    datos.agregarPedido(pedido);
  }

  public void eliminar(Pedido pedido) {
    datos.eliminarPedido(pedido);
  }

  public List<Pedido> listar() {
    return datos.getPedidos();
  }

  public List<Pedido> listarPendientes() {
    return datos.getPedidos().stream()
        .filter(p -> p.cancelable())
        .toList();
  }

  public List<Pedido> listarEnviados() {
    return datos.getPedidos().stream()
        .filter(p -> !p.cancelable())
        .toList();
  }
}
