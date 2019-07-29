// Nth fibonacci number in Java
public class Fibonacci {
   public static void main(String[] args) {
      println(fibonacci(50));
   }
   public static void println(Object o) {
      System.out.println(o.toString());
   }
   
   public static int fibonacci(int n)  {
       if(n == 0) {
           return 0;
       }
       else if(n == 1) {
         return 1;
       } else {
         return fibonacci(n - 1) + fibonacci(n - 2);
      }
   }
}