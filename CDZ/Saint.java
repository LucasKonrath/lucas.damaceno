// Classe Saint (Cavaleirxs que entregam justiça cósmica.)
public class Saint {
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida;
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
    
}