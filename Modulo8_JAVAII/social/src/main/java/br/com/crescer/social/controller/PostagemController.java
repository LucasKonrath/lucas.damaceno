package br.com.crescer.social.controller;

import br.com.crescer.social.models.Postagem;
import br.com.crescer.social.services.PostagemService;

import br.com.crescer.social.services.UsuarioService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author carloshenrique
 */


@RestController
public class PostagemController {
    
    @Autowired
    private PostagemService ps; 

    @Autowired
    private UsuarioService us; 
    
    @PostMapping(value = "/postagem")
    public void adicionarPostagem(@RequestBody Postagem postagem, @AuthenticationPrincipal User usuario){
    
        ps.save(postagem, us.findByEmail(usuario.getUsername()));
    }
    
    @GetMapping(value = "postagens/{id}")
    public List<Postagem> getPostsByUser(@PathVariable Long id) {
        return ps.getPostagensByUserId(id);
    }
    
     @GetMapping(value = "postagem/{id}")
    public Postagem getPostagemById(@PathVariable Long id) {
        return ps.findById(id);
    }
    
    
    
     @GetMapping(value = "postagens/feed")
    public List<Postagem> getFeedPosts(@AuthenticationPrincipal User user, Pageable pageable) {
        return ps.getFeedPosts(us.findByEmail(user.getUsername()), pageable);
    }
    
    
    
    
    
    
    
}
