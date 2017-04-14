import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest{
    @Test
    public void vestirArmaduraDeixaArmaduraVestida(){
    /* AAA 
    1. Arrange - Montagem dos dados de teste.
    */
    Armadura estalactite = new Armadura ("Estalactite",Categoria.OURO);
    Saint shun = new Saint("Shun",estalactite);
    /*
    2. Act - Invocar a ação a ser testada.
    */
   shun.vestirArmadura();
   boolean resultado = shun.getArmaduraVestida();
   /*
    3. Assert - Verificação dos resultados do teste.
    */ 
   assertEquals(true, resultado);
    }
    @Test
    public void naoVestirArmaduraDeixaArmaduraNaoVestida(){
    Saint hyoga = new Saint("Hyoga", new Armadura("Cisne",Categoria.BRONZE));
    assertEquals(false, hyoga.getArmaduraVestida());
    }
    @Test
    public void garantirQueSaintNascaVivo(){
    Saint shun = new Saint("Shun", new Armadura ("Andrômeda",Categoria.BRONZE));
    assertEquals(Status.VIVO, shun.getStatus());
    }
    @Test
    public void garantirQueGeneroDefaultSejaNaoIdentificado(){
    Saint ikki = new Saint("Ikki", new Armadura ("Fênix",Categoria.BRONZE));
    assertEquals(Genero.NAO_INFORMADO, ikki.getGenero());
    }
    @Test
    public void garantirQueTrocarGeneroTroqueDeFatoOGenero(){
    Saint shun = new Saint("Shun", new Armadura ("Andrômeda", Categoria.BRONZE));
    shun.setGenero(Genero.FEMININO);
    assertEquals(Genero.FEMININO, shun.getGenero());
    }
    @Test
    public void garantirQueTrocarStatusTroqueDeFatoOStatus(){
    Saint jabu = new Saint("Jabu", new Armadura ("Unicórnio", Categoria.BRONZE));
    jabu.setStatus(Status.DESACORDADO);
    assertEquals(Status.DESACORDADO, jabu.getStatus());
    }
}
