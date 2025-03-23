package modelo;

import java.util.*;

public class Datos{
    private List<Articulo> articulos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();;
    private List<Pedido> pedidos = new ArrayList<>();;

    public Datos(){
        initialize();
    }

    public void initialize(){
        //Articulos
        Articulo articulo1 = new Articulo("0001", 30, 12.5f, 50.0f, "Ejemplo Articulo 1");
        Articulo articulo2 = new Articulo("0002", 10, 5f, 15f, "Ejemplo Articulo 2");
        Articulo articulo3 = new Articulo("0003", 20, 9.99f, 23.5f, "Ejemplo Articulo 3");

        articulos.add(articulo1);
        articulos.add(articulo2);
        articulos.add(articulo3);

        //Clientes
        Cliente cliente1 = new ClienteEstandar("Nombre1", "Calle de la piruleta", "3938123123", "ejemplo1@ejemplo");
        Cliente cliente2 = new ClientePremium("Nombre2", "Calle falsa", "3938234234", "ejemplo2@ejemplo", 50);

        clientes.add(cliente1);
        clientes.add(cliente2);

        //Pedidos
        Date fecha = new Date();
        Pedido pedido1 = new Pedido(1, 2, fecha, cliente1, articulo1);
        Pedido pedido2 = new Pedido(2, 5, fecha, cliente2, articulo3);
        Pedido pedido3 = new Pedido(3, 3, fecha, cliente2, articulo2);

        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);
    }

    public void agregarArticulo(Articulo articulo) {
        articulos.add(articulo);
    }

    public void mostrarArticulo() {
        for (Articulo a : articulos){
            System.out.println(a.getDescripcion());
        }
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void mostrarClientes() {
        for (Cliente c : clientes){
            System.out.println(c.getNombre());
        }
    }

    public void mostrarClientesEstandar(){
        for (Cliente c : clientes){
            if(c instanceof ClienteEstandar){
                System.out.println(c.getNombre());
            }
        }
    }

    public void mostrarClientesPremium(){
        for (Cliente c : clientes){
            if(!(c instanceof ClienteEstandar)){
                System.out.println(c.getNombre());
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
        for (Pedido p : pedidos){
            System.out.println("Pedido #" + p.getNumeroPedido());
        }
    }
}