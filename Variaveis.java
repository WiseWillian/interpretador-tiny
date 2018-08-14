class Variaveis{
   public static double[] var = new double[26];

   public static void setItem(int pos, double value) {
        var[pos] = value;
   }

   public static double getItem(int pos) {
        return var[pos];
   }
}