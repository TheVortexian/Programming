/**
*
* This file makes the GUI, among other things
* Hopefully it doesn't get cluttered :)
*
* @Date: 8/24/2019
* @Author: Owner of this repo
*/
import javax.swing.*;
import java.awt.*;

public class WindowMaker {
   /*
      param "windowTitle" -> title (String) of the JFrame window
      param "WIDTH" -> (for now) a constant integer defining the width of JFrame window
      param "HEIGHT" -> (for now) a constant integer defining the height of JFrame window
      param "window" -> the actual JFrame. For now, I won't be modifying this class to extend a JFrame and instead it will have a private object inside.
   */
   private String windowTitle;
   private final int WIDTH = 750;
   private final int HEIGHT = 400;
   private JFrame window;
   
   // Constructor for my class
   public WindowMaker(String s) {
      this.windowTitle = s; // declare window title
      // here, actually create our JFrame and make it visible
      window = new JFrame(this.windowTitle);
      window.setSize(this.WIDTH, this.HEIGHT);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setVisible(true);
   }
   
   public void addComponent(JComponent component) {
      
   }

}