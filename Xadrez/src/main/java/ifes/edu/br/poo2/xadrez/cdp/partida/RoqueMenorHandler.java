/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.partida;

import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import ifes.edu.br.poo2.xadrez.cdp.peca.Peca;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.Tabuleiro;

/**
 *
 * @author Bassini
 */
class RoqueMenorHandler extends AbstractJogadaHandler {

    protected boolean matchingWords(String entrada) {
        return ((entrada.equals("O-O"))||(entrada.equals("o-o")));
    }

    @Override
    protected boolean handleHere(Partida partida, String entrada, EnumCor corJogador) {

        if(partida.isRoqueMenor(corJogador)){
            boolean caminhoLivre=true;
            int linha = 0;
            Tabuleiro tabuleiro = partida.getTabuleiro();
            if(corJogador==EnumCor.BRANCO){
                linha = 7;
            }
            
            for(int i=1;i<3;i++){
                if(tabuleiro.getCasa(linha, i).existePeca()){
                    caminhoLivre = false;
                }
            }
            if(caminhoLivre){
                
                Peca torre = tabuleiro.getCasa(linha,0).getPeca();
                Peca rei = tabuleiro.getCasa(linha,3).getPeca();
                
                tabuleiro.getCasa(linha, 0).setPeca(rei);
                tabuleiro.getCasa(linha, 3).setPeca(torre);
                
                partida.setRoqueMaior(corJogador, false);
                partida.setRoqueMenor(corJogador, false);
                
                return true;
            }
        }
        
        
        return false;
    }

    
    
}
