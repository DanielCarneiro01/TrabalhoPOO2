
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
public class TorreTest {
    PecaManager manager;
    Peca instance;
    Tabuleiro tabuleiro;
    public TorreTest(){
       manager = new PecaManager();
        this.instance = manager.createTorre(EnumCor.PRETO);
        tabuleiro = new Tabuleiro(8,8);
        tabuleiro.getCasa(1, 1).setPeca(manager.createTorre(EnumCor.PRETO));
    }
    
    
    @Test
    public void testMovimentoDiagonalFalha() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(2,2);
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
    public void testMovimentoRetoHorizontalSucesso() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(1,5);
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
        Posicao destino = new Posicao(5,1);
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
    public void testCapturaDiagonalFalha() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(2,2);
        tabuleiro.getCasa(2, 2).setPeca(manager.createPeao(EnumCor.PRETO));
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
   
    
    
    public void testCapturaRetoVerticalSucesso() {
        
        Posicao origem = new Posicao(1,1);
        Posicao destino = new Posicao(6,1);
         tabuleiro.getCasa(6,1).setPeca(manager.createPeao(EnumCor.PRETO));
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
