/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.partida;

import ifes.edu.br.poo2.xadrez.cdp.jogador.Jogador;
import ifes.edu.br.poo2.xadrez.cdp.movimento.MovimentoPeaoSecundario;
import ifes.edu.br.poo2.xadrez.cdp.movimento.Posicao;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumPeca;
import ifes.edu.br.poo2.xadrez.cdp.peca.Peca;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.Casa;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.Tabuleiro;

/**
 *
 * @author Bassini
 */
public class MovimentoHandler extends AbstractJogadaHandler {

    protected boolean matchingWords(String entrada) {
        return true;
    }

    @Override
    protected boolean handleHere(Partida partida, String entrada ,EnumCor corJogador) {
        //System.out.println("entrou movimento...");

        try{
            String[] str = entrada.split("");
            if(str.length>3){
                int linhaOrigem, linhaDestino, colunaOrigem, colunaDestino;
                
                colunaOrigem =  Integer.parseInt(str[1]);
                linhaOrigem =   Integer.parseInt(str[2]);
                colunaDestino = Integer.parseInt(str[3]);
                linhaDestino = Integer.parseInt(str[4]);
                
                if( verificaValor(colunaOrigem) &&
                    verificaValor(linhaOrigem)  &&
                    verificaValor(colunaDestino)&&
                    verificaValor(linhaDestino)){
                    
                    Tabuleiro tabuleiro = partida.getTabuleiro();
                    if(!tabuleiro.casaEstaVazia(new Posicao(linhaOrigem, colunaOrigem))){
                        if(tabuleiro.casaEstaVazia(new Posicao(linhaDestino, colunaDestino))){
                            if(verificaEnPassant(partida, corJogador, new Posicao(linhaOrigem, colunaOrigem), new Posicao(linhaDestino, colunaDestino))){
                                
                                return executaEnPassant(partida, corJogador, new Posicao(linhaOrigem, colunaOrigem), new Posicao(linhaDestino, colunaDestino));
                            }
                            else{
                                return moverPeca(partida, corJogador, new Posicao(linhaOrigem, colunaOrigem), new Posicao(linhaDestino, colunaDestino));
                            }
                        
                        
                        }
                        else{
                            return capturarPeca(partida, corJogador, new Posicao(linhaOrigem, colunaOrigem), new Posicao(linhaDestino, colunaDestino));
                        }
                    }
                    
                }
            }
        }
        catch(Exception e){
            return false;
        }
        
        return false;
    }
    
    private boolean verificaValor(int valor){
        
        if(valor>8||valor<1){
            return false;
        }
        
        return true;
    }

    private boolean moverPeca(Partida partida, EnumCor corJogador, Posicao posicaoOrigem, Posicao posicaoDestino) throws Exception {
        
        Tabuleiro tabuleiro = partida.getTabuleiro();
        
        Casa origem = tabuleiro.getCasa(posicaoOrigem.getLinha(), posicaoOrigem.getColuna());
        Casa destino = tabuleiro.getCasa(posicaoDestino.getLinha(), posicaoDestino.getColuna());
        
        
        Peca peca = origem.getPeca();
        
        if(peca.getTipo()==EnumPeca.PEAO){
            int recuo = posicaoOrigem.getLinha() - posicaoDestino.getLinha();
            if(corJogador==EnumCor.BRANCO){
                recuo = recuo*(-1);
            }
                
            if(recuo>0){
                return false;
            }
        }
        
        
        if(peca.getCor()==corJogador && peca.movimento(posicaoOrigem, posicaoDestino, tabuleiro)){
            
            ajustarFlags(partida, posicaoOrigem, corJogador);
            
            destino.setPeca(origem.removePeca());
            
            if(peca.getTipo()==EnumPeca.PEAO){
                peca.setMovimento(new MovimentoPeaoSecundario());
            }
            
            return true;
        }
        
        return false;
       
    }

