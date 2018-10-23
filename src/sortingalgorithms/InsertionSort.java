package sortingalgorithms;

public class InsertionSort {
    public double[] sort(double[] vector){
        for (int i = 1; i < vector.length; i++){
            double tmp = vector[i];
            int j = i - 1;
            while (j >= 0 && vector[j] > tmp){
                vector[j+1] = vector[j];
                j--;
            }
            vector[j+1] = tmp;
        }
        return vector;
    }
}
