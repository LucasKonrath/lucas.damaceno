/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula7;
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

    
    
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_FUNCIONARIO")
    private Funcionario funcionario;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_VIDEO")
    private Video video;
    
    @Basic(optional = true)
    @Column(name = "DATA_DEVOLUCAO")
    private Date dataDevolucao;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    
    
   
    
    
}
