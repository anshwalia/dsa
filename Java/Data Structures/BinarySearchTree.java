// Title : Binary Search Tree Implementation Using Java
// Author : Ansh Walia <anshwalia@outlook.com>
// Date Created : 16/09/2020

import java.util.Scanner;

public class BinarySearchTree {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        // Variables
        boolean looping = true;
        int option;
        int data;

        // Binary Search Tree Object
        BST bst = new BST();

        while(looping){

            System.out.println("\n\n");
            System.out.println("***************************");
            System.out.println("*    BINARY SEARCH TREE   *");
            System.out.println("***************************");
            System.out.println("* 1. Add Node             *");
            System.out.println("* 2. Search Node          *");
            System.out.println("* 3. Pre-Order Traversal  *");
            System.out.println("* 4. In-Order Traversal   *");
            System.out.println("* 5. Post-Order Traversal *");
            System.out.println("* 6. Node Count           *");
            System.out.println("***************************");
            System.out.println("* 0. Exit                 *");
            System.out.println("***************************");

            System.out.print("\nOption => ");
            option = scan.nextInt();

            switch(option){
                case 1:
                    System.out.print("\nEnter Data : ");
                    data = scan.nextInt();
                    bst.addNode(data);
                break;
                case 2:
                    System.out.println("\nEnter Data to Search : ");
                    data = scan.nextInt();
                    bst.search(bst.root, data);
                break;
                case 3:
                    bst.preOrderTraversal(bst.root);
                break;
                case 4:
                    bst.inOrderTraversal(bst.root);
                break;
                case 5:
                    bst.postOrderTraversal(bst.root);
                break;
                case 6:
                    System.out.println("\nNode Count: " + bst.getNodeCount() + "\n");
                break;
                case 0:
                    System.out.println("\n[ Exiting ]\n");
                    looping = false;
                break;
                default:
                    System.out.println("\n[ Invalid Option ]\n");
            }

        }

        scan.close();
    }
}

// Node Class
class Node{
    // Left Child Node
    Node leftChild;
    // Node Data
    int data;
    // Right Child Node
    Node rightChild;

    // Class Constructor
    public Node(int data){
        this.leftChild = null;
        this.data = data;
        this.rightChild = null;
    }
}

// Binary Search Tree Class
class BST{
    // Root Node
    Node root;
    // Node Counter Variable
    int nodeCount;

    // Class Constructor
    public BST(){
        this.root = null;
        this.nodeCount = 0;
    }

    // Method to add new node in BST
    public void addNode(int data){
        Node newNode = new Node(data);

        if(this.root == null){
            this.root = newNode;
        }
        else{
            this.traverseAdd(this.root,newNode);
        }

        this.nodeCount += 1;
    }

    // Method to add new node in BST via traversal
    public void traverseAdd(Node currentNode, Node newNode){
        if(newNode.data < currentNode.data){
            if(currentNode.leftChild == null){
                currentNode.leftChild = newNode;
                return;
            }
            else{
                this.traverseAdd(currentNode.leftChild, newNode);
            }
        }
        else{
            if(currentNode.rightChild == null){
                currentNode.rightChild = newNode;
                return;
            }
            else{
                this.traverseAdd(currentNode.rightChild, newNode);
            }
        }
    }

    // Method to search node in BST
    public void search(Node currentNode,int data){
        if(currentNode == null){
            return;
        }
        else{
            this.search(currentNode.leftChild,data);
            if(currentNode.data == data){
                System.out.println("\nNode with vale [" + currentNode.data + "] present in tree.\n");
            }
            this.search(currentNode.rightChild,data);
        } 
    }

    // Method for Pre-Order Traversal
    public void preOrderTraversal(Node currentNode){
        if(currentNode == null){
            return;
        }
        else{
            System.out.print("[" + currentNode.data + "] ");
            this.preOrderTraversal(currentNode.leftChild);
            this.preOrderTraversal(currentNode.rightChild);
        }
    }

    // Method for In-Order Traversal
    public void inOrderTraversal(Node currentNode){
        if(currentNode == null){
            return;
        }
        else{
            this.inOrderTraversal(currentNode.leftChild);
            System.out.print("[" + currentNode.data + "] ");
            this.inOrderTraversal(currentNode.rightChild);
        }
    }

    // Method for Post-Order Traversal
    public void postOrderTraversal(Node currentNode){
        if(currentNode == null){
            return;
        }
        else{
            this.postOrderTraversal(currentNode.leftChild);
            this.postOrderTraversal(currentNode.rightChild);
            System.out.print("[" + currentNode.data + "] ");
        }
    }

    // Method to get node count in BST
    public int getNodeCount(){
        return this.nodeCount;
    }
}
