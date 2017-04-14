// Classe Saint (Cavaleirxs que entregam justiça cósmica.)
public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
    private Genero genero=Genero.NAO_INFORMADO;
    private Status status=Status.VIVO;
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
    this.status=status;
    }
}