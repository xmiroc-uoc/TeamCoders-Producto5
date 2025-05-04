package com.teamcoders.dao.jpa;

import java.sql.SQLException;
import java.util.List;

import com.teamcoders.dao.IClienteDAO;
import com.teamcoders.modelo.Cliente;
import com.teamcoders.modelo.ClienteEstandar;
import com.teamcoders.modelo.ClientePremium;
import com.teamcoders.utils.JpaUtil;

import jakarta.persistence.EntityManager;

public class ClienteDAOJPA implements IClienteDAO {
    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
         try {
               return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
         } finally {
               em.close();
         }
    }

    @Override
    public void crearCliente(Cliente cliente) throws SQLException {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
         try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
         } finally {
            if (em.getTransaction().isActive()) {
               em.getTransaction().rollback();
            }
            em.close();
         }
    }

    @Override
    public Cliente buscarClientePorEmail(String email) throws SQLException {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
         try {
            return em.find(Cliente.class, email);
         } finally {
            em.close();
         }
    }

    @Override
    public void actualizarCliente(Cliente cliente) throws SQLException {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
         try {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
         } finally {
            if (em.getTransaction().isActive()) {
               em.getTransaction().rollback();
            }
            em.close();
         }
    }

    @Override
    public void borrarCliente(String email) throws SQLException {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
         try {
            Cliente cliente = em.find(Cliente.class, email);
            if (cliente != null) {
               em.getTransaction().begin();
               em.remove(cliente);
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
    public List<Cliente> buscarTodosLosClientesPorTipo(String tipo) throws SQLException {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery(
                "SELECT c FROM Cliente c WHERE TYPE(c) = :tipoClase", Cliente.class)
                .setParameter("tipoClase", tipo.equalsIgnoreCase("premium") ? ClientePremium.class : ClienteEstandar.class)
                .getResultList();
        } finally {
            em.close();
        }
    }
}
