// Title : Linear Search Implementation Using Java
// Author : Satvik Chachra <satvikchachra19@gmail.com>
// Date Created : 18/07/2020

package Algorithms.Searching;

import java.util.Scanner;

public class Linear_Search {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // Initializing array
        int len = scn.nextInt();
        int arr[] = new int[len];

        // Input array
        for (int i = 0; i < len; i++) {
            arr[i] = scn.nextInt();
        }

        // Search 'num' in array
        int num = scn.nextInt();

        // Store index of 'num' in array
        int ans = linearSearch(arr, num);

        // Display index of 'num'
        if (ans == -1) {
            System.out.println("Element not Found.");
        } else {
            System.out.println("Found Element " + num + " at Index " + ans);
        }

        scn.close();
    }

    // Return index of 'num' in the array
    public static int linearSearch(int[] arr, int num) {
        int len = arr.length;

        // Default
        int numIdx = -1;

        for (int i = 0; i < len; i++) {
            // Compare each element of array
            if (arr[i] == num) { 
                numIdx = i;
                return numIdx; // To optimize
            }
        }

        return numIdx; // Returns -1 when 'num' not found
    }
}