import java.util.*;
import java.io.*;
import java.util.Collections.*;

public class ASM_File {

   protected String fileName;
   protected File file;
   protected HashMap<String, Integer> genRegs; // generic registers
   protected HashMap<String, Double> xmmRegs; // xmm registers
   protected HashMap<Integer, String> lines; // holds lines by line num? gotta keep track of lines
                                             // I dont want to explicitly use -IP so not sure what to do
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
   int getGenReg(String reg) {
      int returnable;
      
      if (genRegs.containsKey(reg)) {
         returnable = genRegs.get(reg);
      } else {
         returnable = 0;
      }
      
      return returnable;
   }
   double getXmmReg(String reg) {
      double returnable;
      
      if (xmmRegs.containsKey(reg)) {
         returnable = xmmRegs.get(reg);
      } else {
         returnable = 0;
      }
      
      return returnable;
   }
   
   void DEBUG_print() {
      System.out.print(genRegs);
      System.out.println(xmmRegs);
   }
   // checks if register exists 
   private boolean regExists(String reg) {
      boolean ret = true;
      if (reg.contains("r")) {
         if (genRegs.containsKey(reg)) ret = true;
         else ret = false;
      } else if (reg.contains("xmm")) {
         if (xmmRegs.containsKey(reg)) ret = true;
         else ret = false;
      } else ret = false;
      return ret;
   }
   
   // mov reg, reg
   protected void mov(String reg1, String reg2) {
      
      if (!regExists(reg1)) {
         if (reg1.contains("r")) genRegs.put(reg1, 0);
         else if (reg1.contains("xmm")) xmmRegs.put(reg1, 0.0);
      }
      if (!regExists(reg2)) {
         if (reg2.contains("r")) genRegs.put(reg2, 0);
         else if (reg2.contains("xmm")) xmmRegs.put(reg2, 0.0);
      }
      
      if ((reg1.contains("xmm") && !reg2.contains("xmm")) || (reg1.contains("r") && !reg2.contains("r"))) {
         throw new InputMismatchException();
      }
      else if (reg1.contains("xmm") && reg2.contains("xmm")) {
         if (regExists(reg1) && regExists(reg2)) {
            xmmRegs.replace(reg1, xmmRegs.get(reg2));
         } else {
            throw new NullPointerException();
         }
      }
      else if (reg1.contains("r") && reg2.contains("r")) {
         if (regExists(reg1) && regExists(reg2)) {
            genRegs.replace(reg1, genRegs.get(reg2));
         } else {
            throw new NullPointerException();
         }
      }
   }
   
   // mov reg, val
   protected void mov(String reg, Object val) {
      if (regExists(reg)) {
         if (reg.contains("r") && val instanceof Integer) {
            genRegs.replace(reg, Integer.parseInt(String.valueOf(val)));
         } else if (reg.contains("xmm") && val instanceof Double) {
            xmmRegs.replace(reg, Double.parseDouble(String.valueOf(val)));
         } else {
            throw new IllegalArgumentException();
         }
      } else if (!regExists(reg)) {
         if (reg.contains("r") && val instanceof Integer) {
            genRegs.put(reg, Integer.parseInt(String.valueOf(val)));
         } else if (reg.contains("xmm") && val instanceof Double) {
            xmmRegs.put(reg, Double.parseDouble(String.valueOf(val)));
         } else {
            throw new IllegalArgumentException();
         }
      }
   }
   
   // add reg, reg
   protected void add(String reg1, String reg2) {
      if (regExists(reg1) && regExists(reg2)) {
         if (reg1.contains("r") && reg2.contains("r")) {
            genRegs.replace(reg1, genRegs.get(reg1) + genRegs.get(reg2));
         } else if (reg1.contains("xmm") && reg2.contains("xmm")) {
            xmmRegs.replace(reg1, xmmRegs.get(reg1) + xmmRegs.get(reg2));
         } else {
            throw new InputMismatchException();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
   
   // add reg, val
   protected void add(String reg, Object val) {
      if (regExists(reg)) {
         if (reg.contains("r") && val instanceof Integer) {
            genRegs.replace(reg, genRegs.get(reg) + Integer.parseInt(String.valueOf(val)));
         } else if (reg.contains("xmm") && val instanceof Double) {
            xmmRegs.replace(reg, xmmRegs.get(reg) + Double.parseDouble(String.valueOf(val)));
         } else {
            throw new InputMismatchException();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
   
   // sub reg, reg
   protected void sub(String reg1, String reg2) {
      if (regExists(reg1) && regExists(reg2)) {
         if (reg1.contains("r") && reg2.contains("r")) {
            genRegs.replace(reg1, genRegs.get(reg1) - genRegs.get(reg2));
         } else if (reg1.contains("xmm") && reg2.contains("xmm")) {
            xmmRegs.replace(reg1, xmmRegs.get(reg1) - xmmRegs.get(reg2));
         } else {
            throw new InputMismatchException();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
   
   // add sub, val
   protected void sub(String reg, Object val) {
      if (regExists(reg)) {
         if (reg.contains("r") && val instanceof Integer) {
            genRegs.replace(reg, genRegs.get(reg) - Integer.parseInt(String.valueOf(val)));
         } else if (reg.contains("xmm") && val instanceof Double) {
            xmmRegs.replace(reg, xmmRegs.get(reg) - Double.parseDouble(String.valueOf(val)));
         } else {
            throw new InputMismatchException();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
   
   // mul reg, reg
   protected void mul(String reg1, String reg2) {
      if (regExists(reg1) && regExists(reg2)) {
         if (reg1.contains("r") && reg2.contains("r")) {
            genRegs.replace(reg1, genRegs.get(reg1) * genRegs.get(reg2));
         } else if (reg1.contains("xmm") && reg2.contains("xmm")) {
            xmmRegs.replace(reg1, xmmRegs.get(reg1) * xmmRegs.get(reg2));
         } else {
            throw new InputMismatchException();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
   
   // mul reg, val
   protected void mul(String reg, Object val) {
      if (regExists(reg)) {
         if (reg.contains("r") && val instanceof Integer) {
            genRegs.replace(reg, genRegs.get(reg) * Integer.parseInt(String.valueOf(val)));
         } else if (reg.contains("xmm") && val instanceof Double) {
            xmmRegs.replace(reg, xmmRegs.get(reg) * Double.parseDouble(String.valueOf(val)));
         } else {
            throw new InputMismatchException();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
   
   // div reg, reg
   protected void div(String reg1, String reg2) {
      if (regExists(reg1) && regExists(reg2)) {
         if (reg1.contains("r") && reg2.contains("r")) {
            genRegs.replace(reg1, genRegs.get(reg1) / genRegs.get(reg2));
         } else if (reg1.contains("xmm") && reg2.contains("xmm")) {
            xmmRegs.replace(reg1, xmmRegs.get(reg1) / xmmRegs.get(reg2));
         } else {
            throw new InputMismatchException();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
   
   // div reg, val
   protected void div(String reg, Object val) {
      if (regExists(reg)) {
         if (reg.contains("r") && val instanceof Integer) {
            genRegs.replace(reg, genRegs.get(reg) / Integer.parseInt(String.valueOf(val)));
         } else if (reg.contains("xmm") && val instanceof Double) {
            xmmRegs.replace(reg, xmmRegs.get(reg) / Double.parseDouble(String.valueOf(val)));
         } else {
            throw new InputMismatchException();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}