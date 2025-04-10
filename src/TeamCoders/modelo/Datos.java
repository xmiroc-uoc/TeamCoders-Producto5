package modelo;

import java.util.*;

public class Datos{

    private static ArrayList<Articulo> articulos = new ArrayList<>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Pedido> pedidos = new ArrayList<>();


    public static ArrayList<Articulo> getArticulos(){
        return articulos;
    }

    public static ArrayList<Cliente> getClientes(){
        return clientes;
    }

    public static ArrayList<Pedido> getPedidos(){
        return pedidos;
    }

    public static void agregarArticulo(Articulo articulo) {
        articulos.add(articulo);
    }

    public static void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public static void eliminarPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }
}
