package TeamCoders.vista;

import TeamCoders.controlador.ClienteController;
import TeamCoders.modelo.*;

import java.util.List;
import java.util.Scanner;

public class ClienteView {
  private final ClienteController ctrl = new ClienteController();
  private final Scanner in = new Scanner(System.in);

  public void navegar() {
    String op;
    do {
      System.out.println("\n-- Clientes --");
      System.out.println("1. Añadir Cliente");
      System.out.println("2. Mostrar Todos");
      System.out.println("3. Mostrar Estándar");
      System.out.println("4. Mostrar Premium");
      System.out.println("0. Volver");
      System.out.print("Opción: ");
      op = in.nextLine();

      switch (op) {
        case "1" -> agregar();
        case "2" -> mostrar(ctrl.listar());
        case "3" -> mostrar(ctrl.listarEstandar());
        case "4" -> mostrar(ctrl.listarPremium());
      }
    } while (!"0".equals(op));
  }

  public void agregar() {
    try {
      System.out.print("Tipo (1=Estándar, 2=Premium): ");
      String tipo = in.nextLine();
      System.out.print("Nombre: ");
      String n = in.nextLine();
      System.out.print("Domicilio: ");
      String d = in.nextLine();
      System.out.print("NIF: ");
      String nif = in.nextLine();
      System.out.print("Email: ");
      String e = in.nextLine();

      if ("2".equals(tipo)) {
        System.out.print("Cuota anual: ");
        int cuota = Integer.parseInt(in.nextLine());
        ctrl.agregar(new ClientePremium(n, d, nif, e, cuota));
      } else {
        ctrl.agregar(new ClienteEstandar(n, d, nif, e));
      }
    } catch (Exception ex) {
      System.out.println("Error: " + ex.getMessage());
    }
  }

  private void mostrar(List<Cliente> l) {
    if (l.isEmpty())
      System.out.println("No hay clientes.");
    else
      l.forEach(System.out::println);
  }
}
