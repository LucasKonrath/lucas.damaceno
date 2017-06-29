package br.com.crescer.aula7;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
/**
 *
 * @author lucas.damaceno
 */
@Entity
public class Funcionario implements Serializable{

    @Id
   @Basic(optional = false)
   @Column(name = "ID")
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FUNCIONARIO")
   @SequenceGenerator(
            name = "SEQ_FUNCIONARIO",
            sequenceName = "SEQ_FUNCIONARIO",
            allocationSize = 1
    )
   private Long id;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;

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
    @Column(name = "RUA")
    private String rua;
      
    @Basic(optional = false)
    @Column(name = "RG")
    private String rg;
    
    @Basic(optional = true)
    @Column(name = "EMAIL")
    private String email;
    
    @Basic(optional = true)
    @Column(name = "TELEFONE")
    private String telefone;
    
     
    @Basic(optional = true)
    @Column(name = "CELULAR")
    private String celular;
    
    @Basic(optional = true)
    @Column(name = "SALARIO")
    private double salario;
    
    @Basic(optional = true)
    @Column(name = "FUNCAO")
    private String funcao;
    
    @Basic(optional = true)
    @Column(name = "CPF")
    private String cpf;
    
    
    @Basic(optional = true)
    @Column(name = "NASCIMENTO")
    private Date dataNascimento;
    
    
    
    public Funcionario(){
    
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
    
}
