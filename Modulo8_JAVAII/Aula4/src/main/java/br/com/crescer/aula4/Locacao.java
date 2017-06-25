/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author lucas.damaceno
 */
@Entity
public class Locacao implements Serializable{
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOCACAO")
    @SequenceGenerator(
            name = "SEQ_LOCACAO",
            sequenceName = "SEQ_LOCACAO",
            allocationSize = 1
    )
    private Long id;
    
    @Basic(optional = true)
    @Column(name = "VALOR_TOTAL")
    private double valorTotal;
    
     @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_FUNCIONARIO")
    private Funcionario funcionario;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_VIDEO")
    private Video video;
    
    @Basic(optional = true)
    @Column(name = "DATA_DEVOLUCAO")
    private Date dataDevolucao;
    
    
    
   
    
    
}
