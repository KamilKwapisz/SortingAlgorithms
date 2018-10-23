package sortingalgorithms;

public class InsertionSort {
    public double[] sort(double[] vector){
        for (int i = 1; i < vector.length; i++){
            double elementToInsert = vector[i];
            int j = i - 1;
            while (j >= 0 && vector[j] > elementToInsert){
                vector[j+1] = vector[j];
                j--;
            }
            vector[j+1] = elementToInsert;
        }
        return vector;
    }
}
