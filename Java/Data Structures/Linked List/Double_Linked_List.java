// Title : Doubled Linked List Implementation Using Java
// Author : Ansh Walia <anshwalia@outlook.com>
// Date Created : 25/07/2020

import java.util.Scanner;

public class Double_Linked_List {
    public static void main(String[] args){
        // Variables
        boolean looping = true;
        int option;
        int data;
        int value;

        // Scanner Object
        Scanner scan = new Scanner(System.in);

        // Double Linked List Object
        DoubleLinkedList dll = new DoubleLinkedList(); 

        while(looping){

            // Double Linked List - Menu
            System.out.println("************************");
            System.out.println("*  DOUBLE LINKED LIST  *");
            System.out.println("************************");
            System.out.println("*  1. Append           *");
            System.out.println("*  2. Prepend          *");
            System.out.println("*  3. Insert After     *");
            System.out.println("*  4. Delete Start     *");
            System.out.println("*  5. Delete           *");
            System.out.println("*  6. Delete End       *");
            System.out.println("*  7. Search           *");
            System.out.println("*  8. Check Empty      *");
            System.out.println("*  9. Node Count       *");
            System.out.println("* 10. Display Forward  *");
            System.out.println("* 11. Display Backward *");
            System.out.println("************************");
            System.out.println("*  0.      EXIT        *");
            System.out.println("************************");

            System.out.print("\nOption : ");
            option = scan.nextInt();

            switch(option){

                case 1:
                    System.out.print("\nEnter Data : ");
                    data = scan.nextInt();
                    dll.append(data);
                break;

                case 2:
                    System.out.print("\nEnter Data : ");
                    data = scan.nextInt();
                    dll.prepend(data);
                break;

                case 9:
                    dll.displayNodeCount();
                break;

                case 10:
                    dll.displayForwad();
                break;

                case 11:
                    dll.displayBackward();
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

// Node Class
class Node{
    Node prev;
    int data;
    Node next;

    public Node(int data){
        this.prev = null;
        this.data = data;
        this.next = null;
    }
}

// Double Linked List Class
class DoubleLinkedList{
    // Node Objects
    Node head;
    Node tail;
    Node cursor;

    // Node Count
    int nodeCount;

    // Class Constructor
    public DoubleLinkedList(){
        // init : Node Objects
        this.head = null;
        this.tail = null;
        this.cursor = null;

        // init : Node Count
        this.nodeCount = 0;
    }

    // Method to check if Linked List is Empty
    public boolean isEmpty(){
        if(this.head == null){
            return true;
        }
        else{
            return false;
        }
    }

    // Method to Dsiplay Node Count
    public void displayNodeCount(){
        System.out.println("\nNode Count : " + this.nodeCount + "\n");
    }

    // Method to Display Linked List in Forward Direction
    public void displayForwad(){
        if(this.isEmpty()){
            System.out.println("\n[ LINKED LIST EMPTY ]\n");
        }
        else{
            // Placing cursor at the Head of Linked List
            this.cursor = this.head;

            System.out.print("\nLinked List : (Head)-");
            while(true){
                if(this.cursor == this.tail){
                    System.out.print("[" + this.cursor.data + "]-(Tail)\n\n");
                    break;
                }
                else{
                    System.out.print("[" + this.cursor.data + "]->");
                    this.cursor = this.cursor.next;
                }
            }
        }
    }

    // Method to Display Linked List in Backward Direction
    public void displayBackward(){
        if(isEmpty()){
            System.out.println("\n[ LINKED LIST EMPTY ]\n");
        }
        else{
            // Placing cursor at the Tail of Linked List
            this.cursor = this.tail;

            System.out.print("\n(Tail)-");
            while(true){
                if(this.cursor == this.head){
                    System.out.print("[" + this.cursor.data + "]-(Head)\n\n");
                    break;
                }
                else{
                    System.out.print("[" + this.cursor.data + "]<-");
                    this.cursor = this.cursor.prev;
                }
            }
        }
    }

    // Method to add Node at the end of Linked List
    public void append(int data){
        // Creating New Node
        Node newNode = new Node(data);

        if(this.isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }
        else{
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }

        this.nodeCount += 1;

        System.out.println("\nOperation : Append Node [ Success ]\n");
    }

    // Method to add Node at the start of Linked List
    public void prepend(int data){
        // Creatinge New Node
        Node newNode = new Node(data);

        if(this.isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }
        else{
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }

        this.nodeCount += 1;

        System.out.println("\nOperation : Prepend Node [ Success ]\n");
    }

}