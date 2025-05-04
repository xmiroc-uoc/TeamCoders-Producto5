package com.teamcoders.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("premium")
public class ClientePremium extends Cliente {

  @Column(name = "cuota_anual")
  private int cuotaAnual;

  protected ClientePremium() {
  }

  public ClientePremium(String nombre, String domicilio,
      String nif, String email, int cuotaAnual) {
    super(nombre, domicilio, nif, email);
    this.cuotaAnual = cuotaAnual;
  }

  public int getCuotaAnual() {
    return cuotaAnual;
  }

  public void setCuotaAnual(int cuota) {
    this.cuotaAnual = cuota;
  }

  @Override
  public float descuentoEnvio() {
    return 0.20f;
  }

  @Override
  public String toString() {
    return "ClientePremium: " + super.toString() +
        " [cuotaAnual=" + cuotaAnual + "]";
  }
}
