// Title : Binary Search Implementation Using Java
// Author : Satvik Chachra <satvikchachra19@gmail.com>
// Date Created : 18/07/2020
package Algorithms.Searching;

import java.util.Arrays;
import java.util.Scanner;

public class Binary_Search {
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

        // Sort the array
        Arrays.sort(arr);

        // Store index of 'num' in array
        int ans = binarySearch(arr, 0, len - 1, num);

        // Display index of 'num'
        if (ans == -1) {
            System.out.println("Element not Found.");
        } else {
            System.out.println("Found Element " + num + " at Index " + ans);
        }

        scn.close();
    }

    public static int binarySearch(int[] arr, int l, int r, int num) {
        if (l <= r) {

            // Find middle index
            int mid = (l + (r - l) / 2);

            // If found at 'mid' index, return
            if (arr[mid] == num) {
                return mid;
            }

            // If mid term of array is less than num
            // Find num in right half
            else if (arr[mid] < num) {
                return binarySearch(arr, mid + 1, r, num);
            }

            // If mid term of array is greater than num
            // Find num in left half
            else {
                return binarySearch(arr, l, mid - 1, num);
            }
        }
        return -1;
    }

}
