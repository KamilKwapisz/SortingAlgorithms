package sortingalgorithms;

import java.util.Stack;

public class QuickSort {

    private void swap(double[] vector, int firstIndex, int secondIndex) {
        double tmpVectorElement = vector[firstIndex];
        vector[firstIndex] = vector[secondIndex];
        vector[secondIndex] = tmpVectorElement;
    }

    private int partition(double[] vector, int startIndex, int endIndex) {
        double x = vector[startIndex];
        int i = startIndex + 1;
        int j = endIndex;
        while (i < j) {
            while (i < j && vector[i] <= x) {
                i++;
            }
            while (i < j && vector[i] > x) {
                j++;
            }
            if (i < j) {
                swap(vector, i, j);
            }
        }
        if (vector[i] > x) {
            i--;
        }
        swap(vector, startIndex, i);
        return i;
    }

    private void qsort(double[] vector) {
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
        qsort(vector);
        return vector;
    }
    
}
