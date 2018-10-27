package timemeasures;

import java.util.Random;
import sortingalgorithms.SortingAlgorithm;

public class Timer<T extends SortingAlgorithm> {

    T sorter;
    int maxVectorSize;
    int iterationsNumber;

    public Timer(int maxVectorLength, int iterationsNumber) {
        this.maxVectorSize = maxVectorLength;
        this.iterationsNumber = iterationsNumber;
    }

    public void setSorter(T sorter) {
        this.sorter = sorter;
    }
    
    public void measureSortingTime() {
        for (int vectorSize = 2; vectorSize <= maxVectorSize; vectorSize++) {
            measureOperationsTime(vectorSize);
        }
    }

    private void measureOperationsTime(int vectorSize) {
        long time = 0, timerStart, timerStop;
        int i;
        for (i = 0; i < iterationsNumber; i++) {
            double[] vector = createRandomDataVector(vectorSize);
            timerStart = System.nanoTime();
            sorter.sort(vector);
            timerStop = System.nanoTime();
            time += timerStop - timerStart;
        }
        System.out.print(time / iterationsNumber + ", ");
        time = 0;
        for (i = 0; i < iterationsNumber; i++) {
            double[] vector = createAscSortedVector(vectorSize);
            timerStart = System.nanoTime();
            sorter.sort(vector);
            timerStop = System.nanoTime();
            time += timerStop - timerStart;
        }
        System.out.print(time / iterationsNumber + ", ");
        time = 0;
        for (i = 0; i < iterationsNumber; i++) {
            double[] vector = createDescSortedVector(vectorSize);
            timerStart = System.nanoTime();
            sorter.sort(vector);
            timerStop = System.nanoTime();
            time += timerStop - timerStart;
        }
        System.out.println(time / iterationsNumber);
    }

    private double[] createRandomDataVector(int elementsNumber) {
        double[] vector = new double[elementsNumber];
        Random generator = new Random(291084);
        for (int i = 0; i < elementsNumber; i++) {
            vector[i] = generator.nextDouble();
        }
        return vector;
    }

    private double[] createAscSortedVector(int elementsNumber) {
        double[] vector = new double[elementsNumber];
        for (int i = 0; i < elementsNumber; i++) {
            vector[i] = i;
        }
        return vector;
    }

    private double[] createDescSortedVector(int elementsNumber) {
        double[] vector = new double[elementsNumber];
        for (int i = elementsNumber - 1; i >= 0; i--) {
            vector[i] = elementsNumber - i;
        }
        return vector;
    }
}
