package com.teamcoders.dao.jpa;

import java.sql.SQLException;
import java.util.List;

import com.teamcoders.dao.interfaces.IArticuloDAO;
import com.teamcoders.modelo.Articulo;
import com.teamcoders.utils.JpaUtil;

import jakarta.persistence.EntityManager;

/**
 * Implementación de la interfaz {@link ArticuloDAO} utilizando JPA.
 * Proporciona operaciones de acceso a datos para la entidad {@link Articulo}
 * mediante el uso de EntityManager y transacciones gestionadas.
 */
public class ArticuloDAOJPA implements IArticuloDAO {

   /**
     * Añade un nuevo artículo a la base de datos.
     *
     * @param articulo el artículo que se desea insertar.
     * @throws IllegalArgumentException si el artículo es nulo.
     * @throws jakarta.persistence.PersistenceException si ocurre un error durante la transacción.
     */
   @Override
   public void crearArticulo(Articulo articulo) throws SQLException {
      EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
      try {
         em.getTransaction().begin();
         em.persist(articulo);
         em.getTransaction().commit();
      } finally {
         if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
         }
         em.close();
      }
   }

   /**
     * Obtiene una lista con todos los artículos almacenados en la base de datos.
     *
     * @return una lista de artículos.
     * @throws jakarta.persistence.PersistenceException si ocurre un error durante la consulta.
     */
   @Override
   public List<Articulo> obtenerTodosLosArticulos() {
      EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
      try {
            return em.createQuery("SELECT a FROM Articulo a", Articulo.class).getResultList();
      } finally {
            em.close();
      }
    }

   /**
     * Busca un artículo específico dado su código.
     *
     * @param codigo el código identificador del artículo a buscar.
     * @return el objeto {@link Articulo} correspondiente, o null si no se encuentra.
     * @throws jakarta.persistence.PersistenceException si ocurre un error durante la consulta.
     */
   @Override
   public Articulo buscarArticuloPorCodigo(String codigo) throws SQLException {
      EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
      try {
         return em.find(Articulo.class, codigo);
      } finally {
         em.close();
      }
   }

   /**
     * Actualiza los datos de un artículo existente en la base de datos.
     *
     * @param articulo el objeto artículo con los datos actualizados.
     * @throws IllegalArgumentException si el artículo es nulo o no existe.
     * @throws jakarta.persistence.PersistenceException si ocurre un error al actualizar.
     */
   @Override
   public void actualizarArticulo(Articulo articulo) throws SQLException {
      EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
      try {
         em.getTransaction().begin();
         em.merge(articulo);
         em.getTransaction().commit();
      } finally {
         if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
         }
         em.close();
      }
   }

   /**
     * Elimina un artículo de la base de datos dado su código identificador.
     *
     * @param codigo el identificador único del artículo a eliminar.
     * @throws jakarta.persistence.PersistenceException si ocurre un error al eliminar el artículo.
     */
   @Override
   public void borrarArticulo(String codigo) throws SQLException {
      EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
      try {
         Articulo articulo = em.find(Articulo.class, codigo);
         if (articulo != null) {
            em.getTransaction().begin();
            em.remove(articulo);
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
