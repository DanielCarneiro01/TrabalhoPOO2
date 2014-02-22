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
public interface PecaFactory {
    
    public Peca build(EnumPeca peca);
    public Peca selectPeca(EnumPeca peca);
}
