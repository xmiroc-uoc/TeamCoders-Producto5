package modelo;

import java.util.*;

public class Datos{
    private ArrayList<Articulo> articulos = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();;
    private ArrayList<Pedido> pedidos = new ArrayList<>();;

    public Datos(){
        initialize();
    }

    public ArrayList<Articulo> getArticulos(){
        return articulos;
    }

    public ArrayList<Cliente> getClientes(){
        return clientes;
    }

    public ArrayList<Pedido> getPedidos(){
        return pedidos;
    }

    public void initialize(){
        //Articulos
        Articulo articulo1 = new Articulo("0001", 0, 12.5f, 50.0f, "Ejemplo Articulo 1");
        Articulo articulo2 = new Articulo("0002", 1, 5f, 15f, "Ejemplo Articulo 2");
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
        int count = 1;
        for (Articulo a : articulos){
            System.out.println(count + ". " + a.getDescripcion());
            count ++;
        }
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void mostrarClientes() {
        int count = 1;
        for (Cliente c : clientes){
            System.out.println(count + ". " + c.getNombre());
            count++;
        }
    }

    public void mostrarClientesEstandar(){
        int count = 1;
        for (Cliente c : clientes){
            if(c instanceof ClienteEstandar){
                System.out.println(count + ". " + c.getNombre());
                count++;
            }
        }
    }

    public void mostrarClientesPremium(){
        int count = 1;
        for (Cliente c : clientes){
            if(!(c instanceof ClienteEstandar)){
                System.out.println(count + ". " + c.getNombre());
                count++;
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
        int count = 1;
        for (Pedido p : pedidos){
            System.out.println(count + ". " + "Pedido #" + p.getNumeroPedido());
            count++;
        }
    }

    public void mostrarPedidosPendientes() {
        int count = 1;
        Calendar calendar = Calendar.getInstance();
        Date actualidad = new Date();
        for (Pedido p : pedidos){
            calendar.setTime(p.getFechaPedido());
            calendar.add(Calendar.MINUTE, p.getArticulo().getTiempoPreparacion());
            if(!calendar.getTime().before(actualidad)){
                System.out.println(count + ". " + "Pedido #" + p.getNumeroPedido());
                count++;
            }
        }
    }

    public void mostrarPedidosEnviados() {
        int count = 1;
        Calendar calendar = Calendar.getInstance();
        Date actualidad = new Date();
        for (Pedido p : pedidos){
            calendar.setTime(p.getFechaPedido());
            calendar.add(Calendar.MINUTE, p.getArticulo().getTiempoPreparacion());
            if(calendar.getTime().before(actualidad)){
                System.out.println(count + ". " + "Pedido #" + p.getNumeroPedido());
                count++;
            }
        }
    }
}