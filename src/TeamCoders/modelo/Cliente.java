package modelo;

/**
 * Clase abstracta que representa un cliente de la tienda online.
 * Contiene atributos comunes a todos los tipos de clientes y un método
 * abstracto
 * para calcular el descuento en el envío.
 */
public abstract class Cliente {
  private String nombre;
  private String domicilio;
  private String nif;
  private String email;

  /**
   * Constructor para inicializar un cliente.
   * 
   * @param nombre    Nombre del cliente.
   * @param domicilio Dirección del cliente.
   * @param nif       Número de identificación fiscal.
   * @param email     Correo electrónico del cliente.
   */
  public Cliente(String nombre, String domicilio, String nif, String email) {
    this.nombre = nombre;
    this.domicilio = domicilio;
    this.nif = nif;
    this.email = email;
  }

  /**
   * Obtiene el nombre del cliente.
   * 
   * @return nombre del cliente
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Obtiene el domicilio del cliente.
   * 
   * @return domicilio del cliente
   */
  public String getDomicilio() {
    return domicilio;
  }

  /**
   * Obtiene el NIF del cliente.
   * 
   * @return NIF del cliente
   */
  public String getNif() {
    return nif;
  }

  /**
   * Obtiene el correo electrónico del cliente.
   * 
   * @return email del cliente
   */
  public String getEmail() {
    return email;
  }

  /**
   * Establece el nombre del cliente.
   * 
   * @param nombre nuevo nombre del cliente
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Establece el domicilio del cliente.
   * 
   * @param domicilio nuevo domicilio del cliente
   */
  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
  }

  /**
   * Establece el NIF del cliente.
   * 
   * @param nif nuevo NIF del cliente
   */
  public void setNif(String nif) {
    this.nif = nif;
  }

  /**
   * Establece el correo electrónico del cliente.
   * 
   * @param email nuevo email del cliente
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Método abstracto que devuelve el porcentaje de descuento en el envío.
   * Cada tipo de cliente (estándar o premium) implementa su propio valor.
   * 
   * @return Porcentaje de descuento como decimal (ej. 0.20 para 20%).
   */
  public abstract float descuentoEnvio();

  /**
   * Devuelve una representación en cadena del cliente.
   * 
   * @return String con los datos del cliente
   */
  @Override
  public String toString() {

    return "Cliente{" +
        "nombre='" + nombre + '\'' +
        ", domicilio='" + domicilio + '\'' +
        ", nif='" + nif + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
