package sortingalgorithms;

public class Main {
    
    public void printArray(){
        
    }
    
    public static void main(String[] args) {
        double [] vector = {32.2, 42.1, 7.2, 0.3, 15.7};
        InsertionSort sorter = new InsertionSort();
        for (double x : sorter.sort(vector)){
            System.out.print(x + ", ");
        }
    }
}
