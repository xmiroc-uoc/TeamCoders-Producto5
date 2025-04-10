package modelo;

import java.util.Date;

public class Pedido {
  private int numeroPedido;
  private int unidades;
  private Date fechaPedido;
  private Cliente cliente;
  private Articulo articulo;

  public Pedido(int numeroPedido, int unidades, Date fechaPedido, Cliente cliente, Articulo articulo) {
    this.numeroPedido = numeroPedido;
    this.unidades = unidades;
    this.fechaPedido = fechaPedido;
    this.cliente = cliente;
    this.articulo = articulo;
  }

  public int getNumeroPedido() {
    return numeroPedido;
  }

  public void setNumeroPedido(int numeroPedido) {
    this.numeroPedido = numeroPedido;
  }

  public int getUnidades() {
    return unidades;
  }

  public void setUnidades(int unidades) {
    this.unidades = unidades;
  }

  public Date getFechaPedido() {
    return fechaPedido;
  }

  public void setFechaPedido(Date fechaPedido) {
    this.fechaPedido = fechaPedido;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Articulo getArticulo() {
    return articulo;
  }

  public void setArticulo(Articulo articulo) {
    this.articulo = articulo;
  }

  public boolean cancelable() {
    long ahora = new Date().getTime();
    long pedido = fechaPedido.getTime();
    long prepEnMs = (long) articulo.getTiempoPreparacion() * 60_000;
    return (ahora - pedido) < prepEnMs;
  }

  public float precioPedido() {
    float totalArticulos = articulo.getPrecioVenta() * unidades;
    float desc = cliente.descuentoEnvio();
    float gastosEnvio = articulo.getGastosEnvio() * (1 - desc);
    return totalArticulos + gastosEnvio;
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
}
