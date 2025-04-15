package vista;

import modelo.*;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PedidoView {

  private Datos datos;
  private Scanner teclado = new Scanner(System.in);

  public PedidoView(Datos datos) {
    this.datos = datos;
  }

  public void navegarPedidos() {
    String opcion = "";
    while (!opcion.equals("0")) {
      System.out.println("Haga su selección\n");
      System.out.println(
          "1. Añadir Pedido.\n2. Eliminar Pedido.\n3. Mostar pedidos pendientes de envío.\n4. Mostrar pedidos enviados.\n0. Salir");
      System.out.print("\n");
      opcion = teclado.nextLine();
      System.out.print("\n");

      switch (opcion) {
        case "1":
          try {
            agregarPedido();
          } catch (InputMismatchException ime) {
            System.out.print("\n");
            System.out.println("Tipo de dato erroneo");
            System.out.print("\n");
            teclado.nextLine();
          }
          break;

        case "2":
          try {
            eliminarPedido();
          } catch (InputMismatchException ime) {
            System.out.print("\n");
            System.out.println("Tipo de dato erroneo");
            System.out.print("\n");
            teclado.nextLine();
          }
          break;

        case "3":
          mostrarPedidosPendientes();
          System.out.print("\n");
          break;

        case "4":
          mostrarPedidosEnviados();
          System.out.print("\n");
          break;

        case "0":
          break;

        default:
          System.out.println("Escoja entre las opciones disponibles.\n");
          break;
      }
    }
  }

  public void agregarPedido() {
    System.out.println("Introduzca numero de pedido\n");
    int numPedido = teclado.nextInt();
    System.out.print("\n");

    System.out.println("Introduzca el numero de unidades\n");
    int unidades = teclado.nextInt();
    System.out.print("\n");

    String opcion = "";
    boolean opcionPosible = false;
    teclado.nextLine();

    while (!opcionPosible) {
      System.out.println("1. Seleccionar entre los clientes existentes\n" +
          "2. Agregar nuevo cliente");
      System.out.print("\n");
      opcion = teclado.nextLine();
      System.out.print("\n");

      if (opcion.equals("1") || opcion.equals("2")) {
        opcionPosible = true;
      } else {
        System.out.println("Escoja entre las opciones disponibles.");
      }
    }

    Cliente clienteSeleccionado;
    if (opcion.equals("2")) {
      try {
        System.out.println("Que tipo de cliente quiere agregar:\n" +
            "1. Cliente Estándar\n" +
            "2. Cliente Premium");
        System.out.print("\n");
        String tipo = teclado.nextLine();
        System.out.print("\n");

        if (!tipo.equals("1") && !tipo.equals("2")) {
          System.out.println("Escoja entre las opciones disponibles.\n");
          return;
        }

        System.out.println("Introduzca el nombre\n");
        String nombre = teclado.nextLine();
        if (nombre.equals("")) {
          throw new Exception("Dato no introducido");
        }
        System.out.print("\n");

        System.out.println("Introduzca el domicilio\n");
        String domicilio = teclado.nextLine();
        if (domicilio.equals("")) {
          throw new Exception("Dato no introducido");
        }
        System.out.print("\n");

        System.out.println("Introduzca el NIF\n");
        String nif = teclado.nextLine();
        if (nif.equals("")) {
          throw new Exception("Dato no introducido");
        }
        System.out.print("\n");

        System.out.println("Introduzca el mail\n");
        String email = teclado.nextLine();
        if (email.equals("")) {
          throw new Exception("Dato no introducido");
        }
        System.out.print("\n");

        if (tipo.equals("1")) {
          Cliente newCliente = new ClienteEstandar(nombre, domicilio, nif, email);
          datos.agregarCliente(newCliente);
        } else {
          System.out.println("Introduzca la cuota anual\n");
          int cuotaAnual = teclado.nextInt();
          teclado.nextLine();
          System.out.print("\n");

          Cliente newCliente = new ClientePremium(nombre, domicilio, nif, email, cuotaAnual);
          datos.agregarCliente(newCliente);
        }

        clienteSeleccionado = datos.getClientes().get(datos.getClientes().size() - 1);

      } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.print("\n");
        return;
      }

    } else {
      while (opcionPosible) {
        System.out.println("Seleccione un cliente");
        mostrarClientes();
        System.out.println("\n");

        int opcionCliente = teclado.nextInt();
        teclado.nextLine();
        if (opcionCliente > 0 && opcionCliente <= datos.getClientes().size()) {
          opcionPosible = false;
          clienteSeleccionado = datos.getClientes().get(opcionCliente - 1);
        } else {
          System.out.println("Escoja entre las opciones disponibles.");
          continue;
        }
        break;
      }
    }

    Cliente clienteSeleccionadoFinal;
    if (opcion.equals("2")) {
      clienteSeleccionadoFinal = datos.getClientes().get(datos.getClientes().size() - 1);
    } else {
      clienteSeleccionadoFinal = datos.getClientes().get(datos.getClientes().size() - 1);
    }

    boolean opcionArtPosible = false;
    int opcionArticulo = 0;

    while (!opcionArtPosible) {
      System.out.println("Seleccione un articulo");
      mostrarArticulos();
      System.out.println("\n");

      opcionArticulo = teclado.nextInt();
      if (opcionArticulo > 0 && opcionArticulo <= datos.getArticulos().size()) {
        opcionArtPosible = true;
      } else {
        System.out.println("Escoja entre las opciones disponibles.");
      }
    }

    Articulo articuloSeleccionado = datos.getArticulos().get(opcionArticulo - 1);

    Date fecha = new Date();
    Pedido newPedido = new Pedido(numPedido, unidades, fecha, clienteSeleccionadoFinal, articuloSeleccionado);
    datos.agregarPedido(newPedido);
  }

  public void eliminarPedido() {
    boolean opcionPedPosible = false;
    int opcionPedido = 0;

    while (!opcionPedPosible) {
      System.out.println("Escoja el pedido que quiere eliminar");
      mostrarPedidos();
      System.out.println("\n");

      opcionPedido = teclado.nextInt();
      if (opcionPedido > 0 && opcionPedido <= datos.getPedidos().size()) {
        opcionPedPosible = true;
        Pedido pedidoSeleccionado = datos.getPedidos().get(opcionPedido - 1);
        if (pedidoSeleccionado.cancelable()) {
          datos.eliminarPedido(pedidoSeleccionado);
        } else {
          System.out.println("Este pedido no se puede eliminar");
          teclado.nextLine();
        }
      } else {
        System.out.println("Escoja entre las opciones disponibles.");
      }
    }
  }

  private void mostrarPedidos() {
    List<Pedido> lista = datos.getPedidos();
    int count = 1;
    for (Pedido p : lista) {
      System.out.println(count + ". Pedido #" + p.getNumeroPedido());
      count++;
    }
  }

  private void mostrarClientes() {
    List<Cliente> lista = datos.getClientes();
    int count = 1;
    for (Cliente c : lista) {
      System.out.println(count + ". " + c.getNombre());
      count++;
    }
  }

  private void mostrarArticulos() {
    List<Articulo> lista = datos.getArticulos();
    int count = 1;
    for (Articulo a : lista) {
      System.out.println(count + ". " + a.getDescripcion());
      count++;
    }
  }

  private void mostrarPedidosPendientes() {
    List<Pedido> lista = datos.getPedidos();
    int count = 1;
    for (Pedido p : lista) {
      long finPreparacion = p.getFechaPedido().getTime()
          + (p.getArticulo().getTiempoPreparacion() * 60_000L);

      if (finPreparacion >= System.currentTimeMillis()) {
        System.out.println(count + ". Pedido #" + p.getNumeroPedido());
        count++;
      }
    }
  }

  private void mostrarPedidosEnviados() {
    List<Pedido> lista = datos.getPedidos();
    int count = 1;
    for (Pedido p : lista) {
      long finPreparacion = p.getFechaPedido().getTime()
          + (p.getArticulo().getTiempoPreparacion() * 60_000L);

      if (finPreparacion < System.currentTimeMillis()) {
        System.out.println(count + ". Pedido #" + p.getNumeroPedido());
        count++;
      }
    }
  }
}
