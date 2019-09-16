/*

The LinkedList class, just holds an ArrayList of Nodes

*/
import java.util.ArrayList;
public class LinkedList {

   private ArrayList<Node> nodes;
   
   public LinkedList() {
      this.nodes = new ArrayList<Node>();
   }
   
   public void addItem(Object var) {
      nodes.add(new Node(var));
   }
   public void removeItem(int index) {
      nodes.remove(index);
   }
   
   public void listAddresses() {
      for (Node n : nodes) {
         n.printAddress();
      }
   }
   
   public void getNext(int index) {
      if (index == nodes.size()-1) { nodes.get(0).printAddress(); }
      else { nodes.get(index+1).printAddress(); }
   }
   public void getPrevious(int index) {
      if (index == 0) { System.out.println("NULL"); }
      else { nodes.get(index+1).printAddress(); }
   }
   public void printValues() {
      for (Node n : nodes) {
         System.out.println(String.valueOf(n.getValue()));
      }
   }
}