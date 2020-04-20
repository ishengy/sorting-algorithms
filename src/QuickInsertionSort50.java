import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuickInsertionSort50 {

   public static void main(String args[]) throws IOException {
      if (1 < args.length) {
         // get input and output paths
         String in = args[0];
         String out = args[1];

         // String str = "asc10k";
         // String in = str + ".dat";
         // String out = str + "out.txt";

         Scanner input = new Scanner(new File(in));
         FileWriter fw = new FileWriter(new File(out));

         try {
            int size = countInt(in);
            int i = 0;
            int[] asc = new int[size];

            while (input.hasNextLine()) {
               int n = input.nextInt();
               asc[i] = n;
               i++;
            }
            input.close();

            fw.write("Original List: ");
            System.out.print("Original List: ");
            printArray(asc, fw);
            System.out.println();

            quickSort(asc, fw);

            fw.close();
         } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
         }

      } else {
         System.out.println("Error: No input and/or output file");
      }
   }

   /*
    * returns the number of lines/values the input file has
    * 
    * @param in the file name of the input
    *  
    * @return i number of lines/values
    */
   public static int countInt(String in) throws FileNotFoundException {
      int i = 0;
      Scanner input = new Scanner(new File(in));

      while (input.hasNextLine()) {
         input.nextLine();
         i++;
      }

      input.close();
      return i;
   }

   /*
    * performs insertion sort on given array
    * 
    * @param arr[] the array holding the values from the input file
    */
   public static void insertionSort(int[] arr) {
      for (int i = 1; i < arr.length; i++) {
         int prev = i - 1;
         int placeholder = i;
         while (prev > -1 && arr[placeholder] < arr[prev]) {
            swap(arr, placeholder, prev);
            placeholder--;
            prev--;
         }
      }
   }

   /*
    * print and write the given array
    * 
    * @param arr array to be printed
    * 
    * @param fw FileWriter to write the output to
    */
   public static void printArray(int[] arr, FileWriter fw) throws IOException {
      for (int x = 0; x <= arr.length - 1; x++) {
         System.out.print(arr[x] + " ");
         fw.write(arr[x] + " ");
      }
      fw.write("\r\n \r\n");
      System.out.println();
   }

   /*
    * performs quicksort on the given array and writes it out to a file
    * 
    * @param arr array to be printed
    * 
    * @param fw FileWriter to write the output to
    */
   public static void quickSort(int[] arr, FileWriter fw) throws IOException {
      StackList stack = new StackList();
      stack.push(0);
      stack.push(arr.length);

      long startTime = System.nanoTime();
      while (!stack.isEmpty()) {
         int end = stack.pop();
         int start = stack.pop();

         // stopping case
         if (end - start > 50) {
            // select method of pivot
            int piv = start;

            int part = partition(arr, piv, start, end);

            stack.push(part + 1);
            stack.push(end);

            stack.push(start);
            stack.push(part);
         } else {
            insertionSort(arr);
            break;
         }
      }
      long stopTime = System.nanoTime();
      long elapsedTime = stopTime - startTime;

      System.out.print("Sorted list: ");
      fw.write("Sorted List: ");
      printArray(arr, fw);
      System.out.println();

      fw.write("Execution Time: " + elapsedTime + " nanoseconds \r\n");
      System.out.println("Execution Time: " + elapsedTime + " nanoseconds");
   }

   /*
    * partition the array based on the pivot
    * 
    * @param arr the input array to be partitioned
    * 
    * @param pos the index of the pivot
    * 
    * @param start the index of the start of the partition
    * 
    * @param end the index of the end of the partition
    * 
    * @return i the index of the new end
    */
   public static int partition(int[] arr, int pos, int start, int end) {
      int pStart = start;
      int pEnd = end - 1;
      int pivot = arr[pos];
      swap(arr, pos, end - 1);

      while (pStart < pEnd) {
         if (arr[pStart] < pivot) {
            pStart++;
         } else if (arr[pEnd] >= pivot) {
            pEnd--;
         } else {
            swap(arr, pStart, pEnd);
         }
      }
      int i = pEnd;
      if (arr[pEnd] < pivot) {
         i++;
      }
      swap(arr, end - 1, i);
      // printArray(input);
      return i;
   }

   /**
    * method to swap values of two indices
    *
    * @param arr the input array
    * @param i   the index of the first value to be swapped
    * @param j   the index of the second value to be swapped
    */
   public static void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

}