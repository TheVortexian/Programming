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
      Scanner s = new Scanner(System.in);
      System.out.println("Enter card #: ");
      String num = s.next();
      System.out.println("Is valid? " + checkCard(num));
   }

}