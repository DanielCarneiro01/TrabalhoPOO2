/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.partida;

import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import ifes.edu.br.poo2.xadrez.cgd.DadosPartidaDAO;
import ifes.edu.br.poo2.xadrez.cgd.JogadorDAO;
import ifes.edu.br.poo2.xadrez.cgd.PartidaDAO;
import ifes.edu.br.poo2.xadrez.cgt.DadosPartidaControle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Bassini
 */
class DesistirHandler extends AbstractJogadaHandler {

    protected boolean matchingWords(String entrada) {
        return (entrada.equals("desistir"));
    }

    @Override
    protected boolean handleHere(Partida partida, String entrada, EnumCor corJogador) {
        
        
        //SALVAR PARTIDA
        partida.setFinalizada(true);
        
        System.out.println("Jogador "+corJogador.toString()+" DESISTIU!!");
        
        if(corJogador==EnumCor.BRANCO){
            
            partida.setWinner(partida.getJogadorPreto());
        }
        else{
            partida.setWinner(partida.getJogadorBranco());
        }
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String horaFim = dateFormat.format(cal.getTime());
        
        partida.setFim(horaFim);
        
        
        
        //DEVE SALVAR A PARTIDA NOS DADOS DAS PARTIDAS FINALIZADAS
        
        try{
            DadosPartidaControle controle = new DadosPartidaControle();
            controle.guardarDadosPartida(partida);
            JogadorDAO jogadorDAO = new JogadorDAO();
            jogadorDAO.update(partida.getWinner());
        }
        catch(Exception e){
            System.out.println("ERRO ao salvar Dados da Partida: "+e.getMessage());
        }
        
        if(partida.getId()!=0){
            PartidaDAO partidaDAO = new PartidaDAO();
            try{
                partidaDAO.delete(partida);
            }
            catch(Exception e){
                System.out.println("ERRO ao excluir partida: "+e.getMessage());
            }
        }
        
        
        
        return true;
        
    }

    
    
}
