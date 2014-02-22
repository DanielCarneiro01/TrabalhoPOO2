
package ifes.edu.br.poo2.xadrez.cdp.peca;

import ifes.edu.br.poo2.xadrez.cdp.movimento.Movimento;
import ifes.edu.br.poo2.xadrez.cdp.movimento.MovimentoPeaoPrimario;
import ifes.edu.br.poo2.xadrez.cdp.movimento.MovimentoPeaoCaptura;
import ifes.edu.br.poo2.xadrez.cdp.movimento.MovimentoRainha;
import ifes.edu.br.poo2.xadrez.cdp.movimento.MovimentoCavalo;
import ifes.edu.br.poo2.xadrez.cdp.movimento.MovimentoTorre;
import ifes.edu.br.poo2.xadrez.cdp.movimento.MovimentoRei;
import ifes.edu.br.poo2.xadrez.cdp.movimento.MovimentoBispo;


public class PecaManager {
    private Peca peao, cavalo, bispo, torre, rei, rainha;
    
    public PecaManager(){
        Movimento movimento;
        peao = new PecaImp(EnumPeca.PEAO ,new MovimentoPeaoPrimario(), new MovimentoPeaoCaptura());
        movimento = new MovimentoCavalo();
        cavalo = new PecaImp(EnumPeca.CAVALO, movimento, movimento);
        movimento = new MovimentoBispo();
        bispo = new PecaImp(EnumPeca.BISPO , movimento, movimento);
        movimento = new MovimentoTorre();
        torre = new PecaImp(EnumPeca.TORRE ,movimento, movimento);
        movimento = new MovimentoRei();
        rei = new PecaImp(EnumPeca.REI, movimento, movimento);
        movimento = new MovimentoRainha();
        rainha = new PecaImp(EnumPeca.RAINHA, movimento, movimento);
    }
    
    public Peca createPeao(EnumCor cor){
        Peca peca = (PecaImp)peao.clone();
        peca.setCor(cor);
        return peca;
    }
    
    public Peca createCavalo(EnumCor cor){
        Peca peca = (PecaImp)cavalo.clone();
        peca.setCor(cor);
        return peca;
    }
    
    public Peca createTorre(EnumCor cor){
        Peca peca = (PecaImp)torre.clone();
        peca.setCor(cor);
        return peca;
    }
    
    public Peca createBispo(EnumCor cor){
        Peca peca = (PecaImp)bispo.clone();
        peca.setCor(cor);
        return peca;
    }
    
    public Peca createRei(EnumCor cor){
        Peca peca = (PecaImp)rei.clone();
        peca.setCor(cor);
        return peca;
    }
    
    public Peca createRainha(EnumCor cor){
        Peca peca = (PecaImp)rainha.clone();
        peca.setCor(cor);
        return peca;
    }
}

