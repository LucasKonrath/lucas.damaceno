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
public class GeneroDao implements CrudDao<Genero, Long>{

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
    private final EntityManager em = emf.createEntityManager();
    private  final Session session = em.unwrap(Session.class);
    
 
    
   
    
    @Override
    public Genero save(Genero e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        return e;
    }

    @Override
    public void remove(Genero e) {
        em.getTransaction().begin();
        em.remove(em.contains(e) ? e : em.merge(e));
        em.getTransaction().commit();
 
    }

    @Override
    public Genero loadById(Long id) {
        em.getTransaction().begin();
        Genero gen = em.find(Genero.class, id);
        em.getTransaction().commit();
        return gen;
    }

    @Override
    public List<Genero> findAll() {
       Criteria crit = session.createCriteria(Genero.class);
       List<Genero> generos = crit.list();
               return generos;
    }
    
    
    

    
    
    
}
