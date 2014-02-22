/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.peca;

/**
 *
 * @author tiago
 */
public enum EnumPeca {
    PEAO("Peao", 'P', 1), CAVALO("Cavalo",'C',3), BISPO("Bispo",'B',3),
    TORRE("Torre",'T',5), REI("Rei",'R',100), RAINHA("Rainha",'D',9);

    private final String nome;
    private final char inicial;
    private final int pontos;
    
    EnumPeca(String nome, char inicial, int pontos){
        this.nome = nome;
        this.inicial = inicial;
        this.pontos = pontos;
    }
    public String getNome(){
        return this.nome;
    }
    public char getInicial(){
        return this.inicial;
    }
    public int getPontos(){
        return this.pontos;
    }
}
