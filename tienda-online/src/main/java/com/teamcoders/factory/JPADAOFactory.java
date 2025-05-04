package com.teamcoders.factory;

import com.teamcoders.dao.interfaces.IArticuloDAO;
import com.teamcoders.dao.interfaces.IClienteDAO;
import com.teamcoders.dao.interfaces.IPedidoDAO;
import com.teamcoders.dao.jpa.ArticuloDAOJPA;
import com.teamcoders.dao.jpa.ClienteDAOJPA;
import com.teamcoders.dao.jpa.PedidoDAOJPA;

/**
 * Implementación concreta de {@link DAOFactory} que utiliza JPA para el acceso a datos.
 *
 * Esta clase devuelve instancias específicas de DAOs implementadas mediante JPA,
 * permitiendo a la lógica de negocio operar independientemente del mecanismo de persistencia.
 */
public class JPADAOFactory extends DAOFactory {

    /**
     * Devuelve una instancia de {@link ClienteDAOJPA}.
     *
     * @return un DAO JPA para la entidad Cliente.
     */
    @Override
    public IClienteDAO getClienteDAO() {
        return new ClienteDAOJPA();
    }

    /**
     * Devuelve una instancia de {@link ArticuloDAOJPA}.
     *
     * @return un DAO JPA para la entidad Articulo.
     */
    @Override
    public IArticuloDAO getArticuloDAO() {
        return new ArticuloDAOJPA();
    }

    /**
     * Devuelve una instancia de {@link PedidoDAOJPA}.
     *
     * @return un DAO JPA para la entidad Pedido.
     */
    @Override
    public IPedidoDAO getPedidoDAO() {
        return new PedidoDAOJPA();
    }
}
