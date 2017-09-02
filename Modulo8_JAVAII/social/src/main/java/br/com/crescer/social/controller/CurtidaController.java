package br.com.crescer.social.controller;

import br.com.crescer.social.models.Curtida;
import br.com.crescer.social.models.Postagem;
import br.com.crescer.social.services.CurtidaService;
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
 * @author lucas
 */


@RestController
public class CurtidaController {
    
  

    
    @Autowired
    private CurtidaService cs; 
  
    @Autowired
    private UsuarioService us;
    
    @PostMapping(value = "/curtir/{ID}")
    public void adicionarCurtida(@RequestBody Curtida curtida, @AuthenticationPrincipal User usuario, @PathVariable Long ID){
        cs.save(curtida, us.findByEmail(usuario.getUsername()), ID);
    }
    
    //Fazer a logica depois.
    @PostMapping(value = "/descurtir/{ID}")
    public void retirarCurtida(@RequestBody Curtida curtida, @AuthenticationPrincipal User usuario, @PathVariable Long ID){
        cs.delete(ID);
    }
    
    
        
    
    
    
    
    
}
