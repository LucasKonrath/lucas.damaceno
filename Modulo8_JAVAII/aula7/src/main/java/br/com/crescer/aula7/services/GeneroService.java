/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.services;

import br.com.crescer.aula7.Genero;
import br.com.crescer.aula7.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {
        @Autowired
        GeneroRepository generoRepository;
        
        public Iterable<Genero> listAll(){
        
            return generoRepository.findAll();
        }
        
        public Genero getById(Long id){
        
           return generoRepository.findOne(id);
        }
        
        public Genero addGenero(Genero gen){
        
            return generoRepository.save(gen);
        }
        
        public void deletar(Genero gen){
        
            generoRepository.delete(gen);
        }

                

}