/*

Node object included in the Linked List
Each node can hold any valid Java data type
*/

public class Node {
   
   private Object value;
   public Node (Object var) {
      this.value = var;
   }
   
   public Object getValue() {
      return this.value;
   }
   
   public void printAddress() {
      System.out.println(this);
   }

}