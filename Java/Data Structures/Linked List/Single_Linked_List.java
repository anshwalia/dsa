// Title : Single Linked List Implementation Using Java
// Author : Ansh Walia <anshwalia@outlook.com>
// Date Created : 24/07/2020

import java.util.Scanner;

public class Single_Linked_List{
    public static void main(String[] args){
        // Variables
        boolean looping = true;
        int option;
        int data;
        int value;

        // Scanner Object
        Scanner scan = new Scanner(System.in);
        
        // Linked List Object
        LinkedList ll = new LinkedList();

        while(looping){

            // LINKED LIST MENU
            System.out.println("*******************");
            System.out.println("*   LINKED LIST   *");
            System.out.println("*******************");
            System.out.println("* 1. Append       *");
            System.out.println("* 2. Prepend      *");
            System.out.println("* 3. Insert After *");
            System.out.println("* 4. Delete Front *");
            System.out.println("* 5. Delete       *");
            System.out.println("* 6. Delete Back  *");
            System.out.println("* 7. Check Empty  *");
            System.out.println("* 8. Display      *");
            System.out.println("*******************");
            System.out.println("* 0. Exit         *");
            System.out.println("*******************");

            System.out.print("\nOption : ");
            option = scan.nextInt();

            switch(option){

                case 1:
                    System.out.print("\nEnter Data : ");
                    data = scan.nextInt();
                    ll.append(data);
                break;

                case 2:
                    System.out.print("\nEnter Data : ");
                    data = scan.nextInt();
                    ll.prepend(data);
                break;

                case 3:
                    System.out.print("\nEnter Node Value : ");
                    value = scan.nextInt();
                    System.out.print("\nEnter Data : ");
                    data = scan.nextInt();
                    ll.insertAfter(data, value);
                break;

                case 4:
                    ll.deleteFront();
                break;

                case 5:
                    System.out.print("\nEnter Node Value : ");
                    value = scan.nextInt();
                    ll.deleteNode(value);
                break;

                case 6:
                    ll.deleteBack();
                break;

                case 7:
                    if(ll.isEmpty()){
                        System.out.println("\n[ LINKED LIST EMPTY ]\n");
                    }
                    else{
                        System.out.println("\n[ LINKED LIST NOT EMPTY ]\n");
                    }
                break;

                case 8:
                    ll.display();
                break;

                case 0:
                    System.out.println("\n[ EXITING ]\n");
                    looping = false;
                break;
            }
        }

        scan.close();
    }
}

// Node Class
class Node{
    public int data;
    public Node next;

    // Constructor
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

// Linked List
class LinkedList{
    // Properties
    Node head;
    Node tail;
    Node cursor;

    // Node Count
    int nodeCount;

    // Constructor
    LinkedList(){
        this.head = null;
        this.tail = null;
        this.cursor = null;
        this.nodeCount = 0;
    }

    // Method to check if linked list is empty
    public boolean isEmpty(){
        if(this.head == null){
            return true;
        }
        else{
            return false;
        }
    }

    // Method to insert data in Linked List
    public void prepend(int data){
        // Creating New Node
        Node newNode = new Node(data);

        if(this.isEmpty()){
            // Making Head => New Node
            this.head = newNode;
            // Making Tail => New Node
            this.tail = newNode;
        }
        else{
            // Linking New Node to Head's Next Node
            newNode.next = this.head;
            // Making Head's Next Node => New Node
            this.head = newNode;
        }

        // Incrementing Node Count
        this.nodeCount += 1;

        System.out.println("\nOperation : Insertion [ Success ]\n");
    }

    // Method to add node at the end
    public void append(int data){
        // Creating New Node
        Node newNode = new Node(data);

        if(this.isEmpty()){
            // Making Head => New Node
            this.head = newNode;
            // Making Tail => New Node
            this.tail = newNode;
        }
        else{
            // Linking New Node to Tail's Next Node
            tail.next = newNode;
            // Making Head's Next Node => New Node
            tail = newNode;
        }

        // Incrementing Node Count
        this.nodeCount += 1;

        System.out.println("\nOperation : Append [ Success ]\n");
    }

