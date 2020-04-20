import java.io.FileWriter;
import java.io.IOException;

public class MyLinkedList
{
	Node head; 
	static class Node
	{
		int data;
		Node next;

		// Constructor
		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
	public static void addFront(MyLinkedList list, int data)
	{
	   Node addMe = new Node(data);
	   if (list.head == null)
      {
         list.head = addMe;
      } 
      else
      {
         addMe.next = list.head;
         list.head = addMe;
      }   
	}
	
	/*
    * adds a new node to the list
    * 
    * @param list the list that will be appended on to
    * @param data the value to be stored in the node
    */
	public static void add(MyLinkedList list, int data)
	{
		Node addMe = new Node(data);
		addMe.next = null;

		if (list.head == null)
		{
			list.head = addMe;
		} 
		else
		{
			Node last = list.head;
			while (last.next != null)
			{
				last = last.next;
			}
			// Insert the addMe at last node
			last.next = addMe;
		}
	}
	
	/*
    * empties a list
    * 
    * @param list the list to be emptied
    */
	public static void clear(MyLinkedList list)
	{
	   list.head = null;
	}

	/*
    * moves through the list
    * 
    * @param list the list that will be traversed
    * @param pos the position to move to
    * @return move the node that resides at the desired position
    */
	public static Node traverse(MyLinkedList list, int pos)
	{
		Node move = list.head;
		for(int i = 1; i<pos;i++)
		{
			move = move.next;			
		}
		return move;
	}
	
	/*
    * replaces a node's value
    * 
    * @param list the list that contains the node to be changed
    * @param pos the position of said node
    * @param num the value to replace with
    */
	public static void replace(MyLinkedList list, int pos, int num)
	{
		Node replace = list.head;
		for(int i = 1; i<pos;i++)
		{
			replace = replace.next;			
		}
		replace.data = num;
	}
	
	/*
    * copies a list to another list via the starting node
    * 
    * @param copy the starting node of the list to be copied
    * @param clone the list to copy to
    */
	public static void clone(Node copy, MyLinkedList clone)
   {
	   while(copy != null)
	   {
	      add(clone, copy.data);
	      copy = copy.next;
	   }
   }
	
	/*
    * copies a list to another list
    * 
    * @param list the list to be copied
    * @param clone the list to copy to
    */
	public static void clone(MyLinkedList list, MyLinkedList clone)
   {      
      Node copy = list.head;
      while(copy!=null)
      {
         add(clone, copy.data);
         copy = copy.next;
      }
   }

	/*
    * print and write the given list
    * 
    * @param list the list to be printed
    * @param fw FileWriter to write the output to
    */
	public static void printList(MyLinkedList list, FileWriter fw) throws IOException
	{
		Node currNode = list.head;
		System.out.print("LinkedList: ");

		while (currNode != null)
		{
			System.out.print(currNode.data + " ");
			fw.write(currNode.data + " ");
			currNode = currNode.next;
		}
		System.out.println();
	}
	
	/*
    * get the size of the list
    * 
    * @param list the list to measure
    * @return size the size of the input list
    */
	public static int getSize(MyLinkedList list)
	{
		Node currNode = list.head;
		int size = 0;

		while (currNode != null)
		{
			size++;
			currNode = currNode.next;
		}
		return size;
	}
}
