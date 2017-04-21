

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
    GoldSaint mu = new GoldSaint("Mu","Áries");
    GoldSaint aldebaran = new GoldSaint("Aldebaran","Touro");
    GoldSaint saga = new GoldSaint("Saga","Gêmeos");
    GoldSaint mascaraDaMorte = new GoldSaint("Máscara da Morte","Câncer");
    GoldSaint aioria = new GoldSaint("Aioria","Leão");
    GoldSaint shaka = new GoldSaint("Shaka","Virgem");
    GoldSaint dohko = new GoldSaint("Dohko","Libra");
    GoldSaint milo = new GoldSaint("Milo","Escorpião");
    GoldSaint aioros = new GoldSaint("Aioros","Sagitário");
    GoldSaint shura = new GoldSaint("Shura","Capricórnio");
    GoldSaint camus = new GoldSaint("Camus","Aquário");
    GoldSaint afrodite = new GoldSaint("Afrodite","Peixes");
    }
    @Test ( expected = Exception.class)
    public void garantirQueCavaleiroDeOuroComSignoErradoDispareException()throws Exception{
    Constelacao aries = new Constelacao("Jarbas");
    GoldSaint mu = new GoldSaint("Mu","Jarbas");
    }
}
