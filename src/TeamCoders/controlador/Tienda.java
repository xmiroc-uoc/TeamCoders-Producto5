package TeamCoders.controlador;

import TeamCoders.vista.*;

public class Tienda {
  private final TiendaView menu = new TiendaView();
  private final ArticuloView vArt = new ArticuloView();
  private final ClienteView vCli = new ClienteView();
  private final PedidoView vPed = new PedidoView();

  public void navegarTienda() {
    String op;
    do {
      menu.printMenuGeneral();
      op = menu.leer();
      switch (op) {
        case "1" -> vArt.navegar();
        case "2" -> vCli.navegar();
        case "3" -> vPed.navegar();
      }
    } while (!"0".equals(op));
  }
}
