import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;

public class SaintTest{
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception{
    /* AAA 
    1. Arrange - Montagem dos dados de teste.
    */
        Saint seiya = new BronzeSaint("Seiya", "Pegaso");
    /*
    2. Act - Invocar a ação a ser testada.
    */
        seiya.vestirArmadura();
        boolean resultado = seiya.getArmaduraVestida();
   /*
    3. Assert - Verificação dos resultados do teste.
    */ 
        assertTrue(resultado);
    }
    @Test 
    public void garantirQueMetodoDespirArmaduraFuncione() throws Exception{
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        shun.vestirArmadura();
        shun.despirArmadura();
        assertEquals(false, shun.getArmaduraVestida());
    }
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception{
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        assertEquals(false, hyoga.getArmaduraVestida());
    }
    @Test
    public void garantirQueSaintNascaVivo() throws Exception{
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        assertEquals(Status.VIVO, shun.getStatus());
    }
    @Test
    public void garantirQueGeneroDefaultSejaNaoInformado() throws Exception{
        Saint ikki = new BronzeSaint("Ikki", "Fênix");
        assertEquals(Genero.NAO_INFORMADO, ikki.getGenero());
    }
    @Test
    public void garantirQueTrocarGeneroTroqueDeFatoOGenero()throws Exception{
        Saint shun = new BronzeSaint("Shun","Andrômeda");
        shun.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, shun.getGenero());
    }
   
    
    @Test
    public void garantirQueFuncaoPerderVidaEstejaCalculandoCorretamente()throws Exception{
        Saint ichi = new BronzeSaint("Ichi","Fênix");
        ichi.perderVida(23.2);
        //assertEquals(expected, actual, delta) utilizado abaixo, para comparar valor obtido com o esperado.
        // parâmetro delta é a tolerância aceita.
        assertEquals(ichi.getVida(),76.8,0.01);
    }
    @Test
    public void garantirQueSaintFaleceComMenosDe1DeVida()throws Exception{
        Saint ichi = new BronzeSaint("Ichi","Hidra");
        ichi.perderVida(98.9);
        assertEquals(ichi.getStatus(), Status.VIVO);
        ichi.perderVida(0.11);
        assertEquals(ichi.getStatus(), Status.MORTO);
        //assertEquals(expected, actual, delta) utilizado acima, para comparar valor obtido com o esperado.
        // parâmetro delta é a tolerância aceita.
    }
    @Test
    public void garantirQueSaintAoFicarComMenosDe1DeVidaFiqueCom0()throws Exception{
        Saint ichi = new BronzeSaint("Ichi","Hidra");
        ichi.perderVida(99.2);
        assertEquals(ichi.getVida(),0.0,0.0000001);
        ichi.perderVida(20000);
        assertEquals(ichi.getVida(),0.0,0.0000001);
        ichi.perderVida(20000);
        assertEquals(ichi.getVida(),0.0,0.0000001);
        //assertEquals(expected, actual, delta) utilizado acima, para comparar valor obtido com o esperado.
        // parâmetro delta é a tolerância aceita.
    }
     @Test
    public void garantirQueSaintAoPerderMuitaVidaFiqueCom0()throws Exception{
        Saint ichi = new BronzeSaint("Ichi","Hidra");
        ichi.perderVida(20000);
        assertEquals(ichi.getVida(),0.0,0.0000001);
        assertEquals(Status.MORTO, ichi.getStatus());
        //assertEquals(expected, actual, delta) utilizado acima, para comparar valor obtido com o esperado.
        // parâmetro delta é a tolerância aceita.
    }

    @Test
    public void garantirQueSaintTenha0deVidaAoTomar100DeDano()throws Exception{
        Saint ichi = new BronzeSaint("Ichi","Hidra");
        ichi.perderVida(100);
        //assertEquals(expected, actual, delta) utilizado acima, para comparar valor obtido com o esperado.
        // parâmetro delta é a tolerância aceita.
        assertEquals(ichi.getVida(),0,0.01);
    }
    @Test
    public void garantirQueVidaPadraoSeja100()throws Exception{
        Saint kanon = new BronzeSaint("Kanon","Touro");
        assertEquals(kanon.getVida(),100.0,0.01);
    }
    @Test
    public void garantirQuePesoDaArmaduraSejaAdquiridoCorretamenteParaCavaleiroDeOuro()throws Exception{
        Saint aiolia = new GoldSaint("Aiolia","Leão");
        assertEquals(aiolia.getCategoriaArmadura(), 3);
    }
    @Test
    public void garantirQuePesoDaArmaduraSejaAdquiridoCorretamenteParaCavaleiroDePrata()throws Exception{
        Saint misty = new SilverSaint("Misty","Lagarto");
        assertEquals(misty.getCategoriaArmadura(), 2);
    }
    @Test
    public void garantirQuePesoDaArmaduraSejaAdquiridoCorretamenteParaCavaleiroDeBronze()throws Exception{
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        assertEquals(shiryu.getCategoriaArmadura(), 1);
    }

    @Test
    public void garantirQueMetodoGetConstelacaoDoSaintFuncioneAdequadamente()throws Exception{
        Saint ikki = new BronzeSaint("Ikki","Fênix");
        assertEquals(ikki.getNomeConstelacao(),"Fênix");
    }
    @Test
    public void garantirQueMetodoGetConstelacaoDaArmaduraFuncioneAdequadamente()throws Exception{
        Armadura aries = new Armadura(new Constelacao("Touro"), Categoria.OURO);
        assertEquals(aries.getNomeConstelacao(),"Touro");
    }
    @Test
    public void BronzeSaintNasceCom5SentidosDespertados()throws Exception{
    BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
    assertEquals(shun.getQtdSentidosDespertados(),5);
    }
    @Test
    public void SaintPrataTem6Sentidos()throws Exception{
    SilverSaint shun = new SilverSaint("Shun","Andrômeda");
    assertEquals(shun.getQtdSentidosDespertados(),6);
    }
    @Test
    public void SaintOuroTem7Sentidos()throws Exception{
    GoldSaint shun = new GoldSaint("Shun", "Libra");
    assertEquals(shun.getQtdSentidosDespertados(),7);
    }
    
   
    @Test(expected = InvalidParameterException.class)
    public void garantirQueDanoNegativoThrowsException() throws Exception{
    SilverSaint ikki = new SilverSaint("Ikki", "Fênix");
    ikki.perderVida(-200);
}
}
