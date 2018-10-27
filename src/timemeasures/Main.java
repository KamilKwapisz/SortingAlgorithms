package timemeasures;

import sortingalgorithms.InsertionSort;
import sortingalgorithms.MergeSort;
import sortingalgorithms.QuickSort;

public class Main {
    
    public static void printVector(double [] vector){
        System.out.print("[");
        for (double element : vector){
            System.out.print(element + ", ");
        } 
        System.out.println("]");
    }
    
    public static void main(String[] args) {
//        double [] vector = {32.2, 42.1, 7.2, 0.3, 15.7};
////        InsertionSort sorter = new InsertionSort();
        MergeSort sorter = new MergeSort();
//        QuickSort sorter = new QuickSort();
//        InsertionSort sorter = new InsertionSort();
//        printVector(sorter.sort(vector));
        Timer timer = new Timer(250, 10000);
        timer.setSorter(sorter);
        System.out.println("Merge Sort: \n");
        timer.measureSortingTime();
//      
//        TimeMeasures timer = new TimeMeasures(500, 1000);
//        System.out.println("Insertion Sort: \n");
//        timer.measureInsortTime();
//        System.out.println("Quick Sort: \n");
//        timer.measureQuickSortTime();
//        System.out.println("Merge Sort: \n");
//        timer.measureMergeSortTime();
    }
}
