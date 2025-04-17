package TeamCoders.vista;

import TeamCoders.controlador.ArticuloController;
import TeamCoders.modelo.Articulo;

import java.util.List;
import java.util.Scanner;

public class ArticuloView {
  private final ArticuloController ctrl = new ArticuloController();
  private final Scanner in = new Scanner(System.in);

  public void navegar() {
    String op;
    do {
      System.out.println("\n-- Artículos --");
      System.out.println("1. Añadir Artículo");
      System.out.println("2. Mostrar Artículos");
      System.out.println("0. Volver");
      System.out.print("Opción: ");
      op = in.nextLine();

      switch (op) {
        case "1" -> agregar();
        case "2" -> mostrar();
      }
    } while (!"0".equals(op));
  }

  private void agregar() {
    try {
      System.out.print("Código: ");
      String c = in.nextLine();
      System.out.print("Tiempo preparación(min):");
      int tp = Integer.parseInt(in.nextLine());
      System.out.print("Gastos envío: ");
      float ge = Float.parseFloat(in.nextLine());
      System.out.print("Precio venta: ");
      float pv = Float.parseFloat(in.nextLine());
      System.out.print("Descripción: ");
      String d = in.nextLine();
      ctrl.agregar(new Articulo(c, tp, ge, pv, d));
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private void mostrar() {
    List<Articulo> l = ctrl.listar();
    if (l.isEmpty())
      System.out.println("No hay artículos.");
    else
      l.forEach(System.out::println);
  }
}
