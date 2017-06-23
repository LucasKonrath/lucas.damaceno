/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4;

import javax.persistence.*;
import org.hibernate.Session;

/**
 *
 * @author lucas.damaceno
 */
public class Run {

    public static void main(String[] args) {

        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em;
        em = emf.createEntityManager();


        
        final Session session = em.unwrap(Session.class);
        final Cliente cliente = (Cliente) session.load(Cliente.class, 1l);
        cliente.setNome("Enéas 56");
      
        em.getTransaction().begin();
        session.saveOrUpdate(cliente);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

}
