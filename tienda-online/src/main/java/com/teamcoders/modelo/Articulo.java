package com.teamcoders.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa un artículo que puede ser adquirido por un cliente en la tienda online.
 */
@Entity
@Table(name = "articulos")
public class Articulo {
    @Id
    @Column(name = "codigo")
    private String codigo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_venta")
    private double precioVenta;

    @Column(name = "gastos_envio")
    private double gastosEnvio;

    @Column(name = "tiempo_preparacion")
    private int tiempoPreparacion;

    /**
     * Constructor sin argumentos (obligatorio para JPA)
     */
    public Articulo() {
    }

    /**
     * Constructor para crear un artículo.
     * 
     * @param codigo            Código único del artículo.
     * @param tiempoPreparacion Tiempo necesario para preparar el artículo (en
     *                          minutos).
     * @param gastosEnvio       Coste de envío del artículo.
     * @param precioVenta       Precio de venta del artículo.
     * @param descripcion       Descripción del artículo.
     */
    public Articulo(String codigo, int tiempoPreparacion, double gastosEnvio, double precioVenta, String descripcion) {
        this.codigo = codigo;
        this.tiempoPreparacion = tiempoPreparacion;
        this.gastosEnvio = gastosEnvio;
        this.precioVenta = precioVenta;
        this.descripcion = descripcion;

    }

    /**
     * Devuelve el código del artículo.
     * 
     * @return Código del artículo.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Devuelve la descripción del artículo.
     * 
     * @return Descripción del artículo.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Devuelve el precio de venta del artículo.
     * 
     * @return Precio de venta.
     */
    public double getPrecioVenta() {
        return precioVenta;
    }

    /**
     * Devuelve los gastos de envío del artículo.
     * 
     * @return Gastos de envío.
     */
    public double getGastosEnvio() {
        return gastosEnvio;
    }

    /**
     * Devuelve el tiempo de preparación del artículo en minutos.
     * 
     * @return Tiempo de preparación.
     */
    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    /**
     * Establece el código del artículo.
     * 
     * @param codigo Nuevo código del artículo.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Establece la descripción del artículo.
     * 
     * @param descripcion Nueva descripción.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Establece el precio de venta del artículo.
     * 
     * @param precioVenta Nuevo precio.
     */
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * Establece los gastos de envío del artículo.
     * 
     * @param gastosEnvio Nuevos gastos de envío.
     */
    public void setGastosEnvio(double gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    /**
     * Establece el tiempo de preparación en minutos.
     * 
     * @param tiempoPreparacion Nuevo tiempo de preparación.
     */
    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    /**
     * Devuelve una representación textual del artículo.
     * 
     * @return String con los datos del artículo.
     */
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
