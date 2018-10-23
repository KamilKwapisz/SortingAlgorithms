package sortingalgorithms;

public class MergeSort implements SortingAlgorithm {

    void merge(double vector[], int leftIndex, int middleIndex, int RightIndex) {
        int firstVectorSize = middleIndex - leftIndex + 1;
        int secondVectorSize = RightIndex - middleIndex;
        double leftVector[] = new double[firstVectorSize];
        double rightVector[] = new double[secondVectorSize];

        for (int i = 0; i < firstVectorSize; i++) {
            leftVector[i] = vector[leftIndex + i];
        }
        for (int j = 0; j < secondVectorSize; j++) {
            rightVector[j] = vector[middleIndex + 1 + j];
        }

        int firstVectorIndex = 0, secondVectorIndex = 0, mergedVectorIndex = leftIndex;
        while (firstVectorIndex < firstVectorSize && secondVectorIndex < secondVectorSize) {
            if (leftVector[firstVectorIndex] <= rightVector[secondVectorIndex]) {
                vector[mergedVectorIndex] = leftVector[firstVectorIndex];
                firstVectorIndex++;
            } else {
                vector[mergedVectorIndex] = rightVector[secondVectorIndex];
                secondVectorIndex++;
            }
            mergedVectorIndex++;
        }
        while (firstVectorIndex < firstVectorSize) {
            vector[mergedVectorIndex] = leftVector[firstVectorIndex];
            firstVectorIndex++;
            mergedVectorIndex++;
        }
        while (secondVectorIndex < secondVectorSize) {
            vector[mergedVectorIndex] = rightVector[secondVectorIndex];
            secondVectorIndex++;
            mergedVectorIndex++;
        }
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
