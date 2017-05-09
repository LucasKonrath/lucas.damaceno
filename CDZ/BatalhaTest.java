
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest{
    @Test (expected = Exception.class)
    public void GarantirQueBatalhaSemMovimentosThrowException()throws Exception{
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint aiolia = new GoldSaint("Aiolia","Leão");
        Batalha batalha = new Batalha(hyoga,aiolia);
        batalha.iniciar();
    }

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
    public void BatalhaSaint1MaiorQueSaint2() throws Exception{
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint aiolia = new GoldSaint("Aiolia","Leão");
        Golpe doGanso = new Golpe("Do Ganso", 20);
        aiolia.aprenderGolpe(doGanso);
        hyoga.aprenderGolpe(new Golpe("Po De Diamante",30));
        Movimento aioliaAtacaHyoga = new Golpear(aiolia,hyoga);
        Movimento aioliaVesteArmadura = new VestirArmadura(aiolia);
        aiolia.adicionarMovimento(aioliaVesteArmadura);
        aiolia.adicionarMovimento(aioliaAtacaHyoga);
        Movimento hyogaVesteArmadura = new VestirArmadura(hyoga);
        hyoga.adicionarMovimento(hyogaVesteArmadura);
        hyoga.adicionarMovimento(new Golpear(hyoga,aiolia));
        Batalha batalha = new Batalha(hyoga,aiolia);
        batalha.iniciar();
        assertEquals(40.0,aiolia.getVida(),0.01);
        assertEquals(Status.MORTO, hyoga.getStatus());
        assertTrue(hyoga.getArmaduraVestida());
        assertTrue(aiolia.getArmaduraVestida());
    }

    @Test 
    public void BatalhaSaint2MaiorQueSaint1() throws Exception{
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint aiolia = new GoldSaint("Aiolia","Leão");
        Golpe doGanso = new Golpe("Do Ganso", 20);
        aiolia.aprenderGolpe(doGanso);
        hyoga.aprenderGolpe(new Golpe("Po De Diamante",30));
        Movimento aioliaAtacaHyoga = new Golpear(aiolia,hyoga);
        Movimento aioliaVesteArmadura = new VestirArmadura(aiolia);
        aiolia.adicionarMovimento(aioliaVesteArmadura);
        aiolia.adicionarMovimento(aioliaAtacaHyoga);
        Movimento hyogaVesteArmadura = new VestirArmadura(hyoga);
        hyoga.adicionarMovimento(hyogaVesteArmadura);
        hyoga.adicionarMovimento(new Golpear(hyoga,aiolia));
        Batalha batalha = new Batalha(aiolia,hyoga);
        batalha.iniciar();
        assertEquals(40.0,aiolia.getVida(),0.01);
        assertEquals(Status.MORTO, hyoga.getStatus());
        assertTrue(hyoga.getArmaduraVestida());
        assertTrue(aiolia.getArmaduraVestida());
    }

    @Test 
    public void BatalhaSaint1IgualSaint2() throws Exception{
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint aiolia = new BronzeSaint("Aiolia","Leão");
        Golpe doGanso = new Golpe("Do Ganso", 20);
        aiolia.aprenderGolpe(doGanso);
        hyoga.aprenderGolpe(doGanso);
        Movimento aioliaAtacaHyoga = new Golpear(aiolia,hyoga);
        aiolia.adicionarMovimento(aioliaAtacaHyoga);
        hyoga.adicionarMovimento(new Golpear(hyoga,aiolia));
        Batalha batalha = new Batalha(aiolia,hyoga);
        batalha.iniciar();
        assertEquals(20.0,aiolia.getVida(),0.01);
        assertEquals(Status.MORTO, hyoga.getStatus());
        assertFalse(hyoga.getArmaduraVestida());
        assertFalse(aiolia.getArmaduraVestida());
    }

    @ Test
    public void GuerraEntreSaints1() throws Exception{

        Saint def1 = new BronzeSaint("Hyoga", "Cisne");
        Saint def2 = new BronzeSaint("Aiolia","Leão");
        Saint def3 = new SilverSaint("Misty", "Lagarto");
        Saint def4 = new SilverSaint("Batata", "Selvagem");
        Saint def5 = new GoldSaint("Aiolia","Leão");
        Saint def6 = new GoldSaint("Mu","Áries");
        Golpe doGanso = new Golpe("Do Ganso", 20);
        def1.aprenderGolpe(doGanso);
        def2.aprenderGolpe(doGanso);
        def3.aprenderGolpe(doGanso);
        def4.aprenderGolpe(doGanso);
        def5.aprenderGolpe(doGanso);
        def6.aprenderGolpe(doGanso);
        
        Saint atk1 = new BronzeSaint("Hyoga", "Cisne");
        Saint atk2 = new BronzeSaint("Aiolia","Leão");
        Saint atk3 = new SilverSaint("Misty", "Lagarto");
        Saint atk4 = new SilverSaint("Batata", "Selvagem");
        Saint atk5 = new GoldSaint("Aiolia","Leão");
        Saint atk6 = new GoldSaint("Mu","Áries");
        atk1.aprenderGolpe(doGanso);
        atk2.aprenderGolpe(doGanso);
        atk3.aprenderGolpe(doGanso);
        atk4.aprenderGolpe(doGanso);
        atk5.aprenderGolpe(doGanso);
        atk6.aprenderGolpe(doGanso);
        
        ExercitoDeSaints defensor = new ExercitoQueAtacaEmOrdemHierarquica();
        ExercitoDeSaints atacante = new ExercitoQueAtacaEmOrdemAlternada();
        
        defensor.alistar(def1);
        defensor.alistar(def2);
        defensor.alistar(def3);
        defensor.alistar(def4);
        defensor.alistar(def5);
        defensor.alistar(def6);
        
        atacante.alistar(atk1);
        atacante.alistar(atk2);
        atacante.alistar(atk3);
        atacante.alistar(atk4);
        atacante.alistar(atk5);
        atacante.alistar(atk6);
        GuerraEntreExercitos guerraEpica = new GuerraEntreExercitos(defensor, atacante);
        guerraEpica.iniciar();
    }
    
    
    
    
    
    
    
}