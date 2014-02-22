/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cgt;

import ifes.edu.br.poo2.xadrez.cdp.partida.Partida;
import ifes.edu.br.poo2.xadrez.cgd.DadosPartidaDAO;
import ifes.edu.br.poo2.xadrez.cih.DadosPartidaView;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author tiago
 */
public class DadosPartidaControle {
    DadosPartidaDAO dadosPartidaDAO;
    
    public DadosPartidaControle(){
        dadosPartidaDAO = new DadosPartidaDAO();
    }
           
            
    public void consultarDadosPartida() throws SQLException, ClassNotFoundException {
        List lista = dadosPartidaDAO.findAll();
        
        DadosPartidaView view = new DadosPartidaView();
        
        view.exibirDadosPartida(lista);
        
    }

    public void guardarDadosPartida(Partida partida) throws SQLException, ClassNotFoundException {
        //controle.GuardarPontuacao(score.getNomeJogadorBranco(), score.getPontosBranco());
        dadosPartidaDAO.insert(partida);
    }
    
}
