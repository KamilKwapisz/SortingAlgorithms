package sortingalgorithms;

public class MergeSort implements SortingAlgorithm {

    public double[] sort(double[] vector) {
        int vectorLength = vector.length;
        double[] temporaryVector = new double[vectorLength];
        int leftIndex, rightIndex, rightEndIndex, tempVectorIndex;
        int i, j, k;

        for (i = 1; i < vectorLength; i *= 2) {
            for (leftIndex = 0; leftIndex + i < vectorLength; leftIndex += i * 2) {
                rightIndex = leftIndex + i;
                rightEndIndex = rightIndex + i;
                if (rightEndIndex > vectorLength) {
                    rightEndIndex = vectorLength;
                }
                tempVectorIndex = leftIndex;
                k = leftIndex;
                j = rightIndex;
                while (k < rightIndex && j < rightEndIndex) {
                    if (vector[k] <= vector[j]) {
                        temporaryVector[tempVectorIndex] = vector[k];
                        k++;
                    } else {
                        temporaryVector[tempVectorIndex] = vector[j];
                        j++;
                    }
                    tempVectorIndex++;
                }
                while (k < rightIndex) {
                    temporaryVector[tempVectorIndex] = vector[k];
                    k++;
                    tempVectorIndex++;
                }
                while (j < rightEndIndex) {
                    temporaryVector[tempVectorIndex] = vector[j];
                    j++;
                    tempVectorIndex++;
                }
                for (tempVectorIndex = leftIndex; tempVectorIndex < rightEndIndex; tempVectorIndex++) {
                    vector[tempVectorIndex] = temporaryVector[tempVectorIndex];
                }
            }
        }
        return vector;
    }
}
