package sortingalgorithms;

import java.util.Stack;

public class QuickSort implements SortingAlgorithm{

    private void swap(double[] vector, int firstIndex, int secondIndex) {
        double tmpVectorElement = vector[firstIndex];
        vector[firstIndex] = vector[secondIndex];
        vector[secondIndex] = tmpVectorElement;
    }

    private int partition(double[] vector, int startIndex, int endIndex) {
        double vectorElement = vector[startIndex];
        int i = startIndex + 1;
        int j = endIndex;
        while (i < j) {
            while (i < j && vector[i] <= vectorElement) {
                i++;
            }
            while (i < j && vector[j] > vectorElement) {
                j--;
            }
            if (i < j) {
                swap(vector, i, j);
            }
        }
        if (vector[i] > vectorElement) {
            i--;
        }
        swap(vector, startIndex, i);
        return i;
    }

    private void quickSort(double[] vector) {
        int vectorLength = vector.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(vectorLength - 1);
        while (!stack.empty()) {
            int endIndex = stack.pop();
            int beginIndex = stack.pop();
            int middleIndex = partition(vector, beginIndex, endIndex);
            if (middleIndex - 1 > beginIndex) {
                stack.push(beginIndex);
                stack.push(middleIndex - 1);
            }
            if (middleIndex + 1 < endIndex) {
                stack.push(middleIndex + 1);
                stack.push(endIndex);
            }
        }
    }
    
    public double[] sort(double[] vector){
        if (vector == null){
            throw new NullPointerException();
        }
        quickSort(vector);
        return vector;
    }
    
}
