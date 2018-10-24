package sortingalgorithms;

public class MergeSort implements SortingAlgorithm {

    void merge(double vector[], int leftIndex, int middleIndex, int rightIndex) {
        double[] mergedVector = new double[rightIndex - leftIndex + 1];
        int i = leftIndex;
        int j = middleIndex;
        int l = 0;

        while (i < middleIndex && j <= rightIndex) {
            if (vector[i] <= vector[j]) {
                mergedVector[l++] = vector[i++];
            } else {
                mergedVector[l++] = vector[j++];
            }
        }
        while (i < middleIndex) {
            mergedVector[l++] = vector[i++];
        }
        while (j < rightIndex) {
            mergedVector[l++] = vector[j++];
        }
        vector = mergedVector;

    }

    private void sortVector(double vector[], int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleElementIndex = (leftIndex + rightIndex) / 2;
            sortVector(vector, leftIndex, middleElementIndex);
            sortVector(vector, middleElementIndex + 1, rightIndex);
            merge(vector, leftIndex, middleElementIndex, rightIndex);
        }
    }

    public double[] sort(double unsortedVector[]) {
        if (unsortedVector == null) {
            throw new NullPointerException();
        }
        sortVector(unsortedVector, 0, unsortedVector.length - 1);
        double[] sortedVector = unsortedVector;
        return sortedVector;
    }
}
