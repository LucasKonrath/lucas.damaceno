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
public class Cliente implements Serializable{
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENTE")
    @SequenceGenerator(
            name = "SEQ_CLIENTE",
            sequenceName = "SEQ_CLIENTE",
            allocationSize = 1
    )
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    
    
    @Basic(optional = false)
    @Column(name = "CPF")
    private String cpf;
    
    
    @Basic(optional = true)
    @Column(name = "RG")
    private String rg;
    
     @Basic(optional = true)
    @Column(name = "RUA")
    private String rua;
     
     @Basic(optional = true)
    @Column(name = "BAIRRO")
    private String bairro;
     
    @Basic(optional = true)
    @Column(name = "CIDADE")
    private String cidade;
          
          
    @Basic(optional = true)
    @Column(name = "NUMERO_CASA")
    private String numeroCasa;
    
    
    @Basic(optional = true)
    @Column(name = "EMAIL")
    private String email;
     
    @Basic(optional = true)
    @Column(name = "TELEFONE")
    private String telefone;
     
    @Basic(optional = false)
    @Column(name = "CELULAR")
    private String celular; 
    
    @Basic(optional = true)
    @Column(name = "NASCIMENTO")
    private Date dataNascimento;

    
    
    public Cliente(){
    
    
    }
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
   
    
    
}
