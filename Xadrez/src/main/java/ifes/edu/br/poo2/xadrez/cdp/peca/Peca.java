/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.peca;

import ifes.edu.br.poo2.xadrez.cdp.movimento.Movimento;
import ifes.edu.br.poo2.xadrez.cdp.movimento.Posicao;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.Tabuleiro;

/**
 *
 * @author tiago
 */
public interface Peca extends Cloneable{
    
    
    public  boolean movimento(Posicao origem, Posicao destino, Tabuleiro tabuleiro)throws Exception;
    public  boolean captura(Posicao origem, Posicao destino, Tabuleiro tabuleiro)throws Exception;
    public Object clone();

    public EnumCor getCor();
    public EnumPeca getTipo();
    public String getNome();
    public String getNomeView();
    public void setCor(EnumCor cor);
    public void setMovimento(Movimento movimento);

    
}
