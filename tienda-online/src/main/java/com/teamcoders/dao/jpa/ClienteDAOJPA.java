package com.teamcoders.dao.jpa;

import java.sql.SQLException;
import java.util.List;

import com.teamcoders.dao.IClienteDAO;
import com.teamcoders.modelo.Cliente;
import com.teamcoders.utils.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ClienteDAOJPA implements IClienteDAO {
    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void crearCliente(Cliente cliente) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearCliente'");
    }

    @Override
    public Cliente buscarClientePorEmail(String email) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarClientePorEmail'");
    }

    @Override
    public void actualizarCliente(Cliente cliente) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarCliente'");
    }

    @Override
    public void borrarCliente(String email) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarCliente'");
    }

    @Override
    public List<Cliente> buscarTodosLosClientesPorTipo(String tipo) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodosLosClientesPorTipo'");
    }
}
