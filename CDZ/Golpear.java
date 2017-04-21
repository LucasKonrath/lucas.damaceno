public class Golpear implements Movimento{
    private Saint golpeador;
    private Saint golpeado;
    public Golpear(Saint golpeador, Saint golpeado) throws Exception{
        this.golpeador= golpeador;
        this.golpeado = golpeado;
    }


    public void executar()throws Exception{
        int danoDoGolpe = golpeador.getProximoGolpe().getFatorDanoDoGolpe();
        if (golpeador.getArmaduraVestida() == true) {
            danoDoGolpe = danoDoGolpe * (1 + golpeador.getCategoriaArmadura());
        }
        golpeado.perderVida(danoDoGolpe);
    }

}