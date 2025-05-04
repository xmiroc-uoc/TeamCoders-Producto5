package com.teamcoders.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Clase de utilidad para gestionar la fábrica de EntityManager de JPA.
 * 
 * <p>
 * Esta clase centraliza la creación de la instancia {@code EntityManagerFactory}
 * para toda la aplicación. Implementa el patrón Singleton para garantizar que
 * se utilice una única instancia, reduciendo el uso de recursos y evitando 
 * inconsistencias en el acceso a la base de datos.
 * </p>
 * 
 * <p>
 * El nombre de la unidad de persistencia debe coincidir con el definido en 
 * el archivo {@code persistence.xml}. En este caso, "tienda-online".
 * </p>
 * 
 * <p>
 * Se recomienda cerrar la fábrica utilizando {@link #close()} al finalizar
 * la aplicación para liberar correctamente los recursos.
 * </p>
 * 
 */
public class JpaUtil {

    /** 
     * Fábrica de gestores de entidades (EntityManagerFactory).
     */
    private static final EntityManagerFactory emf;

    // Bloque de inicialización estático
    static {
        try {
            emf = Persistence.createEntityManagerFactory("tienda-online");
        } catch (Throwable ex) {
            System.err.println("Inicialización de EntityManagerFactory fallida: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Devuelve la instancia única de {@code EntityManagerFactory}.
     * 
     * @return la fábrica de EntityManager que permite crear EntityManagers.
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    /**
     * Cierra la {@code EntityManagerFactory} liberando todos los recursos.
     * 
     * <p>
     * Este método debe invocarse al finalizar la aplicación o en una fase
     * de limpieza para evitar pérdidas de memoria o conexiones abiertas.
     * </p>
     */
    public static void cerrar() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
