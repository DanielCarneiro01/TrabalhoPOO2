/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cgt;

import ifes.edu.br.poo2.xadrez.cci.MenuOpcaoInterpretador;
import ifes.edu.br.poo2.xadrez.cgd.DadosPartidaDAO;
import ifes.edu.br.poo2.xadrez.cgd.JogadorDAO;
import ifes.edu.br.poo2.xadrez.cgd.PartidaDAO;


/**
 *
 * @author tiago
 */
public class JogoControle {
    public void start()throws Exception{
        JogadorDAO jogadorDao = new JogadorDAO();
        DadosPartidaDAO dadosPartidaDAO = new DadosPartidaDAO();
        PartidaDAO partidaDAO = new PartidaDAO();
                
        jogadorDao.criarTabela();
        dadosPartidaDAO.criarTabela();
        partidaDAO.criarTabela();
        
        MenuOpcaoInterpretador menuInterpretador = new MenuOpcaoInterpretador();
        menuInterpretador.menuIncialInterpreter();
    }
}
