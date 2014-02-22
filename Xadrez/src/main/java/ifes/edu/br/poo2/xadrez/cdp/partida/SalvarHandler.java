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
class SalvarHandler extends AbstractJogadaHandler {

    protected boolean matchingWords(String entrada) {
        return (entrada.equals("salvar"));
    }

    @Override
    protected boolean handleHere(Partida partida, String entrada, EnumCor corJogador) {
        try{
        PartidaDAO dao = new PartidaDAO();
        
        if(partida.getId()!=0){
            
            dao.update(partida);
            
        }else{
            
            dao.insert(partida);
        
        }
        //retorna sempre false
        //para que o movimento de salvar
        //não seja contado como um movimento de jogo
        
        }
        catch(Exception e){
            System.out.println("Erro ao Salvar a partida: "+e.getMessage());
        }
        return false;
        
    }

    
    
}
