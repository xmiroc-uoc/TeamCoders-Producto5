package TeamCoders.vista;

import TeamCoders.controlador.*;
import TeamCoders.modelo.*;

import java.util.*;

public class PedidoView {
  private final PedidoController ctrlPed = new PedidoController();
  private final ArticuloController ctrlArt = new ArticuloController();
  private final ClienteController ctrlCli = new ClienteController();
  private final Scanner in = new Scanner(System.in);

  public void navegar() {
    String op;
    do {
      System.out.println("\n-- Pedidos --");
      System.out.println("1. Añadir Pedido");
      System.out.println("2. Eliminar Pedido");
      System.out.println("3. Pendientes de envío");
      System.out.println("4. Enviados");
      System.out.println("0. Volver");
      System.out.print("Opción: ");
      op = in.nextLine();

      switch (op) {
        case "1" -> agregar();
        case "2" -> eliminar();
        case "3" -> mostrar(ctrlPed.listarPendientes());
        case "4" -> mostrar(ctrlPed.listarEnviados());
      }
    } while (!"0".equals(op));
  }

  private void agregar() {
    try {
      System.out.print("Número de pedido: ");
      int num = Integer.parseInt(in.nextLine());
      System.out.print("Unidades: ");
      int uni = Integer.parseInt(in.nextLine());

      Cliente cli = seleccionarCliente();
      if (cli == null)
        return;

      Articulo art = seleccionarArticulo();
      if (art == null)
        return;

      ctrlPed.agregar(new Pedido(num, uni, new Date(), cli, art));
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private Cliente seleccionarCliente() {
    System.out.println("1. Seleccionar existente");
    System.out.println("2. Crear nuevo");
    System.out.print("Opción: ");
    String op = in.nextLine();
    if ("2".equals(op)) {
      new ClienteView().agregar();
    }
    List<Cliente> lista = ctrlCli.listar();
    if (lista.isEmpty()) {
      System.out.println("No hay clientes.");
      return null;
    }
    for (int i = 0; i < lista.size(); i++)
      System.out.println((i + 1) + ". " + lista.get(i).getNombre());
    System.out.print("Seleccione: ");
    int idx = Integer.parseInt(in.nextLine()) - 1;
    return lista.get(idx);
  }

  private Articulo seleccionarArticulo() {
    List<Articulo> lista = ctrlArt.listar();
    if (lista.isEmpty()) {
      System.out.println("No hay artículos.");
      return null;
    }
    for (int i = 0; i < lista.size(); i++)
      System.out.println((i + 1) + ". " + lista.get(i).getDescripcion());
    System.out.print("Seleccione: ");
    int idx = Integer.parseInt(in.nextLine()) - 1;
    return lista.get(idx);
  }

  private void eliminar() {
    List<Pedido> lista = ctrlPed.listarPendientes();
    if (lista.isEmpty()) {
      System.out.println("Nada que eliminar.");
      return;
    }
    for (int i = 0; i < lista.size(); i++)
      System.out.println((i + 1) + ". #" + lista.get(i).getNumeroPedido());
    System.out.print("Seleccione: ");
    int idx = Integer.parseInt(in.nextLine()) - 1;
    ctrlPed.eliminar(lista.get(idx));
  }

  private void mostrar(List<Pedido> l) {
    if (l.isEmpty())
      System.out.println("No hay pedidos.");
    else
      l.forEach(System.out::println);
  }
}
