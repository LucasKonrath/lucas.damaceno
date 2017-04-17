

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest{

@Test
    public void garantirQueSaint2DeArmaduraMelhorAtaquePrimeiro(){
    	Saint ikki = new Saint("Ikki", new Armadura("Fênix",Categoria.PRATA));
    	Saint kanon = new Saint("Kanon", new Armadura("Gêmeos", Categoria.OURO));
    	Batalha batalha1 = new Batalha(ikki,kanon);
    	batalha1.iniciar();
    	assertEquals(ikki.getVida(),90.0, 0.00001);
		assertEquals(kanon.getVida(),100.0,0.001);
    }
    @Test
    public void garantirQueCasoArmadurasSejamIguaisOPrimeiroAtaque(){
    	Saint ikki = new Saint("Ikki", new Armadura("Fênix",Categoria.PRATA));
    	Saint kanon = new Saint("Kanon", new Armadura("Gêmeos", Categoria.PRATA));
    	Batalha batalha1 = new Batalha(ikki,kanon);
    	batalha1.iniciar();
    	assertEquals(kanon.getVida(),90.0, 0.00001);
		assertEquals(ikki.getVida(),100.0, 0.00001);
    }
	@Test
    public void garantirQueSaint1DeArmaduraMelhorAtaquePrimeiro(){
    	Saint ikki = new Saint("Ikki", new Armadura("Fênix",Categoria.PRATA));
    	Saint kanon = new Saint("Kanon", new Armadura("Gêmeos", Categoria.OURO));
    	Batalha batalha1 = new Batalha(kanon,ikki);
    	batalha1.iniciar();
    	assertEquals(ikki.getVida(),90.0, 0.00001);
		assertEquals(kanon.getVida(),100.0,0.001);
    }

}