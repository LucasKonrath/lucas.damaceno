/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.services;

import br.com.crescer.aula7.Cliente;
import br.com.crescer.aula7.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
        @Autowired
        ClienteRepository clienteRepository;
        
        public Iterable<Cliente> listAll(){
        
            return clienteRepository.findAll();
        }
        
        public Cliente getById(Long id){
        
           return clienteRepository.findOne(id);
        }
        
        public Cliente addCliente(Cliente cli){
        
            return clienteRepository.save(cli);
        }
        
        public void deletar(Cliente cli){
        
            clienteRepository.delete(cli);
        }

                

}