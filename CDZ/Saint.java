// Classe Saint (Cavaleirxs que entregam justiça cósmica.)
public class Saint {
    public String nome;
    public Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero=Genero.NAO_INFORMADO;
    private Status status=Status.VIVO;
    private double vida = 100.0;
    public Saint(String nome, Armadura armadura){
        this.armadura=armadura;
        this.nome=nome;     
    }
    
    public void vestirArmadura(){
       this.armaduraVestida = true;
    }
    //camelCase
    public boolean getArmaduraVestida(){
        return this.armaduraVestida;
    }
    public Genero getGenero(){
    return this.genero;
    }
    public void setGenero(Genero genero){
    this.genero=genero;
    }
    public Status getStatus(){
    return this.status;
    }
    public void setStatus(Status status){
    this.status = status;
    }
    public void perderVida(double dano) {
    this.vida = this.vida - dano;
    }
    public double getVida(){
    return this.vida;
    }
    public int getCategoriaArmadura(){
    return this.armadura.categoria.getValor();
    }
    
}