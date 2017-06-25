/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4;

import javax.persistence.*;
import org.hibernate.Session;
import java.util.List;

/**
 *
 * @author lucas.damaceno
 */
public class Run {

    public static void main(String[] args) {

        CrudDao generos = new GeneroDao();
       
       Genero gen = new Genero();
       gen.setDescricao("Batata e calzone");
       generos.save(gen);
       Genero gen2 = (Genero)generos.loadById(10l);
        System.out.println(gen2.getDescricao());
        List<Genero> listGen = generos.findAll();
        for(Genero gene : listGen){
            System.out.println(gene.getDescricao());
        }
    }

}
