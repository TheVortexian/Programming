import WindowHandler.*; // package

public class Driver
{
   public static void main(String[] args) throws InterruptedException {
      Window w = new Window("App Window", 1200, 850);
      w.initWindow();
      while(true) {
         w.setBackgroundRGBA((float)Math.random(), (float)Math.random(), (float)Math.random(), (float)Math.random());
         Thread.sleep(500);
      }
   }
}