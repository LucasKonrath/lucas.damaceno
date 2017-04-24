
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpearTest{

    @Test
    public void GolpearComSaintBronzeSemArmadura() throws Exception{
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint aiolia = new BronzeSaint("Aiolia","Leão");
        Golpe doGanso = new Golpe("Do Ganso", 20);
        aiolia.aprenderGolpe(doGanso);
        Golpear test = new Golpear(aiolia,hyoga);
        test.executar();
        assertEquals(hyoga.getVida(), 80.0, 0.00001);
    }

    @Test
    public void GolpearComSaintPrataSemArmadura() throws Exception{
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint aiolia = new SilverSaint("Aiolia","Leão");
        Golpe doGanso = new Golpe("Do Ganso", 20);
        aiolia.aprenderGolpe(doGanso);
        Golpear test = new Golpear(aiolia,hyoga);
        test.executar();
        assertEquals(hyoga.getVida(), 80.0, 0.00001);
    }

    @Test
    public void GolpearComSaintOuroSemArmadura()throws Exception{
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint aiolia = new GoldSaint("Aiolia","Leão");
        Golpe doGanso = new Golpe("Do Ganso", 20);
        aiolia.aprenderGolpe(doGanso);
        Golpear test = new Golpear(aiolia,hyoga);
        test.executar();
        assertEquals(hyoga.getVida(), 80.0, 0.00001);
    }

    @Test
    public void GolpearComSaintBronzeComArmadura()throws Exception{
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint aiolia = new BronzeSaint("Aiolia","Leão");
        Golpe doGanso = new Golpe("Do Ganso", 20);
        aiolia.aprenderGolpe(doGanso);
        aiolia.vestirArmadura();
        Golpear test = new Golpear(aiolia,hyoga);
        test.executar();
        assertEquals(hyoga.getVida(), 60.0, 0.00001);
    }

    @Test
    public void GolpearComSaintPrataComArmadura() throws Exception{
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint aiolia = new SilverSaint("Aiolia","Leão");
        Golpe doGanso = new Golpe("Do Ganso", 20);
        aiolia.aprenderGolpe(doGanso);
        aiolia.vestirArmadura();
        Golpear test = new Golpear(aiolia,hyoga);
        test.executar();
        assertEquals(hyoga.getVida(), 40.0, 0.00001);
    }

    @Test
    public void GolpearComSaintOuroComArmadura()throws Exception{
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint aiolia = new GoldSaint("Aiolia","Leão");
        Golpe doGanso = new Golpe("Do Ganso", 20);
        aiolia.aprenderGolpe(doGanso);
        aiolia.vestirArmadura();
        Golpear test = new Golpear(aiolia,hyoga);
        test.executar();
        assertEquals(hyoga.getVida(), 20.0, 0.00001);
    }

    @Test (expected = Exception.class)
    public void GolpearComSaintsSemGolpes() throws Exception{
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Saint aiolia = new BronzeSaint("Aiolia","Leão");
        Golpear test = new Golpear(aiolia,hyoga);
        test.executar();
    }

}