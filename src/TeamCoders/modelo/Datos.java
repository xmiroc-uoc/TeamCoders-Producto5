package modelo;

import java.util.*;

/**
* Clase de utilidad que almacena los datos en memoria para la tienda online.
* Administra listas estáticas de artículos, clientes y pedidos.
*/
public class Datos{

    // Listas que actúan como "base de datos" en memoria
    private static ArrayList<Articulo> articulos = new ArrayList<>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Pedido> pedidos = new ArrayList<>();

    /**
     * Devuelve la lista actual de artículos.
     * @return lista de artículos
     */
    public static ArrayList<Articulo> getArticulos(){
        return articulos;
    }

    /**
     * Devuelve la lista actual de clientes.
     * @return lista de clientes
     */
    public static ArrayList<Cliente> getClientes(){
        return clientes;
    }

    /**
     * Devuelve la lista actual de pedidos.
     * @return lista de pedidos
     */
    public static ArrayList<Pedido> getPedidos(){
        return pedidos;
    }

    /**
     * Agrega un artículo a la lista de artículos.
     * @param articulo el artículo a agregar
     */
    public static void agregarArticulo(Articulo articulo) {
        articulos.add(articulo);
    }

    /**
     * Agrega un cliente a la lista de clientes.
     * @param cliente el cliente a agregar
     */
    public static void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    /**
     * Agrega un pedido a la lista de pedidos.
     * @param pedido el pedido a agregar
     */
    public static void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    /**
     * Elimina un pedido de la lista de pedidos.
     * @param pedido el pedido a eliminar
     */
    public static void eliminarPedido(Pedido pedido) {
        pedidos.remove(pedido); // Elimina el objeto si existe en la lista
    }
}
