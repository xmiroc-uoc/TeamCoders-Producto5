package com.teamcoders.dao.jpa;

import java.sql.SQLException;
import java.util.List;

import com.teamcoders.dao.IPedidoDAO;
import com.teamcoders.modelo.Pedido;
import com.teamcoders.utils.JpaUtil;

import jakarta.persistence.EntityManager;

public class PedidoDAOJPA implements IPedidoDAO {
     @Override
    public List<Pedido> obtenerTodosLosPedidos() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
        } finally {
            em.close();
        }
    }

     @Override
     public void crearPedido(Pedido pedido) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearPedido'");
     }

     @Override
     public Pedido buscarPedidoPorNumero(int numero) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPedidoPorNumero'");
     }

     @Override
     public void actualizarPedido(Pedido pedido) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarPedido'");
     }

     @Override
     public void borrarPedido(int numero) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarPedido'");
     }

     @Override
     public List<Pedido> buscarPedidosPendientesEnvio() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPedidosPendientesEnvio'");
     }

     @Override
     public List<Pedido> buscarPedidosEnviados() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPedidosEnviados'");
     }
}
