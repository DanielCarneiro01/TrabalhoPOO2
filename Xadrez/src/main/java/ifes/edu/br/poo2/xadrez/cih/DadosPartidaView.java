/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cih;

import ifes.edu.br.poo2.xadrez.cdp.partida.Partida;
import java.util.List;

/**
 *
 * @author Bassini
 */
public class DadosPartidaView {
    
    public void exibirDadosPartida(List<Partida> lista){
        
        System.out.println("Dados das Partidas: ");
        for(Partida partida : lista){
            
            System.out.println( partida.getInicio() +" - "+
                                partida.getFim()    +" - "+
                                partida.getWinner().getNome());
        }
    }
    
}
