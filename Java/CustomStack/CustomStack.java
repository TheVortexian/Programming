import java.util.ArrayList;
public class CustomStack<T> {
   
   // the driving force of this "stack".
   private ArrayList<T> list = new ArrayList<T>();
   
   CustomStack() { } // empty constructor since there isn't really a need for one...
   
   public void push(T obj) {
      this.list.add(0, obj); //thank god for List interface
   }
   public void pop() {
      this.list.remove(this.list.size() - 1); //pops the most recently added element
   }
   //peeks at the newest added element to the stack
   public T peek() {
      return this.list.get(this.list.size() - 1);
   }
   
   //Prints all the elements in the stack
   public void listElements() {
      System.out.println("\nPopping top element...\n");
      for (int i = 0; i < this.list.size(); i++) {
         System.out.println("[" + i + "] -> " + String.valueOf(this.list.get(i)));
      }
   }
}