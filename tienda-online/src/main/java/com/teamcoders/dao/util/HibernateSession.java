package com.teamcoders.dao.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSession {
     private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(com.teamcoders.modelo.Articulo.class);
            configuration.addAnnotatedClass(com.teamcoders.modelo.Cliente.class);
            configuration.addAnnotatedClass(com.teamcoders.modelo.ClienteEstandar.class);
            configuration.addAnnotatedClass(com.teamcoders.modelo.ClientePremium.class);
            configuration.addAnnotatedClass(com.teamcoders.modelo.Pedido.class);
            StandardServiceRegistryBuilder builder =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            return configuration.buildSessionFactory(builder.build());
        } catch (Exception ex) {
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed: " + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
