// Title : Queue Implementation Using C++
// Author : Ansh Walia <anshwalia@outlook.com>
// Date Created : 27/07/2020

#include <iostream>
#include <stdlib.h>

using namespace std;

// Queue Class
class Queue{

	private:
		int * queue;
		int queueSize;
		int front;
		int rear;
		int data;

	public:
		// Class Constructor
		Queue(int size){
			// Allocating Memory Dynamically to Queue
			this->queue = (int*)malloc(size * sizeof(int));
			this->queueSize = size;
			this->front = -1;
			this->rear = -1;
			this->data = 0;
		}

		// Methods

		// Method to check is queue is empty
		bool isEmpty(){
			return ((this->front > this->rear) || (this->front == -1)) ? true : false;
		}

		// Method to check if queue is Full
		bool isFull(){
			return (this->rear >= (this->queueSize-1)) ? true : false;
		}

		// Method to get data
		int getData(){
			return this->data;
		}

		// Method to display queue
		void displayQueue(){
			if(this->isEmpty()){
				cout << "\n[ QUEUE IS EMPTY ]\n" << endl;
			}
			else{
				cout << "\nQueue : (Front)-";
				for(int i = this->front; i <= this->rear; i++){
					if(i == this->rear){
						cout << "[" << this->queue[i] << "]-(Rear)\n" << endl;
					}
					else{
						cout << "[" << this->queue[i] << "]<-";
					}
				}
			}
		}

		// Method to add element to queue
		void enqueue(int data){
			if(this->isFull()){
				cout << "\n[ QUEUE IS FULL ]\n" << endl;
			}
			else{
				this->queue[++this->rear] = data;

				if(this->rear == 0){
					this->front = 0;
				}

				cout << "\nOperation : Enqueue [ Success ]\n" << endl;
			}
		}

		// Method to remove element from queue
		bool dequeue(){
			if(this->isEmpty()){
				cout << "\n[ QUEUE IS EMPTY ]\n" << endl;
				return false;
			}
			else{
				this->data = this->queue[this->front++];
				return true;
			}
		}

		// Method to peek element at front of queue
		bool peek(){
			if(this->isEmpty()){
				cout << "\n[ QUEUE IS EMPTY ]\n" << endl;
				return false;
			}
			else{
				this->data = this->queue[this->front];
				return true;
			}
		}

		// Method to reset queue
		void reset(){
			this->front = -1;
			this->rear = -1;
			this->data = 0;
			cout << "\nOperation : Reset [ Success ]\n" << endl;
		}

		// Method to free allocated memory to queue
		void freeMemory(){
			free(this->queue);
		}
};


int main(){
	// Program Variables
	bool looping = true;
	int size;
	int option;
	int data;

	// User Input : Queue Size
	cout << "\nEnter Queue Size : ";
	cin >> size;

	// Creating New Queue Object
	Queue * q = new Queue(size);

	// Program Loop
	while(looping){

		// Queue Menu
		cout << endl;
		cout << "******************" << endl;
		cout << "*      QUEUE     *" << endl;
		cout << "******************" << endl;
		cout << "* 1. Enqueue     *" << endl;
		cout << "* 2. Dequeue     *" << endl;
		cout << "* 3. Peek        *" << endl;
		cout << "* 4. Display     *" << endl;
		cout << "* 5. Check Empty *" << endl;
		cout << "* 6. Check Full  *" << endl;
		cout << "* 7. Reset       *" << endl;
		cout << "******************" << endl;
		cout << "* 0. EXIT        *" << endl;
		cout << "******************" << endl;
		cout << endl;

		cout << "Option : ";
		cin >> option;

		// Linux System Call : Clear Screen
		system("clear");

		switch(option){

			case 1:
				cout << "\nEnter Data : ";
				cin >> data;
				q->enqueue(data);
			break;

			case 2:
				if(q->dequeue()){
					cout << "Element Dequeued : " << q->getData() << "\n" << endl;
				}
			break;

			case 3:
				if(q->peek()){
					cout << "Front Element : " << q->getData() << "\n" << endl;
				}
			break;

			case 4:
				q->displayQueue();
			break;

			case 5:
				if(q->isEmpty()){
					cout << "\n[ QUEUE IS EMPTY ]\n" << endl;
				}
				else{
					cout << "\n[ QUEUE IS NOT EMPTY ]\n" << endl;
				}
			break;

			case 6:
				if(q->isFull()){
					cout << "\n[ QUEUE IS FULL ]\n" << endl;
				}
				else{
					cout << "\n[ QUEUE IS NOT FULL ]\n" << endl;
				}
			break;

			case 7:
				q->reset();
			break;

			case 0:
				q->freeMemory();
				cout << "\n[ EXITING ]\n" << endl;
				looping = false;
			break;

			default:
				cout << "\n[ INVALID OPTION ]\n" << endl;
		}
	}

	return 0;
}