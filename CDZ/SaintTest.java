import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest{
    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception{
    /* AAA 
    1. Arrange - Montagem dos dados de teste.
    */
        Armadura pegaso = new Armadura ("Pegaso",Categoria.BRONZE);
        Saint seiya = new Saint("Seiya", pegaso);
    /*
    2. Act - Invocar a ação a ser testada.
    */
        seiya.vestirArmadura();
        boolean resultado = seiya.getArmaduraVestida();
   /*
    3. Assert - Verificação dos resultados do teste.
    */ 
        assertEquals(true, resultado);
    }
    @Test 
    public void garantirQueMetodoDespirArmaduraFuncione() throws Exception{
        Saint shun = new Saint("Shun", new Armadura("Andrômeda",Categoria.BRONZE));
        shun.vestirArmadura();
        shun.despirArmadura();
        assertEquals(false, shun.getArmaduraVestida());
    }
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida() throws Exception{
        Saint hyoga = new Saint("Hyoga", new Armadura("Cisne",Categoria.BRONZE));
        assertEquals(false, hyoga.getArmaduraVestida());
    }
    @Test
    public void garantirQueSaintNascaVivo() throws Exception{
        Saint shun = new Saint("Shun", new Armadura ("Andrômeda",Categoria.BRONZE));
        assertEquals(Status.VIVO, shun.getStatus());
    }
    @Test
    public void garantirQueGeneroDefaultSejaNaoInformado() throws Exception{
        Saint ikki = new Saint("Ikki", new Armadura ("Fênix",Categoria.BRONZE));
        assertEquals(Genero.NAO_INFORMADO, ikki.getGenero());
    }
    @Test
    public void garantirQueTrocarGeneroTroqueDeFatoOGenero()throws Exception{
        Saint shun = new Saint("Shun", new Armadura ("Andrômeda", Categoria.BRONZE));
        shun.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, shun.getGenero());
    }
    @Test
    public void garantirQueTrocarStatusTroqueDeFatoOStatus()throws Exception{
        Saint jabu = new Saint("Jabu", new Armadura ("Unicórnio", Categoria.BRONZE));
        jabu.setStatus(Status.DESACORDADO);
        assertEquals(Status.DESACORDADO, jabu.getStatus());
    }
    @Test
    public void garantirQueStatusNaoSejaEstatico()throws Exception{
        Saint jabu = new Saint("Jabu", new Armadura ("Unicórnio", Categoria.BRONZE));
        jabu.setStatus(Status.MORTO);
        assertEquals(Status.MORTO, jabu.getStatus());
    }
    
    @Test
    public void garantirQueFuncaoPerderVidaEstejaCalculandoCorretamente()throws Exception{
        Saint ichi = new Saint("Ichi", new Armadura("Hidra", Categoria.BRONZE));
        ichi.perderVida(23.2);
        //assertEquals(expected, actual, delta) utilizado abaixo, para comparar valor obtido com o esperado.
        // parâmetro delta é a tolerância aceita.
        assertEquals(ichi.getVida(),76.8,0.01);
    }
@Test
    public void garantirQueFuncaoPerderVidaEstejaCalculandoCorretamenteParaDanoNegativo()throws Exception{
        Saint ichi = new Saint("Ichi", new Armadura("Hidra", Categoria.BRONZE));
        ichi.perderVida(-23.2);
        //assertEquals(expected, actual, delta) utilizado abaixo, para comparar valor obtido com o esperado.
        // parâmetro delta é a tolerância aceita.
        assertEquals(ichi.getVida(),123.2,0.01);
    }
@Test
    public void garantirQueSaintTenha0deVidaAoTomar100DeDano()throws Exception{
        Saint ichi = new Saint("Ichi", new Armadura("Hidra", Categoria.BRONZE));
        ichi.perderVida(100);
        //assertEquals(expected, actual, delta) utilizado abaixo, para comparar valor obtido com o esperado.
        // parâmetro delta é a tolerância aceita.
        assertEquals(ichi.getVida(),0,0.01);
    }
    @Test
    public void garantirQueVidaPadraoSeja100()throws Exception{
        Saint kanon = new Saint("Kanon", new Armadura("Touro", Categoria.OURO));
        assertEquals(kanon.getVida(),100.0,0.01);
    }
    @Test
    public void garantirQuePesoDaArmaduraSejaAdquiridoCorretamenteParaCavaleiroDeOuro()throws Exception{
        Saint aiolia = new Saint("Aiolia", new Armadura("Touro", Categoria.OURO));
        assertEquals(aiolia.getCategoriaArmadura(), 3);
    }
    @Test
    public void garantirQuePesoDaArmaduraSejaAdquiridoCorretamenteParaCavaleiroDePrata()throws Exception{
        Saint misty = new Saint("Misty", new Armadura("Lagarto", Categoria.PRATA));
        assertEquals(misty.getCategoriaArmadura(), 2);
    }
    @Test
    public void garantirQuePesoDaArmaduraSejaAdquiridoCorretamenteParaCavaleiroDeBronze()throws Exception{
        Saint shiryu = new Saint("Shiryu", new Armadura("Dragão", Categoria.BRONZE));
        assertEquals(shiryu.getCategoriaArmadura(), 1);
    }

    @Test
    public void garantirQueMetodoGetConstelacaoDoSaintFuncioneAdequadamente()throws Exception{
        Saint ikki = new Saint("Ikki", new Armadura("Fênix",Categoria.BRONZE));
        assertEquals(ikki.getConstelacao(),"Fênix");
    }
    @Test
    public void garantirQueMetodoGetConstelacaoDaArmaduraFuncioneAdequadamente()throws Exception{
        Armadura aries = new Armadura("Touro", Categoria.OURO);
        assertEquals(aries.getConstelacao(),"Touro");
    }
	@Test
	public void SaintNasceCom5SentidosDespertados()throws Exception{
	Saint shun = new Saint("Shun", new Armadura("Andrômeda",Categoria.BRONZE));
	assertEquals(shun.getQtdSentidosDespertados(),5);
	}
	@Test
	public void SaintPrataTem6Sentidos()throws Exception{
	Saint shun = new Saint("Shun", new Armadura("Andrômeda",Categoria.PRATA));
	assertEquals(shun.getQtdSentidosDespertados(),6);
	}
	@Test
	public void SaintOuroTem7Sentidos()throws Exception{
	Saint shun = new Saint("Shun", new Armadura("Touro",Categoria.OURO));
	assertEquals(shun.getQtdSentidosDespertados(),7);
	}
}
