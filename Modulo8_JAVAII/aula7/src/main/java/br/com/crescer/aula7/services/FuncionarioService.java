/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7.services;

import br.com.crescer.aula7.Funcionario;
import br.com.crescer.aula7.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
        @Autowired
        FuncionarioRepository funcionarioRepository;
        
        public Iterable<Funcionario> listAll(){
        
            return funcionarioRepository.findAll();
        }

                

}