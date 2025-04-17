package TeamCoders.modelo;

import java.util.Date;

public class Pedido {
  private int numeroPedido;
  private int unidades;
  private Date fechaPedido;
  private Cliente cliente;
  private Articulo articulo;

  public Pedido() {
  }

  public Pedido(int numeroPedido, int unidades, Date fechaPedido, Cliente cliente, Articulo articulo) {
    this.numeroPedido = numeroPedido;
    this.unidades = unidades;
    this.fechaPedido = fechaPedido;
    this.cliente = cliente;
    this.articulo = articulo;
  }

  /*---- getters ----*/
  public int getNumeroPedido() {
    return numeroPedido;
  }

  public int getUnidades() {
    return unidades;
  }

  public Date getFechaPedido() {
    return fechaPedido;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public Articulo getArticulo() {
    return articulo;
  }

  /*---- setters ----*/
  public void setNumeroPedido(int numeroPedido) {
    this.numeroPedido = numeroPedido;
  }

  public void setUnidades(int unidades) {
    this.unidades = unidades;
  }

  public void setFechaPedido(Date fechaPedido) {
    this.fechaPedido = fechaPedido;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public void setArticulo(Articulo articulo) {
    this.articulo = articulo;
  }

  /*---- lógica ----*/
  public boolean cancelable() {
    long msPrep = (long) articulo.getTiempoPreparacion() * 60_000L;
    return System.currentTimeMillis() - fechaPedido.getTime() < msPrep;
  }

  public float precioPedido() {
    float base = articulo.getPrecioVenta() * unidades;
    float envio = articulo.getGastosEnvio() * (1 - cliente.descuentoEnvio());
    return base + envio;
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
