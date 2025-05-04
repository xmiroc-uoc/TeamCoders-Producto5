package com.teamcoders.modelo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * Cliente estándar sin descuento en el envío.
 */
@Entity
@DiscriminatorValue("Estandar") // coincide con ENUM('estandar', 'premium')
public class ClienteEstandar extends Cliente {

    /**
     * Constructor sin argumentos (obligatorio para JPA)
     */
    public ClienteEstandar() {
    }

    /**
     * Constructor para cliente estándar.
     * 
     * @param nombre    Nombre del cliente.
     * @param domicilio Dirección del cliente.
     * @param nif       Número de identificación fiscal.
     * @param email     Correo electrónico del cliente.
     */
    public ClienteEstandar(String nombre, String domicilio, String nif, String email) {
        super(nombre, domicilio, nif, email);
    }

    /**
     * No aplica descuento.
     * 
     * @return 0.0 como descuento en el envío.
     */
    @Override
    public float descuentoEnvio() {

        return 0.0f;
    }

    /**
     * Devuelve una representación textual del cliente estándar.
     * 
     * @return String con los datos del cliente estándar.
     */
    @Override
    public String toString() {
        return "Cliente Estandar: " + super.toString();
    }
}
