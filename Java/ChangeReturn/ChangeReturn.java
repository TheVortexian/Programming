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
   }


   public static String calcChange(float c, float g) {
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
      if (totalChange > 0) {

        //bills
        while (totalChange - 100 >= 0) {
          hundreds++;
          totalChange -= 100;
        }
        while (totalChange - 50 >= 0) {
          fifties++;
          totalChange -= 50;
        }
        while (totalChange - 20 >= 0) {
          twenties++;
          totalChange -= 20;
        }
        while (totalChange - 10 >= 0) {
          tens++;
          totalChange -= 10;
        }
        while (totalChange - 5 >= 0) {
          fives++;
          totalChange -= 5;
        }
        while (totalChange - 1 >= 0) {
          ones++;
          totalChange -= 1;
        }

        //Coins
         while (totalChange - .25 >= 0) {
            quarters++;
            totalChange -= .25;
         }
         while (totalChange - .1 >= 0) {
            dimes++;
            totalChange -= .1;
         }
         while (totalChange - .05 >= 0) {
            nickels++;
            totalChange -= .05;
         }
         while (totalChange - .01 >= 0) {
            pennies++;
            totalChange -= .01;
         }

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
