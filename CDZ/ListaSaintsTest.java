

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

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

@Test
public void garantirQueMetodoTodosFuncioneNormalmente()throws Exception{
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
    ArrayList<Saint> teste = lista.todos();
    assertEquals(lista.todos(), teste);
}
@Test
public void buscarPorNomeFuncionaAdequadamente() throws Exception{
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
    Saint definitivamenteNaoEOHyoga = lista.buscarPorNome("Hyoga");
    assertEquals(hyoga,definitivamenteNaoEOHyoga);
}
@Test public void buscarSaintExistenteComRepeticao()throws Exception{
    ListaSaints lista = new ListaSaints();
    Constelacao cisne = new Constelacao("Cisne");
    Armadura deCisne = new Armadura(cisne,Categoria.BRONZE);
    Constelacao fenix = new Constelacao("Fenix");
    Armadura deFenix = new Armadura(cisne,Categoria.BRONZE);
    Constelacao lagarto = new Constelacao("Lagarto");
    Armadura deLagarto = new Armadura(lagarto, Categoria.PRATA);
    BronzeSaint ikki = new BronzeSaint("Ikki", deFenix);
    BronzeSaint hyoga = new BronzeSaint("Hyoga", deCisne);
    BronzeSaint misty = new BronzeSaint("Hyoga", deLagarto);
    lista.adicionaSaint(ikki);
    lista.adicionaSaint(hyoga);
    lista.adicionaSaint(misty);
    Saint definitivamenteNaoEOHyoga = lista.buscarPorNome("Hyoga");
    assertEquals(hyoga,definitivamenteNaoEOHyoga);
}
@Test
public void buscarPorNomeRetornaNullSeNaoHouverSaint() throws Exception{
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
    Saint definitivamenteNaoEOHyoga = lista.buscarPorNome("Yoda");
    assertEquals(null,definitivamenteNaoEOHyoga);
}
@Test 
public void buscarPorNomeEmListaVaziaRetornaNull(){
assertNull(new ListaSaints().buscarPorNome("Seiya"));
}
@Test
public void garantirFuncionamentoDaBuscaPorCategoria()throws Exception{
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
    ArrayList<Saint> bronze = lista.buscarPorCategoria(Categoria.BRONZE);
    lista.remover(misty);
    ArrayList<Saint> todos = lista.todos();
    assertEquals(bronze, todos);
}
@Test public void buscaPorCategoriaComListaVaziaRetornaNull(){
    ListaSaints lista = new ListaSaints();
    assertEquals(lista.buscarPorCategoria(Categoria.BRONZE), new ArrayList<Saint>());
}
}

