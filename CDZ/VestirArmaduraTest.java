
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
public class VestirArmaduraTest{

    @Test
    public void vestirArmaduraDeixaArmaduraVestida() throws Exception{
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Movimento vestirHyoga = new VestirArmadura(hyoga);
        vestirHyoga.executar();
        assertTrue(hyoga.getArmaduraVestida());
    }

    @Test
    public void naoVestirArmadura()throws Exception{
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");
        Movimento vestirHyoga = new VestirArmadura(hyoga);
        assertFalse(hyoga.getArmaduraVestida());
    }

    @Test (expected = NullPointerException.class)
    public void vestirArmaduraComSaintNull() throws Exception{
        Saint shaina = null;
        Movimento movimento = new VestirArmadura(shaina);
        movimento.executar();
    }

}