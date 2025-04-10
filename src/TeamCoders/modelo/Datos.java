
package TeamCoders.modelo;

import java.util.ArrayList;

public class Datos {
    private ArrayList<Cliente> clientes;
    private ArrayList<Articulo> articulos;
    private ArrayList<Pedido> pedidos;

    public Datos() {
        clientes = new ArrayList<>();
        articulos = new ArrayList<>();
        pedidos = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}
