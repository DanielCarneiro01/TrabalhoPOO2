/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.model.peca;

import ifes.edu.br.poo2.xadrez.cdp.peca.Peca;
import ifes.edu.br.poo2.xadrez.cdp.peca.PecaManager;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import ifes.edu.br.poo2.xadrez.cdp.movimento.MovimentoBispo;
import ifes.edu.br.poo2.xadrez.cdp.movimento.Posicao;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.Tabuleiro;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiago
 */
public class PeaoTest {
    PecaManager manager;
    Peca instance;
    Tabuleiro tabuleiro;
    public PeaoTest(){
        manager = new PecaManager();
        this.instance = manager.createPeao(EnumCor.PRETO);
        tabuleiro = new Tabuleiro(8,8);
        tabuleiro.getCasa(1, 1).setPeca(manager.createPeao(EnumCor.PRETO));
    }
    
    @Test
    public void testMovimentoPrimarioDiagonalFalha() {
        System.out.println("Teste Primario Diagonal Falha");
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(3,3);

        boolean expResult = false;
        boolean result = false;
        try{
            this.instance.movimento(origem, destino, tabuleiro);
        }
        catch(Exception exception){
            
            result = true;
            System.out.println(exception.getMessage());
            
        }
        assertEquals(expResult, result);
    }
    @Test
    public void testMovimentoPrimarioRetoVerticalFalha() {
        System.out.println("Teste Primario Reto Vertical Falha");
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(4,1);
        
        boolean expResult = false;
        boolean result = false;
        try{
            this.instance.movimento(origem, destino, tabuleiro);
        }
        catch(Exception exception){
            
            result = true;
            System.out.println(exception.getMessage());
            
        }
        assertEquals(expResult, result);
    }
    @Test
    public void testMovimentoPrimarioRetoHorizontalFalha() {
        System.out.println("Teste Primario Reto Horizontal Falha");
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(1,4);
 
        boolean expResult = false;
        boolean result = false;
        try{
            this.instance.movimento(origem, destino, tabuleiro);
        }
        catch(Exception exception){
            
            result = true;
            System.out.println(exception.getMessage());
            
        }
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMovimentoPrimarioSucesso() {
        
        System.out.println("Teste Primario Sucesso");
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(3,1);
        boolean expResult = true;
        boolean result = true;
        try{
            this.instance.movimento(origem, destino, tabuleiro);
        }
        catch(Exception exception){
            
            result = false;
            System.out.println(exception.getMessage());
            
        }
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMovimentoSecundarioSucesso() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(2,1);
        
        
        boolean expResult = true;
        boolean result = true;
        try{
            this.instance.movimento(origem, destino,tabuleiro);
            this.instance.movimento(destino, origem, tabuleiro);
        }
        catch(Exception exception){
            
            result = false;
            System.out.println(exception.getMessage());
            
        }
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testMovimentoSecundarioDiagonalFalha() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(2,1);
        Posicao destino2 = new Posicao(2,2);
        boolean expResult = false;
        boolean result = false;
        try{
            this.instance.movimento(origem, destino,tabuleiro);
            this.instance.movimento(destino, destino2, tabuleiro);
        }
        catch(Exception exception){
            
            result = true;
            System.out.println(exception.getMessage());
            
        }
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMovimentoSecundarioRetoVerticalFalha() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(2,1);
        
        Posicao destino2 = new Posicao(3,1);
        boolean expResult = false;
        boolean result = false;
        try{
            this.instance.movimento(origem, destino,tabuleiro);
            this.instance.movimento(destino, destino2, tabuleiro);
        }
        catch(Exception exception){
            
            result = true;
            System.out.println(exception.getMessage());
            
        }
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMovimentoSecundarioRetoHorizontalFalha() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(2,1);
        Posicao destino2 = new Posicao(1,2);
        
        boolean expResult = false;
        boolean result = false;
        try{
            this.instance.movimento(origem, destino,tabuleiro);
            this.instance.movimento(destino, destino2, tabuleiro);
        }
        catch(Exception exception){
            
            result = true;
            System.out.println(exception.getMessage());
            
        }
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCapturaDiagonalSucesso() {
        
        //tabuleiro.getCasa(1, 1).setPeca(new Peao());
        tabuleiro.getCasa(2,2).setPeca(manager.createPeao(EnumCor.PRETO));
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(2,2);
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
        Posicao destino = new Posicao(5,5);
        tabuleiro.getCasa(5,5).setPeca(manager.createPeao(EnumCor.PRETO));

        boolean expResult = false;
        boolean result = false;
        try{
            this.instance.captura(origem, destino, tabuleiro);
        }
        catch(Exception exception){
            
            result = true;
            System.out.println(exception.getMessage());
            
        }
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCapturaRetoFalha() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(3,1);
        tabuleiro.getCasa(3,1).setPeca(manager.createPeao(EnumCor.PRETO));

        boolean expResult = false;
        boolean result = false;
        try{
            this.instance.captura(origem, destino, tabuleiro);
        }
        catch(Exception exception){
            
            result = true;
            System.out.println(exception.getMessage());
            
        }
        assertEquals(expResult, result);
    }
    
}
