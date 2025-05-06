package com.teamcoders.dao.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.teamcoders.dao.IArticuloDAO;
import com.teamcoders.dao.util.HibernateSession;
import com.teamcoders.modelo.Articulo;

public class ArticuloDAOHibernate implements IArticuloDAO{
    
    @Override
    public void crearArticulo(Articulo articulo){
        Transaction tx = null;
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(articulo);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public Articulo buscarArticuloPorCodigo(String codigo){
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            return session.get(Articulo.class, codigo);
        }
    }

    @Override
    public List<Articulo> obtenerTodosLosArticulos(){
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Query<Articulo> query = session.createQuery("FROM Articulo", Articulo.class);
            return query.getResultList();
        }
    }

    @Override
    public void actualizarArticulo(Articulo articulo){
        Transaction tx = null;
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(articulo);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public void borrarArticulo(String codigo){
        Transaction tx = null;
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Articulo articulo = session.get(Articulo.class, codigo);
            if (articulo != null) {
                session.remove(articulo);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
    }
