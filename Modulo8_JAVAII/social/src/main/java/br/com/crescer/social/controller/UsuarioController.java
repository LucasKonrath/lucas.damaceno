package br.com.crescer.social.controller;

import br.com.crescer.social.models.Usuario;

import br.com.crescer.social.services.UsuarioService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UsuarioController {
    
    @Autowired
    private UsuarioService us; 

    
    @GetMapping(value = "/usuarios")
    public List<Usuario> listUsers(){
    
        return (List) us.findAll();
    }
    
    @GetMapping(value = "/usuario/{ID}")
    public Usuario getUserById(@PathVariable Long ID){
        return us.findById(ID);
    }
    
    @GetMapping(value = "/dadosUsuarioAtual")
    public Usuario getDataLoggedUser(@AuthenticationPrincipal User usuario){
      
        return us.findByEmail(usuario.getUsername());
    }
    
    @GetMapping(value = "/usuarioAtual")
    public Map<String, Object> getLoggedUser(@AuthenticationPrincipal User usuario){
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("dados", usuario);
        return mapa;
    }
    
     @GetMapping(value = "/usuario/amigos")
    public List<Usuario> getAmigosDoUsuario(@AuthenticationPrincipal User usuario){
       Usuario user = us.findByEmail(usuario.getUsername());
       List<Usuario> lu = user.getAmigos();
      
       return lu;
    }
    
    @GetMapping(value = "/usuario/solicitacoes")
    public List<Usuario> getSolicitacoesUsuario(@AuthenticationPrincipal User usuario){
       Usuario user = us.findByEmail(usuario.getUsername());
       return user.getSolicitacoes();
    }
    
    
    
    @PostMapping(value = "/usuario")
    public Usuario addUsuario(@RequestBody Usuario usuario) {
        Usuario teste = us.findByEmail(usuario.getEmail());
        if(teste == null)
                us.save(usuario);
        return us.findByEmail(usuario.getEmail());
    }
    
    @PutMapping(value = "/usuario")
    public void updateUsuario(@RequestBody Usuario usuario) {
        us.save(usuario);
    }
    @PostMapping(value = "/usuario/convidar/{ID}")
    public void enviarSolicitacao(@PathVariable Long ID, @AuthenticationPrincipal User usuario){
    Usuario usuarioSolicitante = us.findByEmail(usuario.getUsername());
    Usuario usuarioSolicitado = us.findById(ID);
    us.enviarSolicitacao(usuarioSolicitante, usuarioSolicitado);
    }
    
    
    @PostMapping(value = "/usuario/aceitar/{ID}")
    public void aceitarSolicitacao(@PathVariable Long ID, @AuthenticationPrincipal User usuario){
    Usuario usuarioQueAceita = us.findByEmail(usuario.getUsername());
    Usuario usuarioAceito = us.findById(ID);
    us.aceitarSolicitacaoAmizade(usuarioQueAceita, usuarioAceito);
    }
    
    
     @DeleteMapping(value = "/usuario/{ID}")
    public void deleteUserById(@PathVariable Long ID){
        us.delete(ID);
    }
    
    
    
    
    
    
    
}
