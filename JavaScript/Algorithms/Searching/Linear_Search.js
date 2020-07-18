// Title : Linear Search Implementation Using JavaScript
// Author : Ansh Walia <anshwalia@outlook.com>
// Date Created : 18/07/2020

// Note : You can use Node.JS to run this code in terminal or,
// 	      You can directly run this code in browser console in developer tools

'use strict';

// Linear Search Algorithm
function linearSearch(array,value){
	// Array Object to store match found
	let matches = [];

	// Search Loop
	for(let i = 0; i < array.length; i++){
		if(array[i] == value){
			matches.push(i);
		}
	}

	// Returning Matches Found
	return matches;
}

// Function to test linear search algorithm
async function test(){
	// Test Array/Dataset
	const test_array = [1,2,3,4,5,6,2,2,5,7,8];
	
	// Test Value to Search
	const search_value = 2;

	// Calling Linear Search Function
	const result = await linearSearch(test_array,search_value);

	if(result.length != 0){
		console.log('Matches Found at Index : ',result);
	}
	else{
		console.log('No Matches Found!');
	}
}

// Entry Point
test();