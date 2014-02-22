
package ifes.edu.br.poo2.xadrez.model.peca;

import ifes.edu.br.poo2.xadrez.cdp.peca.Peca;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumPeca;
import ifes.edu.br.poo2.xadrez.cdp.peca.PecaPretaFactory;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PecaPretaFactoryTest {
    
    public PecaPretaFactoryTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testSelectPecaPretaSucesso() {
        System.out.println("selectPeca");
        EnumPeca peca = EnumPeca.BISPO;
        PecaPretaFactory instance = new PecaPretaFactory();
        
        Peca result = instance.selectPeca(peca);
        
        assertEquals(EnumCor.PRETO, result.getCor());
    }
    
    @Test
    public void testSelectPecaPretaFalha() {
        System.out.println("selectPeca");
        EnumPeca peca = EnumPeca.CAVALO;
        PecaPretaFactory instance = new PecaPretaFactory();
        Peca result = instance.selectPeca(peca);
        assertNotSame(EnumCor.BRANCO, result.getCor());
    }
}
