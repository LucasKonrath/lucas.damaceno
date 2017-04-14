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
  
}
