/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.model.peca;

import ifes.edu.br.poo2.xadrez.cdp.peca.Peca;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumPeca;
import ifes.edu.br.poo2.xadrez.cdp.peca.PecaManager;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiago
 */
public class PecaManagerTest {
    PecaManager instance;
    EnumCor cor ;
    
    public PecaManagerTest() {
        this.instance = new PecaManager();
        this.cor = EnumCor.BRANCO;
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createPeao method, of class PecaManager.
     */
    @Test
    public void testCreatePeao() {
        System.out.println("createPeao");
        EnumPeca expResult = EnumPeca.PEAO;
        Peca result = this.instance.createPeao(cor);
        assertEquals(expResult, result.getTipo());
    }

    /**
     * Test of createCavalo method, of class PecaManager.
     */
    @Test
    public void testCreateCavalo() {
        System.out.println("createCavalo");
        EnumPeca expResult = EnumPeca.CAVALO;
        Peca result = this.instance.createCavalo(cor);
        assertEquals(expResult, result.getTipo());
    }

    /**
     * Test of createTorre method, of class PecaManager.
     */
    @Test
    public void testCreateTorre() {
        System.out.println("createTorre");
        EnumPeca expResult = EnumPeca.TORRE;
        Peca result = this.instance.createTorre(cor);
        assertEquals(expResult, result.getTipo());
    }

    /**
     * Test of createBispo method, of class PecaManager.
     */
    @Test
    public void testCreateBispo() {
        System.out.println("createBispo");
        EnumPeca expResult = EnumPeca.BISPO;
        Peca result = this.instance.createBispo(cor);
        assertEquals(expResult, result.getTipo());
    }

    /**
     * Test of createRei method, of class PecaManager.
     */
    @Test
    public void testCreateRei() {
        System.out.println("createRei");
        EnumPeca expResult = EnumPeca.REI;
        Peca result = this.instance.createRei(cor);
        assertEquals(expResult, result.getTipo());
    }

    /**
     * Test of createRainha method, of class PecaManager.
     */
    @Test
    public void testCreateRainha() {
        System.out.println("createRainha");
        EnumPeca expResult = EnumPeca.RAINHA;
        Peca result = this.instance.createRainha(cor);
        assertEquals(expResult, result.getTipo());
        
    }
    
}
