/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.model.tabuleiro;

import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.GeradorCorCasa;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiago
 */
public class GeradorCorCasaTest {
    
    public GeradorCorCasaTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class GeradorCorCasa.
     */
    @Test
    public void testPrimeiraCor() {
        
        System.out.println("Primeira Cor");      
        assertEquals(EnumCor.BRANCO, GeradorCorCasa.INSTANCE.proximaCor());
        
        System.out.println("Segunda Cor");
        assertEquals(EnumCor.PRETO, GeradorCorCasa.INSTANCE.proximaCor());
        
        System.out.println("Terceira Cor");
        assertEquals(EnumCor.BRANCO, GeradorCorCasa.INSTANCE.proximaCor());
        
        
        
    }

  
   
    
}
