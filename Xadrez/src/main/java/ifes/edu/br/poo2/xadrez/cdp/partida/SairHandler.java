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
class SairHandler extends AbstractJogadaHandler {

    protected boolean matchingWords(String entrada) {
        return (entrada.equals("sair"));
    }

    @Override
    protected boolean handleHere(Partida partida, String entrada,EnumCor corJogador) {
        try{
            PartidaDAO dao = new PartidaDAO();

            if(partida.getId()!=0){

                dao.update(partida);

            }else{

                dao.insert(partida);

            }

            partida.setFinalizada(true);

            return true;
        }
        catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
        return false;
        
    }

    
    
}
