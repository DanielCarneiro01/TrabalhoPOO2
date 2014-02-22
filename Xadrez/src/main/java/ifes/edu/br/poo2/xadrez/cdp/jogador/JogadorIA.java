/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.jogador;

import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import java.util.Random;

/**
 *
 * @author tiago
 */
public class JogadorIA extends JogadorImp{
    
    public JogadorIA(EnumCor cor){
        this.cor = cor;
    }

    @Override
    public String realizarJogada() {
        
        String jogada="";
        
        Random generator = new Random();
        jogada += generator.nextInt(7)+1;
        jogada += generator.nextInt(7)+1;
        jogada += generator.nextInt(7)+1;
        jogada += generator.nextInt(7)+1;
        
        return jogada;
    
    }
    
}
