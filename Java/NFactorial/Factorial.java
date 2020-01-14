/*

A class that just gives you a factorial after N :)

Utilizes Java's BigInteger class; this is not only slightly faster, but also allows us to do HUGE factorials that longs or doubles wouldn't allow us to do.
Takes ~9-10 seconds to evaluate 150,000! depending on your machine.

*/
import java.math.BigInteger;
import java.io.*;
public class Factorial {
   
   public static BigInteger fac = new BigInteger("1");
   public static void main(String[] args) {
      //This convolution takes the time the program took to run, and prints it to the file output.txt
      long start = System.nanoTime();
      final long N = 100000;
      BigInteger result = factorial(N);
      long end = System.nanoTime();
      System.out.println("Done! Check directory for .txt file containing results.");
      try {
      writeFile(("Evaluated " + N + "!, taking " + (double)((end-start)/(1000000000)) + " seconds and got: "), result.toString());
      } catch (Exception e) { System.out.println(e); }
   }
   
   // We can't use recursion because java gets angry if you do, so iteration it is
   public static BigInteger factorial(long n) {
      for (long i = n; i > 1; i--) {
         BigInteger b1 = fac;
         BigInteger n2 = BigInteger.valueOf(i);
         fac = b1.multiply(n2);
      }
      return fac;
   }
   
   // method to write to file
   public static void writeFile(String line1, String line2) throws IOException {
      BufferedWriter br = new BufferedWriter(new FileWriter("output", false));
      br.write(line1 + "\n");
      br.write(line2);
      br.close();
   }
}