package com.teamcoders.dao.jpa;

import com.teamcoders.dao.IArticuloDAO;
import com.teamcoders.dao.util.JPAUtil;
import com.teamcoders.modelo.Articulo;
import jakarta.persistence.EntityManager;

import java.sql.SQLException;
import java.util.List;

public class ArticuloDAOJPA implements IArticuloDAO {

  @Override
  public void crearArticulo(Articulo articulo) throws SQLException {
    EntityManager em = JPAUtil.getEntityManager();
    em.getTransaction().begin();
    em.persist(articulo);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public Articulo buscarArticuloPorCodigo(String codigo) throws SQLException {
    EntityManager em = JPAUtil.getEntityManager();
    Articulo a = em.find(Articulo.class, codigo);
    em.close();
    return a;
  }

  @Override
  public List<Articulo> obtenerTodosLosArticulos() throws SQLException {
    EntityManager em = JPAUtil.getEntityManager();
    List<Articulo> lista = em.createQuery("FROM Articulo", Articulo.class).getResultList();
    em.close();
    return lista;
  }

  @Override
  public void actualizarArticulo(Articulo articulo) throws SQLException {
    EntityManager em = JPAUtil.getEntityManager();
    em.getTransaction().begin();
    em.merge(articulo);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public void borrarArticulo(String codigo) throws SQLException {
    EntityManager em = JPAUtil.getEntityManager();
    Articulo a = em.find(Articulo.class, codigo);
    if (a != null) {
      em.getTransaction().begin();
      em.remove(a);
      em.getTransaction().commit();
    }
    em.close();
  }
}
