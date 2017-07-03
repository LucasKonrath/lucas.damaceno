/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author lucas.damaceno
 */
@Entity
public class Usuario implements Serializable{
    
    @Id
    @Column(name = "ID_USUARIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(
            name = "SEQ_USUARIO",
            sequenceName = "SEQ_USUARIO",
            allocationSize = 1
    )
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "NOME_USUARIO")
    private String nome;
  
    @Email
    @Basic(optional = false)
    @Column(name="EMAIL_USUARIO")
    private String email;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    

    @Basic(optional = false)
    @Column(name = "SENHA_USUARIO")
    private String senha;
    
    @Basic(optional = true)
    @Column(name = "FOTO_USUARIO")
    private String foto;
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Usuario> amigos;
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Usuario> solicitacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }

    public List<Usuario> getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(List<Usuario> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }

    public List<Postagem> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagem> postagens) {
        this.postagens = postagens;
    }
    
    
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Postagem> postagens;
    public Usuario(){
    
    
    }
    
    
   
    
    
}
