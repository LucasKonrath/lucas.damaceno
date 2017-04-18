

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ConstelacaoTest
{ 
    @Test
    public void garantirQueConstelacaoRetorneNomeCorreto(){
    Constelacao cisne = new Constelacao("Cisne");
    assertEquals("Cisne", cisne.getNomeConstelacao());
    }
    @Test 
    public void garantirQueGetGolpesRetorneOsValoresCertos(){
        Constelacao cisne = new Constelacao("Cisne");
        Golpe doGanso = new Golpe("DoGanso",50);
        Golpe daGarca = new Golpe("DanielSan", 70);
        Golpe jutsuProibido = new Golpe("Narutao", 42);
        cisne.aprenderGolpe(doGanso);
        cisne.aprenderGolpe(daGarca);
        cisne.aprenderGolpe(jutsuProibido);
        Golpe[] golpesRecebidos = cisne.getGolpes();
        assertEquals(golpesRecebidos[0], doGanso);
        assertEquals(golpesRecebidos[1], daGarca);
        assertEquals(golpesRecebidos[2], jutsuProibido);
        
    }
    @Test (expected = Exception.class)
    public void garantirFuncionamentoDoThrowExceptionDoMetodoGetProximoGolpe()throws Exception{
    Constelacao cisne = new Constelacao("Cisne");
    cisne.getProximoGolpe();
    }
    
    @Test 
    public void garantirFuncionamentoDoMetodoGetProximoGolpe()throws Exception{
    Constelacao cisne = new Constelacao("Cisne");
    Golpe doGanso = new Golpe("Do Ganso", 75);
    Golpe doDanielSan = new Golpe("Do Daniel-San", 50);
    Golpe doLindomar = new Golpe("Sub-Zero BR", 120);
    cisne.aprenderGolpe(doGanso);
    assertEquals(cisne.getProximoGolpe(),doGanso);
    cisne.aprenderGolpe(doDanielSan);
    assertEquals(cisne.getProximoGolpe(),doDanielSan);
    cisne.aprenderGolpe(doLindomar);
    assertEquals(cisne.getProximoGolpe(),doLindomar);
    assertEquals(cisne.getProximoGolpe(),doGanso);
    }
    
}
