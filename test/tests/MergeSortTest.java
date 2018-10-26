package tests;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;
import sortingalgorithms.MergeSort;

public class MergeSortTest {

    @Test
    public void testWithOddNumberOfDoubles() {
        // Given
        double[] unsortedVector = {32.2, 42.1, 7.2, 0.3, 15.7};
        MergeSort sorter = new MergeSort();

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
        MergeSort sorter = new MergeSort();

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
        MergeSort sorter = new MergeSort();

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
        Random generator = new Random(291084);
        for (int i = 0; i < unsortedVectorLength; i++) {
            unsortedVector[i] = generator.nextDouble();
        }
        MergeSort sorter = new MergeSort();

        // When
        double[] sortedVector = sorter.sort(unsortedVector);
        int sortedVectorLength = sortedVector.length;

        // Then
        assertEquals(sortedVectorLength, unsortedVectorLength);
    }

    @Test(expected = NullPointerException.class)
    public void testIfMethodRaisesAnNullPointerException() {
        // Given
        double[] unsortedVector = null;
        MergeSort sorter = new MergeSort();

        // When
        double[] sortedVector = sorter.sort(unsortedVector);

        // Then
        assertNull(sortedVector);
    }

    @Test
    public void testOnEmptyVector() {
        // Given
        int vectorLength = 10;
        double[] unsortedVector = new double[vectorLength];
        MergeSort sorter = new MergeSort();

        // When
        double[] sortedVector = sorter.sort(unsortedVector);
        double[] expectedVector = new double[vectorLength];
        int expectedLength = vectorLength;

        // Then
        assertEquals(sortedVector.length, expectedLength);
        assertArrayEquals(sortedVector, expectedVector, 0.0);
    }

    @Test
    public void testOnHugeIntegerValueVectorSize() {
        // Given
        int vectorLength = 10000000;
        double[] unsortedVector = new double[vectorLength];
        MergeSort sorter = new MergeSort();
        for (int i = 0; i < vectorLength; i++) {
            unsortedVector[i] = vectorLength - i  - 1;
        }

        // When
        double[] sortedVector = sorter.sort(unsortedVector);
        double[] expectedVector = new double[vectorLength];
        for (int i = 0; i < vectorLength; i++) {
            expectedVector[i] = i;
        }
        
        // Then
        assertArrayEquals(sortedVector, expectedVector, 0.0);
    }

}
