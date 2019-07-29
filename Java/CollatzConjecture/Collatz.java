import java.util.Scanner;

public class Collatz {
   
   static int steps = 0;
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      System.out.println("Enter number: ");
      int n = s.nextInt();
      collatz(n);
   }
   
   public static void collatz(int n) {
      if (n == 1) {
         System.out.println(steps + " step(s)");
      }
      
      else if ((n > 1) && (n % 2 == 0)) {
         steps++;
         collatz(n/2);
      }
      
      else if ((n > 1) && (n % 2 > 0)) {
         steps++;
         collatz(1 + (n*3));
      }
   }
   
}