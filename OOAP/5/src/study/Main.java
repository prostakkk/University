package study;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;

class SortingAlgorithms {
    private static SortingAlgorithms instance;

    private SortingAlgorithms() {
    }

    public static SortingAlgorithms getInstance() {
        if (instance == null) {
            synchronized (SortingAlgorithms.class) {
                if (instance == null) {
                    instance = new SortingAlgorithms();
                }
            }
        }
        return instance;
    }

    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public void writeSortingTimeToFile(String fileName,
                                       long bubbleSortTime,
                                       long shellSortTime,
                                       long quickSortTime,
                                       int[] sortedArray) {
        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            writer.write("Bubble Sort Time: " + bubbleSortTime + " ms\n");
            writer.write("Shell Sort Time: " + shellSortTime + " ms\n");
            writer.write("Quick Sort Time: " + quickSortTime + " ms\n");

            writer.write("Sorted Array: " + Arrays.toString(sortedArray) + "\n");

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SortingAlgorithms sorter = SortingAlgorithms.getInstance();
        int[] arr = new int[10000]; // Розмір масиву

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1;
        }

        final long[] bubbleTime = new long[1];
        final long[] shellTime = new long[1];
        final long[] quickTime = new long[1];
        Thread bubbleSortThread = new Thread(() -> {
            int[] sortedArray = arr.clone();
            long bubbleSortStartTime = System.currentTimeMillis();
            sorter.bubbleSort(sortedArray);
            bubbleTime[0] = System.currentTimeMillis() - bubbleSortStartTime;

        });
        Thread shellSortThread = new Thread(() -> {
            int[] sortedArray = arr.clone();
            long shellSortStartTime = System.currentTimeMillis();
            sorter.shellSort(sortedArray);
            shellTime[0] = System.currentTimeMillis() - shellSortStartTime;
        });
        Thread quickSortThread = new Thread(() -> {
            int[] sortedArray = arr.clone();
            long quickSortStartTime = System.currentTimeMillis();
            sorter.quickSort(sortedArray, 0, arr.length - 1);
            quickTime[0] = System.currentTimeMillis() - quickSortStartTime;
        });

        bubbleSortThread.start();
        shellSortThread.start();
        quickSortThread.start();

        try {
            bubbleSortThread.join();
            shellSortThread.join();
            quickSortThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       sorter.writeSortingTimeToFile("sorting_time.txt",
                bubbleTime[0],
                shellTime[0],
                quickTime[0],
                arr);
    }
}

