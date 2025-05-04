package com.teamcoders.factory;

import com.teamcoders.dao.interfaces.IArticuloDAO;
import com.teamcoders.dao.interfaces.IClienteDAO;
import com.teamcoders.dao.interfaces.IPedidoDAO;

/**
 * Clase abstracta base para las fábricas de DAO (Data Access Object).
 * 
 * Esta clase define una interfaz para crear objetos DAO específicos según el tipo de persistencia
 * utilizada (por ejemplo, JPA o MySQL). El uso del patrón Factory permite desacoplar la lógica
 * de negocio del tipo de acceso a datos implementado.
 */
public abstract class DAOFactory {

    /** Constante que representa la implementación basada en MySQL. */
    public static final int MYSQL = 1;

    /** Constante que representa la implementación basada en JPA. */
    public static final int JPA = 2;

    /**
     * Devuelve una instancia del DAO para la entidad Cliente.
     *
     * @return una implementación de {@link IClienteDAO}.
     */
    public abstract IClienteDAO getClienteDAO();

    /**
     * Devuelve una instancia del DAO para la entidad Articulo.
     *
     * @return una implementación de {@link IArticuloDAO}.
     */
    public abstract IArticuloDAO getArticuloDAO();

    /**
     * Devuelve una instancia del DAO para la entidad Pedido.
     *
     * @return una implementación de {@link IPedidoDAO}.
     */
    public abstract IPedidoDAO getPedidoDAO();

    /**
     * Devuelve una instancia concreta de {@link DAOFactory} según el tipo solicitado.
     *
     * @param tipo el tipo de fábrica deseado (por ejemplo, {@link #MYSQL} o {@link #JPA}).
     * @return una subclase de {@link DAOFactory} correspondiente al tipo indicado.
     * @throws RuntimeException si el tipo especificado no está soportado.
     */
    public static DAOFactory getDAOFactory(int tipo) {
        switch (tipo) {
            case MYSQL:
                return new MySQLDAOFactory();
            case JPA:
                return new JPADAOFactory();
            default:
                // Podrías lanzar excepción o retornar null
                throw new RuntimeException("Tipo de DAOFactory no válido");
        }
    }
}
