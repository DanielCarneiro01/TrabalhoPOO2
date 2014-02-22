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
public abstract class AbstractJogadorFactory {
    public abstract Jogador createJogador(EnumCor cor);
}
