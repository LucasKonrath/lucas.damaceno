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
public class LocacaoDao implements CrudDao<Locacao, Long>{

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
    private final EntityManager em = emf.createEntityManager();
    private  final Session session = em.unwrap(Session.class);
    
 
    
   
    
    @Override
    public Locacao save(Locacao e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        return e;
    }

    @Override
    public void remove(Locacao e) {
        em.getTransaction().begin();
        em.remove(em.contains(e) ? e : em.merge(e));
        em.getTransaction().commit();
 
    }

    @Override
    public Locacao loadById(Long id) {
        em.getTransaction().begin();
        Locacao loc = em.find(Locacao.class, id);
        em.getTransaction().commit();
        return loc;
    }

    @Override
    public List<Locacao> findAll() {
       Criteria crit = session.createCriteria(Locacao.class);
       List<Locacao> locacoes = crit.list();
               return locacoes;
    }
    
   
}
