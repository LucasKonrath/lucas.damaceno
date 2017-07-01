/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.services;

import br.com.crescer.social.models.Postagem;
import br.com.crescer.social.models.Usuario;
import br.com.crescer.social.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository ur;

   public Page<Usuario> findAll(Pageable pageable){
    
        return ur.findAll(pageable);
    
    }
    
    public Iterable<Usuario> findAll(){
        return ur.findAll();
    }
    
      public Usuario findById(Long id) {
        return ur.findOne(id);
    }

    public Usuario findByEmail(String email) {
        return ur.findByEmail(email);
    }
    
    public void enviarSolicitacao(Usuario envia, Usuario recebe) {
        recebe.getSolicitacoes().add(envia);
        update(recebe);
    }
    
     public void aceitarSolicitacaoAmizade(Usuario aceita, Usuario adicionar) {
        aceita.getSolicitacoes().remove(adicionar);
        aceita.getAmigos().add(adicionar);
        adicionar.getAmigos().add(aceita);
        update(aceita);
        update(adicionar);
    }
    
    
    
    public Usuario update(Usuario usuario) {
        return ur.save(usuario);
    }
      
    public Usuario save(Usuario usuario) {
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        return ur.save(usuario);
    }
    
    
    
     public void delete(Long id) {
        ur.delete(id);
    }
    
}
