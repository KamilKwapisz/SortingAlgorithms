package tests;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;
import sortingalgorithms.MergeSortRecurrent;

public class MergeSortTest {

    @Test
    public void testWithOddNumberOfDoubles() {
        // Given
        double[] unsortedVector = {32.2, 42.1, 7.2, 0.3, 15.7};
        MergeSortRecurrent sorter = new MergeSortRecurrent();

        // When
        double[] sortedVector = sorter.sort(unsortedVector);
        double[] expectedVector = {0.3, 7.2, 15.7, 32.2, 42.1};

        // Then
        assertEquals(expectedVector.length, sortedVector.length);
        assertArrayEquals(expectedVector, sortedVector, 0);
    }

    @Test
    public void testWithEvenNumberOfDoubles() {
        // Given
        double[] unsortedVector = {32.2, 42.1, 7.2, 0.3, 15.7, 70.2};
        MergeSortRecurrent sorter = new MergeSortRecurrent();

        // When
        double[] sortedVector = sorter.sort(unsortedVector);
        double[] expectedVector = {0.3, 7.2, 15.7, 32.2, 42.1, 70.2};

        // Then
        assertArrayEquals(expectedVector, sortedVector, 0);
    }

    @Test
    public void testWithNegativeNumbers() {
        // Given
        double[] unsortedVector = {-32, -2, 3, 0, -17, 29};
        MergeSortRecurrent sorter = new MergeSortRecurrent();

        // When
        double[] sortedVector = sorter.sort(unsortedVector);
        double[] expectedVector = {-32, -17, -2, 0, 3, 29};

        // Then
        assertArrayEquals(expectedVector, sortedVector, 0);
    }

    @Test
    public void testVectorSize() {
        // Given
        int unsortedVectorLength = 500;
        double[] unsortedVector = new double[unsortedVectorLength];
        Random generator = new Random();
        for (int i = 0; i < unsortedVectorLength; i++) {
            unsortedVector[i] = generator.nextDouble();
        }
        MergeSortRecurrent sorter = new MergeSortRecurrent();

        // When
        double[] sortedVector = sorter.sort(unsortedVector);
        int sortedVectorLength = sortedVector.length;

        // Then
        assertEquals(sortedVectorLength, unsortedVectorLength);
    }
    
    @Test(expected = NullPointerException.class)
    public void testIfMethodRaisesAnNullPointerException(){
        // Given
        double[] unsortedVector = null;
        MergeSortRecurrent sorter = new MergeSortRecurrent();
        
        // When
        double [] sortedVector = sorter.sort(unsortedVector);
        
        // Then
        assertNull(sortedVector);
    }
    
    @Test
    public void testOnEmptyVector(){
        int vectorLength = 10;
        double[] unsortedVector = new double[vectorLength];
        MergeSortRecurrent sorter = new MergeSortRecurrent();
        
        // When
        double [] sortedVector = sorter.sort(unsortedVector);
        double [] expectedVector = new double[vectorLength];
        int expectedLength = vectorLength;
        
        // Then
        assertEquals(sortedVector.length, expectedLength);
        assertArrayEquals(sortedVector, expectedVector, 0.0);
    }

}
