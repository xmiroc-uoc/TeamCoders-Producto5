package TeamCoders.dao;

import TeamCoders.modelo.Pedido;
import java.util.List;

public interface PedidoDAO {
  void agregar(Pedido pedido);

  void eliminar(Pedido pedido);

  List<Pedido> listar();

  List<Pedido> listarPendientes();

  List<Pedido> listarEnviados();
}
