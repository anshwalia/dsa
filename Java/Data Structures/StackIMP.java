// Title : Stack Implementation Using Java
// Author : Ansh Walia <anshwalia@outlook.com>
// Date Created : 25/07/2020

import java.util.Scanner;

public class StackIMP{
    public static void main(String[] args){
        // Variables
        boolean looping = true;
        int size;
        int data;
        int value;
        int option;

        // Scanner Object
        Scanner scan = new Scanner(System.in);

        // Stack Size User Input
        System.out.print("\nEnter Stack Size : ");
        size = scan.nextInt();

        // Stack Object
        Stack s = new Stack(size);

        // Program Loop
        while(looping){

            // Stack Menu
            System.out.println("\n**************");
            System.out.println("*    STACK   *");
            System.out.println("**************");
            System.out.println("* 1. Push    *");
            System.out.println("* 2. Pop     *");
            System.out.println("* 3. Peek    *");
            System.out.println("* 4. Display *");
            System.out.println("**************");
            System.out.println("* 0. EXIT    *");
            System.out.println("**************");

            System.out.print("\nOption : ");
            option = scan.nextInt();

            switch(option){

                case 1:
                    System.out.print("\nEnter Data : ");
                    data = scan.nextInt();
                    s.push(data);
                break;

                case 2:
                    value = s.pop();
                    if((value > (s.getMin()-1)) && (value < (s.getMax()+1))){
                        System.out.println("\nPopped Data Element : " + value + "\n");
                    }
                break;

                case 3:
                    value = s.peek();
                    if((value > (s.getMin()-1)) && (value < (s.getMax()+1))){
                        System.out.println("\nTop Most Data Element : " + value + "\n");
                    }
                break;

                case 4:
                    s.displayStack();
                break;

                case 0:
                    System.out.println("\n[ EXITING ]\n");
                    looping = false;
                break;

                default:
                    System.out.println("\n[ INVALID OPTION ]\n");
            }
        }

        scan.close();

    }
}

// Stack Class
class Stack{
    // Properties
    int stack[];
    int stackSize;
    int top;

    // Variable to assist in poping and peeking stack
    int cmpMin;
    int cmpMax;

    // Constructor
    Stack(int size){
        this.stack = new int[size];
        this.stackSize = size;
        this.top -= 1;
        this.cmpMin = 0;
        this.cmpMax = 0;
    }

    // Methods

    // Method to check if Stack is Empty
    public boolean isEmpty(){
        return this.top < 0 ? true : false;
    }

    // Method to check if Stack is Full
    public boolean isFull(){
        return this.top >= (this.stackSize-1) ? true : false;
    }

    // Method to get min range 
    public int getMin(){
        return this.cmpMin;
    }

    // Method to get max range
    public int getMax(){
        return this.cmpMax;
    }

    // Method to Display Complete Stack
    public void displayStack(){
        if(this.isEmpty()){
            System.out.println("\n[ STACK IS EMPTY ]\n");
        }
        else{
            System.out.println("\n[ STACK ]\n");
            for(int i = top; i >= 0; i--){
                System.out.println("[ " + this.stack[i] + " ]");
            }
            System.out.println("\n");
        }
    }

    // Method to push data elements in stack
    public void push(int data){
        if(this.isFull()){
            System.out.println("\n[ STACK IS FULL ]\n");
        }
        else{
            // Operation to get min and max values assist in poping and peeking operations
            if(data < this.cmpMin){
                this.cmpMin = data;
            }
            if(data > this.cmpMax){
                this.cmpMax = data;
            }
            // --------------------
            this.stack[++this.top] = data;
        }
    }

    // Method to pop data elements out of stack
    public int pop(){
        if(this.isEmpty()){
            System.out.println("\n[ STACK IS EMPTY ]\n");
            return -1;
        }
        else{
            return this.stack[this.top--];
        }
    }

    // Method to peek at the top most value in stack
    public int peek(){
        if(isEmpty()){
            System.out.println("\n[ STACK IS EMPTY ]\n");
            return -1;
        }
        else{
            return this.stack[this.top];
        }
    }


}