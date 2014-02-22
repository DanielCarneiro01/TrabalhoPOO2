/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.movimento;

import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import ifes.edu.br.poo2.xadrez.cdp.peca.Peca;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.Casa;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.Tabuleiro;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class MovimentosEspeciais {

    boolean RoqueGrandePreto = true;
    boolean RoqueGrandeBranco = true;

    boolean RoquePequenoPreto = true;
    boolean RoquePequenoBranco = true;

    public void setRoqueGrandePreto() {
        this.RoqueGrandePreto = false;
    }

    public void setRoquePequenoPreto() {
        this.RoquePequenoPreto = false;
    }

    public boolean getRoqueGrandePreto() {
        return this.RoqueGrandePreto;
    }

    public boolean getRoquePequenoPreto() {
        return this.RoquePequenoPreto;
    }

    public void setRoqueGrandeBranco() {
        this.RoqueGrandeBranco = false;
    }

    public void setRoquePequenoBranco() {
        this.RoquePequenoBranco = false;
    }

    public boolean getRoqueGrandeBranco() {
        return this.RoqueGrandeBranco;
    }

    public boolean getRoquePequenoBranco() {
        return this.RoquePequenoBranco;
    }

    public Tabuleiro RoquePequenoPreto(Tabuleiro tabuleiro) throws Exception {
        Posicao posicaoRei = new Posicao(8, 5);
        Posicao posicaoTorre = new Posicao(8, 8);
        Posicao DestinoRei = new Posicao(8, 7);
        Posicao DestinoTorre = new Posicao(8, 6);

        tabuleiro.moverPeca(posicaoRei, DestinoRei);
        tabuleiro.moverPeca(posicaoTorre, DestinoTorre);
        return tabuleiro;

    }

    public Tabuleiro RoqueGrandePreto(Tabuleiro tabuleiro) throws Exception {
        int i;
        for (i = 2; i == 5; i++) {
            if (tabuleiro.getCasa(8, i) != null) {
                throw new Exception("Movimento Nao pode ser Executado!");
            }
        }

        Posicao posicaoRei = new Posicao(8, 5);
        Posicao posicaoTorre = new Posicao(8, 1);
        Posicao DestinoRei = new Posicao(8, 3);
        Posicao DestinoTorre = new Posicao(8, 4);

        tabuleiro.moverPeca(posicaoRei, DestinoRei);
        tabuleiro.moverPeca(posicaoTorre, DestinoTorre);
        
        return tabuleiro;
    }

    public Tabuleiro RoquePequenoBranco(Tabuleiro tabuleiro) throws Exception {
        Posicao posicaoRei = new Posicao(1, 5);
        Posicao posicaoTorre = new Posicao(1, 8);
        Posicao DestinoRei = new Posicao(1, 7);
        Posicao DestinoTorre = new Posicao(1, 6);
        try {
            tabuleiro.moverPeca(posicaoRei, DestinoRei);
            tabuleiro.moverPeca(posicaoTorre, DestinoTorre);
        } catch (Exception e) {
            throw new Exception("Movimento Nao pode ser Executado!");
        }
        
        return tabuleiro;
    }

    public Tabuleiro RoqueGrandeBranco(Tabuleiro tabuleiro) throws Exception {
        int coluna;
        for (coluna = 2; coluna == 5; coluna++) {
            if (tabuleiro.getCasa(1, coluna) != null) {
                throw new Exception("Movimento Nao pode ser Executado!");
            }
        }

        Posicao posicaoRei = new Posicao(1, 5);
        Posicao posicaoTorre = new Posicao(1, 1);
        Posicao DestinoRei = new Posicao(1, 3);
        Posicao DestinoTorre = new Posicao(1, 4);

        try {
            tabuleiro.moverPeca(posicaoRei, DestinoRei);
            tabuleiro.moverPeca(posicaoTorre, DestinoTorre);
        } catch (Exception e) {
            throw new Exception("Movimento Nao pode ser Executado!");
        }
        
        return tabuleiro;
    }

    public void Enpassant(Tabuleiro tabuleiro) throws Exception {

    }

    public boolean ValidarEnpassant() {
        return false;

    }

    public Posicao ProcurarReiPreto(Tabuleiro tabuleiro) {

        int linha;
        int coluna;
        Posicao PosReiInimigo = new Posicao(0, 0);
        for (linha = 0; linha <= 8; linha++) {
            for (coluna = 0; coluna <= 8; coluna++) {
                Casa casa = tabuleiro.getCasa(linha, coluna);
                Peca peca = casa.getPeca();
                if (((peca.getNome()) == "Rei") && ((peca.getCor()) == EnumCor.PRETO)) {
                    PosReiInimigo.setPosicao(linha, coluna);

                    return PosReiInimigo;
                }
            }
        }
        return null;
    }

    public Posicao ProcurarReiBranco(Tabuleiro tabuleiro) {

        int linha;
        int coluna;
        Posicao PosReiInimigo = new Posicao(0, 0);
        for (linha = 0; linha <= 8; linha++) {
            for (coluna = 0; coluna <= 8; coluna++) {
                Casa casa = tabuleiro.getCasa(linha, coluna);
                Peca peca = casa.getPeca();
                if (((peca.getNome()) == "Rei") && ((peca.getCor()) == EnumCor.BRANCO)) {
                    PosReiInimigo.setPosicao(linha, coluna);

                    return PosReiInimigo;
                }
            }
        }
        return null;
    }

    public boolean VerificarChequeBranco(Tabuleiro tabuleiro) {
        int coluna;
        int linha;
        boolean cheque = false;
        Casa casa;
        Peca peca;
        Posicao PosicaoPeca = new Posicao(0, 0);
        Tabuleiro tabuleiroteste;

        Posicao PosReiInimigo = ProcurarReiPreto(tabuleiro);

        for (linha = 0; linha <= 8; linha++) {
            for (coluna = 0; coluna <= 8; coluna++) {
                casa = tabuleiro.getCasa(linha, coluna);
                if (casa.existePeca()) {
                    peca = casa.getPeca();
                    if ((peca.getCor() == EnumCor.BRANCO) && (peca.getNome() != "Rei")) {

                        PosicaoPeca.setPosicao(linha, coluna);
                        tabuleiroteste = tabuleiro;

                        try {

                            peca.movimento(PosicaoPeca, PosReiInimigo, tabuleiroteste);
                            cheque = true;
                        } catch (Exception e) {
                            cheque = false;
                        }
                    }
                }
            }
        }
        return cheque;
    }

    public boolean VerificarChequePreto(Tabuleiro tabuleiro) {
        int coluna;
        int linha;
        boolean cheque = false;
        Casa casa;
        Peca peca;
        Posicao PosicaoPeca = new Posicao(0, 0);
        Tabuleiro tabuleiroteste;

        Posicao PosReiInimigo = ProcurarReiBranco(tabuleiro);

        for (linha = 0; linha <= 8; linha++) {
            for (coluna = 0; coluna <= 8; coluna++) {
                casa = tabuleiro.getCasa(linha, coluna);
                if (casa.existePeca()) {
                    peca = casa.getPeca();
                    if ((peca.getCor() == EnumCor.PRETO) && (peca.getNome() != "Rei")) {

                        PosicaoPeca.setPosicao(linha, coluna);
                        tabuleiroteste = tabuleiro;

                        try {
                            peca.movimento(PosicaoPeca, PosReiInimigo, tabuleiroteste);
                            cheque = true;
                        } catch (Exception e) {
                            cheque = false;
                        }
                    }
                }
            }
        }
        return cheque;
    }
    
    public Tabuleiro promoverPeca(Posicao posicao, Tabuleiro tabuleiro){
        ArrayList<Peca> cemiterio = new ArrayList<Peca>();
        int iterador=0;
        
        
        Casa casa = tabuleiro.getCasa(posicao.getLinha(), posicao.getColuna());
        Peca peca = casa.getPeca();
        
        cemiterio = tabuleiro.GetCemiterio();
        
        while(cemiterio.size()> iterador)
        {
          iterador ++;
          if(cemiterio.get(iterador).getNome()==peca.getNome())
          {
              Peca pecaSubstituta = cemiterio.get(iterador);
              tabuleiro.GetCemiterio().remove(iterador);
              tabuleiro.GetCemiterio().add(peca);
              return tabuleiro;
              
          }
          else{
              return tabuleiro;
          }
        }
        return tabuleiro;
        
    }
            

            
}