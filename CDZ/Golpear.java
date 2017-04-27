public class Golpear implements Movimento{
    private Saint golpeador;
    private Saint golpeado;
    public Golpear(Saint golpeador, Saint golpeado) throws Exception{
        this.golpeador= golpeador;
        this.golpeado = golpeado;
    }

    public void executar()throws Exception{
        int danoDoGolpe = golpeador.getProximoGolpe().getFatorDanoDoGolpe();
        if(golpeado.vaiBloquearProximoAtaque == false){
            if (golpeador.getArmaduraVestida() == true) {
                danoDoGolpe  *= (1 + golpeador.getCategoriaArmadura());
            }
            this.golpeado.perderVida(danoDoGolpe);
        }
        else{ 
            this.golpeador.perderVida(golpeador.getVida() * 0.25);
            golpeado.vaiBloquearProximoAtaque = false;
        }
    }

    public boolean equals(Object outro){
        Golpear outroGolpear =(Golpear)outro;
        return this.golpeador.equals(outroGolpear.golpeador) && this.golpeado.equals(outroGolpear.golpeado);
    }

}