    // Method to insert node after a node with specific value
    public void insertAfter(int data,int value){
        if(this.isEmpty()){
            System.out.println("\n[ LINKED LIST EMPTY ]\n");
        }
        else{
            this.cursor = this.head;

            while(true){
                if(this.cursor.data == value){
                    // Creating New Node
                    Node newNode = new Node(data);

                    // Linking New Node
                    if(this.cursor == this.tail){
                        this.cursor.next = newNode;
                        this.tail = newNode;
                    }
                    else{
                        Node temp = this.cursor.next;
                        this.cursor.next = newNode;
                        newNode.next = temp;
                    }

                    // Incrementing Node Count
                    this.nodeCount += 1;

                    System.out.println("\nOperation : Insert After [ Success ]\n");

                    break;
                }
                else{
                    if(this.cursor.next == null){
                        System.out.println("\nOperation : Insert After [ Failed ]");
                        System.out.println("No Match Found!\n");
                        break;
                    }
                    else{
                        this.cursor = this.cursor.next;
                    }
                }
            }
        }
    }

    // Method to delete node at front of linked list
    public void deleteFront(){
        if(this.isEmpty()){
            System.out.println("\n[ LINKED LIST EMPTY ]\n");
        }
        else{
            if(this.head == this.tail){
                this.head = null;
                this.tail = null;
            }
            else{
                this.head = this.head.next;
            }
            System.out.println("\nOperation : Delete Back [ Success ]\n");
        }
    }

    // Method to delete a node with specific value
    public void deleteNode(int value){
        if(this.isEmpty()){
            System.out.println("\n[ LINKED LIST EMPTY ]\n");
        }
        else{
            this.cursor = this.head;

            if(this.head == this.tail){
                if(this.head.data == value){
                    this.head = null;
                    this.tail = null;
                    System.out.println("\nOperation : Delete Node [ Success ]\n");
                }
                else{
                    System.out.println("\nOperation : Delete Node [ Failed ]");
                    System.out.println("No Match Found!\n");
                }
            }
            else{
                if(this.head.data == value){
                    this.head = this.head.next;
                    System.out.println("\nOperation : Delete Node [ Success ]\n");
                }
                else{
                    while(true){
                        if(this.cursor.next.data == value){
                            Node temp = this.cursor.next.next;
                            this.cursor.next = temp;
                            System.out.println("\nOperation : Delete Node [ Success ]\n");
                            break;
                        }
                        else{
                            if(this.cursor.next == null){
                                System.out.println("\nOperation : Delete Node [ Failed ]");
                                System.out.println("No Match Found!\n");
                                break;
                            }
                            else{
                                this.cursor = this.cursor.next;
                            }
                        }
                    }
                }
            }
        }
    }

    // Method to delete node at end of linked list
    public void deleteBack(){
        if(this.isEmpty()){
            System.out.println("\n[ LINKED LIST EMPTY ]\n");
        }
        else{
            if(this.head == this.tail){
                this.head = null;
                this.tail = null;
            }
            else{
                this.cursor = this.head;
                while(true){
                    if(this.cursor.next == this.tail){
                        this.cursor.next = null;
                        this.tail = this.cursor;
                        break;
                    }
                    else{
                        this.cursor = this.cursor.next;
                    }
                }
            }
            System.out.println("\nOperation : Delete Back [ Success ]\n");
        }
    }

    // Method to display complete Linked List
    public void display(){
        if(this.isEmpty()){
            System.out.println("\n[ LINKED LIST EMPTY ]\n");
        }
        else{
            // Making Cursor => Head
            this.cursor = this.head;
            System.out.print("\nLinked List : (Head)");
            while(this.cursor != null){
                System.out.print("[" + this.cursor.data + "]->");
                this.cursor = this.cursor.next;
            }
            System.out.println("\n");
        }
    }
}