package com.teamcoders.dao.jpa;

import java.sql.SQLException;
import java.util.List;

import com.teamcoders.dao.IArticuloDAO;
import com.teamcoders.modelo.Articulo;
import com.teamcoders.utils.JpaUtil;


import jakarta.persistence.EntityManager;

public class ArticuloDAOJPA implements IArticuloDAO {
     @Override
    public List<Articulo> obtenerTodosLosArticulos() {
         EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
         try {
               return em.createQuery("SELECT a FROM Articulo a", Articulo.class).getResultList();
         } finally {
               em.close();
         }
    }

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

     @Override
     public Articulo buscarArticuloPorCodigo(String codigo) throws SQLException {
         EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
         try {
            return em.find(Articulo.class, codigo);
         } finally {
            em.close();
         }
     }

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
