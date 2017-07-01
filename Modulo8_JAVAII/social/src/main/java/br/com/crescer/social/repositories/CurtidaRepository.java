/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repositories;

import br.com.crescer.social.models.Curtida;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author lucas
 */
public interface CurtidaRepository extends PagingAndSortingRepository<Curtida, Long>{
    
}
