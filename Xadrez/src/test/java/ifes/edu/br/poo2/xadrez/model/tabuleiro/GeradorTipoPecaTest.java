/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.model.tabuleiro;

import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.GeradorTipoPeca;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumPeca;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiago
 */
public class GeradorTipoPecaTest {
    
    public GeradorTipoPecaTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class GeradorTipoPeca.
     */
     @Test
    public void testGerarTipoPecaPreto() {
        
        System.out.println("Primeira Peca - Torre");      
        assertEquals(EnumPeca.TORRE, GeradorTipoPeca.PRETO.proximaPeca());
        
        System.out.println("Segunda Peca - Cavalo");      
        assertEquals(EnumPeca.CAVALO, GeradorTipoPeca.PRETO.proximaPeca());
        
        System.out.println("Terceira Peca - Bispo");      
        assertEquals(EnumPeca.BISPO, GeradorTipoPeca.PRETO.proximaPeca());
        
        System.out.println("Quarta Peca - Rei");      
        assertEquals(EnumPeca.REI, GeradorTipoPeca.PRETO.proximaPeca());

        System.out.println("Quinta Peca - Rainha");      
        assertEquals(EnumPeca.RAINHA, GeradorTipoPeca.PRETO.proximaPeca());
        
        System.out.println("Sexta Peca - Bispo");      
        assertEquals(EnumPeca.BISPO, GeradorTipoPeca.PRETO.proximaPeca());
        
        System.out.println("Setima Peca - Cavalo");      
        assertEquals(EnumPeca.CAVALO, GeradorTipoPeca.PRETO.proximaPeca());
        
        System.out.println("Oitava Peca - Torre");      
        assertEquals(EnumPeca.TORRE, GeradorTipoPeca.PRETO.proximaPeca());
        
    }
    @Test
    public void testGerarTipoPecaBranco() {
        
        System.out.println("Primeira Peca - Torre");      
        assertEquals(EnumPeca.TORRE, GeradorTipoPeca.BRANCO.proximaPeca());
        
        System.out.println("Segunda Peca - Cavalo");      
        assertEquals(EnumPeca.CAVALO, GeradorTipoPeca.BRANCO.proximaPeca());
        
        System.out.println("Terceira Peca - Bispo");      
        assertEquals(EnumPeca.BISPO, GeradorTipoPeca.BRANCO.proximaPeca());
        
        System.out.println("Quarta Peca - Rei");      
        assertEquals(EnumPeca.REI, GeradorTipoPeca.BRANCO.proximaPeca());

        System.out.println("Quinta Peca - Rainha");      
        assertEquals(EnumPeca.RAINHA, GeradorTipoPeca.BRANCO.proximaPeca());
        
        System.out.println("Sexta Peca - Bispo");      
        assertEquals(EnumPeca.BISPO, GeradorTipoPeca.BRANCO.proximaPeca());
        
        System.out.println("Setima Peca - Cavalo");      
        assertEquals(EnumPeca.CAVALO, GeradorTipoPeca.BRANCO.proximaPeca());
        
        System.out.println("Oitava Peca - Torre");      
        assertEquals(EnumPeca.TORRE, GeradorTipoPeca.BRANCO.proximaPeca());
        
    }
    
}
