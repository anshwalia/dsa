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
    public Node prev;
    int data;
    public Node next;

    // Class Constructor
    public Node(int data){
        this.prev = null;
        this.data = data;
        this.next = null;
    }
}

// Circular Linked List Class
class CircularLinkedList{
    // Properties
    Node head;
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
            newNode.next = newNode;
            newNode.prev = newNode;
        }
        else{
            Node temp = this.head;
            this.head = newNode;
            this.head.prev = temp.prev;
            this.head.next = temp;
            temp.prev = this.head;
        }

        System.out.println("\nOperation : Insert Node [ Success ]\n");
    }

}