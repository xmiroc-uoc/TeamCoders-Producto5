package TeamCoders.controlador;

import java.util.List;

import TeamCoders.modelo.*;

public class TiendaController {
    
    private Datos datosTienda;

    public TiendaController() {
        datosTienda = new Datos();
    }

    public void agregarCliente(Cliente cliente) {
        datosTienda.agregarCliente(cliente);
    }

    public void mostrarClientes() {
        datosTienda.mostrarClientes();
    }

    public void mostrarClientesEstandar() {
        datosTienda.mostrarClientesEstandar();
    }

    public void mostrarClientesPremium() {
        datosTienda.mostrarClientesPremium();
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

    public List<Articulo> getArticulos() {
        return datosTienda.getArticulos();
    }

    public List<Cliente> getClientes() {
        return datosTienda.getClientes();
    }

    public List<Pedido> getPedidos() {
        return datosTienda.getPedidos();
    }
}