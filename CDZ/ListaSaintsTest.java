
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
        BronzeSaint ikki = new BronzeSaint("Ikki","Fênix");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","Cisne");
        BronzeSaint misty = new BronzeSaint("Misty","Lagarto");
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
        BronzeSaint ikki = new BronzeSaint("Ikki", "Fênix");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","Cisne");
        BronzeSaint misty = new BronzeSaint("Misty","Lagarto");
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
        BronzeSaint ikki = new BronzeSaint("Ikki", "Fênix");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","Cisne");
        BronzeSaint misty = new BronzeSaint("Misty","Lagarto");
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
        BronzeSaint ikki = new BronzeSaint("Ikki", "Fênix");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","Cisne");
        BronzeSaint misty = new BronzeSaint("Misty","Lagarto");
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
        BronzeSaint ikki = new BronzeSaint("Ikki", "Fênix");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","Cisne");
        BronzeSaint misty = new BronzeSaint("Misty","Lagarto");
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
        BronzeSaint ikki = new BronzeSaint("Ikki", "Fênix");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","Cisne");
        Saint misty = new SilverSaint("Misty","Lagarto");
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

    @Test
    public void buscaPorCategoriaComListaVaziaRetornaNull(){
        ListaSaints lista = new ListaSaints();
        assertEquals(lista.buscarPorCategoria(Categoria.BRONZE), new ArrayList<Saint>());
    }

    @Test
    public void buscaPorCategoriaInexistente()throws Exception{
        ListaSaints lista = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        lista.adicionaSaint(june);
        assertEquals(lista.buscarPorCategoria(Categoria.PRATA), new ArrayList<Saint>());
    }

    @Test 
    public void buscaPorStatusComListaVaziaRetornaNull()throws Exception{
        ListaSaints lista = new ListaSaints();
        ArrayList<Saint> jabu = lista.buscarPorStatus(Status.VIVO);
        assertEquals(0,jabu.size());
    }

    @Test 
    public void buscarPorStatusInexistente()throws Exception{
        ListaSaints lista = new ListaSaints();
        BronzeSaint ikki = new BronzeSaint("Ikki", "Fênix");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","Cisne");
        Saint misty = new SilverSaint("Misty","Lagarto");
        lista.adicionaSaint(misty);
        lista.adicionaSaint(hyoga);
        lista.adicionaSaint(ikki);
        ArrayList<Saint> jabu = lista.buscarPorStatus(Status.DESACORDADO);
        assertEquals(0,jabu.size());
    }

    @Test 
    public void buscarPorStatusExistente()throws Exception{
        ListaSaints lista = new ListaSaints();
        BronzeSaint ikki = new BronzeSaint("Ikki", "Fênix");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","Cisne");
        Saint misty = new SilverSaint("Misty","Lagarto");
        lista.adicionaSaint(misty);
        lista.adicionaSaint(hyoga);
        lista.adicionaSaint(ikki);
        misty.perderVida(99.2);
        ikki.perderVida(99.2);
        ArrayList<Saint> jabu = lista.buscarPorStatus(Status.MORTO);
        assertEquals(2,jabu.size());
        assertEquals(misty,jabu.get(0));
        assertEquals(ikki,jabu.get(1));
    }

    @Test
    public void getSaintMaiorVidaComListaVazia()throws Exception{
        ListaSaints lista = new ListaSaints();
        Saint nulo = lista.getSaintMaiorVida();
        assertNull(nulo);
    }

    @Test
    public void getSaintMaiorVidaComApenasUm() throws Exception {
        ListaSaints lista = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        lista.adicionaSaint(june);
        assertEquals(june, lista.getSaintMaiorVida());
    }

    @Test
    public void getSaintMaiorVidaComApenasTres() throws Exception {
        ListaSaints lista = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        lista.adicionaSaint(shun);
        lista.adicionaSaint(misty);
        lista.adicionaSaint(june);
        shun.perderVida(10);
        june.perderVida(20);
        assertEquals(misty, lista.getSaintMaiorVida());
    }

    @Test
    public void getSaintMenorVidaComListaVazia()throws Exception{
        ListaSaints lista = new ListaSaints();
        Saint nulo = lista.getSaintMenorVida();
        assertNull(nulo);
    }

    @Test
    public void getSaintMenorVidaComApenasUm() throws Exception {
        ListaSaints lista = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        lista.adicionaSaint(june);
        assertEquals(june, lista.getSaintMenorVida());
    }

    @Test
    public void ordenarComListaVazia() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(new ArrayList<Saint>(), resultado);
    }

    @Test
    public void ordenarComListaDeValoresIguais() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionaSaint(shun);
        listaSaints.adicionaSaint(misty);
        listaSaints.adicionaSaint(june);
        listaSaints.ordenar();
        ArrayList<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }

    @Test
    public void getSaintMenorVidaComApenasTres() throws Exception {
        ListaSaints lista = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        lista.adicionaSaint(shun);
        lista.adicionaSaint(misty);
        lista.adicionaSaint(june);
        shun.perderVida(10);
        june.perderVida(20);
        assertEquals(june, lista.getSaintMenorVida());
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
        BronzeSaint ikki = new BronzeSaint("Ikki", "Fênix");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","Cisne");
        BronzeSaint misty = new BronzeSaint("Misty","Lagarto");
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
        BronzeSaint ikki = new BronzeSaint("Ikki", "Fênix");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","Cisne");
        BronzeSaint misty = new BronzeSaint("Misty","Lagarto");
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
    public void garantirFuncionamentoDoMetodoUnirLista()throws Exception{
        Constelacao cisne = new Constelacao("Cisne");
        Armadura deCisne = new Armadura(cisne, Categoria.BRONZE);
        BronzeSaint shun = new BronzeSaint("Shun", "Andrômeda");
        BronzeSaint shiryu = new BronzeSaint("Shiryu", "Dragão");
        BronzeSaint ikki = new BronzeSaint("Ikki", "Fênix");
        BronzeSaint misty = new BronzeSaint("Misty", "Lagarto");
        BronzeSaint hyoga = new BronzeSaint("Hyoga", "Cisne");
        BronzeSaint jabu = new BronzeSaint("Jabu", "Unicórnio");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista1.adicionaSaint(shun);
        lista1.adicionaSaint(shiryu);
        lista1.adicionaSaint(ikki);
        lista1.adicionaSaint(misty);
        lista1.adicionaSaint(hyoga);
        lista1.adicionaSaint(jabu);
        lista1.adicionaSaint(hyoga);
        lista1.adicionaSaint(jabu);
        lista2.adicionaSaint(misty);
        lista2.adicionaSaint (hyoga);
        lista2.adicionaSaint(ikki);
        ListaSaints listaResultado = lista1.unir(lista2);
        ArrayList<Saint> resultado = listaResultado.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(shiryu, resultado.get(1));
        assertEquals(ikki, resultado.get(2));
        assertEquals(misty, resultado.get(3));
        assertEquals(hyoga, resultado.get(4));
        assertEquals(jabu, resultado.get(5));
        assertEquals(hyoga, resultado.get(6));
        assertEquals(jabu, resultado.get(7));
        assertEquals(misty, resultado.get(8));
        assertEquals(hyoga, resultado.get(9));
        assertEquals(ikki, resultado.get(10));
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
        BronzeSaint ikki = new BronzeSaint("Ikki", "Fênix");
        BronzeSaint hyoga = new BronzeSaint("Hyoga","Cisne");
        BronzeSaint misty = new BronzeSaint("Misty","Lagarto");
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
        BronzeSaint shun = new BronzeSaint("Shun","Andrômeda");
        BronzeSaint shiryu = new BronzeSaint("Shiryu", "Dragão");
        BronzeSaint ikki = new BronzeSaint("Ikki", "Fênix");
        BronzeSaint misty = new BronzeSaint("Misty", "Lagarto");
        BronzeSaint hyoga = new BronzeSaint("Hyoga", "Cisne");
        BronzeSaint jabu = new BronzeSaint("Jabu", "Unicórnio");
        ListaSaints lista1 = new ListaSaints();
        ListaSaints lista2 = new ListaSaints();
        lista1.adicionaSaint(shun);
        lista1.adicionaSaint(shiryu);
        lista1.adicionaSaint(ikki);
        lista1.adicionaSaint(misty);
        lista1.adicionaSaint(hyoga);
        lista1.adicionaSaint(jabu);
        lista1.adicionaSaint(hyoga);
        lista1.adicionaSaint(jabu);
        lista2.adicionaSaint(misty);
        lista2.adicionaSaint (hyoga);
        lista2.adicionaSaint(ikki);
        ListaSaints listaResultado = lista1.diff(lista2);
        ArrayList<Saint> resultado = listaResultado.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(shiryu, resultado.get(1));
        assertEquals(jabu, resultado.get(2));
        assertEquals(jabu, resultado.get(3));
    }
    
    @Test
    public void getCSVComListaVazia() throws Exception {
        ListaSaints lista = new ListaSaints();
        assertEquals("", lista.getCSV());
    }
    
     @Test
    public void getCSVComApenasUmSaint() throws Exception {
        ListaSaints lista = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionaSaint(june);
        String esperado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(esperado, lista.getCSV());
    }
    
    @Test
    public void getCSVComApenasDoisSaints() throws Exception {
        ListaSaints lista = new ListaSaints();
        BronzeSaint june = new BronzeSaint("June", "");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionaSaint(june);
        Saint dohko = new GoldSaint("Dohko", "Libra");
        dohko.perderVida(90);
        dohko.vestirArmadura();
        lista.adicionaSaint(dohko);
        String esperado = "June,84.5,,BRONZE,VIVO,FEMININO,false"+System.getProperty("line.separator")+"Dohko,10.0,Libra,OURO,VIVO,NAO_INFORMADO,true";
        assertEquals(esperado, lista.getCSV());
    }
    
    
}

