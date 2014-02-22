/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.jogador;

import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import java.util.Scanner;

/**
 *
 * @author tiago
 */
public class JogadorHumano extends JogadorImp{
    
    public JogadorHumano(EnumCor cor){
        this.cor = cor;
    }

    @Override
    public String realizarJogada() {
        System.out.print("Jogador "+this.getCor().name()+": ");
        Scanner scanner = new Scanner(System.in);
        
        return scanner.nextLine();
        
    }
}
