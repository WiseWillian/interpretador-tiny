import java.io.*;  
import java.util.*;

import lp.*; 

class ComandoRead extends Comando {
   
   BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
   char variavel;
   	
   ComandoRead(int lin, String txt) {
      linha= lin;
      variavel= txt.charAt(0);
   }
   
   public int executa() {
      try {
         double conteudo = Double.parseDouble(teclado.readLine());
         int pos = ((int)variavel) - 97;
         Variaveis.setItem(pos, conteudo);
      }
      catch( Exception e) {
         System.out.println("ERRO: "+e);
      }
      return linha+1;
   }
}