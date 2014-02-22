package ifes.edu.br.poo2.xadrez.cdp.movimento;

public class Posicao {

	private int linha, coluna;
	
	public Posicao(int linha, int coluna){
		this.linha = linha-1;
		this.coluna = coluna-1;
	}

    public Posicao() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	public void setPosicao(int linha, int coluna){
		this.linha = linha -1;
		this.coluna = coluna-1;
	}
	
	public int getLinha(){
		return this.linha;
	}
	public int getColuna(){
		return this.coluna;
	}
	
	
}
