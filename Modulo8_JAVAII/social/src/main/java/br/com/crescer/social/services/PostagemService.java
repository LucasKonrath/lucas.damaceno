/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.services;

import br.com.crescer.social.models.Postagem;
import br.com.crescer.social.models.Usuario;
import br.com.crescer.social.repositories.PostagemRepository;
import java.util.List;

import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class PostagemService {
    
    @Autowired
    private PostagemRepository pr;
    
    @Autowired
    private UsuarioService us;
    
    public Page<Postagem> findAll(Pageable pageable){
    
        return pr.findAll(pageable);
    
    }
    
    public Iterable<Postagem> findAll(){
        return pr.findAll();
    }
    
    
    public Postagem findById(Long ID){
    
        return pr.findOne(ID);
    }
    
    public Postagem save(Postagem post, Usuario usuario){
    Usuario postador = us.findByEmail(usuario.getEmail());
    post.setUsuario(postador);
    return pr.save(post);
    
    }
     public Postagem update(Postagem post) {
        return pr.save(post);
    }
    
    public void remove(Long ID){
        pr.delete(ID);
    }
    
    
    public List<Postagem> getPostagensByUserId(Long id) {
        return us.findById(id).getPostagens();
    }
    
    
    public List<Postagem> getFeedPosts(Usuario usuario, Pageable pageable) {
        List<Usuario> amigos = 
                us.findByEmail(usuario.getEmail()).getAmigos();
        return pr.findByUsuarioInOrderByIdDesc(amigos, pageable);
    }
    
}
