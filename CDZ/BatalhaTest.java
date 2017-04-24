
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest{

    @Test (expected = Exception.class)
    public void GarantirQueBatalhaSemMovimentosDeDanoThrowException()throws Exception{
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint aiolia = new GoldSaint("Aiolia","Leão");
        Movimento aioliaVesteArmadura = new VestirArmadura(aiolia);
        aiolia.adicionarMovimento(aioliaVesteArmadura);
        Movimento hyogaVesteArmadura = new VestirArmadura(hyoga);
        hyoga.adicionarMovimento(hyogaVesteArmadura);
        Batalha batalha = new Batalha(hyoga,aiolia);
        batalha.iniciar();
    }

    @Test 
    public void GarantirQueBatalhaSeComporteComoOPrevisto() throws Exception{
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint aiolia = new GoldSaint("Aiolia","Leão");
        Golpe doGanso = new Golpe("Do Ganso", 20);
        aiolia.aprenderGolpe(doGanso);
        Movimento aioliaAtacaHyoga = new Golpear(aiolia,hyoga);
        Movimento aioliaVesteArmadura = new VestirArmadura(aiolia);
        aiolia.adicionarMovimento(aioliaVesteArmadura);
        aiolia.adicionarMovimento(aioliaAtacaHyoga);
        Movimento hyogaVesteArmadura = new VestirArmadura(hyoga);
        hyoga.adicionarMovimento(hyogaVesteArmadura);
        Batalha batalha = new Batalha(hyoga,aiolia);
        batalha.iniciar();
        assertEquals(Status.MORTO, hyoga.getStatus());
        assertTrue(hyoga.getArmaduraVestida());
        assertTrue(aiolia.getArmaduraVestida());
    }

}