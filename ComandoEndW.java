import java.io.*;  
import java.util.*;

import lp.*; 

class ComandoEndW extends Comando {
	private int linha;
	private int linhaInicio;
																																																																																																																																																																																																																																																																																																																																			

	ComandoEndW(int linha, int linhaInicio) {
		this.linha = linha;
		this.linhaInicio = linhaInicio;
	}

	public int executa() {
		return this.linhaInicio;
	}
}