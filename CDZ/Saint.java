// Classe Saint (Cavaleirxs que entregam justiça cósmica.)
public class Saint {
    public String nome;
    protected Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero=Genero.NAO_INFORMADO;
    private Status status=Status.VIVO;
    private double vida = 100.0;
    protected int qtdSentidosDespertados;
// Construtor da classe Saint
    public Saint(String nome, Armadura armadura) throws Exception{
            this.armadura=armadura;
            this.nome=nome;
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
 // Método para alterar Status do saint.
    

// Metodo que causa dano no Saint.
    public void perderVida(double dano) throws Exception {
        if (dano < 0){
        throw new Exception ("Invalid Parameter Exception");
        }
        if((this.vida) > 1)this.vida -= dano;
        if (this.vida < 1) {
            this.vida=0;
            this.status = Status.MORTO;
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
    public Golpe[] getGolpes(){
       return this.armadura.getGolpes();
    }
    public void aprenderGolpe(Golpe golpe){
        this.armadura.aprenderGolpe(golpe);
    }
    public Golpe getProximoGolpe() throws Exception{
        return this.armadura.getProximoGolpe();
    }
 
}
