package TeamCoders.modelo;

import java.util.*;

import javax.management.openmbean.CompositeDataInvocationHandler;


public class Datos {
    private List<Cliente> clientes;
    private List<Articulo> articulos;
    private List<Pedido> pedidos;
    
    public Datos() {
        this.clientes = new ArrayList<>();
        this.articulos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public void agregarArticulo(Articulo articulo) { 
        articulos.add(articulo); 
    }

    public void mostrarArticulos() {
        for (Articulo a : articulos) {
            System.out.println(a.toString());
        }
    }

    public void agregarCliente(Cliente cliente) { 
        clientes.add(cliente);
    }

    public void mostrarClientes() { 
        for (Cliente c : clientes) {
            System.out.println(c.toString());
        } 
    }

    public void mostrarClientesEstandar() {
        for (Cliente c : clientes) {
            if (c instanceof ClienteEstandar) {
                System.out.println(c.toString());
            }
        }
    }
    
    public void mostrarClientesPremium() {
        for (Cliente c : clientes) {
            if (c instanceof ClientePremium) {
                System.out.println(c.toString());
            }
        }
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido); 
    }

    public void eliminarPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public void mostrarPedidos() {
        for (Pedido p : pedidos) {
            System.out.println(p.toString());
        }
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }
    
    public List<Cliente> getClientes() {
        return clientes;
    }
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
