/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.repositories;

import br.com.crescer.social.models.Postagem;
import br.com.crescer.social.models.Usuario;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author lucas
 */
public interface PostagemRepository extends PagingAndSortingRepository<Postagem, Long> {
    
    List<Postagem> findByUsuarioInOrderByIdDesc(List<Usuario> users, Pageable pageable);
    
}
