import java.util.Scanner;

public class ChangeReturn {

   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      float cost = 0;
      float given = 0;
      System.out.println("Enter cost: ");
      cost = s.nextFloat();
      System.out.println("Enter money given: ");
      given = s.nextFloat();

      System.out.println(calcChange(cost, given));
      s.close();
   }


   public static String calcChange(float c, float g) {
      if (c < 0 || g < 0) {
         throw new IndexOutOfBoundsException("Prices cannot be less than 0!");
      }
      int ones = 0, fives = 0, tens = 0, twenties = 0, fifties = 0, hundreds = 0;
      int quarters = 0; // .25
      int dimes = 0; // .1
      int nickels = 0; // .05
      int pennies = 0; // .01
      float cost = c;
      float given = g;
      float totalChange = (given-cost);

      //iterate through change with while loops
      // might not be the most efficient method but it works
      // you have to iterate by biggest -> smallest
      if (totalChange > 0) {
         hundreds = (int)(totalChange / 100);
         totalChange %= 100;
         fifties = (int)(totalChange / 50);
         totalChange %= 50;
         twenties = (int)(totalChange / 20);
         totalChange %= 20;
         tens = (int)(totalChange / 10);
         totalChange %= 10;
         fives = (int)(totalChange / 5);
         totalChange %= 5;
         ones = (int)(totalChange);
         totalChange %= 1; // not sure if this is needed
         quarters = (int)(totalChange / .25);
         totalChange %= .25;
         dimes = (int)(totalChange / .1);
         totalChange %= .1;
         nickels = (int)(totalChange / .05);
         totalChange %= .05;
         pennies = (int)Math.ceil((totalChange / .01));
         totalChange %= .01;
         return("Total change: " + 
               String.format("%.2f",(given-cost)) + "\nHundreds: " + hundreds + "\nFifties: " + fifties + 
               "\nTwenties: " + twenties + "\nTens: " + tens + "\nFives: " + fives + "\nOnes: " + ones +
               "\nQuarters: " + quarters + "\nDimes: " + dimes + "\nNickels: " + nickels + "\nPennies: " + pennies);
      }
      if (totalChange == 0) {
         return("You have no change!");
      }
      return("You must give enough money to pay!");
   }
}
