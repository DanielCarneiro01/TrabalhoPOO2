package Principal;


import ifes.edu.br.poo2.xadrez.cgt.JogoControle;
import ifes.edu.br.poo2.xadrez.cih.TabuleiroView;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.Tabuleiro;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.TabuleiroBuilder;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.TabuleiroDirector;


public class Principal {
    
    public static void main(String args[]) throws Exception{
        
        JogoControle game = new JogoControle();
        
        game.start();
        
    }
    
}
