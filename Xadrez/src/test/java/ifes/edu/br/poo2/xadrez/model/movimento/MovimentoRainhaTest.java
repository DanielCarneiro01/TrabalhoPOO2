/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.model.movimento;

import ifes.edu.br.poo2.xadrez.cdp.movimento.Movimento;
import ifes.edu.br.poo2.xadrez.cdp.movimento.Posicao;
import ifes.edu.br.poo2.xadrez.cdp.movimento.MovimentoRainha;
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
public class MovimentoRainhaTest {
    Tabuleiro tabuleiro;

    public MovimentoRainhaTest() {
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
        System.out.println("Inicializando teste Rainha...");
    }
    
    @After
    public void tearDown() {
        System.out.println("Encerrando teste Rainha...");
    }

    /**
     * Test of mover method, of class MovimentoRainha.
     */
    @Test
    public void testMover() {
        System.out.println("mover");
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(5,5);
        MovimentoRainha instance = new MovimentoRainha();
        boolean expResult = true;
        boolean result = instance.mover(origem, destino);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testAnalisaTrajetoFalha() throws Exception {
        System.out.println("analizaTrajetoFalha");
        Posicao origem = new Posicao(0,4);
        Posicao destino = new Posicao(4,0);
        
        //this.tabuleiro.getCasa(1,1).setPeca(null);
        
        Movimento instance = new MovimentoRainha();
        boolean expResult = false;
        boolean result = instance.analisaTrajeto(origem, destino, tabuleiro);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testAnalisaTrajetoSucesso() throws Exception {
        System.out.println("analizaTrajetoSucesso");
        Posicao origem = new Posicao(0,4);
        Posicao destino = new Posicao(4,0);
        
        this.tabuleiro.getCasa(1,3).setPeca(null);
        
        Movimento instance = new MovimentoRainha();
        boolean expResult = true;
        boolean result = instance.analisaTrajeto(origem, destino, tabuleiro);
        assertEquals(expResult, result);
        
    }
    
}
