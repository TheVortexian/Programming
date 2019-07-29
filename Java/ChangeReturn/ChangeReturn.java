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
      
      int quarters = 0; // .25
      int dimes = 0; // .1
      int nickels = 0; // .05
      int pennies = 0; // .01
      float cost = c;
      float given = g;
      float totalChange = (given-cost);
      
      if (totalChange > 0) {
         
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
         
         return("Total change: " + String.format("%.2f",(given-cost)) + "\nQuarters: " + quarters + "\nDimes: " + dimes + "\nNickels: " + nickels + "\nPennies: " + pennies);
      }
      if (totalChange == 0) {
         return("You have no change!");
      }
      return("You must give enough money to pay!");
   }
}