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
            System.out.println(time);
        }
    }

    private long getAverageInsortTime(int elementsNumber) {
        InsertionSort sorter = new InsertionSort();
        long time = 0;
        for (int i = 0; i < iterationsNumber; i++) {
            double[] vector = createRandomVector(elementsNumber);
            long timerStart = System.nanoTime();
            sorter.sort(vector);
            long timerStop = System.nanoTime();
            time += timerStop - timerStart;
        }
        time /= iterationsNumber;
        return time;
    }

    private double[] createRandomVector(int elementsNumber) {
        double[] vector = new double[elementsNumber];
        Random generator = new Random();
        for (int i = elementsNumber - 1; i >= 0; i--) {
            vector[i] = elementsNumber - i;
        }
//        for (int i = 0; i < elementsNumber; i++) {
////            vector[i] = generator.nextDouble();
//            vector[i] = i;
//        }
        return vector;
    }

    public void measureMergeSortTime() {
        for (int i = 2; i <= maxVectorLength; i++) {
            double[] vector = createRandomVector(i);
            long time = getAverageMergeSortTime(vector);
            System.out.println(time);
        }
    }

    private long getAverageMergeSortTime(double[] vector) {
        MergeSort sorter = new MergeSort();
        long time = 0;
        for (int i = 0; i < iterationsNumber; i++) {
            long timerStart = System.nanoTime();
            sorter.sort(vector);
            long timerStop = System.nanoTime();
            time += timerStop - timerStart;
        }
        time /= iterationsNumber;
        return time;
    }
}
