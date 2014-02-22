/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cci;


import ifes.edu.br.poo2.xadrez.cdp.jogador.Jogador;
import ifes.edu.br.poo2.xadrez.cdp.jogador.Score;
import ifes.edu.br.poo2.xadrez.cgt.DadosPartidaControle;
import ifes.edu.br.poo2.xadrez.cdp.partida.Partida;
import ifes.edu.br.poo2.xadrez.cgd.JogadorDAO;
import ifes.edu.br.poo2.xadrez.cgd.PartidaDAO;
import ifes.edu.br.poo2.xadrez.cgt.GameControle;
import ifes.edu.br.poo2.xadrez.cgt.PartidaControle;
import ifes.edu.br.poo2.xadrez.cih.MenuView;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tiago
 */
public class MenuOpcaoInterpretador {
    
    
    public void menuIncialInterpreter() throws Exception{
        int opcao=0;
        PartidaControle controlePartida;
        Partida partida;
        
        DadosPartidaControle controleScore = new DadosPartidaControle();
        Scanner in = new Scanner(System.in);
        MenuView menu = new MenuView();
        
        
        //opcao = in.nextInt();
        while (opcao!=4) // repeat until valid selection made
        {
                String nomeJogadorBranco, nomeJogadorPreto;
            
                menu.exibirMenuInicial();
                opcao = in.nextInt();
                switch (opcao) {
                    case 1:
                        menuSecundario();
                       
                        break;
                    case 2:
                                
                        this.retornarPartida();

                        break;
                    case 3:
                        //dados das partidas
                        exibirDadosPartida();
                        
                        
                        break;
                    case 4:
                        System.out.println("Saindo.");
                        break;
                    default:
                        menu.showOpcaoInvalida();
                        break;
 
                }
                
        }
    }

    private void retornarPartida() {
        PartidaDAO partidaDAO = new PartidaDAO();
        try{
            System.out.println("Partidas Salvas: ");
            List<Partida> lista = partidaDAO.findAll();
            
            
            
            for(Partida partida : lista){
                
                System.out.println( partida.getId()+" "+
                                    partida.getInicio()+" "+
                                    partida.getJogadorBranco().getNome()+" "+
                                    partida.getJogadorPreto().getNome());
            }
        
        }
        catch(Exception e){
            System.out.println("Erro buscar Partidas: "+e.getMessage());
        }
    }

    private void menuSecundario() {
        
        try{
        GameControle game;
        MenuView menu = new MenuView();
        menu.showMenuSecundario();
        Scanner in = new Scanner(System.in);
        String nomeJogadorBranco, nomeJogadorPreto;
        Partida partida;
        PartidaControle controlePartida = new PartidaControle();
        int opcao = in.nextInt();
        switch (opcao){
            case 1:
                
                game = new GameControle();

                menu.nomeJogadorBranco();
                nomeJogadorBranco = in.next();
                menu.nomeJogadorPreto();
                nomeJogadorPreto = in.next();
                partida = controlePartida.iniciarPartidaAmigos(nomeJogadorBranco,nomeJogadorPreto);
               

                game.playGame(partida);

                
                break;
            case 2:
                
                game = new GameControle();
                menu.nomeJogadorBranco();
                nomeJogadorBranco = in.next();
                partida = controlePartida.iniciarPartidaSolo(nomeJogadorBranco);
               

                game.playGame(partida);
                
                break;
            default:
                menu.showOpcaoInvalida();
                break;
                
                                
            }
        }
        catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
                        
    }

    private void exibirDadosPartida() {
        
        try{
            DadosPartidaControle control = new DadosPartidaControle();                                
            control.consultarDadosPartida();
            
            JogadorDAO dao = new JogadorDAO();
            
            List<Jogador> lista = dao.findAll();
            
            System.out.println("Lista de Jogadores: ");
            for(Jogador jogador : lista){
                
                System.out.println(jogador.getId()+" --> "+jogador.getNome()+" : "+jogador.getVitorias()+" vitorias.");
                
            }
            

        }
        catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
      
}
