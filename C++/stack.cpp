// Title : Stack Data Structure Implementation using C++
// Author : Ansh Walia <anshwalia@outlook.com>
// Date Created : 17-07-2020 

#include <iostream>
#include <stdlib.h>
#include <string>

using namespace std;

class Stack {

    private:
        // Stack Properties

        // Stack Pointer
        int * stack = NULL;

        // Stack Size
        int size = 0;

        // Top Variable
        int top = -1;

    public:
        
        // Default Construstor 
        Stack(int arr[],int size){
            this->stack = &arr[0];
            this->size = size;
        };

        // Method to push elements into stack
        void push(int element){
            if(this->top < (this->size-1)){
                this->stack[++this->top] = element;
                cout << "\nAdded : " << element << " at index : " << this->top << "\n";
            }
            else{
                cout << "Stack Overflow!\n";
            }
        }

        // Method to pop elements out of stack
        int pop(){
            if(this->top > -1){
                return this->stack[top--];
            }
            else{
                cout << "Stack Underflow!\n";
                return -1;
            }
        }

        // Method to peek at the top of stack
        int peek(){
            if(this->top > -1){
                return this->stack[this->top];
            }
            else
            {
                cout << "Stack Underflow!";
                return -1;
            }
        }

        // Method to display stack elements
        void displayStack(){
            cout << "   STACK\n";
            for(int i = this->top; i >= 0; i--){
                if(i == this->top){
                    cout << " ^ [ " << this->stack[i] << " ]\n";
                }
                else{
                    cout << " | [ " << this->stack[i] << " ]\n";
                }
            }
        }

        // Method to find if stack is empty
        void isEmpty(){
            if(this->top > -1){
                cout << "\nStack is not Empty!";
            }
            else
            {
                cout << "\nStack is Empty!";
            }
            
        }
};

int main(){
    int size = 0;

    // Stack Size user input
    cout << "Enter Stack Size : ";
    cin >> size;
    int arr[size];

    // New Stack Object
    Stack *s1 = new Stack(arr,size);

    // Variable to store looping condition
    bool loop = true;

    // Variable to store option selection
    int option = 0;

    // Temporary variable to store various data
    int temp = 0;

    // Main Program Loop
    while(loop){
        cout << "\n";
        cout << "********************\n";
        cout << "* STACK OPERATIONS *\n";
        cout << "********************\n";
        cout << "* 1. Push          *\n";
        cout << "* 2. Pop           *\n";
        cout << "* 3. Peek          *\n";
        cout << "* 4. Display Stack *\n";
        cout << "* 5. isEmpty       *\n";
        cout << "* 0. Exit          *\n";
        cout << "********************\n";
        cout << "\n";
        cout << "=> ";
        cin >> option;

        // SCREEN CLEARING
        
        // Enable if compiling for Window
        // system("cls");

        // Enable if compiling for linux
        // system("clear");

        // Default Method
        cout << string(70, '\n');


        switch(option){

            // Stack Operation : Push
            case 1:
                cout << "\nInput Element : ";
                cin >> temp;
                s1->push(temp);
            break;

            // Stack Operation : Pop
            case 2:
                temp = s1->pop();
                cout << "\nElement Poped : " << temp;
            break;

            // Stack Operation : Peek
            case 3:
                temp = s1->peek();
                cout << "\nTop Element : " << temp;
            break;

            // Stack Operation : Display Stack
            case 4:
                s1->displayStack();
            break;

            // Stack Operation : isEmpty
            case 5:
                s1->isEmpty();
            break;

            // Exit Condition
            case 0:
                cout << "\n<--EXITING-->\n";
                loop = false;
            break;

            default:
                cout << "Invalid Input!";

        }

    }
    
}

