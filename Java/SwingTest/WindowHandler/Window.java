package WindowHandler;

import java.awt.*; // swing and awt imports
import javax.swing.*;

// top level class
public class Window {
   
   private JFrame winframe; // window fields
   private String winTitle;
   private int width;
   private int height;
   
   // first full constructor
   public Window(String title, int width, int height) {
      this.winTitle = title;
      this.width = width;
      this.height = height;
   }
   
   // default constructor
   public Window() {
      this.winTitle = "Application Window";
      this.width = 100;
      this.height = 100;
   }  
   
   /*
   Try to create window
   */
   public boolean initWindow() {
      try {
      // make window and display it
         this.winframe = new JFrame(winTitle);
         this.winframe.setSize(width, height);
         this.winframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.winframe.setLocationRelativeTo(null);
         this.winframe.setVisible(true);
         return true;
      } catch (Exception e) {
      // otherwise something is wrong
         System.out.println("Error creating and displaying window!\n" + e);
         return false;
      }
   }
   
   /*
   Change background window color (two)
   */
   public void setBackgroundRGBA(float r, float g, float b, float a) {
      this.winframe.getContentPane().setBackground(new Color(r, g, b, a));
      // set bkg of jframe using the built in functions
   }
   public void setBackgroundConst(Color c) {
      this.winframe.getContentPane().setBackground(c);
      // use built in color from Color class
   }
   
}