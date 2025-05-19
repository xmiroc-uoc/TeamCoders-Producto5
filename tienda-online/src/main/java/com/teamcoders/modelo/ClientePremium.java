package com.teamcoders.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * Representa un cliente de tipo premium en la tienda online.
 *
 * <p>
 * Esta clase extiende de {@link Cliente} y añade un atributo adicional
 * {@code cuotaAnual},
 * que representa la tarifa anual asociada a los beneficios premium del cliente.
 * Se identifica mediante el valor de discriminador {@code Premium} en la tabla
 * de herencia JPA.
 * </p>
 *
 * <p>
 * Se utiliza para distinguir clientes con ventajas especiales y permite aplicar
 * lógica
 * diferenciada en procesos de facturación, fidelización o análisis de clientes.
 * </p>
 *
 */
@Entity
@DiscriminatorValue("premium")
public class ClientePremium extends Cliente {

  @Column(name = "cuota_anual")
  private int cuotaAnual;

  /**
   * Constructor vacío requerido por JPA.
   */
  public ClientePremium() {
  }

  /**
   * Constructor para cliente premium.
   *
   * @param nombre     Nombre del cliente.
   * @param domicilio  Dirección del cliente.
   * @param nif        Número de identificación fiscal.
   * @param email      Correo electrónico del cliente.
   * @param cuotaAnual Cuota anual en euros.
   */
  public ClientePremium(String nombre, String domicilio, String nif, String email, int cuotaAnual) {
    super(nombre, domicilio, nif, email);
    this.cuotaAnual = cuotaAnual;
  }

  /**
   * Obtiene la cuota anual del cliente premium.
   *
   * @return cuota anual en euros.
   */
  public int getCuotaAnual() {
    return cuotaAnual;
  }

  /**
   * Establece la cuota anual del cliente premium.
   *
   * @param cuotaAnual nueva cuota anual.
   */
  public void setCuotaAnual(int cuotaAnual) {
    this.cuotaAnual = cuotaAnual;
  }

  /**
   * Devuelve un descuento fijo del 20% en los gastos de envío.
   *
   * @return 0.20 como descuento.
   */
  @Override
  public float descuentoEnvio() {
    return 0.20f;
  }

  /**
   * Devuelve una representación textual del cliente premium.
   *
   * @return String con los datos del cliente premium.
   */
  @Override
  public String toString() {
    return "ClientePremium: " + super.toString() + " [cuotaAnual=" + cuotaAnual + "]";
  }
}
