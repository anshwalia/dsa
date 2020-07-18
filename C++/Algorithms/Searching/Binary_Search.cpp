// Title : Binary Search Implementation Using C++
// Author : Ansh Walia <anshwalia@outlook.com>
// Date Created : 18/07/2020

#include <iostream>
#include <stdlib.h>
#include <cmath>

using namespace std;

// Function to sort array ( Bubble Sort )
void sort(int * array,int size){
	// Temporary Variable used for swapping
	int temp = 0;

	// Sorting Loop
	for(int i = 0; i < (size-1); i++){
		for(int j = (i+1); j < size; j++){
			if(array[j] < array[i]){
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
	}
}

// Function to display/print array
void displayArray(int array[],int size){
	cout << "[ ";
	for(int i = 0; i < size; i++){
		cout << array[i] << ", ";
	}
	cout << "]\n";
}

// Binary Search Algorithm
int binarySearch(int array[],int lowerBound,int upperBound,int value){

	if(upperBound >= lowerBound){
		int mid = ( lowerBound + round((upperBound-lowerBound)/2));

		// If value present at mid
		if(value == array[mid]){
			return mid;
		}

		// If value is smaller than value at mid
		if(value < array[mid]){
			return binarySearch(array,lowerBound,(mid-1),value);
		}
		// If value if greater than value at mid
		else{
			return binarySearch(array,(mid+1),upperBound,value);
		}
	}
	else{
		return -1;
	}

}

int main(){
	// Variable to store array size
	int size = 0;

	// Variable to store value to search
	int value = 0;

	// Array Size Input
	cout << "Enter Array Size : ";
	cin >> size;

	// Dynamiclly Allocating Memory for Array
	int * array = (int*)malloc( size * sizeof(int) );

	// Array Data Input
	for(int i = 0; i < size; i++){
		cout << "Element at Index [" << i << "] : ";
		cin >> array[i];
	}

	// Value to search input
	cout << "\nEnter Value to Search : ";
	cin >> value;

	// Before Sorting
	cout << "\nArray Before Sorting : ";
	displayArray(array,size);

	// Sorting Array Elements
	sort(array,size);

	// After Sorting
	cout << "\nArray After Sorting : ";
	displayArray(array,size);

	// Searching
	int match = binarySearch(array,0,(size-1),value);

	// If match is not equal to -1 result is printed
	if(match != -1){
		cout << "\nMatch Found => Index : " << match << " , Value : " << array[match] << "\n\n";
	}
	else{
		cout << "\nNo Match Found!\n\n";
	}

	// Freeing/Clearing Allocated Memory
	free(array);

	return 0;
}