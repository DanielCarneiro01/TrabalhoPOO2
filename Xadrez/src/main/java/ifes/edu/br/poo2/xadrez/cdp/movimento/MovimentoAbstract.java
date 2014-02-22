/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.movimento;

import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.Tabuleiro;

/**
 *
 * @author tiago
 */
public abstract class MovimentoAbstract implements Movimento {
    
    public boolean analisaTrajeto(Posicao origem, Posicao destino, Tabuleiro tabuleiro) throws Exception {
        
        int linha = origem.getLinha();
        int coluna = origem.getColuna();
        int linhaDestino = destino.getLinha();
        int colunaDestino = destino.getColuna();
        
        linha = this.verificaProximoValor(linha, linhaDestino);
        coluna = this.verificaProximoValor(coluna, colunaDestino);
            
        while(linha!=linhaDestino || coluna!=colunaDestino){

            if(tabuleiro.getCasa(linha, coluna).existePeca()){
                return false;
                //throw new Exception("Trajeto Invalido.");
            }
            linha = this.verificaProximoValor(linha, linhaDestino);
            coluna = this.verificaProximoValor(coluna, colunaDestino);
        }
                
        return true;
        
    }
    
     private int verificaProximoValor(int valor, int valorObjetivo){
        
        if(valorObjetivo>valor){
                valor++;
            }
            else{
                if(valorObjetivo<valor){
                    valor--;
                }
            } 
        return valor;
    }
    
}
