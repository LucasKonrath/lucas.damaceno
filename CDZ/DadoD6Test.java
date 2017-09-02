import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;

public class DadoD6Test{
    @Test
    public void testRandomizer() throws Exception{
        Sorteador comDadoD6 = new DadoD6();
        for(int x=0; x <2000; x++){
            if(comDadoD6.sortear() > 6 || comDadoD6.sortear() < 1) throw new Exception("Numero invalido gerado.");
        }

    }
}