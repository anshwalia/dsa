// Title : Bubble Sort Implementation Using Java
// Author : Satvik Chachra <satvikchachra19@gmail.com>
// Date Created : 18/07/2020

package Algorithms.Sorting;

import java.util.Scanner;

public class Bubble_Sort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // Initializing array
        int len = scn.nextInt();
        int arr[] = new int[len];

        // Input array
        for (int i = 0; i < len; i++) {
            arr[i] = scn.nextInt();
        }

        // Bubble sort the array
        bubbleSort(arr);

        // Print the sorted array
        System.out.println("Sorted Array");
        printArray(arr);

        scn.close();

    }

    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap the two
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}