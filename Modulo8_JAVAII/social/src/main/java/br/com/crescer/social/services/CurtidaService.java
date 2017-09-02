/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.services;
import br.com.crescer.social.models.Curtida;
import br.com.crescer.social.models.Postagem;
import br.com.crescer.social.models.Usuario;
import br.com.crescer.social.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lucas
 */
@Service
public class CurtidaService {
    
    @Autowired
    private CurtidaRepository cr;
    
    @Autowired
    private UsuarioService us;
    
    @Autowired
    private PostagemService ps;
    
    public Curtida save(Curtida curtida, Usuario usuario, Long IdPostagem){
    
        curtida.setPostagem(ps.findById(IdPostagem));
        curtida.setUsuarioCurtidor(us.findByEmail(usuario.getEmail()));
        return cr.save(curtida);
    
    }
    
    public void delete(Long id){
        cr.delete(id);
    }
    
}
