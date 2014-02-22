/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.poo2.xadrez.cdp.peca;

import java.lang.reflect.*;

/**
 *
 * @author tiago
 */
public class PecaBrancaFactory extends PecaFactoryAbstract{

    
    public PecaBrancaFactory(){
        this.manager = new PecaManager();
    }
    
    
    public Peca selectPeca(EnumPeca peca) {
        
        try{
            Class classe = manager.getClass();

            Method metodo = classe.getMethod("create"+peca.getNome(), EnumCor.class );

            return (Peca)metodo.invoke(this.manager, EnumCor.BRANCO);
        
        }
        catch(Exception e){
            System.out.println("Erro no Reflection!!");
        }
        
        return null;
    }
    
}
