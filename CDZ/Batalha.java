public class Batalha{

    private Saint saint1, saint2;
    // Construtor da classe Batalha.
    public Batalha(Saint saint1, Saint saint2){
        this.saint1 = saint1;
        this.saint2 = saint2;
    }

    public  void iniciar() throws Exception{ 
        final double dano = 10.0;
        Movimento movimento;
        Saint primeiroAAtacar = this.saint2;
        Saint segundoAAtacar = this.saint1;
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
        }
    }
}