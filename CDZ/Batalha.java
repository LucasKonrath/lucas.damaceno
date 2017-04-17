public class Batalha{

  private Saint saint1, saint2;
// Construtor da classe Batalha.
  public Batalha(Saint saint1, Saint saint2){
    this.saint1 = saint1;
    this.saint2 = saint2;
  }

  public  void iniciar() throws Exception{ 
	final double dano = 10.0;
// Se categoria da armadura do saint 1 for maior ou igual a do Saint 2, ele ataca primeiro.
    if(saint1.getCategoriaArmadura() >= saint2.getCategoriaArmadura()){
      saint2.perderVida(dano);
      System.out.println(saint1 + " ataca " +
      saint2 + " causando " + dano + " de dano.");
    }
// Senão, saint 2 ataca-o.
    else{
      saint1.perderVida(dano);
      System.out.println(saint2 + " ataca " +
      saint1 + " causando " + dano + " de dano.");
    }
  }

}