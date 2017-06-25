/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4;

import javax.persistence.*;

/**
 *
 * @author lucas.damaceno
 */
public class JPA {

    public static void main(String[] args) {

        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em;
        em = emf.createEntityManager();

       
        em.getTransaction().begin();
        Genero genero = new Genero();
        
        genero.setDescricao("Terror mucho loko.");
        
        em.persist(genero);
        em.getTransaction().commit();

        em.close();
        emf.close();

    }

}
