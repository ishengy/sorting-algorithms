# sorting-algorithms
Self-Implemented Sorting Algorithms

The source code in this assignment can be compiled with JDK 8 from the command line. It was developed using Eclipse.


    1. Move all java files and input files under one directory

    2a. To compile the drivers, enter: javac QuickInsertionSort50.java
    2b. To compile the drivers, enter: javac QuickInsertionSort100.java
    2c. To compile the drivers, enter: javac QuickSort3MPivot.java
    2d. To compile the drivers, enter: javac QuickSortFirstPivot.java
    2e. To compile the drivers, enter: javac NaturalMerge.java

    3a. To run the program, enter: java QuickInsertionSort50 [input file] [output file]
    3b. To run the program, enter: java QuickInsertionSort100 [input file] [output file]
    3c. To run the program, enter: java QuickSort3MPivot [input file] [output file]
    3d. To run the program, enter: java QuickSortFirstPivot [input file] [output file]
    3e. To run the program, enter: java NaturalMerge [input file] [output file]

There are five classes used to sort with natural merge sort, and the four quicksort variations.
- The NaturalMerge class is the driver that executes the code for the natural merge sort. It is implemented with linked lists and utilizes the QueueList class to store the input data and it will help to store the partitions.
- The QuickSortFirstPivot is the class driver that executes the code for the quicksort with first item pivot. It is implemented with arrays to store the input data. It also utilizes the StackList class to store the start and end points of the partitions for backtracking purposes.
- The QuickSort3Mpivot class is the driver that executes the code for quicksort with the median of three as the pivot. It utilizes the same structures as the QuickSortFirstPivot.
- The QuickInsertionSort50 class is the driver that executes the code for the hybrid quicksort/insertion sort for a stopping case of a partition size of 50. It utilizes the same structures as the QuickSortFirstPivot.
- The QuickInsertionSort100 class is the driver that executes the code for the hybrid quicksort/insertion sort for a stopping case of a partition size of 100. It utilizes the same structures as the QuickSortFirstPivot.

A writeup analyzing each sorting algorithm's runtime for varying sizes of input and initial orders is made available, along with an Excel sheet documenting all 100 runtimes.
