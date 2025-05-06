package com.teamcoders.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import com.teamcoders.dao.IClienteDAO;
import com.teamcoders.dao.util.HibernateSession;
import com.teamcoders.modelo.Cliente;
import com.teamcoders.modelo.ClienteEstandar;
import com.teamcoders.modelo.ClientePremium;

public class ClienteDAOHibernate implements IClienteDAO{

      @Override
    public void crearCliente(Cliente cliente) {
        Transaction tx = null;
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(cliente);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public Cliente buscarClientePorEmail(String email) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            return session.get(Cliente.class, email);
        }
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Query<Cliente> query = session.createQuery("FROM Cliente", Cliente.class);
            return query.getResultList();
        }
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        Transaction tx = null;
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(cliente); 
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public void borrarCliente(String email) {
        Transaction tx = null;
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Cliente cliente = session.get(Cliente.class, email);
            if (cliente != null) {
                session.remove(cliente);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public List<Cliente> buscarTodosLosClientesPorTipo(String tipo) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Class<? extends Cliente> claseCliente;
            if (tipo.equalsIgnoreCase("premium")) {
                claseCliente = ClientePremium.class;
            } else {
                claseCliente = ClienteEstandar.class;
            }

            Query<Cliente> query = session.createQuery(
                "FROM Cliente c WHERE TYPE(c) = :tipoClase", Cliente.class);
            query.setParameter("tipoClase", claseCliente);
            return query.getResultList();
        }
    }
}