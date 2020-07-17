// Title : Linear Search Implementetion Using C++
// Author : Ansh Walia <anshwalia@outlook.com>
// Date Created : 18/07/2020

#include <iostream>
#include <stdlib.h>

using namespace std;

// Linear Search Algorithm
int ** linearSearch(int array[],int size, int searchValue){
	// Variable to store count of matching elements
	int match_count = 0;
	// Array to store 
	int match_array[size];

	// Linear Search Loop
	for(int i = 0; i < size; i++){
		if(array[i] == searchValue){
			match_array[match_count] = i;
			match_count += 1;
		}
	}

	// Allocating Memory Dynamically to result 2D array
	int ** result = (int**)malloc(2*sizeof(int));

	// Allocating Memory Dynamically for Index 0 of result 2d array
	result[0] = (int*)malloc(sizeof(int));

	// Assigning Match Count Value to Result 2D array at index[0][0]
	result[0][0] = match_count;

	// Allocating Memory Dynamically for Index 1 of result 2d array
	result[1] = (int*)malloc(match_count*sizeof(int));

	// Assigning Match Index Values to Result 2D array at index[0][i]
	for(int i = 0; i < match_count; i++){
		result[1][i] = match_array[i];
	}

	// Returning Result 2D Array
	return result;
}

// / Function to display/print array
void displayArray(int array[],int size){
	cout << "[ ";
	for(int i = 0; i < size; i++){
		cout << array[i] << ", ";
	}
	cout << "]\n";
}


int main(){
	// Variable for array size
	int size = 0;

	// Variable to store search value
	int searchValue = 0;

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


    // Search value input
    cout << "\nEnter Value to Search : ";
    cin >> searchValue;

    // Linear Search
    int ** result = linearSearch(array,size,searchValue);

    // Printing Match Result if match count is not 0
    if(result[0][0] != 0){
    	cout << "Matches Found : ";
    	displayArray(result[1],result[0][0]);
    }
    else{
    	cout << "No Matches Found!";
    }

	return 0;
}
