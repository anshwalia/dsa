// Title : Binary Search Implementation using JavaScript
// Author : Ansh Walia <anshwalia@outlook.com>
// Date Created : 20/07/2020

'use strict';

// Binary Search
function binarySearch(array,lowerBound,upperBound,searchValue){
    
    if(upperBound >= lowerBound){
        // Calculating Array Mid-Point
        let midPoint = (lowerBound + Math.floor((upperBound-lowerBound)/2));

        // Evaluating if value at midpoint is equal to search value
        if(searchValue == array[midPoint]){
            return midPoint;
        }

        // Evaluating if value at midpoint is greater than search value
        if(searchValue < array[midPoint]){
            return binarySearch(array,lowerBound,(midPoint-1),searchValue);
        }
        // Evaluating if value at midepoint is less than search value
        else{
            return binarySearch(array,(midPoint+1),upperBound,searchValue);
        }

    }
    else{
        // Returning -1 if no matching value found
        return -1;
    }

}

// Bubble Sort : For Sorting Array
function bubbleSort(array){
    // Temporary variable to help in swapping
    let temp = 0;

    // Sorting Loop
    for(let i = 0; i < (array.length-1); i++){
        for(let j = (i+1); j < array.length; j++){
            if(array[j] < array[i]){
                // Element Swapping
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }

    // Returning Sorted Loop
    return array;
}

// Test Function
async function test(){
    // Test Array
    let testArr = [10,9,8,7,6,1,2,3,4,5];

    // Value to search in test array
    let searchValue = 8;

    // Printing array before sorting
    console.log("\nArray Before Sorting :",testArr,"\n");

    // Calling bubbleSort function to sort test array 
    testArr = await bubbleSort(testArr);

    // Printing array after sorting
    console.log("Array After Sorting :",testArr,"\n");

    // Calling binarySearch function to search given value in array
    let matchIndex = await binarySearch(testArr,0,(testArr.length-1),searchValue);

    // If match index value is less than 0 i.e -ve than element is not present in give array
    if(matchIndex < 0){
        console.log("No Match Found!\n");
    }
    // if match index value is greater than or equalt to 0 than element is present in given array
    else{
        console.log("Match found at index :",matchIndex,"\n");
    }
}

// Start Point
test();