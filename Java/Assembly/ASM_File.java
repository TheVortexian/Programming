import java.util.*;
import java.io.*;
import java.util.Collections.*;

public class ASM_File {

   protected String fileName;
   protected File file;
   protected HashMap<String, Integer> genRegs; // generic registers
   protected HashMap<String, Double> xmmRegs; // xmm registers
   protected HashMap<Integer, String> lines; // holds lines by line num
   private int lineCount = 0;
   public ASM_File(String fileName) {
      this.fileName = fileName;
      this.file = new File(fileName);
      this.genRegs = new HashMap<String, Integer>();
      this.xmmRegs = new HashMap<String, Double>();
      this.lines = new HashMap<Integer, String>();
      try {
         Scanner s = new Scanner(this.file);
         int line = 1;
         while (s.hasNextLine()) {
            this.lines.put(line, s.nextLine());
            line++;
            lineCount++;
         }
      } catch (FileNotFoundException e) {
         System.out.println("Could not read file!");
      }
   }
   
   // puts a generic register / value
   void putGenReg(String reg, int val) {
      if (genRegs.containsKey(reg)) {
         genRegs.replace(reg, val);
      } else {
         genRegs.put(reg, val);
      }
   }
   
   // puts an xmm register / value
   void putXmmReg(String reg, double val) {
      if (xmmRegs.containsKey(reg)) {
         xmmRegs.replace(reg, val);
      } else {
         xmmRegs.put(reg, val);
      }
   }
   // return a register's value
   int getRegVal(String reg) {
      int returnable;
      
      if (genRegs.containsKey(reg)) {
         returnable = genRegs.get(reg);
      } else {
         returnable = 0;
      }
      
      return returnable;
   }
   double getXmmVal(String reg) {
      double returnable;
      
      if (xmmRegs.containsKey(reg)) {
         returnable = xmmRegs.get(reg);
      } else {
         returnable = 0;
      }
      
      return returnable;
   }
   
   void DEBUG_printRegs() {
      System.out.print(genRegs);
      System.out.println(xmmRegs);
   }
   
   void operations() {
      while (lineCount-- > 0) {
         
      }
   }
}