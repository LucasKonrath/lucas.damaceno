import java.util.Random;
public class ContraAtaque implements Movimento{
    private Saint golpeado;
    private Saint golpeador;

    public ContraAtaque(Saint golpeador, Saint golpeado){
        this.golpeado = golpeado;
        this.golpeador = golpeador;

    }

    public void executar(){
        Sorteador comDadoD6 = new DadoD6();
        SortearContraAtaque sortear = new SortearContraAtaque(comDadoD6);
        if((golpeado.getVida() < 50) && golpeado.getArmaduraVestida() == false){
            golpeado.vaiBloquearProximoAtaque = sortear.vaiContraAtacar();
        }
    }
}