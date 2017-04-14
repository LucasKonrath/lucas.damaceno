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
        if(saint1.getCategoriaArmadura() >= saint2.getCategoriaArmadura()){
           saint2.perderVida(10.0);
           System.out.println(saint1.nome + " de " + saint1.getConstelacao() + " ataca " +
               saint2.nome + " de " + saint2.getConstelacao()+ " causando 10 de dano.");
       }
// Senão, saint 2 ataca-o.
       else{
        saint1.perderVida(10.0);
        System.out.println(saint2.nome + " de " + saint2.getConstelacao() + " ataca " +
           saint1.nome + " de " + saint1.getConstelacao() + " causando 10 de dano.");
    	}
	}

}