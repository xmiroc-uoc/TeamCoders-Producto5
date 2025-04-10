package controlador;

import modelo.Cliente;
import modelo.ClienteEstandar;
import modelo.ClientePremium;
import modelo.Datos;
import java.util.List;

public class ClienteController {
  private Datos datos;

  public ClienteController(Datos datos) {
    this.datos = datos;
  }

  public void agregar(Cliente cliente) {
    datos.agregarCliente(cliente);
  }

  public List<Cliente> listar() {
    return datos.getClientes();
  }

  public List<Cliente> listarEstandar() {
    return datos.getClientes()
        .stream()
        .filter(c -> c instanceof ClienteEstandar)
        .toList();
  }

  public List<Cliente> listarPremium() {
    return datos.getClientes()
        .stream()
        .filter(c -> c instanceof ClientePremium)
        .toList();
  }
}
