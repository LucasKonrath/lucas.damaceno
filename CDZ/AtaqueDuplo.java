import java.util.Random;
public class AtaqueDuplo implements Movimento{
    private Saint golpeador;
    private Saint golpeado;
    public AtaqueDuplo(Saint golpeador, Saint golpeado){
        this.golpeador = golpeador;
        this.golpeado=golpeado;

    }

    public void executar()throws Exception{
        Sorteador comDadoD6 = new DadoD6();
        CriticalHit acertoCritico = new CriticalHit(comDadoD6);
        int danoDoGolpe= golpeador.getProximoGolpe().getFatorDanoDoGolpe();
        if(acertoCritico.isCriticalHit()){
            if (golpeador.getArmaduraVestida() == true) {
                danoDoGolpe  *= (1 + golpeador.getCategoriaArmadura());
            }
            this.golpeado.perderVida(2*danoDoGolpe);
        }
        else {
            golpeador.perderVida(golpeador.getVida()*0.05);
            this.golpeado.perderVida(danoDoGolpe);
        }
    }

}