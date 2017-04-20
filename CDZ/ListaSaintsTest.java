
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
        lista.remover(hyoga);
        ArrayList<Saint> todos2 = lista.todos();
        ArrayList<Saint> bronze2 = lista.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(todos2,bronze2);
    }

    @Test public void buscaPorCategoriaComListaVaziaRetornaNull(){
        ListaSaints lista = new ListaSaints();
        assertEquals(lista.buscarPorCategoria(Categoria.BRONZE), new ArrayList<Saint>());
    }

    @Test 
    public void ordenarComListaTotalmenteDesordenada()throws Exception{
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
        ikki.perderVida(10);
        hyoga.perderVida(20);
        misty.perderVida(30);
        lista.ordenar();
        ArrayList<Saint> resultado = lista.todos();
        assertEquals(misty,resultado.get(0));
        assertEquals(hyoga,resultado.get(1));
        assertEquals(ikki,resultado.get(2));
    }

    @Test 
    public void ordenarComListaTotalmenteDesordenadaUtilizandoTipoOrdenacao()throws Exception{
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
        ikki.perderVida(10);
        hyoga.perderVida(20);
        misty.perderVida(30);
        lista.ordenar(TipoOrdenacao.ASCENDENTE);
        ArrayList<Saint> resultado = lista.todos();
        assertEquals(misty,resultado.get(0));
        assertEquals(hyoga,resultado.get(1));
        assertEquals(ikki,resultado.get(2));
    }

    @Test 
    public void ordenarComListaTotalmenteDesordenadaUtilizandoTipoOrdenacaoDescendente()throws Exception{
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
        ikki.perderVida(10);
        hyoga.perderVida(20);
        misty.perderVida(30);
        lista.ordenar(TipoOrdenacao.DESCENDENTE);
        ArrayList<Saint> resultado = lista.todos();
        assertEquals(misty,resultado.get(2));
        assertEquals(hyoga,resultado.get(1));
        assertEquals(ikki,resultado.get(0));
    }

    @Test
    public void metodoDiffDevolveArrayCorreto()throws Exception{
        Constelacao cisne = new Constelacao("Cisne");
        Armadura deCisne = new Armadura(cisne, Categoria.BRONZE);
        BronzeSaint shun = new BronzeSaint("Shun", deCisne);
        BronzeSaint shiryu = new BronzeSaint("Shiryu", deCisne);
        BronzeSaint ikki = new BronzeSaint("Ikki", deCisne);
        BronzeSaint misty = new BronzeSaint("Misty", deCisne);
        BronzeSaint hyoga = new BronzeSaint("Hyoga", deCisne);
        BronzeSaint jabu = new BronzeSaint("Jabu", deCisne);
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista1.adicionaSaint(shun);
        lista1.adicionaSaint(shiryu);
        lista1.adicionaSaint(ikki);
        lista1.adicionaSaint(misty);
        lista1.adicionaSaint(hyoga);
        lista1.adicionaSaint(jabu);
        lista2.adicionaSaint(misty);
        lista2.adicionaSaint (hyoga);
        lista2.adicionaSaint(ikki);
        ArrayList<Saint> resultado = lista1.diff(lista2.todos());
        assertEquals(shun, resultado.get(0));
        assertEquals(shiryu, resultado.get(1));
        assertEquals(jabu, resultado.get(2));
    }
}

