package sortingalgorithms;

import java.util.Random;

public class TimeMeasures {

    public void measureInsortTime() {
        int iterationsNumber = 10000000;
        int maxVectorLength = 50;

        for (int i = 2; i <= maxVectorLength; i++) {
            double[] vector = createRandomVector(i);
            long time = getAverageInsortTime(vector, iterationsNumber);
            System.out.println(i + ": " + time);
        }
    }
    
    private long getAverageInsortTime(double[] vector, int iterationsNumber){
        InsertionSort sorter = new InsertionSort();
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

    private double[] createRandomVector(int elementsNumber) {
        double[] vector = new double[elementsNumber];
        Random generator = new Random();
        for (int i = 0; i < elementsNumber; i++) {
            vector[i] = generator.nextDouble();
        }
        return vector;
    }
}
