package com.teamcoders.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

/**
 * Clase abstracta que representa un cliente de la tienda online.
 * Contiene atributos comunes a todos los tipos de clientes y un método
 * abstracto
 * para calcular el descuento en el envío.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@Table(name = "clientes")
public abstract class Cliente {

    @Id
    @Column(name = "dni")
    private String email;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String domicilio;

    @Column(name = "email")
    private String nif;

    /**
     * Constructor sin argumentos (obligatorio para JPA)
     */
    public Cliente() {
    }

    /**
     * Constructor para inicializar un cliente.
     * 
     * @param email     Correo electrónico del cliente.
     * @param nombre    Nombre del cliente.
     * @param domicilio Dirección del cliente.
     * @param nif       Número de identificación fiscal.
     */
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

    // Métodos getter

    /**
     * Obtiene el correo electrónico del cliente.
     * 
     * @return email del cliente
     */
    public String getEmail() {
        return email;
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

    // Métodos setter

    /**
     * Establece el correo electrónico del cliente.
     * 
     * @param email nuevo email del cliente
     */
    public void setEmail(String email) {
        this.email = email;
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
     * Método abstracto que debe devolver el porcentaje de descuento en los gastos
     * de envío.
     * Debe ser implementado por cada tipo de cliente (estándar o premium).
     *
     * @return Descuento en forma decimal (por ejemplo, 0.20 para 20%).
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

    /**
     * Valida que una cadena no sea nula ni vacía.
     *
     * @param valor Valor a validar.
     * @param campo Nombre del campo (para mensaje de error).
     * @throws IllegalArgumentException si el valor es nulo o vacío.
     */
    private void validarCadena(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío.");
        }
    }
}
