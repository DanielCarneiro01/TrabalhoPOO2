/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.partida;

import ifes.edu.br.poo2.xadrez.cdp.jogador.Jogador;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.TabuleiroBuilder;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.Tabuleiro;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.TabuleiroDirector;
import ifes.edu.br.poo2.xadrez.cgd.Model;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.Serializable;

/**
 *
 * @author tiago
 */
public class Partida extends Model implements Serializable{
    
    Jogador jogadorBranco, jogadorPreto, winner;
    Tabuleiro tabuleiro;
    String inicio, fim;
    protected boolean roqueMaiorBranco, roqueMenorBranco, roqueMenorPreto,
            roqueMaiorPreto, xequeBranco, xequePreto, finalizada;

    public String getInicio() {
        return inicio;
    }

    public Jogador getWinner() {
        return winner;
    }

    public void setWinner(Jogador winner) {
        this.winner = winner;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public int getPontosbranco() {
        return pontosbranco;
    }

    public void setPontosbranco(int pontosbranco) {
        this.pontosbranco = pontosbranco;
    }

    public int getPontospreto() {
        return pontospreto;
    }

    public void setPontospreto(int pontospreto) {
        this.pontospreto = pontospreto;
    }
    int pontosbranco;
    int pontospreto;
    
    public Partida(){
        this.roqueMaiorBranco = true;
        this.roqueMaiorPreto = true;
        this.roqueMenorBranco = true;
        this.roqueMenorPreto = true;
        this.xequeBranco = false;
        this.xequePreto = false;
        this.finalizada = false;
        
        TabuleiroBuilder builder = new TabuleiroBuilder(new Tabuleiro());
        TabuleiroDirector director = new TabuleiroDirector();
        
        this.tabuleiro = director.build(builder);
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        this.inicio = dateFormat.format(cal.getTime());
        
    }
    

    public Jogador getJogadorBranco() {
        return jogadorBranco;
    }

    public void setJogadorBranco(Jogador jogadorBranco) {
        this.jogadorBranco = jogadorBranco;
    }

    public Jogador getJogadorPreto() {
        return jogadorPreto;
    }

    public void setJogadorPreto(Jogador jogadorPreto) {
        this.jogadorPreto = jogadorPreto;
    }

    public boolean isRoqueMenorBranco() {
        return roqueMenorBranco;
    }

    public void setRoqueMenorBranco(boolean roqueMenorBranco) {
        this.roqueMenorBranco = roqueMenorBranco;
    }

    public boolean isRoqueMenorPreto() {
        return roqueMenorPreto;
    }

    public void setRoqueMenorPreto(boolean roqueMenorPreto) {
        this.roqueMenorPreto = roqueMenorPreto;
    }

    public boolean isRoqueMaiorPreto() {
        return roqueMaiorPreto;
    }

    public void setRoqueMaiorPreto(boolean roqueMaiorPreto) {
        this.roqueMaiorPreto = roqueMaiorPreto;
    }

    public boolean isXequeBranco() {
        return xequeBranco;
    }

    public void setXequeBranco(boolean xequeBranco) {
        this.xequeBranco = xequeBranco;
    }

    public boolean isXequePreto() {
        return xequePreto;
    }

    public void setXequePreto(boolean xequePreto) {
        this.xequePreto = xequePreto;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public boolean isRoqueMaiorBranco() {
        return roqueMaiorBranco;
    }

    public void setRoqueMaiorBranco(boolean roqueMaiorBranco) {
        this.roqueMaiorBranco = roqueMaiorBranco;
    }

    public boolean isRoqueMenor(EnumCor corJogador) {
        if(corJogador==EnumCor.BRANCO)
            return this.isRoqueMenorBranco();
        else
            return this.isRoqueMenorPreto();
    }

    public boolean isRoqueMaior(EnumCor corJogador) {
        if(corJogador==EnumCor.BRANCO)
            return this.isRoqueMaiorBranco();
        else
            return this.isRoqueMaiorPreto();
        
    }

    void setRoqueMaior(EnumCor corJogador, boolean condicao) {
        
        if(EnumCor.BRANCO == corJogador){
            this.setRoqueMaiorBranco(condicao);
        }
        else{
            this.setRoqueMaiorPreto(condicao);
        }
        
    }

    void setRoqueMenor(EnumCor corJogador, boolean condicao) {
        if(EnumCor.BRANCO == corJogador){
            this.setRoqueMenorBranco(condicao);
        }
        else{
            this.setRoqueMenorPreto(condicao);
        }
    }
    
    
    
}
