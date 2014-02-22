/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.partida;

import ifes.edu.br.poo2.xadrez.cdp.movimento.MovimentosEspeciais;
import ifes.edu.br.poo2.xadrez.cdp.movimento.Posicao;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumPeca;
import ifes.edu.br.poo2.xadrez.cdp.peca.Peca;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.Casa;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.Tabuleiro;
import java.util.List;

/**
 *
 * @author Bassini
 */
class PromocaoHandler extends AbstractJogadaHandler {

    @Override
    protected boolean matchingWords(String entrada) {
        String[] str = entrada.split("");
        String[] tipos = {"D","T","C","B"};
        
        if(str.length>3){
            int coluna,linha;
            try{
                coluna = Integer.parseInt(str[1]);
                linha = Integer.parseInt(str[2]);
                
                if(coluna<1 || coluna>8){
                    return false;
                }
                if(linha<1 || linha>8){
                    return false;
                }
                if(str[3].equals("=")){
                    for(String tipo : tipos){
                        if(tipo.equals(str[4])){
                            return true;
                        }
                    }
                }
            }
            catch(Exception e){
                return false;
            }
        }
        return false;
    }

    @Override
    protected boolean handleHere(Partida partida, String entrada,EnumCor corJogador) {
        
        String[] str = entrada.split("");
        int coluna = Integer.parseInt(str[1]);
        int linha = Integer.parseInt(str[2]);
        if ((corJogador==EnumCor.PRETO&& linha == 8) || (linha==1 && corJogador==EnumCor.BRANCO)) {
            
            Tabuleiro tabuleiro = partida.getTabuleiro();
            Casa casa = tabuleiro.getCasa(linha-1, coluna-1);
            
            if(casa.existePeca()){
                Peca peca = casa.getPeca();
                if(peca.getTipo()==EnumPeca.PEAO && peca.getCor()==corJogador ){
                    
                    List<Peca> cemiterio = tabuleiro.GetCemiterio();
                    
                    for(int i=0;i<cemiterio.size();i++){
                        if(str[3].equals(cemiterio.get(i).getNomeView()) && cemiterio.get(i).getCor()==corJogador ){
                            casa.setPeca(cemiterio.get(i));
                            cemiterio.set(i, peca);
                            // deve retornar false para que a promoçao nao seja 
                            //contada como um movimento de turno completo;
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    
    }

  
    
}
