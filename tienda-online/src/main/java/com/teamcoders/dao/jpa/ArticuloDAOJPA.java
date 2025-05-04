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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearArticulo'");
     }

     @Override
     public Articulo buscarArticuloPorCodigo(String codigo) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarArticuloPorCodigo'");
     }

     @Override
     public void actualizarArticulo(Articulo articulo) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarArticulo'");
     }

     @Override
     public void borrarArticulo(String codigo) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarArticulo'");
     }
}
