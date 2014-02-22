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
public interface Movimento {
    
    public boolean mover(Posicao origem, Posicao destino);
    public boolean analisaTrajeto(Posicao origem, Posicao destino, Tabuleiro tabuleiro) throws Exception ;
    
}
