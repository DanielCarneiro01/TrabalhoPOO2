/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.model.peca;

import ifes.edu.br.poo2.xadrez.cdp.peca.Peca;
import ifes.edu.br.poo2.xadrez.cdp.peca.PecaManager;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import ifes.edu.br.poo2.xadrez.cdp.movimento.Posicao;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.Tabuleiro;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiago
 */
public class BispoTest {
    
    PecaManager manager;
    Peca instance;
    Tabuleiro tabuleiro;
    
    public BispoTest(){
        manager = new PecaManager();
        this.instance = manager.createBispo(EnumCor.PRETO);
        tabuleiro = new Tabuleiro(8,8);
        tabuleiro.getCasa(1, 1).setPeca( manager.createBispo(EnumCor.PRETO));
    }
    
    
    @Test
    public void testMovimentoDiagonalSucesso() throws Exception {
        
        
        
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(5,5);
        boolean expResult = true;
        boolean result = true;
        try{
            result = this.instance.movimento(origem, destino, tabuleiro);
        }
        catch(Exception exception){
            
            result = false;
            System.out.println(exception.getMessage());
            
        }
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMovimentoDiagonalFalha() throws Exception {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(3,5);
        boolean expResult = false;
        boolean result = false;
        try{
            result = this.instance.movimento(origem, destino, tabuleiro);
        }
        catch(Exception exception){
            
            result = true;
            System.out.println(exception.getMessage());
            
        }
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMovimentoRetoFalha() throws Exception {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(0,5);
        boolean expResult = false;
        boolean result = false;
        try{
            result = this.instance.movimento(origem, destino, tabuleiro);
        }
        catch(Exception exception){
            
            result = true;
            System.out.println(exception.getMessage());
            
        }
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCapturaDiagonalSucesso() throws Exception {
        
        tabuleiro.getCasa(1, 1).setPeca(manager.createBispo(EnumCor.PRETO));
        
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(5,5);
        tabuleiro.getCasa(5, 5).setPeca(manager.createBispo(EnumCor.PRETO));
        boolean expResult = true;
        boolean result = true;
        try{
            result = this.instance.captura(origem, destino, tabuleiro);
        }
        catch(Exception exception){
            
            result = false;
            System.out.println(exception.getMessage());
            
        }
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCapturaDiagonalFalha() throws Exception {
        
        tabuleiro.getCasa(1, 1).setPeca(manager.createBispo(EnumCor.PRETO));
        tabuleiro.getCasa(3, 5).setPeca(manager.createBispo(EnumCor.PRETO));
        
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(3,5);
        boolean expResult = false;
        boolean result = false;
        try{
            result = this.instance.captura(origem, destino, tabuleiro);
        }
        catch(Exception exception){
            
            result = true;
            System.out.println(exception.getMessage());
            
        }
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCapturaRetoFalha() throws Exception {
        
        tabuleiro.getCasa(1, 1).setPeca(manager.createBispo(EnumCor.PRETO));
        tabuleiro.getCasa(3, 0).setPeca(manager.createBispo(EnumCor.PRETO));
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(3,0);
        boolean expResult = false;
        boolean result = false;
        try{
            result = this.instance.captura(origem, destino, tabuleiro);
        }
        catch(Exception exception){
            
            result = true;
            System.out.println(exception.getMessage());
            
        }
        assertEquals(expResult, result);
    }
    
    
    
}
