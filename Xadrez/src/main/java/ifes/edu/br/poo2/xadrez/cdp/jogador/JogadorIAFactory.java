/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.jogador;

import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;

/**
 *
 * @author tiago
 */
public class JogadorIAFactory extends AbstractJogadorFactory{

    @Override
    public Jogador createJogador(EnumCor cor) {
        return new JogadorIA(cor);
    }
    
}
