import java.io.*;  
import java.util.*;

import lp.*; 

class ComandoWhile extends Comando {
	private Expressao exp;
	private int linha;
	private int linhaEnd;
																																																																																																																																																																																																																																																																																																																																			

	ComandoWhile(int linha, int linhaEnd, Expressao exp) {
		this.exp = exp;
		this.linha = linha;
		this.linhaEnd = linhaEnd;
	}

	public void setLinhaEnd(int novaLinha){
		this.linhaEnd = novaLinha;
	}

	public int executa() {
		double resultadoExp = this.exp.avalia();
		resultadoExp == 1 ? return this.linha + 1 : return this.linhaEnd;
	}
}