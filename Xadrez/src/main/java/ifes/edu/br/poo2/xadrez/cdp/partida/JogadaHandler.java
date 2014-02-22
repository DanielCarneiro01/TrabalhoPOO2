/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.partida;

import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;

/**
 *
 * @author Bassini
 */
public interface JogadaHandler {
    
    public void setNextHandler(JogadaHandler handler);
    public boolean processHandler(Partida partida, String entrada, EnumCor corJogador);
    
}
