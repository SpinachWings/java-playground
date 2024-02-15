package sorting;

import java.util.Arrays;
import java.util.Random;

public class Sorting {

    public static void handleSort() {
        int[] array = {1,6,23,4,12,88,9,0,26,1};

        System.out.println("Init array:");
        System.out.println(Arrays.toString(array));

        System.out.println("Insertion sort result:");
        insertionSort(array);
        System.out.println(Arrays.toString(array));

        System.out.println("Shuffling:");
        shuffle(array);
        System.out.println(Arrays.toString(array));

        System.out.println("Merge sort result:");
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

        System.out.println("Shuffling:");
        shuffle(array);
        System.out.println(Arrays.toString(array));

        System.out.println("Heap sort result:");
        heapSort(array);
        System.out.println(Arrays.toString(array));

        System.out.println("Shuffling:");
        shuffle(array);
        System.out.println(Arrays.toString(array));

        System.out.println("Quick sort result:");
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void shuffle(int[] array) {
        Random random = new Random();
        random.nextInt();
        int length = array.length;

        for (int i = 0 ; i < length ; i++) {
            int randomIndex = i + random.nextInt(length - i);
            int currentValue = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = currentValue;
        }
    }

    private static void insertionSort(int[] array) {
        int length = array.length;

        for(int j = 1 ; j < length ; j++){

            int key = array[j];
            int i = j - 1;

            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i--;
            }

            array[i + 1] = key;
        }
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] leftArray = new int[leftSize + 1];
        int[] rightArray = new int[rightSize + 1];

        for (int i = 0 ; i < leftSize ; i++) {
            leftArray[i] = array[i + left];
        }
        for (int i = 0 ; i < rightSize ; i++) {
            rightArray[i] = array[i + mid + 1];
        }

        leftArray[leftSize] = 9999;
        rightArray[rightSize] = 9999;

        int i = 0;
        int j = 0;

        for (int k = left ; k < right + 1 ; k++) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
        }
    }

    private static void heapSort(int[] array) {
        for (int i = array.length / 2 - 1 ; i >= 0 ; i--) {
            maxHeapify(array, i);
        }
    }

    private static void maxHeapify(int[] array, int index) {
        int leftIndex = getHeapLeftIndex(index);
        int rightIndex = getHeapRightIndex(index);

        int largestIndex;
        if (leftIndex < array.length && array[leftIndex] > array[index]) {
            largestIndex = leftIndex;
        } else {
            largestIndex = index;
        }

        if (rightIndex < array.length && array[rightIndex] > array[largestIndex]) {
            largestIndex = rightIndex;
        }

        if (largestIndex != index) {
            int helper = array[index];
            array[index] = array[largestIndex];
            array[largestIndex] = helper;
            maxHeapify(array, largestIndex);
        }
    }

    private static int getHeapLeftIndex(int index) {
        return index * 2 + 1;
    }

    private static int getHeapRightIndex(int index) {
        return index * 2 + 2;
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int partition = partition(array, left, right);
            quickSort(array, left, partition - 1);
            quickSort(array, partition + 1, right);
        }

    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;

        for (int j = left ; j < right ; j++) {
            if (array[j] <= pivot) {
                i++;

                int helper = array[i];
                array[i] = array[j];
                array[j] = helper;
            }
        }

        int helper = array[i + 1];
        array[i + 1] = pivot;
        array[right] = helper;

        return i + 1;
    }
}