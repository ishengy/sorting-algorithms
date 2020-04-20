
public class QueueList { 
    Node front;
    Node rear; 
    
    static class Node { 
        int data; 
        Node next; 
      
        /**
         * The node constructor that contains the item that we want to push into the
         * queue.
         * 
         * @param data the string that should be pushed into the queue
         */
        Node(int data) 
        { 
            this.data = data; 
            this.next = null; 
        } 
    } 
  
    /**
     * The queue constructor that sets both the front and rear pointers to null
     * 
     */
    QueueList() 
    { 
        this.front = null;
        this.rear = null; 
    }
    

    
    /**
	* returns whether or not the queue is empty
	*
	* @return true if the queue is empty, otherwise false
	*/
	public boolean isEmpty()
	{
		if(front == null)
			return true;
		else
			return false;
	}
  
	/**
    * pushes a new string into the queue
    *
    * @param data This parameter is the string that will be pushed into the queue
    */ 
    public void push(int data) 
    { 
  
        // Create a new LL node 
        Node temp = new Node(data); 
  
        // If QueueList is empty, then new node is front and rear both 
        if (this.rear == null) { 
            this.front = temp;
            this.rear = temp; 
            return; 
        } 
  
        // Add the new node at the end of QueueList and change rear 
        this.rear.next = temp; 
        this.rear = temp; 
    } 
  
    /**
     * pops and returns the front of the queue
     *
     * @return the string that was popped
     */ 
    public int pop() 
    { 
        // If QueueList is empty, return NULL. 
        if (this.front == null) 
            return -1; 
  
        // Store previous front and move front one node ahead 
        Node temp = this.front; 
        this.front = this.front.next; 
  
        // If front becomes NULL, then change rear also as NULL 
        if (this.front == null) 
            this.rear = null; 
        return temp.data; 
    } 
    
    /**
     * returns the value of the strong at the front without popping
     *
     * @return the string at the front of the queue
     */
    public int peek() 
    { 
        // If QueueList is empty, return NULL. 
        if (this.front == null) 
            return -1;
  
        // Store previous front and move front one node ahead 
        Node temp = this.front; 
  
        return temp.data; 
    }
} 
   
    
