/***************************************************************************************
 * Name: Ivan Sheng 
 * Lab #4
 * Description: The StackList class that holds the stack
 * implementation using a linked list. Each stack has pointers, nodes containing
 * the item, and a size of stack. The class contains the methods: getSize(),
 * push(), pop(), peek(), isEmpty(), search()
 ***************************************************************************************/

public class StackList {

   Node curr;
   int size = 0;

   static class Node {
      int data;
      Node next;

      /**
       * The node constructor that contains the item that we want to push into the
       * stack.
       * 
       * @param data the int who should be pushed into the stack
       */
      Node(int data) {
         this.data = data;
      }
   }

   /**
    * pushes a new int into the stack
    *
    * @param data This parameter is the int that will be pushed into the stack
    */
   public void push(int data) {
      Node insertMe = new Node(data);
      if (curr == null) {
         curr = insertMe;
      } else {
         Node temp = curr;
         curr = insertMe;
         insertMe.next = temp;
      }
      size++;

   }

   /**
    * pops and returns the top of the stack
    *
    * @return the int who was popped
    */
   public int pop() {
      int popTop;
      if (curr == null) {
         System.out.println("Empty Stack");
         return -1;
      } else {
         popTop = curr.data;
         curr = curr.next;
         size--;
         return popTop;
      }
   }

   /**
    * returns the value of the int on top without popping
    *
    * @return the int on the top of the stack
    */
   public int peek() {
      if (curr == null) {
         System.out.println("Empty Stack");
         return -1;
      } else {
         return curr.data;
      }
   }

   /**
    * returns whether or not the stack is empty
    *
    * @return true if the stack is empty, otherwise false
    */
   public boolean isEmpty() {
      if (curr == null)
         return true;
      else
         return false;
   }
}
