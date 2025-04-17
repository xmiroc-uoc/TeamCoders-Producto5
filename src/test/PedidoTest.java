import TeamCoders.modelo.*;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

  @Test
  public void testPrecioPedidoEstandar() {
    Cliente cli = new ClienteEstandar("Ana", "C/1", "N1", "a@mail.com");
    Articulo art = new Articulo("A1", 10, 5f, 10f, "Libro");
    Pedido p = new Pedido(1, 2, new Date(), cli, art);
    assertEquals(25f, p.precioPedido(), 0.01);
  }
}
