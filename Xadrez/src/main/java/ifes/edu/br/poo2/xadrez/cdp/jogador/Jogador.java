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
public interface Jogador {
    
    public  String realizarJogada();
    public void setId(long id);
    public long getId();
    public void setVitorias(int vitorias);
    public int getVitorias();
    public void setNome(String nomeJogadorBranco);
    public String getNome();
    public void setCor(EnumCor cor);
    public EnumCor getCor();
}
