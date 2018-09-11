import java.io.*;  
import java.util.*;

import lp.*; 

class Interpretador {
   private ArquivoFonte arq;
   private Vector comandos;
   private String palavraAtual;
   		
   public Interpretador(String nome) {
	  arq= new ArquivoFonte(nome);
	  comandos= new Vector();
   }
   
   public void listaArquivo() {
	  String palavra;
	  
	  do {
		 palavra= arq.proximaPalavra();
		 System.out.println ("Palavra: " + palavra);
	  } while (!palavra.equals("EOF"));
   }
   
   public void leArquivo() {
	  String comandoAtual;
	  int linha= 0;
	  do {
		 comandoAtual= arq.proximaPalavra();

		 if(comandoAtual.equals("endp")){
			trataComandoEndp(linha);
			linha++;
		 }
		 else if(comandoAtual.equals("writeln")){
			trataComandoWriteln(linha);
			linha++;
		 }
		 else if(comandoAtual.equals("writeStr")) {
			arq.proximaPalavra(); //Descarta o parenteses
			trataComandoWriteStr(linha, arq.proximaPalavra());
			linha++;
		 }
		 else if(comandoAtual.equals("read")) {
			arq.proximaPalavra(); //Descarta o parenteses
			trataComandoRead(linha, arq.proximaPalavra());
			linha++;
		 }
		 else if(comandoAtual.equals("writeVar")) {
			arq.proximaPalavra(); //Descarta o parenteses
			trataComandoWriteVar(linha, arq.proximaPalavra());
			linha++;
		 } 
		 else if(comandoAtual.equals("while")) {
			arq.proximaPalavra(); //Descarta o parenteses
			trataComandoWhile(linha, arq.proximaPalavra());
			linha++;
		 }
		 else if(comandoAtual.equals("endw")) {
			arq.proximaPalavra(); //Descarta o parenteses
			trataComandoEndW(linha, arq.proximaPalavra());
			linha++;
		 }          		  
	  } while (!comandoAtual.equals("endp"));
   }
   
   private void trataComandoEndp(int lin) {
	  
	  ComandoEndp c= new ComandoEndp(lin);
	  comandos.addElement(c);
   }

   private void trataComandoWriteStr(int lin, String text) {
	   ComandoWriteStr c = new ComandoWriteStr(lin, text);
	   comandos.addElement(c);
   }
   	   	
   private void trataComandoWriteln(int lin) {
	  
	  ComandoWriteln c= new ComandoWriteln(lin);
	  comandos.addElement(c);
   }

   private void trataComandoRead(int lin, String text) {
	  ComandoRead c = new ComandoRead(lin, text);
	  comandos.addElement(c);
   }

   private void trataComandoWriteVar(int lin, String text) {
	ComandoWriteVar c = new ComandoWriteVar(lin, text);
	comandos.addElement(c);
}

private void trataComandoWhile(ArquivoFonte arq, Expressao exp, int lin) {
	int linhaEnd = lin;

	String comandoAtual = arq.proximaPalavra();
	while(!comandoAtual.equals("endw"))
		linhaEnd++;
    ComandoWhile c = new ComandoWhile(lin, linhaEnd, exp); 
    comandos.addElement(c);
}

private void trataComandoEndW(int lin) {
	  
    ComandoEndW c= new ComandoEndW(lin);
    comandos.addElement(c);
}
   
   public void executa() {
	  Comando cmd;
	  int pc= 0;
	  do {
		 cmd= (Comando) comandos.elementAt(pc);
		 pc= cmd.executa();
	  } while (pc != -1);
   }   
}
