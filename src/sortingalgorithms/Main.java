package sortingalgorithms;

import timemeasures.TimeMeasures;

public class Main {
    
    public static void printVector(double [] vector){
        System.out.print("[");
        for (double element : vector){
            System.out.print(element + ", ");
        } 
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        double [] vector = {32.2, 42.1, 7.2, 0.3, 15.7};
//        InsertionSort sorter = new InsertionSort();
        MergeSort sorter = new MergeSort();
//        QuickSort sorter = new QuickSort();
        printVector(sorter.sort(vector));
        
        TimeMeasures timer = new TimeMeasures(180, 100000);
//        System.out.println("Insertion Sort: \n");
//        timer.measureInsortTime();
//        System.out.println("Quick Sort: \n");
//        timer.measureQuickSortTime();
        System.out.println("Merge Sort: \n");
        timer.measureMergeSortTime();
    }
}
