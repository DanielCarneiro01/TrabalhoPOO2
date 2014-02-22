/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.edu.br.poo2.xadrez.cgt;

import ifes.edu.br.poo2.xadrez.cdp.jogador.AbstractJogadorFactory;
import ifes.edu.br.poo2.xadrez.cdp.jogador.Jogador;
import ifes.edu.br.poo2.xadrez.cdp.jogador.JogadorHumanoFactory;
import ifes.edu.br.poo2.xadrez.cdp.jogador.JogadorIAFactory;
import ifes.edu.br.poo2.xadrez.cdp.jogador.Score;
import ifes.edu.br.poo2.xadrez.cdp.movimento.Posicao;
import ifes.edu.br.poo2.xadrez.cdp.partida.Partida;
import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.Tabuleiro;
import ifes.edu.br.poo2.xadrez.cdp.movimento.MovimentosEspeciais;
import ifes.edu.br.poo2.xadrez.cgd.DadosPartidaDAO;
import ifes.edu.br.poo2.xadrez.cgd.JogadorDAO;
import ifes.edu.br.poo2.xadrez.cih.TabuleiroView;
import java.sql.SQLException;
import java.util.Scanner;



public class PartidaControle {

    public Partida iniciarPartidaAmigos(String nomeJogadorBranco, String nomeJogadorPreto) throws SQLException, ClassNotFoundException {
        
        JogadorDAO jogadorDAO = new JogadorDAO();
        
        Jogador jogadorBranco = jogadorDAO.findbyNome(nomeJogadorBranco);
        
        if( jogadorBranco != null){
            jogadorBranco.setCor(EnumCor.BRANCO);
        }
        else{
            AbstractJogadorFactory factory = new JogadorHumanoFactory();
            jogadorBranco = factory.createJogador(EnumCor.BRANCO);
            jogadorBranco.setNome(nomeJogadorBranco);
            jogadorBranco.setVitorias(0);
            jogadorDAO.insert(jogadorBranco);
        }
        
        Jogador jogadorPreto = jogadorDAO.findbyNome(nomeJogadorPreto);
        
        if( jogadorPreto != null){
            jogadorPreto.setCor(EnumCor.PRETO);
        }
        else{
            AbstractJogadorFactory factory = new JogadorHumanoFactory();
            jogadorPreto = factory.createJogador(EnumCor.PRETO);
            jogadorPreto.setNome(nomeJogadorPreto);
            jogadorPreto.setVitorias(0);
            jogadorDAO.insert(jogadorPreto);
        }
        
        Partida partida = new Partida();
        partida.setJogadorBranco(jogadorBranco);
        partida.setJogadorPreto(jogadorPreto);
        
        /*
        System.out.println("Branco: "+  jogadorBranco.getId()+" "+
                                        jogadorBranco.getNome()+" "+
                                        jogadorBranco.getVitorias()+" "+
                                        jogadorBranco.getCor().toString());
        
        System.out.println("Preto: "+  jogadorPreto.getId()+" "+
                                        jogadorPreto.getNome()+" "+
                                        jogadorPreto.getVitorias()+" "+
                                        jogadorPreto.getCor().toString());
        
        */
        return partida;

    }

    public Partida iniciarPartidaSolo(String nomeJogadorBranco) throws SQLException, ClassNotFoundException {
        JogadorDAO jogadorDAO = new JogadorDAO();
        
        Jogador jogadorBranco = jogadorDAO.findbyNome(nomeJogadorBranco);
        
        if( jogadorBranco != null){
            jogadorBranco.setCor(EnumCor.BRANCO);
        }
        else{
            AbstractJogadorFactory factory = new JogadorHumanoFactory();
            jogadorBranco = factory.createJogador(EnumCor.BRANCO);
            jogadorBranco.setNome(nomeJogadorBranco);
            jogadorBranco.setVitorias(0);
            jogadorDAO.insert(jogadorBranco);
        }
        
        Jogador jogadorPreto = jogadorDAO.findbyNome("ZEUS");
        
        AbstractJogadorFactory factory = new JogadorIAFactory();
        Jogador zeus = factory.createJogador(EnumCor.PRETO);
        zeus.setNome("ZEUS");
        zeus.setVitorias(0);
        
        
        if( jogadorPreto != null){
            zeus.setId(jogadorPreto.getId());
            zeus.setVitorias(jogadorPreto.getVitorias());
        }
        else{
            jogadorDAO.insert(zeus);
        }
        
        Partida partida = new Partida();
        partida.setJogadorBranco(jogadorBranco);
        partida.setJogadorPreto(zeus);

        return partida;
    }

    public boolean VerificarEntrada(String jogada) {
        int teste;
        try {
            teste = Integer.parseInt(jogada);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String[] ConverteEntrada(String entrada) {
        String[] valorconvertido;
        valorconvertido = entrada.split("");
        return valorconvertido;
    }


}
