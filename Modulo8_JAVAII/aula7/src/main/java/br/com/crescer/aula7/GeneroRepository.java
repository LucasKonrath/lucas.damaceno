/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7;

import br.com.crescer.aula7.Genero;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * @author Carlos H. Nonnemacher
 */
public interface GeneroRepository extends CrudRepository<Genero, Long> {
          
}