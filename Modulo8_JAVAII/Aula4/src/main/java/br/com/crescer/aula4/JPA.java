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

       
        
        Cliente cliente = new Cliente();
        cliente = em.find(Cliente.class,1L);
        
         
         
  
        cliente.setNome("Minha Mãe");
        em.getTransaction().begin(); 
        em.merge(cliente);
        
        em.getTransaction().commit();

        em.close();
        emf.close();

    }

}
