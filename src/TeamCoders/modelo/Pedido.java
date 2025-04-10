package modelo;

import java.time.LocalDateTime;

public class Pedido {
    private int numeroPedido;
    private int unidades;
    private LocalDateTime fechaPedido;
    private Cliente cliente;
    private Articulo articulo;

    public Pedido(int numeroPedido, int unidades, LocalDateTime fechaPedido, Cliente cliente, Articulo articulo) {
        this.numeroPedido = numeroPedido;
        this.unidades = unidades;
        this.fechaPedido = fechaPedido;
        this.cliente = cliente;
        this.articulo = articulo;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public int getUnidades() {
        return unidades;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numeroPedido=" + numeroPedido +
                ", unidades=" + unidades +
                ", fechaPedido=" + fechaPedido +
                ", cliente=" + cliente +
                ", articulo=" + articulo +
                '}';
    }

    public boolean cancelable() {
        long minutosTranscurridos = java.time.Duration.between(fechaPedido, LocalDateTime.now()).toMinutes();
        return minutosTranscurridos < articulo.getTiempoPreparacion();
    }

    public double precioPedido() {
        double total = articulo.getPrecioVenta() * unidades;
        double descuento = cliente.descuentoEnvio();
        return total + (articulo.getGastosEnvio() * (1 - descuento));
    }
}
