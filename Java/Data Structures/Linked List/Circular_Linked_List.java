import java.util.Scanner;

public class Circular_Linked_List {
    public static void main(String[] args){
        // Program Variables
        boolean looping = true;
        int option;
        int data;
        int value;

        // Scanner Object
        Scanner scan = new Scanner(System.in);

        // Circular Linked List Object
        CircularLinkedList cll = new CircularLinkedList();

        while(looping){

            System.out.println("************************");
            System.out.println("* CIRCULAR LINKED LIST *");
            System.out.println("************************");
            System.out.println("* 1. Insert            *");
            System.out.println("* 2. Delete            *");
            System.out.println("* 3. Display           *");
            System.out.println("************************");
            System.out.println("* 0. Exit              *");
            System.out.println("************************");

            System.out.print("\nOption : ");
            option = scan.nextInt();

            switch(option){

                case 1:
                    System.out.print("\nEnter Data : ");
                    data = scan.nextInt();
                    cll.insert(data);
                break;

                case 2:
                    System.out.print("\nEnter Value : ");
                    value = scan.nextInt();
                    cll.delete(value);
                break;

                case 3:
                    cll.display();
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
    int data;
    public Node next;

    // Class Constructor
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

// Circular Linked List Class
class CircularLinkedList{
    // Properties
    Node head;
    Node tail;
    Node cursor;
    int nodeCount;
    int data;

    // Class Constructor
    public CircularLinkedList(){
        this.head = null;
        this.cursor = null;
        this.nodeCount = 0;
        this.data = 0;
    }

    // Methods
    
    // Method to check if linked list is empty 
    public boolean isEmpty(){
        return (this.head == null) ? true : false;
    }

    // Method to display complete linked list
    public void display(){
        if(this.isEmpty()){
            System.out.println("\n[ LINKED LIST IS EMPTY ]\n");
        }
        else{
            this.cursor = this.head;

            System.out.print("\nLinked List : (Head)-");
            while(true){
                if(this.cursor.next == this.head){
                    System.out.print("[" + this.cursor.data + "]-(Head)\n\n");
                    break;
                }
                else{
                    System.out.print("[" + this.cursor.data + "]->");
                    this.cursor = this.cursor.next;
                }
            }
        }
    }

    // Method to insert node in linked list
    public void insert(int data){
        // Creating New Node
        Node newNode = new Node(data);

        if(this.isEmpty()){
            this.head = newNode;
            this.tail = newNode;
            newNode.next = newNode;
        }
        else{
            Node temp = this.head;
            this.head = newNode;
            this.head.next = temp;
            this.tail.next = newNode;
        }

        System.out.println("\nOperation : Insert Node [ Success ]\n");
    }

    // Method to delete element from Linked List
    public void delete(int value){
        if(this.isEmpty()){
            System.out.println("\n[ LINKED LIST EMPTY ]\n");
        }
        else{
            this.cursor = this.head;

            while(true){
                if((this.head.data == value) && (this.head.next == this.head)){
                    this.head = null;
                    this.tail = null;
                    System.out.println("\nOperation : Delete Node [ Success ]\n");
                    break;
                }
                else if(this.head.data == value){
                    this.tail.next = this.head.next;
                    this.head.next = null;
                    this.head = this.tail.next;
                    System.out.println("\nOperation : Delete Node [ Success ]\n");
                    break;
                }
                else if(this.cursor.next.data == value){
                    Node temp1 = this.cursor.next;
                    Node temp2 = this.cursor.next.next;
                    
                    this.cursor.next = temp2;
                    temp1.next = null;

                    System.out.println("\nOperation : Delete Node [ Success ]\n");
                    break;
                }
                else{
                    if(this.cursor.next == this.head){
                        System.out.println("\nOperation : Delete Node [ Failed ]\n");
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