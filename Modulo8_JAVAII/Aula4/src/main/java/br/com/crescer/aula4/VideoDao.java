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
public class VideoDao implements CrudDao<Video, Long>{

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
    private final EntityManager em = emf.createEntityManager();
    private  final Session session = em.unwrap(Session.class);
    
 
    
   
    
    @Override
    public Video save(Video e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        return e;
    }

    @Override
    public void remove(Video e) {
        em.getTransaction().begin();
        em.remove(em.contains(e) ? e : em.merge(e));
        em.getTransaction().commit();
 
    }

    @Override
    public Video loadById(Long id) {
        em.getTransaction().begin();
        Video vid = em.find(Video.class, id);
        em.getTransaction().commit();
        return vid;
    }

    @Override
    public List<Video> findAll() {
       Criteria crit = session.createCriteria(Video.class);
       List<Video> videos = crit.list();
               return videos;
    }
    
   
}
