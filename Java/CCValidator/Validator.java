import java.util.Scanner;
public class Validator {
   
   // for 16 digit long cards
   public static boolean checkCard(String card) {
      int sum = 0;
      for (int i = 0; i < card.length()-1; i++) {
         int val = (int)card.charAt(i);
         if (i % 2 == 0) {
            val *= 2;
            if (val > 9) {
               val = 1 + (val % 10);
            }
         }
         sum += val;
      }
      return (sum % 10 == 0);
   }
   
   public static void main(String[] args) {
      System.out.println(392 / 10 % 10 / 2);
   }

}