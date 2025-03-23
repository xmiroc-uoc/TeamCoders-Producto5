package TeamCoders.controlador;

import TeamCoders.modelo.*;

public class TiendaController {
    
    private Datos datosTienda;

    public TiendaController(Datos datosTienda) {
        datosTienda = new Datos();
    }

    public void agregarCliente(Cliente cliente) {
        datosTienda.agregarCliente(cliente);
    }

    public void mostrarClientes() {
        datosTienda.mostrarClientes();
    }

    public void agregarArticulo(Articulo articulo) {
        datosTienda.agregarArticulo(articulo);
    }

    public void mostrarArticulos() {
        datosTienda.mostrarArticulos();
    }

    public void agregarPedido(Pedido pedido) {
        datosTienda.agregarPedido(pedido);
    }

    public void eliminarPedido(Pedido pedido) {
        datosTienda.eliminarPedido(pedido);
    }

    public void mostrarPedidos() {
        datosTienda.mostrarPedidos();
    }
}