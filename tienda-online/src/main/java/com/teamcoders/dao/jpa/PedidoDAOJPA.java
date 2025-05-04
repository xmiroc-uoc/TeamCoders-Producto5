package com.teamcoders.dao.jpa;

import java.sql.SQLException;
import java.util.List;

import com.teamcoders.dao.IPedidoDAO;
import com.teamcoders.modelo.Pedido;
import com.teamcoders.utils.JpaUtil;

import jakarta.persistence.EntityManager;

/**
 * Implementación de la interfaz {@link PedidoDAO} utilizando JPA.
 * Permite realizar operaciones CRUD sobre entidades {@link Pedido} a través de JPA.
 */
public class PedidoDAOJPA implements IPedidoDAO {

   /**
     * Inserta un nuevo pedido en la base de datos.
     *
     * @param pedido el objeto {@link Pedido} a insertar.
     * @throws IllegalArgumentException si el pedido es nulo.
     * @throws jakarta.persistence.PersistenceException si ocurre un error durante la persistencia.
     */
    @Override
    public void crearPedido(Pedido pedido) throws SQLException {
      EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
      try {
         em.getTransaction().begin();
         em.persist(pedido);
         em.getTransaction().commit();
      } finally {
         if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
         }
         em.close();
      }
    }

   /**
     * Obtiene todos los pedidos registrados en la base de datos.
     *
     * @return una lista de objetos {@link Pedido}.
     * @throws jakarta.persistence.PersistenceException si ocurre un error durante la consulta.
     */
    @Override
    public List<Pedido> obtenerTodosLosPedidos() {
      EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
      try {
         return em.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
      } finally {
         em.close();
      }
    }

   /**
     * Busca un pedido por su número identificador.
     *
     * @param numeroPedido el identificador único del pedido.
     * @return el objeto {@link Pedido} correspondiente, o null si no se encuentra.
     * @throws jakarta.persistence.PersistenceException si ocurre un error durante la búsqueda.
     */
    @Override
    public Pedido buscarPedidoPorNumero(int numero) throws SQLException {
      EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
      try {
         return em.find(Pedido.class, numero);
      } finally {
         em.close();
      }
    }

   /**
     * Obtiene todos los pedidos que aún no han sido enviados.
     *
     * @return una lista de pedidos con campo {@code fechaEnvio} nulo.
     * @throws SQLException si ocurre un error durante la consulta.
     */
   @Override
   public List<Pedido> buscarPedidosPendientesEnvio() throws SQLException {
      EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
      try {
         return em.createQuery(
            "SELECT p FROM Pedido p WHERE p.fechaEnvio IS NULL", Pedido.class)
            .getResultList();
      } finally {
         em.close();
      }
   }

   /**
     * Obtiene todos los pedidos que ya han sido enviados.
     *
     * @return una lista de pedidos con campo {@code fechaEnvio} no nulo.
     * @throws SQLException si ocurre un error durante la consulta.
     */
   @Override
   public List<Pedido> buscarPedidosEnviados() throws SQLException {
      EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
      try {
         return em.createQuery(
            "SELECT p FROM Pedido p WHERE p.fechaEnvio IS NOT NULL", Pedido.class)
            .getResultList();
      } finally {
         em.close();
      }
   }

   /**
     * Actualiza un pedido existente en la base de datos.
     *
     * @param pedido el objeto {@link Pedido} con los datos actualizados.
     * @throws IllegalArgumentException si el pedido es nulo.
     * @throws jakarta.persistence.PersistenceException si ocurre un error durante la actualización.
     */
   @Override
   public void actualizarPedido(Pedido pedido) throws SQLException {
      EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
      try {
         em.getTransaction().begin();
         em.merge(pedido);
         em.getTransaction().commit();
      } finally {
         if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
         }
         em.close();
      }
   }

   /**
     * Elimina un pedido de la base de datos según su identificador.
     *
     * @param numeroPedido el identificador único del pedido a eliminar.
     * @throws jakarta.persistence.PersistenceException si ocurre un error durante la operación.
     */
   @Override
   public void borrarPedido(int numero) throws SQLException {
      EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
      try {
         Pedido pedido = em.find(Pedido.class, numero);
         if (pedido != null) {
            em.getTransaction().begin();
            em.remove(pedido);
            em.getTransaction().commit();
         }
      } finally {
         if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
         }
         em.close();
      }
   }
}
