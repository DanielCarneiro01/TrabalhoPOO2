/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.model.peca;

import ifes.edu.br.poo2.xadrez.cdp.peca.Peca;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumPeca;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import ifes.edu.br.poo2.xadrez.cdp.peca.PecaBrancaFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiago
 */
public class PecaBrancaFactoryTest {
    
    public PecaBrancaFactoryTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of selectPeca method, of class PecaBrancaFactory.
     */
    @Test
    public void testSelectPecaBrancaSucesso() {
        System.out.println("selectPeca");
        EnumPeca peca = EnumPeca.BISPO;
        PecaBrancaFactory instance = new PecaBrancaFactory();
        
        Peca result = instance.selectPeca(peca);
        
        assertEquals(EnumCor.BRANCO, result.getCor());
    }
    
    @Test
    public void testSelectPecaBrancaFalha() {
        System.out.println("selectPeca");
        EnumPeca peca = EnumPeca.BISPO;
        PecaBrancaFactory instance = new PecaBrancaFactory();
        
        Peca result = instance.selectPeca(peca);
        
        assertNotSame(EnumCor.PRETO, result.getCor());
    }
}
