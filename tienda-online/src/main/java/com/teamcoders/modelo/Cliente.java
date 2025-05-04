package com.teamcoders.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Cliente {

  @Id // PK → el email
  @Column(length = 120)
  private String email;

  @Column(nullable = false)
  private String nombre;

  @Column(nullable = false)
  private String domicilio;

  @Column(nullable = false, length = 15)
  private String nif;

  protected Cliente() {
  }

  public String getEmail() {
    return email;
  }

  public String getNombre() {
    return nombre;
  }

  public String getDomicilio() {
    return domicilio;
  }

  public String getNif() {
    return nif;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
  }

  public void setNif(String nif) {
    this.nif = nif;
  }

  public Cliente(String nombre, String domicilio, String nif, String email) {
    validarCadena(nombre, "Nombre");
    validarCadena(domicilio, "Domicilio");
    validarCadena(nif, "NIF");
    validarCadena(email, "Email");

    this.nombre = nombre;
    this.domicilio = domicilio;
    this.nif = nif;
    this.email = email;
  }

  public abstract float descuentoEnvio();

  @Override
  public String toString() {
    return "Cliente{" +
        "nombre='" + nombre + '\'' +
        ", domicilio='" + domicilio + '\'' +
        ", nif='" + nif + '\'' +
        ", email='" + email + '\'' +
        '}';
  }

  private void validarCadena(String valor, String campo) {
    if (valor == null || valor.isBlank()) {
      throw new IllegalArgumentException(campo + " no puede estar vacío.");
    }
  }
}
