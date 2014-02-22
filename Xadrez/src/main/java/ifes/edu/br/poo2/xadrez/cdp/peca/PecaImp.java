package ifes.edu.br.poo2.xadrez.cdp.peca;

import ifes.edu.br.poo2.xadrez.cdp.movimento.Movimento;
import ifes.edu.br.poo2.xadrez.cdp.movimento.MovimentoPeaoPrimario;
import ifes.edu.br.poo2.xadrez.cdp.movimento.MovimentoPeaoSecundario;
import ifes.edu.br.poo2.xadrez.cdp.movimento.Posicao;
import ifes.edu.br.poo2.xadrez.cdp.tabuleiro.Tabuleiro;

/**
 *
 * @author tiago
 */
public class PecaImp implements Peca{
    
    protected EnumCor cor;
    protected EnumPeca tipo;
    protected Movimento movimento;
    protected Movimento captura;
    
    public PecaImp(EnumPeca tipo, Movimento movimento, Movimento captura){
        this.tipo = tipo;
        this.movimento = movimento;
        this.captura = captura;
    }
    
    public boolean captura(Posicao origem, Posicao destino){
        return this.captura.mover(origem, destino);
    }
    public boolean movimento(Posicao origem, Posicao destino){
        
        boolean retorno =  this.movimento.mover(origem, destino);
        
        return retorno;
    }
    
    public Object clone(){
        Object obj =null;
        try{
            obj= super.clone();
        }
        catch(CloneNotSupportedException e){
            System.out.println("Impossivel clonar objeto "+this.getClass());
        }
        return obj;
    }

    public String getNome() {
        
        if(cor==EnumCor.BRANCO)
            return ""+this.tipo.getNome()+"Branco";
        else
            return ""+this.tipo.getNome()+"Preto";
    }
    
    public String getNomeView() {
        
        if(cor==EnumCor.BRANCO)
            return ""+this.tipo.getInicial()+" Branco";
        else
            return ""+this.tipo.getInicial()+" Preto";
    }


    public EnumCor getCor() {
        return cor;
    }

    public void setCor(EnumCor cor) {
        this.cor = cor;
    }
    
    public void setMovimento(Movimento movimento){
        this.movimento = movimento;
    }
    public void setCaptura(Movimento captura){
        this.captura = captura;
    }
    
    public EnumPeca getTipo(){
        return this.tipo;
    }
    
    public  boolean movimento(Posicao origem, Posicao destino, Tabuleiro tabuleiro) throws Exception{
        
        
        if(
           tabuleiro.casaEstaVazia(destino) &&
           this.movimento.mover(origem, destino) && 
           this.movimento.analisaTrajeto(origem, destino, tabuleiro)
           )
        {   
            return true;   
        }
        
        return false;
    }
    public  boolean captura(Posicao origem, Posicao destino, Tabuleiro tabuleiro) throws Exception{
        
        if(
           !tabuleiro.casaEstaVazia(destino) &&
           this.captura.mover(origem, destino) && 
           this.captura.analisaTrajeto(origem, destino, tabuleiro)
           )
        {   
            return true;   
        }
        
        return false;
    }
    
}



