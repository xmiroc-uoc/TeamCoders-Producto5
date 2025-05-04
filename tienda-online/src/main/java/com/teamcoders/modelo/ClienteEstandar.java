package com.teamcoders.modelo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * Representa un cliente de tipo estándar.
 *
 * <p>
 * Hereda de la clase abstracta {@link Cliente} y no añade atributos adicionales.
 * Se identifica mediante el valor de discriminador {@code Estandar} en la tabla única de clientes.
 * </p>
 *
 * <p>
 * Esta clase se usa para diferenciar clientes estándar en operaciones como filtrado,
 * visualización y lógica de negocio específica.
 * </p>
 *
 */
@Entity
@DiscriminatorValue("Estandar") // coincide con ENUM('estandar', 'premium')
public class ClienteEstandar extends Cliente {

    /**
     * Constructor vacío requerido por JPA.
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
