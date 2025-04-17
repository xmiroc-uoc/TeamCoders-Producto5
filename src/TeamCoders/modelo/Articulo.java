package TeamCoders.modelo;

public class Articulo {
  private String codigo;
  private String descripcion;
  private float precioVenta;
  private float gastosEnvio;
  private int tiempoPreparacion; // minutos

  public Articulo() {
  }

  public Articulo(String codigo, int tiempoPreparacion, float gastosEnvio,
      float precioVenta, String descripcion) {
    this.codigo = codigo;
    this.tiempoPreparacion = tiempoPreparacion;
    this.gastosEnvio = gastosEnvio;
    this.precioVenta = precioVenta;
    this.descripcion = descripcion;
  }

  /*--------- getters ----------*/
  public String getCodigo() {
    return codigo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public float getPrecioVenta() {
    return precioVenta;
  }

  public float getGastosEnvio() {
    return gastosEnvio;
  }

  public int getTiempoPreparacion() {
    return tiempoPreparacion;
  }

  /*--------- setters ----------*/
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public void setPrecioVenta(float precioVenta) {
    this.precioVenta = precioVenta;
  }

  public void setGastosEnvio(float gastosEnvio) {
    this.gastosEnvio = gastosEnvio;
  }

  public void setTiempoPreparacion(int tiempoPreparacion) {
    this.tiempoPreparacion = tiempoPreparacion;
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
