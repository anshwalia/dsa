// Title : Queue Implementation Using Java
// Author : Ansh Walia <anshwalia@outlook.com>
// Date Created : 26/07/2020

import java.util.Scanner;

public class QueueIMP {
    public static void main(String[] args){
        // Program Variables
        boolean looping = true;
        int option;
        int size;
        int data;

        // Scanner Object
        Scanner scan = new Scanner(System.in);

        // User Input : Queue Size
        System.out.print("\nEnter Queue Size : ");
        size = scan.nextInt();

        // Queue Object
        Queue q = new Queue(size);

        // Program Loop
        while(looping){

            // Queue Menu
            System.out.println("******************");
            System.out.println("*      QUEUE     *");
            System.out.println("******************");
            System.out.println("* 1. Enqueue     *");
            System.out.println("* 2. Dequeue     *");
            System.out.println("* 3. Peek        *");
            System.out.println("* 4. Check Empty *");
            System.out.println("* 5. Check Full  *");
            System.out.println("* 6. Display     *");
            System.out.println("* 7. Reset       *");
            System.out.println("******************");
            System.out.println("* 0. EXIT        *");
            System.out.println("******************");

            System.out.print("\nOption : ");
            option = scan.nextInt();

            switch(option){

                case 1:
                    System.out.print("\nEnter Data : ");
                    data = scan.nextInt();
                    q.enqueue(data);
                break;

                case 2:
                    if(q.dequque()){
                        System.out.println("\nElement Dequeued : " +   q.getData() + "\n");
                    }
                break;

                case 3:
                    if(q.peek()){
                        System.out.println("\nElement Dequeued : " + q.getData() + "\n");
                    }
                break;

                case 4:
                    if(q.isEmpty()){
                        System.out.println("\n[ QUEUE IS EMPTY ]\n");
                    }
                    else{
                        System.out.println("\n[ QUEUE IS NOT EMPTY ]\n");
                    }
                break;

                case 5:
                    if(q.isFull()){
                        System.out.println("\n[ QUEUE IS FULL ]\n");
                    }
                    else{
                        System.out.println("\n[ QUEUE IS NOT FULL ]\n");
                    }
                break;

                case 6:
                    q.displayQueue();
                break;

                case 7:
                    q.resetQueue();
                break;

                case 0:
                    looping = false;
                    System.out.println("\n[ EXITING ]\n");
                break;

                default:
                    System.out.println("\n[ INVALID OPTION ]\n");
            }

        }

        scan.close();
    }
}

// Queue Class
class Queue{
    // Properties
    int[] queue;
    int queueSize;
    int front;
    int rear;
    int data;

    // Class Constructor
    public Queue(int size){
        this.queue = new int[size];
        this.queueSize = size;
        this.front = -1;
        this.rear = -1;
        int data = 0;
    }

    // Methods

    // Method to check if queue is empty
    public boolean isEmpty(){
        return (this.rear == this.front) ? true : false;
    }

    // Method to check if queue is full
    public boolean isFull(){
        return (this.rear >= (this.queueSize-1)) ? true : false;
    }

    // Method to get data from queue after dequeue/peek operation
    public int getData(){
        return this.data;
    }

    // Method to display complete queue
    public void displayQueue(){
        if(this.isEmpty()){
            System.out.println("\n[ QUEUE IS EMPTY ]\n");
        }
        else{
            System.out.print("\nQueue : (Front)-");
            for(int i = this.front; i <= this.rear; i++){
                if(i == this.rear){
                    System.out.print("[" + this.queue[i] + "]-(Rear)\n\n");
                }
                else{
                    System.out.print("[" + this.queue[i] + "]<-");
                }
            }
        }
    }

    // Method to add elements in queue
    public void enqueue(int data){
        if(this.isFull()){
            System.out.println("\n[ QUEUE IS FULL ]\n");
        }
        else{
            this.queue[++rear] = data;

            if(this.rear == 0){
                this.front = 0;
            }

            System.out.println("\nOperation : Enqueue [ Success ]\n");
        }
    }

    // Method to remove elements in queue
    public boolean dequque(){
        if(this.isEmpty()){
            System.out.println("\n[ QUEUE IS EMPTY ]\n");
            return false;
        }
        else{
            this.data = this.queue[this.front++];
            return true;
        }
    }

    // Method to peek front value in queue
    public boolean peek(){
        if(this.isEmpty()){
            System.out.println("\n[ QUEUE IS EMPTY ]\n");
            return false;
        }
        else{
            this.data = this.queue[this.front];
            return true;
        }
    }

    // Method to reset the queue
    public void resetQueue(){
        this.front = -1;
        this.rear = -1;
        this.data = 0;
        System.out.println("\nOperation : Reset Queue [ Success ]\n");
    }
}