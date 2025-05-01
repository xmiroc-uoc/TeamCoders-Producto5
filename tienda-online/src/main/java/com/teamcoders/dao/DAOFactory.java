package com.teamcoders.dao;

/**
 * Clase abstracta base para las fábricas de DAO.
 * Permite desacoplar la lógica del sistema del tipo de base de datos utilizada.
 */
public abstract class DAOFactory {
    // Podrías tener distintos tipos, p.ej. MYSQL, MEMORIA, etc.
    public static final int MYSQL = 1;

    /**
     * Obtiene un DAO específico para Cliente.
     * 
     * @return IClienteDAO
     */
    public abstract IClienteDAO getClienteDAO();

    /**
     * Obtiene un DAO específico para Artículo.
     * 
     * @return IArticuloDAO
     */
    public abstract IArticuloDAO getArticuloDAO();

    /**
     * Obtiene un DAO específico para Pedido.
     * 
     * @return IPedidoDAO
     */
    public abstract IPedidoDAO getPedidoDAO();

    /**
     * Devuelve una instancia concreta de la fábrica según el tipo solicitado.
     * 
     * @param tipo Tipo de DAOFactory (ej: MYSQL).
     * @return Instancia de DAOFactory concreta.
     */
    public static DAOFactory getDAOFactory(int tipo) {
        switch (tipo) {
            case MYSQL:
                return new MySQLDAOFactory();
            default:
                // Podrías lanzar excepción o retornar null
                throw new RuntimeException("Tipo de DAOFactory no válido");
        }
    }
}
