package vista;

import modelo.Cliente;
import modelo.ClienteEstandar;
import modelo.ClientePremium;
import modelo.Datos;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClienteView {

  private Datos datos;
  private Scanner teclado = new Scanner(System.in);

  public ClienteView(Datos datos) {
    this.datos = datos;
  }

  public void navegarClientes() {
    String opcion = "";
    while (!opcion.equals("0")) {
      System.out.println("Haga su selección\n");
      System.out.println(
          "1. Añadir Clientes\n2. Mostrar Clientes\n3. Mostrar Clientes Estándar\n4. Mostrar Clientes Premium\n0. Salir");
      System.out.print("\n");
      opcion = teclado.nextLine();
      System.out.print("\n");

      switch (opcion) {
        case "1":
          try {
            agregarCliente();
          } catch (InputMismatchException ime) {
            System.out.print("\n");
            System.out.println("Tipo de dato erroneo");
            System.out.print("\n");
            teclado.nextLine();
          } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.print("\n");
          }
          break;

        case "2":
          mostrarClientes();
          System.out.print("\n");
          break;

        case "3":
          mostrarClientesEstandar();
          System.out.print("\n");
          break;

        case "4":
          mostrarClientesPremium();
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

  public void agregarCliente() throws Exception {
    String opcionTipo = "";
    boolean opcionPosible = false;

    while (!opcionPosible) {
      System.out.println("Que tipo de cliente quiere agregar:\n" +
          "1. Cliente Estándar\n" +
          "2. Cliente Premium");
      System.out.print("\n");
      opcionTipo = teclado.nextLine();
      System.out.print("\n");

      if (opcionTipo.equals("1") || opcionTipo.equals("2")) {
        opcionPosible = true;
      } else {
        System.out.println("Escoja entre las opciones disponibles.\n");
      }
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

    if (opcionTipo.equals("1")) {
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
  }

  private void mostrarClientes() {
    List<Cliente> lista = datos.getClientes();
    if (lista.isEmpty()) {
      System.out.println("No hay clientes.");
      return;
    }
    int count = 1;
    for (Cliente c : lista) {
      System.out.println(count + ". " + c.getNombre());
      count++;
    }
  }

  private void mostrarClientesEstandar() {
    List<Cliente> lista = datos.getClientes();
    int count = 1;
    for (Cliente c : lista) {
      if (c instanceof ClienteEstandar) {
        System.out.println(count + ". " + c.getNombre());
        count++;
      }
    }
  }

  private void mostrarClientesPremium() {
    List<Cliente> lista = datos.getClientes();
    int count = 1;
    for (Cliente c : lista) {
      if (c instanceof ClientePremium) {
        System.out.println(count + ". " + c.getNombre());
        count++;
      }
    }
  }
}
