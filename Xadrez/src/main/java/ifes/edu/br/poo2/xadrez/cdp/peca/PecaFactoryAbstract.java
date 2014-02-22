/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.peca;

/**
 *
 * @author tiago
 */
public abstract class PecaFactoryAbstract implements PecaFactory{
    
    
    PecaManager manager;
    
    public Peca build(EnumPeca peca){
        return this.selectPeca(peca);
    }
}
