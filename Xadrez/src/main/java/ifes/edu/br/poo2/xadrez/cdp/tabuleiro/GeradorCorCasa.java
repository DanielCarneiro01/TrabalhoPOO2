/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.tabuleiro;

import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;

/**
 *
 * @author tiago
 */
public enum GeradorCorCasa {
    INSTANCE;
    
    private EnumCor cor= EnumCor.PRETO;
    
    
    
    public synchronized EnumCor proximaCor(){
    
        if(cor == EnumCor.BRANCO ){
            cor= EnumCor.PRETO;
        }
        else{
            cor=EnumCor.BRANCO;
        }
        return cor;
    }
    
}
