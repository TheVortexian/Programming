import java.util.*;
import java.io.*;

public class ASM_Main {

   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      System.out.println("Enter file name: ");
      
      ASM_File f = new ASM_File(s.nextLine());
   }

}