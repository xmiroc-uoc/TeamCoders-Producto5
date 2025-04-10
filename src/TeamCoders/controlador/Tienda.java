package controlador;

import modelo.Datos;
import vista.*;

public class Tienda {

  private Datos datos = new Datos();

  private TiendaView menuGeneral = new TiendaView();
  private ArticuloView articuloView = new ArticuloView(datos);
  private ClienteView clienteView = new ClienteView(datos);
  private PedidoView pedidoView = new PedidoView(datos);

  public void navegarTienda() {

    String opcion = "";

    while (!opcion.equals("0")) {

      menuGeneral.printMenuGeneral();

      break;
    }
  }
}
