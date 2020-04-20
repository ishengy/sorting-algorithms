import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NaturalMerge {
   public static void main(String[] args) throws IOException {

      if (1 < args.length) {
         // get input and output paths
         String in = args[0];
         String out = args[1];

         Scanner input = new Scanner(new File(in));
         FileWriter fw = new FileWriter(new File(out));

         try {
            QueueList list = new QueueList();
            int size = 0;

            while (input.hasNextLine()) {
               int n = input.nextInt();
               list.push(n);
               size++;
            }
            input.close();

            fw.write("Original list: ");
            printQueue(list, fw);
            natMerge(list, size, fw);
            fw.close();
            
         } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
         }

      } else {
         System.out.println("Error: No input and/or output file");
      }

   }

   /*
    * print and write the given queue
    * 
    * @param q the queue to be printed
    * 
    * @param fw FileWriter to write the output to
    */
   public static void printQueue(QueueList q, FileWriter fw) throws IOException {
      QueueList temp = new QueueList();
      while (!q.isEmpty()) {
         int hold = q.pop();
         System.out.print(hold + " ");
         fw.write(hold + " ");
         temp.push(hold);
      }
      fw.write("\r\n \r\n");
      System.out.println();
      System.out.println();

      while (!temp.isEmpty()) {
         q.push(temp.pop());
      }
   }

   /*
    * performs the natural merge sort
    * 
    * @param list the list to sort
    * 
    * @param size the size of the list
    * 
    * @param fw FileWriter to write the output to
    */
   public static void natMerge(QueueList list, int size, FileWriter fw) throws IOException {
      QueueList temp1 = new QueueList();
      QueueList temp2 = new QueueList();

      int count = 0;
      int currVal = 0;
      int nextVal = 0;
      int loopi = 0;

      long startTime = System.nanoTime();
      while (loopi != size) {
         currVal = list.pop();

         if (list.peek() != -1) {
            nextVal = list.peek();
         }

         if (count == 0) {
            temp1.push(currVal);
         } else {
            temp2.push(currVal);
         }

         if (currVal > nextVal)
            count++;

         if (count > 1 || list.peek() == -1) {
            loopi = sortPartitions(temp1, temp2, list);
            count = 0;
         }
         currVal = nextVal;
      }

      long stopTime = System.nanoTime();
      long elapsedTime = stopTime - startTime;

      fw.write("Sorted List: ");
      printQueue(list, fw);
      fw.write("Execution Time: " + elapsedTime + " nanoseconds \r\n");
      System.out.println("Execution Time: " + elapsedTime + " nanoseconds");
   }

   /*
    * sorts the two partitions provided as parameters
    * 
    * @param first the first partition as a queue
    * 
    * @param second the second partition as a queue
    * 
    * @param sorted the queue that will store the sorted list
    * 
    */
   public static int sortPartitions(QueueList first, QueueList second, QueueList sorted) {
      int curr1Val = -1;
      int curr2Val = -1;
      int counter = 0;

      if (!first.isEmpty())
         curr1Val = first.pop();

      if (!second.isEmpty())
         curr2Val = second.pop();

      while (curr1Val != -1 || curr2Val != -1) {
         boolean curr1Pop = false;
         boolean curr2Pop = false;

         if (curr1Val == -1) {
            sorted.push(curr2Val);
            curr2Pop = true;
            curr1Pop = false;
         } else if (curr2Val == -1) {
            sorted.push(curr1Val);
            curr2Pop = false;
            curr1Pop = true;
         } else if (curr1Val < curr2Val) {
            sorted.push(curr1Val);
            curr1Pop = true;
         } else if (curr1Val >= curr2Val) {
            sorted.push(curr2Val);
            curr2Pop = true;
         }

         if (curr1Pop) {
            curr1Val = first.pop();
         }

         if (curr2Pop) {
            curr2Val = second.pop();
         }
         counter++;
      }
      return counter;
   }
}
