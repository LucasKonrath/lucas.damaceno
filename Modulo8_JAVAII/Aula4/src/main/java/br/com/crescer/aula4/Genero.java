/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author lucas.damaceno
 */
@Entity
public class Genero implements Serializable{
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID_GENERO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERO")
    @SequenceGenerator(
            name = "SEQ_GENERO",
            sequenceName = "SEQ_GENERO",
            allocationSize = 1
    )   
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "DS_GENERO")
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Genero(){
    }
    
    
    
   
}
