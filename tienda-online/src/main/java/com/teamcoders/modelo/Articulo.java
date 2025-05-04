package com.teamcoders.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "articulos")
public class Articulo {

  @Id
  @Column(length = 10)
  private String codigo;

  @Column(nullable = false)
  private String descripcion;

  @Column(name = "precio_venta")
  private double precioVenta;

  @Column(name = "gastos_envio")
  private double gastosEnvio;

  @Column(name = "tiempo_preparacion")
  private int tiempoPreparacion;

  protected Articulo() {
  }

  public Articulo(String codigo, int tiempoPreparacion,
      double gastosEnvio, double precioVenta, String descripcion) {
    this.codigo = codigo;
    this.tiempoPreparacion = tiempoPreparacion;
    this.gastosEnvio = gastosEnvio;
    this.precioVenta = precioVenta;
    this.descripcion = descripcion;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String d) {
    this.descripcion = d;
  }

  public double getPrecioVenta() {
    return precioVenta;
  }

  public void setPrecioVenta(double p) {
    this.precioVenta = p;
  }

  public double getGastosEnvio() {
    return gastosEnvio;
  }

  public void setGastosEnvio(double g) {
    this.gastosEnvio = g;
  }

  public int getTiempoPreparacion() {
    return tiempoPreparacion;
  }

  public void setTiempoPreparacion(int t) {
    this.tiempoPreparacion = t;
  }

  @Override
  public String toString() {
    return "Articulo{" +
        "codigo='" + codigo + '\'' +
        ", descripcion='" + descripcion + '\'' +
        ", precioVenta=" + precioVenta +
        ", gastosEnvio=" + gastosEnvio +
        ", tiempoPreparacion=" + tiempoPreparacion +
        '}';
  }
}
