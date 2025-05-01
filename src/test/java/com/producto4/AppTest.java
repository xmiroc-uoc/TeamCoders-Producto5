package com.producto4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.time.LocalDateTime;
import com.modelo.*;


public class AppTest {

    @Test
    public void testPrecioPedidoClienteEstandar() {
        Cliente cliente = new ClienteEstandar("Ana", "Calle 1", "12345678A", "ana@email.com");
        Articulo articulo = new Articulo("A1", 10, 10.0f, 5.0f, "Libro");
        Pedido pedido = new Pedido(1, 2, LocalDateTime.now(), cliente, articulo);

        float esperado = 5.0f * 2 + 10.0f;
        assertEquals(esperado, pedido.precioPedido(), 0.001);
    }

    @Test
    public void testPedidoCancelable() {
        Cliente cliente = new ClienteEstandar("Ana", "Calle 1", "12345678A", "ana@email.com");
        Articulo articulo = new Articulo("A1", 40, 10.0f, 5.0f, "Libro");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime hace30Min = now.minusMinutes(30);

        Pedido pedido = new Pedido(2, 1, hace30Min, cliente, articulo);
        assertTrue(pedido.cancelable());
    }
    
}
