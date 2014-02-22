/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.movimento;

import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.Tabuleiro;

/**
 *
 * @author tiago
 */
public class MovimentoCavalo extends MovimentoAbstract{

    @Override
    public boolean mover(Posicao origem, Posicao destino) {
        
        int diferencaLinha  = Util.diferencaAbsoluta(destino.getLinha(), origem.getLinha());
        int diferencaColuna = Util.diferencaAbsoluta(destino.getColuna(), origem.getColuna());
    
        return (
               ( diferencaLinha==2 && diferencaColuna==1 ) ||
               ( diferencaLinha==1 && diferencaColuna==2 )
               );
    }
    
    public boolean analisaTrajeto(Posicao origem, Posicao destino, Tabuleiro tabuleiro) throws Exception {
        return true;
    }
    
}
