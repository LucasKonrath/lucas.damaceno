public class Batalha{

    private Saint saint1, saint2;
    // Construtor da classe Batalha.
    public Batalha(Saint saint1, Saint saint2){
        this.saint1 = saint1;
        this.saint2 = saint2;
    }

    public  void iniciar() throws Exception{ 
        int contador=0;
        Movimento movimento;
        Saint primeiroAAtacar = this.saint2;
        Saint segundoAAtacar = this.saint1;
        double vidaDoPrimeiro = saint1.getVida();
        double vidaDoSegundo = saint2.getVida();
        if(saint1.getCategoriaArmadura() >= saint2.getCategoriaArmadura()) {
            primeiroAAtacar = this.saint1;
            segundoAAtacar = this.saint2;
        }
        while(saint1.getStatus() != Status.MORTO && saint2.getStatus() != Status.MORTO){
            movimento = primeiroAAtacar.getProximoMovimento();
            movimento.executar();
            if (segundoAAtacar.getStatus() != Status.MORTO){
                movimento = segundoAAtacar.getProximoMovimento();
                movimento.executar();
            }
            contador++;
            if(contador >= saint1.getTamanhoDaListaDeMovimentos() && contador >= + saint2.getTamanhoDaListaDeMovimentos()){
                if( vidaDoPrimeiro == saint1.getVida() && vidaDoSegundo == saint2.getVida()){
                    throw new Exception ("Nenhum dos Saints tem metodos causadores de dano. Batalha encerrada.");
                }
            }
        }
    }
}