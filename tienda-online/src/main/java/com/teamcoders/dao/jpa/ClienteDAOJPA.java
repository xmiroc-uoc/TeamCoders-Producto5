package com.teamcoders.dao.jpa;

import java.sql.SQLException;
import java.util.List;

import com.teamcoders.dao.interfaces.IClienteDAO;
import com.teamcoders.modelo.Cliente;
import com.teamcoders.modelo.ClienteEstandar;
import com.teamcoders.modelo.ClientePremium;
import com.teamcoders.utils.JpaUtil;

import jakarta.persistence.EntityManager;

/**
 * Implementación de la interfaz {@link IClienteDAO} utilizando JPA (Java Persistence API).
 * Esta clase gestiona la persistencia de objetos {@link Cliente}, proporcionando
 * operaciones CRUD básicas a través del EntityManager.
 * 
 * <p>Permite almacenar, consultar, actualizar y eliminar objetos de tipo Cliente,
 * incluyendo sus subtipos {@link ClienteEstandar} y {@link ClientePremium}, mediante
 * anotaciones JPA y consultas dinámicas.</p>
 * 
 * <p>Se utiliza una factoría de EntityManager centralizada proporcionada por {@link JpaUtil}.</p>
 */
public class ClienteDAOJPA implements IClienteDAO {

   /**
    * Inserta un nuevo cliente en la base de datos.
    *
    * @param cliente el cliente a insertar.
    * @throws IllegalArgumentException si el cliente es nulo.
    * @throws jakarta.persistence.PersistenceException si ocurre un error durante la persistencia.
    */
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

   /**
     * Obtiene todos los clientes registrados en la base de datos.
     *
     * @return una lista con todos los clientes.
     * @throws jakarta.persistence.PersistenceException si ocurre un error durante la consulta.
     */
   @Override
   public List<Cliente> obtenerTodosLosClientes() {
      EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
      try {
            return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
      } finally {
            em.close();
      }
   }

   /**
     * Busca un cliente por su dirección de correo electrónico.
     *
     * @param email el email identificador del cliente.
     * @return el objeto {@link Cliente} correspondiente, o null si no se encuentra.
     * @throws jakarta.persistence.PersistenceException si ocurre un error durante la búsqueda.
     */
   @Override
   public Cliente buscarClientePorEmail(String email) throws SQLException {
      EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
      try {
         return em.find(Cliente.class, email);
      } finally {
         em.close();
      }
   }

   /**
    * Recupera todos los clientes que pertenecen a un tipo específico (Estandar o Premium).
    *
    * @param tipo el tipo de cliente a buscar: "estandar" o "premium" (ignorando mayúsculas/minúsculas).
    * @return una lista de clientes del tipo especificado.
    * @throws IllegalArgumentException si el tipo no es válido.
    * @throws jakarta.persistence.PersistenceException si ocurre un error durante la consulta.
    */
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

   /**
     * Actualiza los datos de un cliente existente en la base de datos.
     *
     * @param cliente el objeto cliente con la información actualizada.
     * @throws IllegalArgumentException si el cliente es nulo.
     * @throws jakarta.persistence.PersistenceException si ocurre un error durante la actualización.
     */
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

   /**
    * Elimina un cliente de la base de datos según su dirección de correo electrónico.
    *
    * @param email el email identificador del cliente a eliminar.
    * @throws jakarta.persistence.PersistenceException si ocurre un error durante la operación.
    */
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
}
