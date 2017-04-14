public class Batalha{
private Saint saint1;
private Saint saint2;
// Construtor da classe Batalha.
public Batalha(Saint saint1, Saint saint2){
    this.saint1 = saint1;
    this.saint2 = saint2;
}
public  void iniciar(){ 
    // Se categoria da armadura do saint 1 for maior ou igual a do Saint 2, ele ataca primeiro.
    if(this.saint1.getCategoriaArmadura() >= this.saint2.getCategoriaArmadura()){
    this.saint2.perderVida(10.0);
    System.out.println(this.saint1.nome + " de " + this.saint1.getConstelacao() + " ataca " +
    this.saint2.nome + " de " + this.saint2.getConstelacao()+ " causando 10 de dano.");
    }
    // Senão, saint 2 ataca-o.
    else {
        this.saint1.perderVida(10.0);
    System.out.println(this.saint2.nome + " de " + this.saint2.getConstelacao() + " ataca " +
    this.saint1.nome + " de " + this.saint1.getConstelacao() + " causando 10 de dano.");
}
}

}