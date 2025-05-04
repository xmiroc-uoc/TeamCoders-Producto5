package com.teamcoders.dao.jpa;

import com.teamcoders.dao.IClienteDAO;
import com.teamcoders.dao.util.JPAUtil;
import com.teamcoders.modelo.Cliente;
import com.teamcoders.modelo.ClienteEstandar;
import com.teamcoders.modelo.ClientePremium;
import jakarta.persistence.EntityManager;

import java.sql.SQLException;
import java.util.List;

public class ClienteDAOJPA implements IClienteDAO {

  @Override
  public void crearCliente(Cliente cliente) throws SQLException {
    EntityManager em = JPAUtil.getEntityManager();
    em.getTransaction().begin();
    em.persist(cliente);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public Cliente buscarClientePorEmail(String email) throws SQLException {
    EntityManager em = JPAUtil.getEntityManager();
    Cliente c = em.find(Cliente.class, email);
    em.close();
    return c;
  }

  @Override
  public List<Cliente> obtenerTodosLosClientes() throws SQLException {
    EntityManager em = JPAUtil.getEntityManager();
    List<Cliente> lista = em.createQuery("FROM Cliente", Cliente.class).getResultList();
    em.close();
    return lista;
  }

  @Override
  public void actualizarCliente(Cliente cliente) throws SQLException {
    EntityManager em = JPAUtil.getEntityManager();
    em.getTransaction().begin();
    em.merge(cliente);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public void borrarCliente(String email) throws SQLException {
    EntityManager em = JPAUtil.getEntityManager();
    Cliente c = em.find(Cliente.class, email);
    if (c != null) {
      em.getTransaction().begin();
      em.remove(c);
      em.getTransaction().commit();
    }
    em.close();
  }

  @Override
  public List<Cliente> buscarTodosLosClientesPorTipo(String tipo) throws SQLException {
    EntityManager em = JPAUtil.getEntityManager();
    List<Cliente> lista;

    if (tipo == null || tipo.isBlank()) {
      lista = em.createQuery("FROM Cliente", Cliente.class).getResultList();
    } else if (tipo.equalsIgnoreCase("premium")) {
      lista = em.createQuery(
          "SELECT c FROM Cliente c WHERE TYPE(c) = :clazz", Cliente.class)
          .setParameter("clazz", ClientePremium.class)
          .getResultList();
    } else { // estandar
      lista = em.createQuery(
          "SELECT c FROM Cliente c WHERE TYPE(c) = :clazz", Cliente.class)
          .setParameter("clazz", ClienteEstandar.class)
          .getResultList();
    }
    em.close();
    return lista;
  }
}
