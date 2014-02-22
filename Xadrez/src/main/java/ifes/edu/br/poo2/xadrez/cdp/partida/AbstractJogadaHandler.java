/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.partida;

import ifes.edu.br.poo2.xadrez.cdp.peca.EnumCor;

/**
 *
 * @author Bassini
 */
public abstract class AbstractJogadaHandler implements JogadaHandler {
    
    protected JogadaHandler nextHandler;
    
    
    public void setNextHandler(JogadaHandler handler) {
        nextHandler = handler;
    }

    public boolean processHandler(Partida partida, String entrada, EnumCor corJogador) {
        
        
        
        if ( matchingWords(entrada) ) {
            
            return handleHere(partida, entrada, corJogador);
        
        }else {
            if(nextHandler!=null){
                return nextHandler.processHandler(partida, entrada, corJogador);
            }
            else{
                return false;
            }
        }
    }
    
    public static boolean handle(Partida partida, String entrada, EnumCor corJogador) {
        // Create the handler objects...
        
        JogadaHandler sair = new SairHandler();
        JogadaHandler salvar = new SalvarHandler();
        JogadaHandler desistir = new DesistirHandler();
        JogadaHandler empatar = new EmpateHandler();
        JogadaHandler pontos = new PontosHandler();
        JogadaHandler roqueMaior = new RoqueMaiorHandler();
        JogadaHandler roqueMenor = new RoqueMenorHandler();
        JogadaHandler promocao = new PromocaoHandler();
        JogadaHandler movimento = new MovimentoHandler();
        
        sair.setNextHandler(salvar);
        salvar.setNextHandler(desistir);
        desistir.setNextHandler(empatar);
        empatar.setNextHandler(pontos);                
        pontos.setNextHandler(roqueMaior);
        roqueMaior.setNextHandler(roqueMenor);
        roqueMenor.setNextHandler(promocao);
        promocao.setNextHandler(movimento);
        
        return sair.processHandler(partida, entrada, corJogador);
    }
    
    protected abstract boolean matchingWords(String entrada);
    protected abstract boolean handleHere(Partida partida, String entrada, EnumCor corJogador);
    
}
