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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author lucas
 */
@Entity
public class Postagem implements Serializable{
    
    @Id
    @Column(name = "ID_POSTAGEM")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_POSTAGEM")
    @SequenceGenerator(
            name = "SEQ_POSTAGEM",
            sequenceName = "SEQ_POSTAGEM",
            allocationSize = 1
    )
    private Long id;
    
    
    
    @Basic(optional = false)
    @Column(name = "TITULO_POSTAGEM")
    private String titulo;
  
    @Basic(optional = false)
    @Column(name = "TEXTO_POSTAGEM")
    private String texto;
    
    @Basic(optional = true)
    @Column(name = "URL_FOTO_POSTAGEM")
    private String urlFoto;
    
    @OneToMany(mappedBy = "postagem")
    private List<Curtida> curtidas;
    
    @OneToMany(mappedBy = "postagem")
    private List<Comentario> comentarios;
    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public List<Curtida> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<Curtida> curtidas) {
        this.curtidas = curtidas;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    
}
