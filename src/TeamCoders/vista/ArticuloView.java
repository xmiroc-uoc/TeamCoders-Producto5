package vista;

import modelo.Articulo;
import modelo.Datos;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ArticuloView {

  private Datos datos;
  private Scanner teclado = new Scanner(System.in);

  public ArticuloView(Datos datos) {
    this.datos = datos;
  }

  public void navegarArticulos() {
    String opcion = "";
    while (!opcion.equals("0")) {
      System.out.println("Haga su selección\n");
      System.out.println("1. Añadir Articulos\n2. Mostrar Articulos\n0. Salir");
      System.out.print("\n");
      opcion = teclado.nextLine();
      System.out.print("\n");

      switch (opcion) {
        case "1":
          try {
            agregarArticulo();
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
          mostrarArticulos();
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

  public void agregarArticulo() throws Exception {
    System.out.println("Introduzca el codigo\n");
    String codigo = teclado.nextLine();
    if (codigo.equals("")) {
      throw new Exception("Dato no introducido");
    }
    System.out.print("\n");

    System.out.println("Introduzca el timepo de preparación en minutos\n");
    int tiempoPreparacion = teclado.nextInt();
    System.out.print("\n");

    System.out.println("Introduzca los gastos de envio\n");
    float gastosEnvio = teclado.nextFloat();
    System.out.print("\n");

    System.out.println("Introduzca el precio de venta\n");
    float precioVenta = teclado.nextFloat();
    System.out.print("\n");

    System.out.println("Introduzca una descripción\n");
    teclado.nextLine();
    String descripcion = teclado.nextLine();
    if (descripcion.equals("")) {
      throw new Exception("Dato no introducido");
    }
    System.out.print("\n");

    Articulo newArticulo = new Articulo(codigo, tiempoPreparacion, gastosEnvio, precioVenta, descripcion);
    datos.agregarArticulo(newArticulo);
  }

  private void mostrarArticulos() {
    List<Articulo> lista = datos.getArticulos();
    if (lista.isEmpty()) {
      System.out.println("No hay artículos disponibles.");
      return;
    }
    int count = 1;
    for (Articulo art : lista) {
      System.out.println(count + ". " + art.getDescripcion() + " (cód: " + art.getCodigo() + ")");
      count++;
    }
  }
}
