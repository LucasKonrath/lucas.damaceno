package br.com.crescer.social.controller;

import br.com.crescer.social.models.Usuario;

import br.com.crescer.social.services.UsuarioService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author carloshenrique
 */


@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioService us; 

    
      
    @PostMapping(value = "/usuario")
    public void addUsuario(@RequestBody Usuario usuario) {
        us.save(usuario);
    }
    
    
}
