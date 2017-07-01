/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.social.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author lucas
 */
@Entity
public class Curtida implements Serializable{
    
    
     @Id
    @Column(name = "ID_CURTIDA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CURTIDA")
    @SequenceGenerator(
            name = "SEQ_CURTIDA",
            sequenceName = "SEQ_CURTIDA",
            allocationSize = 1
    )
    private Long id;
     
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_POSTAGEM")
    private Postagem postagem;
     
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO_CURTIDOR")
    private Usuario usuarioCurtidor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }

    public Usuario getUsuarioCurtidor() {
        return usuarioCurtidor;
    }

    public void setUsuarioCurtidor(Usuario usuarioCurtidor) {
        this.usuarioCurtidor = usuarioCurtidor;
    }
    
    
     
    
}
