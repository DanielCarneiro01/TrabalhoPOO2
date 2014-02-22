/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.model.movimento;

import ifes.edu.br.poo2.xadrez.cdp.movimento.Util;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiago
 */
public class UtilTest {
    
    public UtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("Iniciando teste Util...");
    }
    
    @After
    public void tearDown() {
        System.out.println("Encerrando teste Util...");
    }

    /**
     * Test of diferencaAbsoluta method, of class Util.
     */
    @Test
    public void testDiferencaAbsoluta() {
        System.out.println("diferencaAbsoluta");
        int valor1 = 1;
        int valor2 = 3;
        int expResult = 2;
        int result = Util.diferencaAbsoluta(valor1, valor2);
        assertEquals(expResult, result);
    }
    
}
