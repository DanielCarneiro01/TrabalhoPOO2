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
public class ReiTest {
    
    PecaManager manager;
    Peca instance;
    Tabuleiro tabuleiro;
    
    public ReiTest(){
        manager = new PecaManager();
        this.instance = manager.createRei(EnumCor.PRETO);
        tabuleiro = new Tabuleiro(8,8);
        tabuleiro.getCasa(1, 1).setPeca(manager.createRei(EnumCor.PRETO));
    }
    
    
    @Test
    public void testMovimentoDiagonalSucesso() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(2,2);
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
    public void testMovimentoRetoHorizontalSucesso() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(1,2);
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
    public void testMovimentoRetoVerticalSucesso() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(2,1);
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
    public void testMovimentoDiagonalFalha() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(3,3);
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
    
    public void testMovimentoRetoHorizontalFalha() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(1,3);
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
    
    public void testMovimentoRetoVerticalFalha() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(3,1);
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
    public void testCapturaDiagonalSucesso() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(2,2);
        tabuleiro.getCasa(2, 2).setPeca(manager.createPeao(EnumCor.PRETO));
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
    public void testCapturaDiagonalFalha() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(3,3);
        tabuleiro.getCasa(3, 3).setPeca(manager.createPeao(EnumCor.PRETO));
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
    public void testCapturaRetoHorizontalSucesso() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(1,2);
        tabuleiro.getCasa(1, 2).setPeca(manager.createPeao(EnumCor.PRETO));
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
    public void testCapturaRetoVerticalFalha() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(3,1);
        tabuleiro.getCasa(3, 1).setPeca(manager.createPeao(EnumCor.PRETO));
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
    public void testCapturaRetoHorizontalFalha() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(1,3);
        tabuleiro.getCasa(1, 3).setPeca(manager.createPeao(EnumCor.PRETO));
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
    public void testCapturaRetoVerticalSucesso() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(2,1);
        tabuleiro.getCasa(2, 1).setPeca(manager.createPeao(EnumCor.PRETO));
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
    
}
