import java.util.Scanner;
 
//Class Node
class Node {
    public int data;
    public int row;
    public int col;
    public Node node;
 
//Constructor
    public Node() {
    	node = null;
        data = 0;
        row = 5;
        col = 5;
        col = row;
    }    
//Constructor
    public Node(int d,Node n,int r, int c) {
        data = d;
        node = n;
        row = r;
        col = c;
        
    }    
//Function to set link to next Node
    public void setNode(Node n) {
    	node = n;
    }    
//Function to set data to current Node
    public void setData(int d) {
        data = d;
    }
//Function to set link to next Node
    public void setRow(int r) {
    	row = r;
    }    
//Function to set data to current Node
    public void setCol(int c) {
        col = c;
    }
//Function to get link to next node
    public Node getNode() {
        return node;
    }    
//Function to get data from current Node
    public int getData() {
        return data;
    }
//Function to get link to next node
    public int getRow() {
        return row;
    }    
//Function to get data from current Node
    public int getCol() {
        return col;
    }
}
 
//Class linkedList
class linkedList {
    public Node start;
    public Node end ;
    public int size ;
 
//Constructor
    public linkedList() {
        start = null;
        end = null;
        size = 0;
    }
//Function to check if list is empty
    public boolean isEmpty() {
        return start == null;
    }
//Function to get size of list
    public int getSize() {
        return size;
    }    
//Function to insert an element at beginning
    public void insertAtStart(int value) {
        Node nptr = new Node(value, null, value, value); //(value, null)
        size++;    
        if(start == null) {
            start = nptr;
            end = start;
        }
        else {
            nptr.setNode(start);
            start = nptr;
        }
    }
//Function to insert an element at end
    public void insertAtEnd(int value) {
        Node nptr = new Node(value,null, value, value); //(value, null)
        size++ ;    
        if(start == null) {
            start = nptr;
            end = start;
        }
        else {
            end.setNode(nptr);
            end = nptr;
        }
    }
//Function to insert an element at position
    public void insertAtPosition(int value, int position) {
        Node nptr = new Node(value, null, position, position); //(value, null)
        Node ptr = start;
        position = position - 1 ;
        for (int i = 1; i < size; i++) {
            if (i == position) {
                Node temp = ptr.getNode() ;
                ptr.setNode(nptr);
                nptr.setNode(temp);
                break;
            }
            ptr = ptr.getNode();
        }
        size++ ;
    }
//Function to delete an element at position
    public void deleteAtPosition(int position) {        
        if (position == 1) {
            start = start.getNode();
            size--; 
            return ;
        }
        if (position == size) {
            Node head = start;
            Node tail = start;
            while (head != end) {
                tail = head;
                head = head.getNode();
            }
            end = tail;
            end.setNode(null);
            size --;
            return;
        }
        Node ptr = start;
        position = position - 1 ;
        for (int i = 1; i < size - 1; i++) {
            if (i == position) {
                Node temp = ptr.getNode();
                temp = temp.getNode();
                ptr.setNode(temp);
                break;
            }
            ptr = ptr.getNode();
        }
        size-- ;
    }    
//Function to display elements
    public void display() {
        System.out.print("\nSingly Linked List = ");
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }    
        if (start.getNode() == null) {
            System.out.println(start.getData() );
            return;
        }
        Node ptr = start;
        System.out.print(start.getData()+ "->");
        ptr = start.getNode();
        while (ptr.getNode() != null) {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getNode();
        }
        System.out.print(ptr.getData()+ "\n");
    }
    
    public void matrix(int value, int row, int col, int rowPosition, int colPosition) {
    	for(int i = 0; i <= row - 1; i++){
			for(int j = 0; j <= col - 1; j++){
				System.out.print(value + " ");
				//System.out.print(col);
			}
			System.out.println();
		}
    }
}
 
//Class SinglyLinkedList
public class SinglyLinkedList {    
    public static void main(String[] args) {             
        Scanner scan = new Scanner(System.in);

        //Creating object of class linkedList
        linkedList list = new linkedList(); 
        System.out.println("Singly Linked List Test\n");          
        char ch;

        //Perform list operations
        do {
        	int rowPosition = 0;
            int colPosition = 0;
            list.matrix(0, 5, 5, 0, 0);
        	
            System.out.println("\nMatrix Linked List Operations\n");
            System.out.println("1. clear"); //insert at begin
            System.out.println("2. set size"); //insert at end
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. get element"); //check empty
            System.out.println("6. get size");            
            int choice = scan.nextInt();    
            
            switch (choice) {
            case 1 : 
                System.out.println("Enter integer element to insert");
                list.insertAtStart( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to insert");
                list.insertAtEnd( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to insert");
                int num = scan.nextInt() ;
                System.out.println("Enter position");
                int pos = scan.nextInt() ;
                if (pos <= 1 || pos > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.insertAtPosition(num, pos);
                break;                                          
            case 4 : 
                System.out.println("Enter position");
                int p = scan.nextInt() ;
                if (p < 1 || p > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.deleteAtPosition(p);
                break;
            case 5 : 
                System.out.println("Empty status = "+ list.isEmpty());
                break;                   
            case 6 : 
                System.out.println("Size = "+ list.getSize() +" \n");
                break;                         
             default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
//Display List
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
}