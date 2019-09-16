/*

Driver code for linked list in Java
This isn't a true linked list as I can't really do any memory access, but I can print the JVM address of each object.

@author: me
@since: 9/16/2019

*/

public class Driver {

   public static void main(String[] args) {
      LinkedList l = new LinkedList();
      l.addItem("Hello");
      l.addItem("World!");
      l.addItem(57.5);
      l.addItem(-192);
      l.printValues();
   }

}