/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.services;

import br.com.crescer.social.models.Comentario;
import br.com.crescer.social.models.Postagem;
import br.com.crescer.social.models.Usuario;
import br.com.crescer.social.repositories.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author lucas
 */
@Service
public class ComentarioService {
    
    @Autowired
    private ComentarioRepository cr;
    
    @Autowired
    private UsuarioService us;
    
    @Autowired
    private PostagemService ps;
    
    public Comentario salvar(Comentario comment, Usuario usuario, Postagem post){
    comment.setUsuario(us.findByEmail(usuario.getEmail()));
    comment.setPostagem(ps.findById(post.getId()));
    return cr.save(comment);
    }
}
