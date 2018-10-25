package sortingalgorithms;

import java.util.Random;

public class TimeMeasures {

    int maxVectorLength;
    int iterationsNumber;

    public TimeMeasures(int maxVectorLength, int iterationsNumber) {
        this.maxVectorLength = maxVectorLength;
        this.iterationsNumber = iterationsNumber;
    }

    public void measureInsortTime() {
        for (int i = 2; i <= maxVectorLength; i++) {
            long time = getAverageInsortTime(i);
//            System.out.println(time);
        }
    }

    private long getAverageInsortTime(int elementsNumber) {
        InsertionSort sorter = new InsertionSort();
        long time = 0;
        for (int i = 0; i < iterationsNumber; i++) {
            double[] vector = createRandomDataVector(elementsNumber);
            long timerStart = System.nanoTime();
            sorter.sort(vector);
            long timerStop = System.nanoTime();
            time += timerStop - timerStart;
        }
        System.out.print(time/iterationsNumber + ", ");
        for (int i = 0; i < iterationsNumber; i++) {
            double[] vector = createOptimisticDataVector(elementsNumber);
            long timerStart = System.nanoTime();
            sorter.sort(vector);
            long timerStop = System.nanoTime();
            time += timerStop - timerStart;
        }
        System.out.print(time/iterationsNumber + ", ");
        for (int i = 0; i < iterationsNumber; i++) {
            double[] vector = createPesimistcDataVector(elementsNumber);
            long timerStart = System.nanoTime();
            sorter.sort(vector);
            long timerStop = System.nanoTime();
            time += timerStop - timerStart;
        }
        System.out.println(time/iterationsNumber);
        time /= iterationsNumber;
        return time;
    }

    private double[] createRandomDataVector(int elementsNumber) {
        double[] vector = new double[elementsNumber];
        Random generator = new Random();
        for (int i = 0; i < elementsNumber; i++) {
            vector[i] = generator.nextDouble();
        }
        return vector;
    }
    
    private double[] createOptimisticDataVector(int elementsNumber) {
        double[] vector = new double[elementsNumber];
        for (int i = 0; i < elementsNumber; i++) {
            vector[i] = i;
        }
        return vector;
    }
    
    private double[] createPesimistcDataVector(int elementsNumber) {
        double[] vector = new double[elementsNumber];
        for (int i = elementsNumber - 1; i >= 0; i--) {
            vector[i] = elementsNumber - i;
        }
        return vector;
    }

    public void measureMergeSortTime() {
        for (int i = 2; i <= maxVectorLength; i++) {
//            double[] vector = createRandomDataVector(i);
            long time = getAverageMergeSortTime(i);
//            System.out.println(time);
        }
    }

    private long getAverageMergeSortTime(int elementsNumber) {
        MergeSort sorter = new MergeSort();
        long time = 0;
        for (int i = 0; i < iterationsNumber; i++) {
            double[] vector = createRandomDataVector(elementsNumber);
            long timerStart = System.nanoTime();
            sorter.sort(vector);
            long timerStop = System.nanoTime();
            time += timerStop - timerStart;
        }
        System.out.print(time/iterationsNumber + ", ");
        for (int i = 0; i < iterationsNumber; i++) {
            double[] vector = createOptimisticDataVector(elementsNumber);
            long timerStart = System.nanoTime();
            sorter.sort(vector);
            long timerStop = System.nanoTime();
            time += timerStop - timerStart;
        }
        System.out.print(time/iterationsNumber + ", ");
        for (int i = 0; i < iterationsNumber; i++) {
            double[] vector = createPesimistcDataVector(elementsNumber);
            long timerStart = System.nanoTime();
            sorter.sort(vector);
            long timerStop = System.nanoTime();
            time += timerStop - timerStart;
        }
        System.out.println(time/iterationsNumber);
        time /= iterationsNumber;
        return time;
    }
    
    public void measureQuickSortTime() {
        for (int i = 2; i <= maxVectorLength; i++) {
            long time = getAverageQuickSortTime(i);
//            System.out.println(time);
        }
    }

    private long getAverageQuickSortTime(int elementsNumber) {
        QuickSort sorter = new QuickSort();
        long time = 0;
        for (int i = 0; i < iterationsNumber; i++) {
            double[] vector = createRandomDataVector(elementsNumber);
            long timerStart = System.nanoTime();
            sorter.sort(vector);
            long timerStop = System.nanoTime();
            time += timerStop - timerStart;
        }
        System.out.print(time/iterationsNumber + ", ");
        for (int i = 0; i < iterationsNumber; i++) {
            double[] vector = createOptimisticDataVector(elementsNumber);
            long timerStart = System.nanoTime();
            sorter.sort(vector);
            long timerStop = System.nanoTime();
            time += timerStop - timerStart;
        }
        System.out.print(time/iterationsNumber + ", ");
        for (int i = 0; i < iterationsNumber; i++) {
            double[] vector = createPesimistcDataVector(elementsNumber);
            long timerStart = System.nanoTime();
            sorter.sort(vector);
            long timerStop = System.nanoTime();
            time += timerStop - timerStart;
        }
        System.out.println(time/iterationsNumber);
        time /= iterationsNumber;
        return time;
    }
}
