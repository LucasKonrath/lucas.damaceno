

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ListaSaintsTest{
@Test
public void garantirQueAdicionarSaintFuncioneAdequadamente()throws Exception{
ListaSaints lista = new ListaSaints();
Constelacao cisne = new Constelacao("Cisne");
Armadura deCisne = new Armadura(cisne,Categoria.BRONZE);
Constelacao fenix = new Constelacao("Fenix");
Armadura deFenix = new Armadura(cisne,Categoria.BRONZE);
Constelacao lagarto = new Constelacao("Lagarto");
Armadura deLagarto = new Armadura(lagarto, Categoria.PRATA);
BronzeSaint ikki = new BronzeSaint("Ikki", deFenix);
BronzeSaint hyoga = new BronzeSaint("Hyoga", deCisne);
BronzeSaint misty = new BronzeSaint("Misty", deLagarto);
lista.adicionaSaint(ikki);
lista.adicionaSaint(hyoga);
lista.adicionaSaint(misty);
assertEquals(ikki, lista.getIndice(0));
assertEquals(hyoga, lista.getIndice(1));
assertEquals(misty, lista.getIndice(2));

}

}