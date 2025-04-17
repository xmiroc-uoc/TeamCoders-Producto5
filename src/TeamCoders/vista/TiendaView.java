package TeamCoders.vista;

import java.util.Scanner;

public class TiendaView {
  private final Scanner in = new Scanner(System.in);

  public void printMenuGeneral() {
    System.out.println("\n=== MENÚ TIENDA ===");
    System.out.println("1. Gestión Artículos");
    System.out.println("2. Gestión Clientes");
    System.out.println("3. Gestión Pedidos");
    System.out.println("0. Salir");
    System.out.print("Opción: ");
  }

  public String leer() {
    return in.nextLine();
  }
}
