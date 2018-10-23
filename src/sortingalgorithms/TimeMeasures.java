package sortingalgorithms;

import java.util.Random;

public class TimeMeasures {

    public void measureInsortTime() {
        int iterationsNumber = 10000000;
        int maxVectorLength = 100;

        for (int i = 2; i <= maxVectorLength; i++) {
            long time = getAverageInsortTime(i, iterationsNumber);
//            System.out.println(i + ": " + time);
            System.out.println(time);
        }
    }
    
    private long getAverageInsortTime(int elementsNumber, int iterationsNumber){
        InsertionSort sorter = new InsertionSort();
        long time = 0;
        for (int i = 0; i < iterationsNumber; i++){
            double [] vector = createRandomVector(elementsNumber);
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
        for (int i = 0; i < elementsNumber; i++) {
            vector[i] = generator.nextDouble();
        }
        return vector;
    }
    
    public void measureMergeSortTime() {
        int iterationsNumber = 10000000;
        int maxVectorLength = 100;

        for (int i = 2; i <= maxVectorLength; i++) {
            double[] vector = createRandomVector(i);
            long time = getAverageMergeSortTime(vector, iterationsNumber);
//            System.out.println(i + ": " + time);
            System.out.println(time);
        }
    }
    
    private long getAverageMergeSortTime(double[] vector, int iterationsNumber){
        MergeSort sorter = new MergeSort();
        long time = 0;
        for (int i = 0; i < iterationsNumber; i++){
            long timerStart = System.nanoTime();
            sorter.sort(vector);
            long timerStop = System.nanoTime();
            time += timerStop - timerStart;
        }
        time /= iterationsNumber;
        return time;
    }
}
