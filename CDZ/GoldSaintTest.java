

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GoldSaintTest
{
    @Test
    public void garantirQueCavaleiroDeOuroPertencaAs12CasasDoZodiaco() throws Exception{
    Constelacao aries = new Constelacao("Áries");
    Constelacao touro = new Constelacao("Touro");
    Constelacao gemeos = new Constelacao("Gêmeos");
    Constelacao cancer = new Constelacao("Câncer");
    Constelacao leao = new Constelacao("Leão");
    Constelacao virgem = new Constelacao("Virgem");
    Constelacao libra = new Constelacao("Libra");
    Constelacao escorpiao = new Constelacao("Escorpião");
    Constelacao sagitario = new Constelacao("Sagitário");
    Constelacao capricornio = new Constelacao("Capricórnio");
    Constelacao aquario = new Constelacao("Aquário");
    Constelacao peixes = new Constelacao("Peixes");
    GoldSaint mu = new GoldSaint("Mu",new Armadura(aries, Categoria.OURO));
    GoldSaint aldebaran = new GoldSaint("Aldebaran",new Armadura(touro, Categoria.OURO));
    GoldSaint saga = new GoldSaint("Saga",new Armadura(gemeos, Categoria.OURO));
    GoldSaint mascaraDaMorte = new GoldSaint("Máscara da Morte",new Armadura(cancer, Categoria.OURO));
    GoldSaint aioria = new GoldSaint("Aioria",new Armadura(leao, Categoria.OURO));
    GoldSaint shaka = new GoldSaint("Shaka",new Armadura(virgem, Categoria.OURO));
    GoldSaint dohko = new GoldSaint("Dohko",new Armadura(libra, Categoria.OURO));
    GoldSaint milo = new GoldSaint("Milo",new Armadura(escorpiao, Categoria.OURO));
    GoldSaint aioros = new GoldSaint("Aioros",new Armadura(sagitario, Categoria.OURO));
    GoldSaint shura = new GoldSaint("Shura",new Armadura(capricornio, Categoria.OURO));
    GoldSaint camus = new GoldSaint("Camus",new Armadura(aquario, Categoria.OURO));
    GoldSaint afrodite = new GoldSaint("Afrodite",new Armadura(peixes, Categoria.OURO));
    }
    @Test ( expected = Exception.class)
    public void garantirQueCavaleiroDeOuroComSignoErradoDispareException()throws Exception{
    Constelacao aries = new Constelacao("Jarbas");
    GoldSaint mu = new GoldSaint("Mu",new Armadura(aries, Categoria.OURO));
    }
}
