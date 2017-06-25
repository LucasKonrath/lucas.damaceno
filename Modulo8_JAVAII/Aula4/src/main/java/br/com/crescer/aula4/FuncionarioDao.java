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
public class FuncionarioDao implements CrudDao<Funcionario, Long>{

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
    private final EntityManager em = emf.createEntityManager();
    private  final Session session = em.unwrap(Session.class);
    
 
    
   
    
    @Override
    public Funcionario save(Funcionario e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        return e;
    }

    @Override
    public void remove(Funcionario e) {
        em.getTransaction().begin();
        em.remove(em.contains(e) ? e : em.merge(e));
        em.getTransaction().commit();
 
    }

    @Override
    public Funcionario loadById(Long id) {
        em.getTransaction().begin();
        Funcionario func = em.find(Funcionario.class, id);
        em.getTransaction().commit();
        return func;
    }

    @Override
    public List<Funcionario> findAll() {
       Criteria crit = session.createCriteria(Funcionario.class);
       List<Funcionario> funcs = crit.list();
               return funcs;
    }
    
   
}
