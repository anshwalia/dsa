// Title : Bubble Sort Algorithm Implementation Using C++
// Author : Ansh Walia <anshwalia@outlook.com>
// Date Created : 18/07/2020

#include <iostream>
#include <stdlib.h>

using namespace std;

// Bubble Sort Algorithm
void bubbleSort(int array[],int size){
	// Temporary Variable
	int temp = 0;

	// Variable to count swapping operations
	int swap_count = 0;

	// Nested Loop
	for(int i = 0; i < (size-1); i++){
		for(int j = (i+1); j < size; j++){
			if(array[j] < array[i]){
				// Element Swaping
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;

				// Swap count increment
				swap_count += 1;
			}
		}
	}

	// Printing number of total swap operations during sorting
	cout << "\nTotal Swap Operations : " << swap_count << "\n";
}

// Function to display/print array
void displayArray(int array[],int size){
	cout << "[ ";
	for(int i = 0; i < size; i++){
		cout << array[i] << ", ";
	}
	cout << "]\n";
}

// Main Function
int main(){
	// Variable for Array Size
    int size = 0;

    // Array Size Input
    cout << "Enter Array Size : ";
    cin >> size;

    // Data Array
    int array[size];

    // Array Data Input
    for(int i = 0; i < size; i++){
    	cout << "Index [" << i << "] : ";
    	cin >> array[i];
    }

    // Array Before Sorting
    cout << "\nBefore Sorting : ";
    displayArray(array,size);

    // Sorting
    bubbleSort(array,size);

    // After Sorting
    cout << "\nAfter Sorting : ";
    displayArray(array,size);

    return 0;
}

