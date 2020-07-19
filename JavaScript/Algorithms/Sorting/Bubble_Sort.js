// Title : Bubble Sort Algorithm Implementation Using JavaScript
// Author : Ansh Walia <anshwalia@outlook.com>
// Date Created : 19/07/2020

'use strict';

// Bubble Sort Algorithm
function bubbleSort(array){
	// Temporary Variable used for swapping
	let temp;

	// Sorting Nested Loop
	for(let i = 0; i < (array.length-1); i++){
		for(let j = (i+1); j < array.length; j++){
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}

	// Returning Sorted Array
	return array;
}

// Test Function to test Bubble Sort Algorithm
async function test(){
	// Test Array
	let testArray = [10,9,8,7,6,5,4,3,2,1];

	console.log('\nArray Before Sorting :',testArray);

	// Calling Bubble Sort Function for array sorting
	testArray = await bubbleSort(testArray);

	console.log('\nArray After Sorting :',testArray);
}

// Start Point
test();