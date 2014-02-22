/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.partida;

import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import ifes.edu.br.poo2.xadrez.cdp.peca.Peca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bassini
 */
class PontosHandler extends AbstractJogadaHandler {

    protected boolean matchingWords(String entrada) {
        return (entrada.equals("pontos"));
    }

    @Override
    protected boolean handleHere(Partida partida, String entrada, EnumCor corJogador) {
        
        
        //SALVAR PARTIDA
        System.out.println("Pontos do Jogador: ");
        
        List<Peca> cemiterio = partida.getTabuleiro().GetCemiterio();
        
        int pontos=0;
        
        List<Peca> capturadas = new ArrayList();
        
        for(Peca morto : cemiterio){
            if(morto.getCor()!=corJogador){
                pontos+= morto.getTipo().getPontos();
                capturadas.add(morto);
            }
        }
        
        System.out.print(pontos+"\n");
        
        //ordenar as capturadas pelo valor;
        
        
        for(Peca peca : capturadas){
            System.out.print(peca.getNomeView()+" ");
        }
        //retorna sempre false
        //para que o movimento de salvar
        //não seja contado como um movimento de jogo
        return false;
        
    }

    
    
}
