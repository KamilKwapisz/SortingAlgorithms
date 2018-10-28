package timemeasures;

import sortingalgorithms.InsertionSort;
import sortingalgorithms.MergeSort;
import sortingalgorithms.QuickSort;

public class Main {

    public static void main(String[] args) {
        Timer timer = new Timer(500, 10000);
        MergeSort mergeSorter = new MergeSort();
        timer.setSorter(mergeSorter);
        System.out.println("Merge Sort:");
        timer.measureSortingTime();

        QuickSort quickSorter = new QuickSort();
        timer.setSorter(quickSorter);
        System.out.println("Quick Sort:");
        timer.measureSortingTime();

        InsertionSort insertionSorter = new InsertionSort();
        timer.setSorter(insertionSorter);
        System.out.println("Insertion Sort:");
        timer.measureSortingTime();
    }
}
