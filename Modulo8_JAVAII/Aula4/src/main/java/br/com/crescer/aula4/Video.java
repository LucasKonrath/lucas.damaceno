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
public class Video implements Serializable{
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VIDEO")
    @SequenceGenerator(
            name = "SEQ_VIDEO",
            sequenceName = "SEQ_VIDEO",
            allocationSize = 1
    )
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "VALOR")
    private double valor;
    
    
    @Basic(optional = true)
    @Column(name = "DURACAO")
    private String duracao;
    
    
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_GENERO")
    private Genero genero;
    
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    
    @Basic(optional = true)
    @Column(name = "QUANTIDADE_ESTOQUE")
    private int quantidade_estoque;
     
    @Basic(optional = true)
    @Column(name = "DATA_LANCAMENTO")
    private Date data_lancamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public Date getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(Date data_lancamento) {
        this.data_lancamento = data_lancamento;
    }
    
    
     
    
   
    
    
}
