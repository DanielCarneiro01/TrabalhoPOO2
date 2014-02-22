/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//XEQUE,
//SALVAR,
//SAIR,
//PROMOCAO NAO TA FUNCIONANDO

package ifes.edu.br.poo2.xadrez.cgt;

import ifes.edu.br.poo2.xadrez.cdp.jogador.Jogador;
import ifes.edu.br.poo2.xadrez.cdp.movimento.MovimentosEspeciais;
import ifes.edu.br.poo2.xadrez.cdp.movimento.Posicao;
import ifes.edu.br.poo2.xadrez.cdp.partida.AbstractJogadaHandler;
import ifes.edu.br.poo2.xadrez.cdp.partida.JogadaHandler;
import ifes.edu.br.poo2.xadrez.cdp.partida.MovimentoHandler;
import ifes.edu.br.poo2.xadrez.cdp.partida.Partida;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumPeca;
import ifes.edu.br.poo2.xadrez.cdp.peca.Peca;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.Tabuleiro;
import ifes.edu.br.poo2.xadrez.cih.TabuleiroView;

/**
 *
 * @author Bassini
 */
public class GameControle {
    
    public void playGame(Partida partida) throws Exception {
        
        boolean continua = true;
        
        Jogador jogadorBranco = partida.getJogadorBranco();
        Jogador jogadorPreto = partida.getJogadorPreto();
        
        EnumCor corJogada = EnumCor.BRANCO;
        
        while( continua && !partida.isFinalizada() ){
            
            if(EnumCor.BRANCO == corJogada){
                boolean movimentoValido = false;
                TabuleiroView.exibirTabuleiro(partida.getTabuleiro());
                while (!movimentoValido){
                    movimentoValido = AbstractJogadaHandler.handle(partida, jogadorBranco.realizarJogada(),corJogada);
                }
                continua = true;
                
            }
            else{
                boolean movimentoValido = false;
                while (!movimentoValido){
                    movimentoValido = AbstractJogadaHandler.handle(partida, jogadorPreto.realizarJogada(),corJogada);
                }
                continua = true;
                
            }
            //FUNÇÃO DE VERIFICAR OS XEQUES AQUI
            
            if (VerificarChequeMate(partida.getTabuleiro(), EnumCor.BRANCO)) {
                partida.setWinner(jogadorPreto);
                continua = false;
            }
            else{
                if (VerificarChequeMate(partida.getTabuleiro(), EnumCor.PRETO)) {
                    partida.setWinner(jogadorBranco);
                    continua = false;
                }
            }
            corJogada = proximaCorJogada(corJogada);
            
            
         }
        
    }
    
    private EnumCor proximaCorJogada(EnumCor cor){
        
        if(cor == EnumCor.BRANCO ){
            return EnumCor.PRETO;
        }
        else{
            return EnumCor.BRANCO;
        }
    }
    
    
    
    
    private boolean VerificarCheque(Tabuleiro tabuleiro, EnumCor cor) {

        int linha;
        int coluna;
        Peca pecaRei;
        Peca pecaInimiga;

        for (linha = 0; linha < 8; linha++) {
            for (coluna = 0; coluna < 8; coluna++) {

                pecaRei = tabuleiro.getCasa(linha, coluna).getPeca();

                if (pecaRei != null) {
                    if (pecaRei.getTipo() == EnumPeca.REI && pecaRei.getCor() == cor) {

                        Posicao posicaoRei = new Posicao();
                        posicaoRei.setPosicao(linha, coluna);

                        for (linha = 0; linha < 8; linha++) {
                            for (coluna = 0; coluna < 8; coluna++) {

                                pecaInimiga = tabuleiro.getCasa(linha, coluna).getPeca();

                                if (pecaInimiga != null) {
                                    if (pecaInimiga.getCor() != pecaRei.getCor()) {

                                        Posicao posicao = new Posicao();
                                        posicao.setPosicao(linha, coluna);
                                        if (tabuleiro.moverPeca(posicao, posicaoRei)) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean ProcurarPeca(Tabuleiro tabuleiro, Posicao posicao, EnumCor cor) {
        int linha;
        int coluna;
        Peca peca;
        Posicao posicaoInimigo = new Posicao();
        //Posicao posicao = new Posicao();
        for (linha = 0; linha < 8; linha++) {
            for (coluna = 0; coluna < 8; coluna++) {
                peca = tabuleiro.getCasa(linha, coluna).getPeca();
                if (peca != null) {
                    if (peca.getCor() != cor) {
                        posicaoInimigo.setPosicao(linha, coluna);
                        if (tabuleiro.moverPeca(posicao, posicaoInimigo)) {
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }

    private boolean VerificarChequeMate(Tabuleiro tabuleiro, EnumCor cor) {
        Peca peca;
        Posicao posicaoRei = new Posicao();
        int linha;
        int coluna;

        Posicao posicao = new Posicao();
        for (linha = 0; linha < 8; linha++) {
            for (coluna = 0; coluna < 8; coluna++) {
                peca = tabuleiro.getCasa(linha, coluna).getPeca();
                if (peca != null) {
                    if (peca.getTipo() == EnumPeca.REI && peca.getCor() == cor) {
                        posicaoRei.setPosicao(linha, coluna);
                        if (ProcurarPeca(tabuleiro, posicaoRei, cor)) {
                            return true;
                        }
                        if (linha > 0) {
                            posicaoRei.setPosicao(linha - 1, coluna);
                            if (ProcurarPeca(tabuleiro, posicaoRei, cor)) {
                                return true;
                            }
                        }
                        posicaoRei.setPosicao(linha + 1, coluna);
                        if (ProcurarPeca(tabuleiro, posicaoRei, cor)) {
                            return true;
                        }
                        posicaoRei.setPosicao(linha, coluna + 1);
                        if (ProcurarPeca(tabuleiro, posicaoRei, cor)) {
                            return true;
                        }
                        if (coluna > 0) {
                            posicaoRei.setPosicao(linha, coluna - 1);
                            if (ProcurarPeca(tabuleiro, posicaoRei, cor)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
}
