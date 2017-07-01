package br.com.crescer.social.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author carloshenrique
 */
@Service
public class SocialUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Usuario usuario = usuarioService.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException(
                    String.format(
                            "User with username=%s was not found", username));
        }
        final List<GrantedAuthority> grants = new ArrayList<>();
       
        return new User(username, usuario.getSenha(), grants);
    }

}
