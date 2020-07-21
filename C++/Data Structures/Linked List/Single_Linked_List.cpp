// Title : Single Linked List Implementation using C++
// Author : Ansh Walia <anshwalia@outlook.com>
// Date Created : 21/07/2020

#include <iostream>
#include <stdlib.h>

using namespace std;

// Node Structure
struct Node{
	int data;
	Node * next = NULL;
};

// Single Linked List Class
class Single_Linked_List
{
	private:
		Node * head = NULL;
		Node * currentNode = NULL;
		Node * cursor = NULL;
		int nodeCount = 0;

	public:
		// Linked List Constructor
		Single_Linked_List(Node * head){
			this->head = head;
			this->currentNode = head;
		}

		// Method to Display Linked List
		void display(){
			// If linked list 1st node is NULL
			if(this->head->next == NULL){
				cout << "\nLinked List Empty!" << endl;
			}
			else{
				// Placing cursor at 1st Node
				this->cursor = this->head->next;

				cout << "\nLinked List : (Head)-";

				while(1){
					if(this->cursor->next == NULL){
						cout << "[" << this->cursor->data << "]-(Tail)" << endl;
						break;
					}
					else{
						cout << "[" << this->cursor->data << "]->";
						this->cursor = this->cursor->next;
					}
				}
			}

		}

		// Method to print node count
		void printNodeCount(){
			cout << "\nNode Count : " << this->nodeCount << endl;
		}

		// Method to append node to linked list
		void append(int data){

			// Creating new node and allocating memory dynamically
			Node * newNode = (Node*)malloc(sizeof(Node));

			// Assigning Data to new node
			newNode->data = data;

			// Linking current node to new node
			this->currentNode->next = newNode;

			// Updating current node
			this->currentNode = newNode;

			// Incrementing Node Count
			this->nodeCount += 1;

			cout << "\nOperation : Append Node [ Success ]" << endl;
		}

		// Method to insert node at/after specific value
		void insert(int data,int value){

			if(this->head->next == NULL){
				cout << "\nLinked List Empty!" << endl;
			}
			else{
				// Placing cursor at 1st node
				this->cursor = this->head->next;

				while(1){
					if(this->cursor->data == value){
						// Storing match node in temp variable
						Node * matchNode = this->cursor;

						// Creating New Node
						Node * newNode = (Node*)malloc(sizeof(Node));

						// Assigning Data to new node
						newNode->data = data;

						// Linking new node to next node
						newNode->next = matchNode->next;

						// Linking new to match node
						matchNode->next = newNode;

						// Incrementing Node Count
						this->nodeCount += 1;

						cout << "\nOperation : Insertion [ Success ]" << endl;

						break;
					}
					else{
						if(this->cursor->next == NULL){
							cout << "\nOperation : Insertion [ Failed ]" << endl;
							cout << "No Node Match Found!" << endl;
							break;
						}
						else{
							this->cursor = this->cursor->next;
						}
					}
				}

			}
		}

		// Method to delete node with matching value
		void deleteNode(int value){
			
			if(this->head->next == NULL){
				cout <<  "\nLinked List Empty!" << endl;
			}
			else{
				// Placing Cursor at 1st node
				this->cursor = this->head;

				while(1){
					if(this->cursor->next->data == value){
						// Storing node address of node after target node
						Node * temp = this->cursor->next->next;

						// Freeing memory allocated to unlinked/deleted node
						free(this->cursor->next);

						// Linking node after deleted node to current node
						this->cursor->next = temp;

						// Decrementing Node Count
						this->nodeCount -= 1;

						cout << "\nOperation : Deletion [ Success ]" << endl;

						break;
					}
					else{
						if(this->cursor->next == NULL){
							cout << "\nOperation : Deletion [ Failed ]" << endl;
							cout << "No matching node found!";
							break;
						}
						else{
							this->cursor = this->cursor->next;
						}
					}
				}
					
			}

		}

		// Method to search matching node value
		void search(int value){

			if(this->head->next == NULL){
				cout << "\n[ Linked List Empty ]" << endl;
			}
			else{
				// Placing cursor at 1st node
				this->cursor = this->head->next;

				// Current Node Number
				int nodeNumber = 0;

				while(1){
					// If cursor node value is equal to search value
					if(this->cursor->data == value){
						cout << "\nNode with value [" << value << "], found at Node No. " << nodeNumber << endl;
						break;
					}
					else{
						if(this->cursor->next == NULL){
							cout << "\nNo Node with matching value found!" << endl;
							break;
						}
						else{
							this->cursor = this->cursor->next;
							nodeNumber += 1; 
						}
					}
				}

			}
		}
	
};

int main(){
	// Looping Condition
	bool looping = true;

	// User Option
	int option;

	// Data Input
	int data;

	// Value to find
	int find;

	// Linked List Head
	Node head;

	// Creating New Linked List Object
	Single_Linked_List * sll = new Single_Linked_List(&head);

	while(looping){

		// Linked List Operations Menu
		cout << endl;
		cout << "*****************" << endl;
		cout << "*  LINKED LIST  *" << endl;
		cout << "*****************" << endl;
		cout << "* 1. Append     *" << endl;
		cout << "* 2. Insert     *" << endl;
		cout << "* 3. Delete     *" << endl;
		cout << "* 4. Search     *" << endl;
		cout << "* 5. Display    *" << endl;
		cout << "* 6. Node Count *" << endl;
		cout << "* 0. Exit       *" << endl;
		cout << "*****************" << endl;
		cout << endl;
		cout << "Option : ";

		// User Option Input
		cin >> option;

		// Linux System Call for clearing screen
		system("clear");

		switch(option){

			// Single Linked List [ Operation ] : Node Append
			case 1:
				cout << "\nEnter Data : ";
				cin >> data;
				sll->append(data);
			break;

			// Single Linked List [ Operation ] : Node Insertion
			case 2:
				cout << "\nEnter Data : ";
				cin >> data;
				cout << "\nEnter Value Insert After : ";
				cin >> find;
				sll->insert(data,find);
			break;

			// Single Linked List [ Operation ] : Node Deletion
			case 3:
				cout << "\nEnter Node Value to Delete : ";
				cin >> find;
				sll->deleteNode(find);
			break;

			case 4:
				cout << "\nEnter Node Value to Search : ";
				cin >> find;
				sll->search(find);
			break;

			// Single Linked List 
			case 5:
				sll->display();
			break;

			case 6:
				sll->printNodeCount();
			break;

			case 0:
				cout << "[ Exiting Linked List ]" << endl;
				looping = false;
			break;

			default:
				cout << "Invalid Option! (try again)" << endl;

		}
	}

	return 0;
}