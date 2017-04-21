import java.security.InvalidParameterException;
import java.util.*;
// Classe Saint (Cavaleirxs que entregam justiça cósmica.)
public abstract class Saint /* implements Comparable<Saint> */ {
    public String nome;
    protected Armadura armadura;
    protected boolean armaduraVestida;
    protected Genero genero=Genero.NAO_INFORMADO;
    protected Status status=Status.VIVO;
    protected double vida = 100.0;
    protected int qtdSentidosDespertados;
    protected Categoria categoria=Categoria.BRONZE;
// Construtor da classe Saint
    public Saint(String nome, String constelacao) throws Exception{
            this.armadura = new Armadura(new Constelacao(constelacao), this.categoria);
            this.nome=nome;
        }     
    public String getNome(){
        return this.nome;
    }
// Método para vestir armadura do Saint.    
    public void vestirArmadura(){
        this.armaduraVestida = true;
    }
// Método para despir armadura do Saint.
    public void despirArmadura(){
        this.armaduraVestida = false;
    }
// Método para checar se Saint esta com armadura vestida.
    public boolean getArmaduraVestida(){
        return this.armaduraVestida;
    }
// Método para checar gênero do Saint.
    public Genero getGenero(){
        return this.genero;
    }
// Método para alterar gênero do Saint.
    public void setGenero(Genero genero){
        this.genero=genero;
    }
// Método para retornar Status do saint.
    public Status getStatus(){
        return this.status;
    }
 // Método para alterar Categoria da armadura do Saint.
    abstract void setCategoria();
// Metodo que causa dano no Saint.
    public void perderVida(double dano) {
        if (dano < 0){
            throw new InvalidParameterException ("Invalid Parameter Exception");
        }
        else if((this.vida) > 1){
            this.vida -= dano;
                if (this.vida < 1) {
                    this.vida=0;
                    this.status = Status.MORTO;
                }
        }
    }
// Metodo que retorna a vida atual do Saint.
    public double getVida(){
        return this.vida;
    }
    
// Metodo que retorna o valor numerico da Categoria da Armadura do Saint (Ex: Ouro 3, Prata 2, Bronze 1)
    public int getCategoriaArmadura(){
        return this.armadura.getValorCategoria();
    }
    public String getNomeConstelacao(){
        return this.armadura.getNomeConstelacao();
    }

    @Override
    public String toString() {
        return nome + " de " +  getNomeConstelacao();
    }
    public int getQtdSentidosDespertados(){
    return this.qtdSentidosDespertados;
    }
    public ArrayList getGolpes(){
       return this.armadura.getGolpes();
    }
    public void aprenderGolpe(Golpe golpe){
        this.armadura.aprenderGolpe(golpe);
    }
    public Golpe getProximoGolpe() throws Exception{
        return this.armadura.getProximoGolpe();
    }
    public Armadura getArmadura(){
        return this.armadura;
    }
    public String getCSV(){
        StringBuilder csv = new StringBuilder(512);
        csv.append(this.getNome())
        .append(",")
        .append(this.getVida())
        .append(",")
        .append(this.getNomeConstelacao())
        .append(",")
        .append(this.getArmadura().getCategoria())
        .append(",")
        .append(this.getStatus())
        .append(",")
        .append(this.getGenero())
        .append(",")
        .append(this.getArmaduraVestida());
        return csv.toString();
    }
    /*
    @Override
    public int compareTo(Saint saint) {
    double outraVida = saint.getVida();

    if (saint.getVida() == outraVida)
        return 0;
    else if (saint.getVida() > outraVida)
        return 1;
    else
        return -1;
    }
    */
    
 
}
