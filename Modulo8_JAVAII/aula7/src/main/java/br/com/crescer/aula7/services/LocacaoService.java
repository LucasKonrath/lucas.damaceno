/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.services;

import br.com.crescer.aula7.Locacao;
import br.com.crescer.aula7.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocacaoService {
        @Autowired
        LocacaoRepository locacaoRepository;
        
        public Iterable<Locacao> listAll(){
        
            return locacaoRepository.findAll();
        }
        
        
        public Locacao getById(Long id){
        
           return locacaoRepository.findOne(id);
        }
        
        public Locacao addLocacao(Locacao loc){
        
            return locacaoRepository.save(loc);
        }
        
        public void deletar(Locacao loc){
        
            locacaoRepository.delete(loc);
        }

                

}