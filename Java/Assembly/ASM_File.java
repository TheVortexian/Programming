import java.util.*;
import java.io.*;
import java.util.Collections.*;

public class ASM_File {

   protected String fileName;
   protected File file;
   protected HashMap<String, Integer> genRegs; // generic registers
   protected HashMap<String, Double> xmmRegs; // xmm registers
   protected HashMap<Integer, String> programFile; // holds lines
   private int lineCount = 0;
   public ASM_File(String fileName) {
      this.fileName = fileName;
      this.file = new File(fileName);
      this.genRegs = new HashMap<String, Integer>();
      this.xmmRegs = new HashMap<String, Double>();
      this.programFile = new HashMap<Integer, String>();
      try {
         Scanner s = new Scanner(this.file);
         while (s.hasNextLine()) {
            programFile.put(this.lineCount++, s.nextLine());
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
   
   void print() {
      System.out.println(genRegs);
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
   
   // mov reg, reg (or value)
   protected void mov(String reg1, Object toMove) {
      // reg, reg
      if (toMove instanceof String) {
         String reg2 = String.valueOf(toMove);
         if (!regExists(reg1)) {
            System.out.println("Creating new register " + reg1);
            if (reg1.contains("r")) {
               genRegs.put(reg1, 0);
            } else if (reg1.contains("xmm")) {
               xmmRegs.put(reg1, 0.0);
            }
         }
         if (!regExists(reg2)) {
            System.out.println("Second register does not exist!");
            throw new NullPointerException();
         }
         else {
            if (reg2.contains("r") && reg1.contains("r")) {
               genRegs.replace(reg1, genRegs.get(reg2));
            } else if (reg1.contains("xmm") && reg2.contains("xmm")) {
               xmmRegs.replace(reg1, xmmRegs.get(reg2));
            } else {
               System.out.println("Registers do not match!");
               throw new InputMismatchException();
            } 
         }
      }
      // reg, val
      else if (toMove instanceof Integer) {
         int tempMov = 0;
         try {
            tempMov = Integer.parseInt(String.valueOf(toMove));
         } catch (Exception e) {
            System.out.println("Couldn't parse move value!");
            throw e;
         }
         if (reg1.contains("r")) {
            if (regExists(reg1)) {
               genRegs.replace(reg1, tempMov);
            } else if (!regExists(reg1)) {
               genRegs.put(reg1, tempMov);
            }
         } else { System.out.println("Can't move integer into a non-integer register!"); throw new InputMismatchException(); }
      }
      else if (toMove instanceof Double) {
         double tempMov = 0;
         try {
            tempMov = Double.parseDouble(String.valueOf(toMove));
         } catch (Exception e) {
            System.out.println("Couldn't parse move value!");
            throw e;
         }
         if (reg1.contains("xmm")) {
            if (regExists(reg1)) {
               xmmRegs.replace(reg1, tempMov);
            } else if (!regExists(reg1)) {
               xmmRegs.put(reg1, tempMov);
            }
         } else { System.out.println("Can't move floating point into non-floating point register!"); throw new InputMismatchException(); }
      }
      else {
         System.out.println("Couldn't identify registers or values!");
         throw new NullPointerException();
      }
   } 
   
   // add reg, reg (or value)
   protected void add(String reg1, Object toAdd) {
      if (!(toAdd instanceof String)) {
         if (!regExists(reg1)) {
            System.out.println("Cannot add to nonexistent register!");
            throw new NullPointerException();
         }
         else if (regExists(reg1)) {
            if (toAdd instanceof Integer && reg1.contains("r")) {
               try {
                  genRegs.replace(reg1, genRegs.get(reg1) + Integer.parseInt(String.valueOf(toAdd)));
               } catch (Exception e) { System.out.println("Couldn't parse add value!"); throw e; }
            } else if (toAdd instanceof Double && reg1.contains("xmm")) {
               try {
                  xmmRegs.put(reg1, xmmRegs.get(reg1) + Double.parseDouble(String.valueOf(toAdd)));
               } catch (Exception e) { System.out.println("Couldn't parse add value!"); throw e; }
            }
         }
      }
      else if (toAdd instanceof String) {
         String reg2 = String.valueOf(toAdd);
         if (reg1.contains("r") && reg2.contains("r")) {
            if (regExists(reg1) && regExists(reg2)) {
               genRegs.replace(reg1, genRegs.get(reg1) + genRegs.get(reg2));
            } else {
               System.out.println("Cannot add nonexistent registers!");
               throw new NullPointerException();
            }
         } else if (reg1.contains("xmm") && reg2.contains("xmm")) {
            if (regExists(reg1) && regExists(reg2)) {
               xmmRegs.replace(reg1, xmmRegs.get(reg1) + xmmRegs.get(reg2));
            } else {
               System.out.println("Cannot add nonexistent registers!");
               throw new NullPointerException();
            }
         } else {
            System.out.println("Couldn't identify registers!");
            throw new InputMismatchException();
         }
      } else {
         System.out.println("Couldn't parse anything; this is probably a bug, please look at the add() function in ASM_File.java!");
         throw new NullPointerException();
      }
   }
   
   
   // sub reg, reg (or value)
   protected void sub(String reg1, Object toAdd) {
      if (!(toAdd instanceof String)) {
         if (!regExists(reg1)) {
            System.out.println("Cannot sub to nonexistent register!");
            throw new NullPointerException();
         }
         else if (regExists(reg1)) {
            if (toAdd instanceof Integer && reg1.contains("r")) {
               try {
                  genRegs.replace(reg1, genRegs.get(reg1) - Integer.parseInt(String.valueOf(toAdd)));
               } catch (Exception e) { System.out.println("Couldn't parse sub value!"); throw e; }
            } else if (toAdd instanceof Double && reg1.contains("xmm")) {
               try {
                  xmmRegs.put(reg1, xmmRegs.get(reg1) - Double.parseDouble(String.valueOf(toAdd)));
               } catch (Exception e) { System.out.println("Couldn't parse sub value!"); throw e; }
            }
         }
      }
      else if (toAdd instanceof String) {
         String reg2 = String.valueOf(toAdd);
         if (reg1.contains("r") && reg2.contains("r")) {
            if (regExists(reg1) && regExists(reg2)) {
               genRegs.replace(reg1, genRegs.get(reg1) - genRegs.get(reg2));
            } else {
               System.out.println("Cannot sub nonexistent registers!");
               throw new NullPointerException();
            }
         } else if (reg1.contains("xmm") && reg2.contains("xmm")) {
            if (regExists(reg1) && regExists(reg2)) {
               xmmRegs.replace(reg1, xmmRegs.get(reg1) - xmmRegs.get(reg2));
            } else {
               System.out.println("Cannot sub nonexistent registers!");
               throw new NullPointerException();
            }
         } else {
            System.out.println("Couldn't identify registers!");
            throw new InputMismatchException();
         }
      } else {
         System.out.println("Couldn't parse anything; this is probably a bug, please look at the sub() function in ASM_File.java!");
         throw new NullPointerException();
      }
   }
   
   // mul reg, reg (or value)
   protected void mul(String reg1, Object toAdd) {
      if (!(toAdd instanceof String)) {
         if (!regExists(reg1)) {
            System.out.println("Cannot mul to nonexistent register!");
            throw new NullPointerException();
         }
         else if (regExists(reg1)) {
            if (toAdd instanceof Integer && reg1.contains("r")) {
               try {
                  genRegs.replace(reg1, genRegs.get(reg1) * Integer.parseInt(String.valueOf(toAdd)));
               } catch (Exception e) { System.out.println("Couldn't parse mul value!"); throw e; }
            } else if (toAdd instanceof Double && reg1.contains("xmm")) {
               try {
                  xmmRegs.put(reg1, xmmRegs.get(reg1) * Double.parseDouble(String.valueOf(toAdd)));
               } catch (Exception e) { System.out.println("Couldn't parse mul value!"); throw e; }
            }
         }
      }
      else if (toAdd instanceof String) {
         String reg2 = String.valueOf(toAdd);
         if (reg1.contains("r") && reg2.contains("r")) {
            if (regExists(reg1) && regExists(reg2)) {
               genRegs.replace(reg1, genRegs.get(reg1) * genRegs.get(reg2));
            } else {
               System.out.println("Cannot mul nonexistent registers!");
               throw new NullPointerException();
            }
         } else if (reg1.contains("xmm") && reg2.contains("xmm")) {
            if (regExists(reg1) && regExists(reg2)) {
               xmmRegs.replace(reg1, xmmRegs.get(reg1) * xmmRegs.get(reg2));
            } else {
               System.out.println("Cannot mul nonexistent registers!");
               throw new NullPointerException();
            }
         } else {
            System.out.println("Couldn't identify registers!");
            throw new InputMismatchException();
         }
      } else {
         System.out.println("Couldn't parse anything; this is probably a bug, please look at the mul() function in ASM_File.java!");
         throw new NullPointerException();
      }
   }
   
   // div reg, reg (or value)
   protected void div(String reg1, Object toAdd) {
      if (!(toAdd instanceof String)) {
         if (!regExists(reg1)) {
            System.out.println("Cannot div to nonexistent register!");
            throw new NullPointerException();
         }
         else if (regExists(reg1)) {
            if (toAdd instanceof Integer && reg1.contains("r")) {
               try {
                  genRegs.replace(reg1, genRegs.get(reg1) / Integer.parseInt(String.valueOf(toAdd)));
               } catch (Exception e) { System.out.println("Couldn't parse div value!"); throw e; }
            } else if (toAdd instanceof Double && reg1.contains("xmm")) {
               try {
                  xmmRegs.put(reg1, xmmRegs.get(reg1) / Double.parseDouble(String.valueOf(toAdd)));
               } catch (Exception e) { System.out.println("Couldn't parse div value!"); throw e; }
            }
         }
      }
      else if (toAdd instanceof String) {
         String reg2 = String.valueOf(toAdd);
         if (reg1.contains("r") && reg2.contains("r")) {
            if (regExists(reg1) && regExists(reg2)) {
               genRegs.replace(reg1, genRegs.get(reg1) / genRegs.get(reg2));
            } else {
               System.out.println("Cannot div nonexistent registers!");
               throw new NullPointerException();
            }
         } else if (reg1.contains("xmm") && reg2.contains("xmm")) {
            if (regExists(reg1) && regExists(reg2)) {
               xmmRegs.replace(reg1, xmmRegs.get(reg1) / xmmRegs.get(reg2));
            } else {
               System.out.println("Cannot div nonexistent registers!");
               throw new NullPointerException();
            }
         } else {
            System.out.println("Couldn't identify registers!");
            throw new InputMismatchException();
         }
      } else {
         System.out.println("Couldn't parse anything; this is probably a bug, please look at the div() function in ASM_File.java!");
         throw new NullPointerException();
      }
   }
   
   // the "parser" for the program file
   protected void parse() {
      for (String s : programFile.values()) {
         if (s.length() == 0) {
            System.out.println("Empty string");
            throw new NullPointerException();
         }
         String[] line = s.replace(",", "").split(" ");
         String operator = line[0];
         String register = line[1];
         if (!Character.isLetter(line[2].charAt(0))) {
            if (line[2].contains(".")) {
               weirdParse(operator, register, Double.parseDouble(line[2]));
            } else if (!line[2].contains(".")) {
               weirdParse(operator, register, Integer.parseInt(line[2]));
            }
         } else {
            weirdParse(operator, register, line[2].trim());
         }
      }
   }
   
   private void weirdParse(String operator, String register, Object param) {
      if (operator.equals("mov")) {
         this.mov(register, param);
      } else if (operator.equals("add")) {
         this.add(register, param);
      } else if (operator.equals("sub")) {
         this.sub(register, param);
      } else if (operator.equals("div")) {
         this.div(register, param);
      } else if (operator.equals("mul")) {
         this.mul(register, param);
      } else {
         System.out.println("Unknown operand!");
         throw new NullPointerException();
      }
   }
}