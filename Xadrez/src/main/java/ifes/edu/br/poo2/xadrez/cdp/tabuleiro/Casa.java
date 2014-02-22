/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.tabuleiro;

import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import ifes.edu.br.poo2.xadrez.cdp.peca.Peca;

/**
 *
 * @author tiago
 */
public class Casa extends Item{
    
    Peca peca;
    EnumCor cor;
    
    public Casa(EnumCor cor){
        this.cor = cor;
        this.peca=null;
    }
    
    public EnumCor getCor(){
        return this.cor;
    }
    
    public void setPeca(Peca peca){
        this.peca = peca;
    }
    public Peca getPeca(){
        return this.peca;
    }
    
    public Peca removePeca(){
        Peca retorno = this.peca;
        this.peca=null;
        
        return retorno;
    }
    public boolean existePeca(){
        
        return (this.peca!=null);
    }
    
}
