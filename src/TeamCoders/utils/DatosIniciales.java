package utils;

import java.time.LocalDateTime;

import modelo.Articulo;
import modelo.Cliente;
import modelo.ClienteEstandar;
import modelo.ClientePremium;
import modelo.Datos;
import modelo.Pedido;

public class DatosIniciales {
    public static void cargar() {
        Cliente c1 = new ClienteEstandar("Ana", "Calle Falsa 123", "12345678A", "ana@email.com");
        Cliente c2 = new ClientePremium("Luis", "Avenida Real 456", "87654321B", "luis@email.com", 30);
        Datos.getClientes().add(c1);
        Datos.getClientes().add(c2);

        // Artículos
        Articulo a1 = new Articulo("A001", 30, 12.0, 1200.0, "Laptop");
        Articulo a2 = new Articulo("A002", 15, 15.0, 800.0, "Smartphone");
        Datos.getArticulos().add(a1);
        Datos.getArticulos().add(a2);

        // Pedidos
        Pedido p1 = new Pedido(1, 1, LocalDateTime.now().minusMinutes(10), c1, a1); // pendiente
        Pedido p2 = new Pedido(2, 2, LocalDateTime.now().minusMinutes(40), c2, a2); // enviado
        Datos.getPedidos().add(p1);
        Datos.getPedidos().add(p2);
    }
}
