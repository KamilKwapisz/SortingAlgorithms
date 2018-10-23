package sortingalgorithms;

public class InsertionSort implements SortingAlgorithm {

    public double[] sort(double[] unsortedVector) {
        if (unsortedVector == null) {
            throw new NullPointerException();
        }
        for (int i = 1; i < unsortedVector.length; i++) {
            double elementToInsert = unsortedVector[i];
            int j = i - 1;
            while (j >= 0 && unsortedVector[j] > elementToInsert) {
                unsortedVector[j + 1] = unsortedVector[j];
                j--;
            }
            unsortedVector[j + 1] = elementToInsert;
        }
        double[] sortedVector = unsortedVector;
        return sortedVector;
    }
}
