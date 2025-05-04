package com.teamcoders.modelo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("estandar")
public class ClienteEstandar extends Cliente {

  protected ClienteEstandar() {
  }

  public ClienteEstandar(String nombre, String domicilio,
      String nif, String email) {
    super(nombre, domicilio, nif, email);
  }

  @Override
  public float descuentoEnvio() {
    return 0.0f;
  }

  @Override
  public String toString() {
    return "ClienteEstandar: " + super.toString();
  }
}
