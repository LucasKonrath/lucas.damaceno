/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7;

import org.springframework.data.repository.CrudRepository;


/**
 * @author Carlos H. Nonnemacher
 */
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
          
}