/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.tabuleiro;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumPeca;


/**
 *
 * @author tiago
 */
public enum GeradorTipoPeca {
    PRETO, BRANCO;
    
    private int contador=0;
    
    private final EnumPeca[] lista = {  EnumPeca.TORRE, EnumPeca.CAVALO, EnumPeca.BISPO,
                                        EnumPeca.REI, EnumPeca.RAINHA, EnumPeca.BISPO,
                                        EnumPeca.CAVALO, EnumPeca.TORRE} ;
    
      
    
    public synchronized EnumPeca proximaPeca(){
        
        EnumPeca tipoPeca = lista[contador];
        
        contador++;
        if(contador >= lista.length){
            contador=0;
        }
        return tipoPeca;
    }
    
}
