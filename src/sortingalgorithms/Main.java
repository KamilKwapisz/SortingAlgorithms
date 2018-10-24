package sortingalgorithms;

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
        printVector(sorter.sort(vector));
        
//        TimeMeasures timer = new TimeMeasures(100, 1000000);
//        System.out.println("Insertion Sort: ");
//        timer.measureInsortTime();
//        System.out.println("Merge Sort: ");
//        timer.measureMergeSortTime();
    }
}
