/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.tabuleiro;

import ifes.edu.br.poo2.xadrez.cdp.peca.EnumPeca;
import ifes.edu.br.poo2.xadrez.cdp.peca.PecaBrancaFactory;
import ifes.edu.br.poo2.xadrez.cdp.peca.PecaFactory;
import ifes.edu.br.poo2.xadrez.cdp.peca.PecaPretaFactory;

/**
 *
 * @author tiago
 */
public class TabuleiroBuilder {
    
    private Tabuleiro tabuleiro;
    private PecaFactory pecaFactory;
    
    public TabuleiroBuilder(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
    }
    
    public Tabuleiro getTabuleiro(){
        return tabuleiro;
    }
    
    public void buildCasas(){
        
        for(int linha=0; linha<tabuleiro.QUANTIDADELINHAS;linha++){
            for(int coluna=0; coluna<tabuleiro.QUANTIDADECOLUNAS;coluna++){
                    
                    Casa casa = new Casa(GeradorCorCasa.INSTANCE.proximaCor());
                    this.tabuleiro.setCasa(casa, linha, coluna);
            }
            GeradorCorCasa.INSTANCE.proximaCor();
        }
        
    }
    
    public void buildPecasPretas(){
        
        for(int coluna=0;coluna<this.tabuleiro.QUANTIDADECOLUNAS;coluna++){
            Casa casa = tabuleiro.getCasa(0, coluna);
            this.pecaFactory = new PecaPretaFactory();
            EnumPeca tipoPeca = GeradorTipoPeca.PRETO.proximaPeca();
            casa.setPeca(this.pecaFactory.build(tipoPeca));
        }
        
        for(int coluna=0;coluna<this.tabuleiro.QUANTIDADECOLUNAS;coluna++){
            Casa casa = tabuleiro.getCasa(1, coluna);
            this.pecaFactory = new PecaPretaFactory();
            casa.setPeca(this.pecaFactory.build(EnumPeca.PEAO));
        }
        
    }
    
    public void buildPecasBrancas(){
        for(int coluna=0;coluna<this.tabuleiro.QUANTIDADECOLUNAS;coluna++){
            int linha = tabuleiro.QUANTIDADELINHAS-1;
            Casa casa = tabuleiro.getCasa(linha, coluna);
            this.pecaFactory = new PecaBrancaFactory();
            EnumPeca tipoPeca = GeradorTipoPeca.BRANCO.proximaPeca();
            casa.setPeca(this.pecaFactory.build(tipoPeca));
        }
        
        for(int coluna=0;coluna<this.tabuleiro.QUANTIDADECOLUNAS;coluna++){
            int linha = tabuleiro.QUANTIDADELINHAS-2;
            Casa casa = tabuleiro.getCasa(linha, coluna);
            this.pecaFactory = new PecaBrancaFactory();
            casa.setPeca(this.pecaFactory.build(EnumPeca.PEAO));
        }
    }
    
}
