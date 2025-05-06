package com.teamcoders.dao.hibernate;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.teamcoders.dao.IPedidoDAO;
import com.teamcoders.dao.util.HibernateSession;
import com.teamcoders.modelo.Pedido;

public class PedidoDAOHibernate implements IPedidoDAO{

     @Override
    public void crearPedido(Pedido pedido) {
        Transaction tx = null;
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(pedido); 
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public Pedido buscarPedidoPorNumero(int numero) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            return session.get(Pedido.class, numero); 
        }
    }

    @Override
    public List<Pedido> obtenerTodosLosPedidos() {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Query<Pedido> query = session.createQuery("FROM Pedido", Pedido.class);
            return query.getResultList();
        }
    }

    @Override
    public void actualizarPedido(Pedido pedido) {
        Transaction tx = null;
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(pedido); 
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public void borrarPedido(int numero) {
        Transaction tx = null;
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Pedido pedido = session.get(Pedido.class, numero);
            if (pedido != null) {
                session.remove(pedido);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public List<Pedido> buscarPedidosPendientesEnvio() {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Query<Pedido> query = session.createQuery(
                "FROM Pedido WHERE estado = :estado", Pedido.class);
            query.setParameter("estado", "PENDIENTE_ENVIO");
            return query.getResultList();
        }
    }

    @Override
    public List<Pedido> buscarPedidosEnviados() {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Query<Pedido> query = session.createQuery(
                "FROM Pedido WHERE estado = :estado", Pedido.class);
            query.setParameter("estado", "ENVIADO");
            return query.getResultList();
        }
    }
}
