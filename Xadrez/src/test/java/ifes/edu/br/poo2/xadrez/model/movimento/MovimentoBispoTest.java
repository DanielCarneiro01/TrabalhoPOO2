/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.model.movimento;

import ifes.edu.br.poo2.xadrez.cdp.movimento.MovimentoBispo;
import ifes.edu.br.poo2.xadrez.cdp.movimento.Movimento;
import ifes.edu.br.poo2.xadrez.cdp.movimento.Posicao;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.Tabuleiro;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.TabuleiroBuilder;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.TabuleiroDirector;
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
public class MovimentoBispoTest {
    
    Tabuleiro tabuleiro;
    
    public MovimentoBispoTest() {
        
        tabuleiro = new Tabuleiro();
        
        TabuleiroBuilder tabuleiroBuilder = new TabuleiroBuilder(tabuleiro);
        TabuleiroDirector tabuleiroDirector = new TabuleiroDirector();
        
        tabuleiro = tabuleiroDirector.build(tabuleiroBuilder);
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("Inicializando teste Bispo...");
    }
    
    @After
    public void tearDown() {
        System.out.println("Encerrando teste Bispo...");
    }   

    /**
     * Test of mover method, of class MovimentoBispo.
     */
    @Test
    public void testMover() {
        System.out.println("mover");
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(5,5);
        MovimentoBispo instance = new MovimentoBispo();
        boolean expResult = true;
        boolean result = instance.mover(origem, destino);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testAnalisaTrajetoFalha() throws Exception {
        System.out.println("analizaTrajetoFalha");
        Posicao origem = new Posicao(0,2);
        Posicao destino = new Posicao(2,0);
        
        //this.tabuleiro.getCasa(1,1).setPeca(null);
        
        Movimento instance = new MovimentoBispo();
        boolean expResult = false;
        boolean result = instance.analisaTrajeto(origem, destino, tabuleiro);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testAnalisaTrajetoSucesso() throws Exception {
        System.out.println("analizaTrajetoSucesso");
        Posicao origem = new Posicao(0,2);
        Posicao destino = new Posicao(2,0);
        
        this.tabuleiro.getCasa(1,1).setPeca(null);
        
        MovimentoBispo instance = new MovimentoBispo();
        boolean expResult = true;
        boolean result = instance.analisaTrajeto(origem, destino, tabuleiro);
        assertEquals(expResult, result);
        
    }
    
    
    
    
}
