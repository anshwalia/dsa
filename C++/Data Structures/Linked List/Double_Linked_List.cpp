// Title : Double Linked List Implementation Using C++
// Author : Ansh Walia <anshwalia@outlook.com>
// Date Created : 22/07/2020 

#include <iostream>
#include <stdlib.h>

using namespace std;

// Node Structure
struct Node{
	Node * prev = NULL;
	int data = 0;
	Node * next = NULL;
};

// Double Linked List Class
class Double_Linked_List
{
	private:
		// Node Pointers
		Node * head = NULL;
		Node * tail = NULL;
		Node * cursor = NULL;

		// Node Counter
		int nodeCount = 0;

	public:
		// Class Constructor
		Double_Linked_List(Node * head){
			this->head = head;
			this->tail = head;
		}

		// Method to check if linked list is empty
		bool isEmpty(){
			if(this->head->next == NULL){
				return true;
			}
			else{
				return false;
			}
		}

		// Method to display current node count
		void displayNodeCount(){
			cout << "\nLinked List Node Count : " << this->nodeCount << endl;
		}

		// Method to display complete linked list forwards
		void displayForward(){
			if(this->isEmpty()){
				cout << "\n[ Linked List Empty ]" << endl;
			}
			else{
				this->cursor = this->head->next;

				cout << "\nLinked List : (Head)";

				while(true){
					
					cout << "->[" << this->cursor->data << "]";
					
					if(this->cursor->next == NULL){
						break;
					}
					else{
						this->cursor = this->cursor->next;
					}
				}

				cout << "->(Tail)" << endl;
			}
		}

		// Method to display complete linked list backwards
		void displayBackward(){
			if(this->isEmpty()){
				cout << "\n[ LINKED LIST EMPTY ]" << endl;
			}
			else{
				this->cursor = this->tail;

				cout << "\nLinked List : (Tail)";
				while(true){
					cout << "<-[" << this->cursor->data << "]";
					if(this->cursor->prev == this->head){
						cout << "<-(Head)" << endl;
						break;
					}
					else{
						this->cursor = this->cursor->prev;
					}
				}
			}
		}

		//Method to append new node to linked list
		void append(int data){
			// Creating New Node
			Node * newNode = (Node*)malloc(sizeof(Node));

			// Assigning data to new node
			newNode->data = data;

			// Linking Current Node to new node
			this->tail->next = newNode;

			// Linking New Node back to current node
			newNode->prev = this->tail;

			// Making new node as tail
			this->tail = newNode;

			// Incrementing Node Count
			this->nodeCount += 1;

			// Success Message
			cout << "\nOperation : Append [ Success ]" << endl;
		}

		// Method to insert node at beginning of linked list
		void insert(int data){
			// Creating New Node
			Node * newNode = (Node*)malloc(sizeof(Node));
			// Assigning Data to new node
			newNode->data = data;

			if(this->isEmpty()){
				// Linking Head with New Node
				this->head->next = newNode;
				newNode->prev = this->head;

				// Making Tail as New Node
				this->tail = newNode;
			}
			else{
				// Cursor = 1st Node in Linked List
				this->cursor = this->head->next;

				// Linking Head with New Node
				this->head->next = newNode;
				newNode->prev = this->head;

				// Linking Current Cursor Node with New Node
				newNode->next = this->cursor;
				this->cursor->prev = newNode;
			}


			// Incrementing Node Count
			this->nodeCount += 1;

			cout << "\nOperation : Insertion [ Success ]" << endl;
		}

		// Method to insert new node after a node with specific data value
		void inserAfter(int data,int value){
			if(this->isEmpty()){
				cout << "\n[ LINKED LIST EMPTY ]" << endl;
			}
			else{
				// Cursor = 1st Node in Linked List
				this->cursor = this->head->next;

				// Search Loop
				while(true){
					if(this->cursor->data == value){
						// NEW NODE CREATION
						Node * newNode = (Node*)malloc(sizeof(Node));
						newNode->data = data;

						newNode->prev = this->cursor;

						if(this->cursor->next != NULL){
							newNode->next = this->cursor->next;

							Node * temp = this->cursor->next;

							this->cursor->next = newNode;

							temp->prev = newNode;	
						}
						else{
							this->cursor->next = newNode;

							this->tail = newNode;
						}

						this->nodeCount += 1;

						cout << "\nOperation : Insert After [ Success ]" << endl;

						break;
					}
					else{
						if(this->cursor->next == NULL){
							cout << "\nOperation : Insert After [ Failed ]" << endl;
							cout << "Not Matching Value Found!" << endl;
							break;
						}
						else{
							this->cursor = this->cursor->next;
						}
					}
				}
			}
		}


		// Method to delete a node with specific value
		void deleteNode(int value){
			if(this->isEmpty()){
				cout << "\n[ LINKED LIST EMPTY ]" << endl;
			}
			else{
				this->cursor = this->head;

				while(true){
					if(this->cursor->next->data == value){
						if(this->cursor->next->next == NULL){
							free(this->cursor->next);
							this->cursor->next = NULL;
							this->tail = this->cursor;
						}
						else{
							Node * temp = this->cursor->next->next;

							free(this->cursor->next);

							// Linking Current node while skippin
							this->cursor->next = temp;
							temp->prev = this->cursor;
						}
					}
					else{
						if(this->cursor->next == NULL){
							cout << "\nOperation : Delete [ Failed ]" << endl;
						}
						else{
							this->cursor = this->cursor->next;
						}
					}
				}
			}
		}

};

// Main Function
int main(){
	// Creating Linked List Head Node
	Node head;

	// Creating New Double Linked List
	Double_Linked_List * dll = new Double_Linked_List(&head);

	// Program Menu Variables
	bool looping = true;
	int option;

	// Program Data Variables
	int data;
	int find;

	// MENU
	while(looping){

		// MENU Display
		cout << endl;
		cout << "**********************" << endl;
		cout << "* DOUBLE LINKED LIST *" << endl;
		cout << "**********************" << endl;
		cout << "* 1.Append           *" << endl;
		cout << "* 2.Insert           *" << endl;
		cout << "* 3.Insert After     *" << endl;
		cout << "* 4.Delete           *" << endl;
		cout << "* 5.Delete Last      *" << endl;
		cout << "* 6.Display Forward  *" << endl;
		cout << "* 7.Display Backward *" << endl;
		cout << "* 8.Node Count       *" << endl;
		cout << "*--------------------*" << endl;
		cout << "* 0.Exit             *" << endl;
		cout << "**********************" << endl;
		cout << endl;

		cout << "Option : ";
		cin >> option;

		// Linux System Call for Clearing the Screen
		system("clear");

		// MENU Option Switching
		switch(option){

			case 1:
				cout << "\nEnter Data : ";
				cin >> data;
				dll->append(data);
			break;

			case 2:
				cout << "\nEnter Data : ";
				cin >> data;
				dll->insert(data);
			break;

			case 3:
				cout << "\nEnter Value to Insert After : ";
				cin >> find;
				cout << "\nEnter Data : ";
				cin >> data;
				dll->inserAfter(data,find);
			break;

			case 6:
				dll->displayForward();
			break;

			case 7:
				dll->displayBackward();
			break;

			case 8:
				dll->displayNodeCount();
			break;

			case 0:
				cout << "\n[ EXITING ]" << endl;
				looping = false;
			break;

			default:
				cout << "\n[ INVALID OPTION ]" << endl;
				cout << "-> Try Again" << endl;

		}

	}

	return 0;
}