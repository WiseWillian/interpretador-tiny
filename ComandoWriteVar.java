import java.io.*;  
import java.util.*;

import lp.*; 

class ComandoWriteVar extends Comando {
   
   char variavel;
   	
   ComandoWriteVar(int lin, String txt) {
      linha= lin;
      variavel= txt.charAt(0);
   }
   
   public int executa() {
      int pos = ((int)variavel) - 97;
      System.out.print(Variaveis.getItem(pos));
      return linha+1;
   }
}