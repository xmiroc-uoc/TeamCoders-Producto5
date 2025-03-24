package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.Test;

import TeamCoders.modelo.*;

public class PedidoTest {
    
    @Test
    public void testPrecioPedidoClienteEstandar() {
        Cliente cliente = new ClienteEstandar("Ana", "Calle 1", "12345678A", "ana@email.com");
        Articulo articulo = new Articulo("A1", "Libro", 10.0f, 5.0f, 10);
        Pedido pedido = new Pedido(1, 2, new Date(), cliente, articulo);

        float esperado = 10.0f * 2 + 5.0f;
        assertEquals(esperado, pedido.precioPedido(), 0.001);
    }

    @Test
    public void testPedidoCancelable() {
        Cliente cliente = new ClienteEstandar("Ana", "Calle 1", "12345678A", "ana@email.com");
        Articulo articulo = new Articulo("A1", "Libro", 10.0f, 5.0f, 60);
        Date hace30Min = new Date(System.currentTimeMillis() - 30 * 60 * 1000);

        Pedido pedido = new Pedido(2, 1, hace30Min, cliente, articulo);
        assertTrue(pedido.cancelable());
    }

}
