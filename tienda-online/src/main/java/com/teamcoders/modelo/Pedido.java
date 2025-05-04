package com.teamcoders.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int numeroPedido;

  private int unidades;

  @Column(name = "fecha_pedido")
  private LocalDateTime fechaPedido;

  @ManyToOne
  @JoinColumn(name = "cliente_email")
  private Cliente cliente;

  @ManyToOne
  @JoinColumn(name = "articulo_codigo")
  private Articulo articulo;

  protected Pedido() {
  }

  public Pedido(int numeroPedido, int unidades,
      LocalDateTime fechaPedido,
      Cliente cliente, Articulo articulo) {
    if (cliente == null || articulo == null || fechaPedido == null)
      throw new IllegalArgumentException("Cliente, artículo y fecha no pueden ser nulos.");
    if (unidades <= 0)
      throw new IllegalArgumentException("Unidades debe ser > 0.");

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

  public void setNumeroPedido(int n) {
    this.numeroPedido = n;
  }

  public void setUnidades(int u) {
    this.unidades = u;
  }

  public void setFechaPedido(LocalDateTime f) {
    this.fechaPedido = f;
  }

  public void setCliente(Cliente c) {
    this.cliente = c;
  }

  public void setArticulo(Articulo a) {
    this.articulo = a;
  }

  public boolean cancelable() {
    long minutos = java.time.Duration.between(fechaPedido, LocalDateTime.now()).toMinutes();
    return minutos < articulo.getTiempoPreparacion();
  }

  public double precioPedido() {
    double total = articulo.getPrecioVenta() * unidades;
    double descuento = cliente.descuentoEnvio();
    return total + (articulo.getGastosEnvio() * (1 - descuento));
  }

}