    private boolean capturarPeca(Partida partida,EnumCor corJogador, Posicao posicaoOrigem, Posicao posicaoDestino) throws Exception {
        
        Tabuleiro tabuleiro = partida.getTabuleiro();
        //return tabuleiro.capturarPeca(posicaoOrigem, posicaoDestino);
        
        Casa origem = tabuleiro.getCasa(posicaoOrigem.getLinha(), posicaoOrigem.getColuna());
        Casa destino = tabuleiro.getCasa(posicaoDestino.getLinha(), posicaoDestino.getColuna());
        
        
        Peca peca = origem.getPeca();
        
        if(peca.getTipo()==EnumPeca.PEAO){
            int recuo = posicaoOrigem.getLinha() - posicaoDestino.getLinha();
            if(corJogador==EnumCor.BRANCO){
                recuo = recuo*(-1);
            }
                
            if(recuo>0){
                return false;
            }
        }
        
        
        if(peca.getCor()==corJogador && peca.captura(posicaoOrigem, posicaoDestino, tabuleiro)){
            
            Peca pecaInimiga = destino.getPeca();
            
            if(pecaInimiga.getCor()!=corJogador){
                
                if(peca.getTipo()==EnumPeca.PEAO){
                    peca.setMovimento(new MovimentoPeaoSecundario());
                }
                if(pecaInimiga.getTipo()==EnumPeca.REI){
                    partida.setFinalizada(true);
                    
                    

                    //precisa salvar o vencedor; ---------------------------
                    
                }
                
                ajustarFlags(partida, posicaoOrigem, corJogador);
                ajustaFlagsInimigo(partida, posicaoDestino, pecaInimiga.getCor());
                tabuleiro.addCemiterio(destino.removePeca());
                destino.setPeca(origem.removePeca());
                
                return true;
            }
        }
        
        return false;
        
        
    }
    
    
    private void ajustarFlags(Partida partida, Posicao posicao, EnumCor corJogador){
        
        if(partida.isRoqueMaior(corJogador) || partida.isRoqueMenor(corJogador)){
            
            Tabuleiro tabuleiro = partida.getTabuleiro();
            
            Casa casa = tabuleiro.getCasa(posicao.getLinha(), posicao.getColuna());
            Peca peca = casa.getPeca();
            
            if(peca.getTipo()==EnumPeca.REI && peca.getCor()==corJogador){
                partida.setRoqueMaior(corJogador,false);
                partida.setRoqueMenor(corJogador,false);
            }
            else{
                if(peca.getTipo()==EnumPeca.TORRE && peca.getCor()==corJogador){
                    if(posicao.getColuna()==0){
                        partida.setRoqueMenor(corJogador,false);
                    }
                    else{
                        if(posicao.getColuna()==7){
                            partida.setRoqueMaior(corJogador,false);;
                            
                        }
                    }
                }
            }
        }
        
    }

    private void ajustaFlagsInimigo(Partida partida, Posicao posicao, EnumCor cor) {
        
        if(partida.isRoqueMaior(cor) || partida.isRoqueMenor(cor)){
            
            Tabuleiro tabuleiro = partida.getTabuleiro();
            
            Casa casa = tabuleiro.getCasa(posicao.getLinha(), posicao.getColuna());
            Peca peca = casa.getPeca();
            
            if(peca.getTipo()==EnumPeca.REI && peca.getCor()==cor){
                partida.setRoqueMaior(cor,false);
                partida.setRoqueMenor(cor,false);
                
                partida.setFinalizada(true);
                
                Jogador winner;
                
                if(partida.getJogadorBranco().getCor()==cor){
                    winner = partida.getJogadorPreto();
                }
                else{
                    winner = partida.getJogadorBranco();
                }
                
                partida.setWinner(winner);
                
            }
            else{
                if(peca.getTipo()==EnumPeca.TORRE && peca.getCor()==cor){
                    if(posicao.getColuna()==0){
                        partida.setRoqueMenor(cor,false);
                    }
                    else{
                        if(posicao.getColuna()==7){
                            partida.setRoqueMaior(cor,false);;
                            
                        }
                    }
                }
            }
        }
        
        
    }

    private boolean executaEnPassant(Partida partida, EnumCor corJogador, Posicao posicaoOrigem, Posicao posicaoDestino) {
        Tabuleiro tabuleiro = partida.getTabuleiro();
        
        Casa casaPassant = tabuleiro.getCasa(posicaoOrigem.getLinha(),posicaoDestino.getColuna());
        
        tabuleiro.addCemiterio(casaPassant.removePeca());
        
        Casa casaOrigem = tabuleiro.getCasa(posicaoOrigem.getLinha(), posicaoOrigem.getColuna());
        Peca peca = casaOrigem.removePeca();
                   
        Casa casaDestino = tabuleiro.getCasa(posicaoDestino.getLinha(), posicaoDestino.getColuna());
        casaDestino.setPeca(peca);
                    
        return true;
        
    }

    private boolean verificaEnPassant(Partida partida, EnumCor corJogador, Posicao posicaoOrigem, Posicao posicaoDestino) {
        
        
        Tabuleiro tabuleiro = partida.getTabuleiro();
        
        Casa casaOrigem = tabuleiro.getCasa(posicaoOrigem.getLinha(), posicaoOrigem.getColuna());
        Peca peca = casaOrigem.getPeca();
        
        
        if (peca.getTipo() == EnumPeca.PEAO && peca.getCor()==corJogador) {
            int linhaPassant, colunaPassant;
            linhaPassant = posicaoOrigem.getLinha();
            colunaPassant = posicaoDestino.getColuna();
            
            //verifica recuo do peao
            int recuo = posicaoOrigem.getLinha() - posicaoDestino.getLinha();
            if(corJogador==EnumCor.BRANCO){
                recuo = recuo*(-1);
            }
                
            if(recuo>0){
                return false;
            }
            
            if (!tabuleiro.casaEstaVazia(new Posicao(linhaPassant+1, colunaPassant+1))) {
                Casa casaPassant = tabuleiro.getCasa(linhaPassant, colunaPassant);
                Peca pecaPassant = casaPassant.getPeca();
                if (pecaPassant.getTipo() == EnumPeca.PEAO && pecaPassant.getCor()!=corJogador){
                    return true;
                }
            }
        }
        return false;
    }
}
