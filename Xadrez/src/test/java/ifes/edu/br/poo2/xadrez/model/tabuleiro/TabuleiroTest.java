/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.model.tabuleiro;

import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.Tabuleiro;
import ifes.edu.br.poo2.xadrez.cdp.movimento.Posicao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiago
 */
public class TabuleiroTest {
    
    public TabuleiroTest() {
    }
    
    @Test
    public void testCasaEstaVazia() {
        System.out.println("casaEstaVazia");
        Posicao posicao = new Posicao(1,1);
        Tabuleiro instance = new Tabuleiro(8,8);
        //instance.getCasa(1, 1).setPeca(null);
        boolean expResult = true;
        boolean result = instance.casaEstaVazia(posicao);
        assertEquals(expResult, result);
        
    }
    
}
