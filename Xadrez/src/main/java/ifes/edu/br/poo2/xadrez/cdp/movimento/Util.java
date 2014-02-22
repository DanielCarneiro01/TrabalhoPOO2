/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.movimento;

/**
 *
 * @author tiago
 */
public class Util{

    public static int diferencaAbsoluta(int valor1, int valor2){
        
        int diferenca  = Math.abs(valor1)- Math.abs(valor2);
        
        return Math.abs(diferenca);
    }
    
}
