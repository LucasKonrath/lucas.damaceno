/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4;

import java.util.List;
import javax.persistence.*;
import org.hibernate.*;

/**
 *
 * @author lucas
 */
public class ClienteDao implements CrudDao<Cliente, Long>{

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
    private final EntityManager em = emf.createEntityManager();
    private  final Session session = em.unwrap(Session.class);
    
 
    
   
    
    @Override
    public Cliente save(Cliente e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        return e;
    }

    @Override
    public void remove(Cliente e) {
        em.getTransaction().begin();
        em.remove(em.contains(e) ? e : em.merge(e));
        em.getTransaction().commit();
 
    }

    @Override
    public Cliente loadById(Long id) {
        em.getTransaction().begin();
       Cliente cli = em.find(Cliente.class, id);
        em.getTransaction().commit();
        return cli;
    }

    @Override
    public List<Cliente> findAll() {
       Criteria crit = session.createCriteria(Cliente.class);
       List<Cliente> clients = crit.list();
               return clients;
    }
    
   
}
