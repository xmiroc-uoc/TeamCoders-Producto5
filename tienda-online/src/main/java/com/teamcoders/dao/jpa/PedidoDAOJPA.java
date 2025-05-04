package com.teamcoders.dao.jpa;

import com.teamcoders.dao.IPedidoDAO;
import com.teamcoders.dao.util.JPAUtil;
import com.teamcoders.modelo.Pedido;
import jakarta.persistence.EntityManager;

import java.sql.SQLException;
import java.util.List;

public class PedidoDAOJPA implements IPedidoDAO {

  @Override
  public void crearPedido(Pedido pedido) throws SQLException {
    EntityManager em = JPAUtil.getEntityManager();
    em.getTransaction().begin();
    em.persist(pedido);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public Pedido buscarPedidoPorNumero(int numero) throws SQLException {
    EntityManager em = JPAUtil.getEntityManager();
    Pedido p = em.find(Pedido.class, numero);
    em.close();
    return p;
  }

  @Override
  public List<Pedido> obtenerTodosLosPedidos() throws SQLException {
    EntityManager em = JPAUtil.getEntityManager();
    List<Pedido> lista = em.createQuery("FROM Pedido", Pedido.class).getResultList();
    em.close();
    return lista;
  }

  @Override
  public void actualizarPedido(Pedido pedido) throws SQLException {
    EntityManager em = JPAUtil.getEntityManager();
    em.getTransaction().begin();
    em.merge(pedido);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public void borrarPedido(int numero) throws SQLException {
    EntityManager em = JPAUtil.getEntityManager();
    Pedido p = em.find(Pedido.class, numero);
    if (p != null) {
      em.getTransaction().begin();
      em.remove(p);
      em.getTransaction().commit();
    }
    em.close();
  }

  @Override
  public List<Pedido> buscarPedidosPendientesEnvio() throws SQLException {
    // Suponemos que la entidad tiene un boolean "enviado"
    EntityManager em = JPAUtil.getEntityManager();
    List<Pedido> lista = em.createQuery(
        "FROM Pedido p WHERE p.enviado = false", Pedido.class)
        .getResultList();
    em.close();
    return lista;
  }

  @Override
  public List<Pedido> buscarPedidosEnviados() throws SQLException {
    EntityManager em = JPAUtil.getEntityManager();
    List<Pedido> lista = em.createQuery(
        "FROM Pedido p WHERE p.enviado = true", Pedido.class)
        .getResultList();
    em.close();
    return lista;
  }
}
