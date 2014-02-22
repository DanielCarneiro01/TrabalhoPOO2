/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.partida;

import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import ifes.edu.br.poo2.xadrez.cgd.PartidaDAO;

/**
 *
 * @author Bassini
 */
class EmpateHandler extends AbstractJogadaHandler {

    protected boolean matchingWords(String entrada) {
        return (entrada.equals("empate"));
    }

    @Override
    protected boolean handleHere(Partida partida, String entrada, EnumCor corJogador) {
        
        
        //SALVAR PARTIDA
        System.out.println("Jogo Terminou EMPATADO!!");
        
        partida.setFinalizada(true);
        
        if(partida.getId()!=0){
           
           PartidaDAO partidaDAO = new PartidaDAO();
           try{
                partidaDAO.delete(partida);
           }
           catch(Exception e){
               System.out.println("ERRO ao excluir partida: "+e.getMessage());
           }
        }
        
        //retorna sempre false
        //para que o movimento de salvar
        //não seja contado como um movimento de jogo
        return true;
        
    }

    
    
}
