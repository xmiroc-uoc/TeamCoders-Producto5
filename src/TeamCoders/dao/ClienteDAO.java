package TeamCoders.dao;

import TeamCoders.modelo.Cliente;
import java.util.List;

public interface ClienteDAO {
  void agregar(Cliente cliente);

  List<Cliente> listar();

  List<Cliente> listarEstandar();

  List<Cliente> listarPremium();
}
