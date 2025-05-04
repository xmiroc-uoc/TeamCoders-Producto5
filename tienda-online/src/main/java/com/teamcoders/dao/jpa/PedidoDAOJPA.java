package com.teamcoders.dao.jpa;

import java.sql.SQLException;
import java.util.List;

import com.teamcoders.dao.IPedidoDAO;
import com.teamcoders.modelo.Pedido;
import com.teamcoders.utils.JpaUtil;

import jakarta.persistence.EntityManager;

public class PedidoDAOJPA implements IPedidoDAO {
     @Override
    public List<Pedido> obtenerTodosLosPedidos() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
        } finally {
            em.close();
        }
    }

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

     @Override
     public Pedido buscarPedidoPorNumero(int numero) throws SQLException {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
         try {
            return em.find(Pedido.class, numero);
         } finally {
            em.close();
         }
     }

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
}
