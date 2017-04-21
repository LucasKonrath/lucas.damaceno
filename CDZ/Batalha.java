public class Batalha{

    private Saint saint1, saint2;
    // Construtor da classe Batalha.
    public Batalha(Saint saint1, Saint saint2){
        this.saint1 = saint1;
        this.saint2 = saint2;
    }
    
    
    // LEMBRETE À MINHA PŔOPRIA PESSOA: REFATORAR ESTE MÉTODO, PELO AMOR DE DEUS. APENAS VEJA SE A LÓGICA FUNCIONA E DEPOIS DESTRUA ESTE MONSTRO.
    public  void iniciar() throws Exception{ 
        final double dano = 10.0;
        Movimento movimento;
        while(saint1.getStatus() != Status.MORTO && saint2.getStatus() != Status.MORTO){
            // Se categoria da armadura do saint 1 for maior ou igual a do Saint 2, ele ataca primeiro.
            if(saint1.getCategoriaArmadura() >= saint2.getCategoriaArmadura()){ 
                movimento = saint1.getProximoMovimento();
                movimento.executar();
                if(saint2.getStatus() != Status.MORTO){
                    movimento = saint2.getProximoMovimento();
                    movimento.executar();
                }
            }
            // Senão, saint 2 ataca-o.
            else{
                movimento = saint2.getProximoMovimento();
                movimento.executar();
                if(saint1.getStatus() != Status.MORTO){
                   movimento = saint1.getProximoMovimento();
                   movimento.executar();
                }
            }
        }

    }
}