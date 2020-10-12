import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.lang.Math;
import java.util.Scanner;

//THIS CODE IS EXCEPTIONAL!
public class SparseMatrix implements SparseInterface{
	public static int n_x_n = 5;
	public static int row;
	public static int col;
    public static int data;
    public static boolean loop = true;
    public static int choice;
    public static int det = 0;
    public static Scanner scan = new Scanner(System.in);
    public static List<Integer> myList = new ArrayList<>();
    public static List<Integer> myListTemp = new ArrayList<>();
	
	public SparseMatrix(){
		
	}
	
	public void clear(){
		Collections.fill(myList, 0);
	}

    public void setSize(int size){
    	n_x_n = size;
    	
    	myList.clear();
    	
    	for (int i = 0; i < n_x_n; i++){
        	for (int j = 0; j < n_x_n; j++){
        		myList.add(0);
        	}
        }
    }

    public void addElement(int row, int col, int data){
    	int index = (row * n_x_n) + col;
    	
    	try{
    		myList.set(index, data);
    	}
    	catch (IndexOutOfBoundsException e){
    		System.out.println("ERROR: " + e.getMessage());
    	}
    }

    public void removeElement(int row, int col){
    	int index = (row * n_x_n) + col;
    	
    	try{
    		myList.set(index, 0);
    	}
    	catch (IndexOutOfBoundsException e){
    		System.out.println("ERROR: " + e.getMessage());
    	}
    }

    public int getElement(int row, int col){
    	int index = (row * n_x_n) + col;
    	
    	try{
    		return myList.get(index);
    	}
    	catch (IndexOutOfBoundsException e){
    		System.out.println("ERROR: " + e.getMessage());
    	}
    	return myList.get(index);
    }

    public int determinant(){
    	int det = 0;
    	
		if (n_x_n == 1) {
			det = myList.get(0);
			return det;
		}
		if (n_x_n == 2) {
			det = ((myList.get(0))*(myList.get(3)))-((myList.get(1))*(myList.get(2)));
			return det;
		}
		for (int i = 0; i < n_x_n; i++) {
			myListTemp = myList;

			for (int j = 1; j < n_x_n; j++) {
				for (int k = 0; k < n_x_n; k++) {

					if (k < i) {
						myListTemp.get(((j-1) * n_x_n) + k);
					} else if (k > i) {
						myListTemp.get(((j-1) * n_x_n) + (k-1));
					}
				}
			}
			det += myList.get((0 * n_x_n) + i) * (int)(Math.pow(-1, i)) * determinant();
		}
		return det;
    }

    public SparseInterface minor(int row, int col){
    	int index = (row * n_x_n) + col;
    	int indexRow = index / n_x_n;
    	int indexCol = index % n_x_n;
    	
    	for (int i = 0; i < myList.size()-1; i++){
    		if(row != indexRow && col != indexCol){
    			myListTemp.add(myList.get(i));
    		}
        }
    	
    	return (SparseInterface) myListTemp;
    }

    public String toString(){
    	return myList.toString();
    }

    public int getSize(){
    	return n_x_n;
    }
    
    public static void main(String[] args) {
        
    	// Creates the initial ArrayList with the constructed size
        for (int i = 0; i < n_x_n; i++){
        	for (int j = 0; j < n_x_n; j++){
        		myList.add(0);
        	}
        }
        
        // Prints out the matrix and menu
        while(loop) {
        	
        	for(int i = 0; i <= ((n_x_n*n_x_n)-1); i++){
        		System.out.print(myList.get(i));
        		System.out.print(" ");
        		
        		if((i+1)%n_x_n == 0){
        			System.out.println();
        		}
        	}
        	
        	// User Interface of Matrix operations
			System.out.println();
	        System.out.println("Sparse Matrix Menu");
	        System.out.println();
	        System.out.println("1 ) Clear");
	        System.out.println("2 ) Set Size");
	        System.out.println("3 ) Add Element");
	        System.out.println("4 ) Remove Element");
	        System.out.println("5 ) Get Element");
	        System.out.println("6 ) Determinant");
	        System.out.println("7 ) Minor");
	        System.out.println("8 ) toString");
	        System.out.println("9 ) Get Size");
	        System.out.println("10) Exit");
	        choice = scan.nextInt();
	        
	        // Clear
	        if(choice == 1){
	        	Collections.fill(myList, 0);
	        }
	        
	        // Set Size (int size)
	        else if(choice == 2){
	        	System.out.print("Set new (n x n) matrix size: ");
	        	n_x_n = scan.nextInt();
	        	
	        	myList.clear();
	        	
	        	for (int i = 0; i < n_x_n; i++){
	            	for (int j = 0; j < n_x_n; j++){
	            		myList.add(0);
	            	}
	            }
	        }
	        
	        // Add Element (int row, int col, int data)
	        else if(choice == 3){
	        	System.out.println("Input should be in one line and separated by spaces");
	        	System.out.print("Enter (Row, Column, Data): ");
	        	row = scan.nextInt();
	        	col = scan.nextInt();
	        	data = scan.nextInt();
	        	
	        	int index = (row * n_x_n) + col;
	        	
	        	try{
	        		myList.set(index, data);
	        	}
	        	catch (IndexOutOfBoundsException e){
	        		System.out.println("ERROR: " + e.getMessage());
	        	}
	        }
	        
	        // Remove Element (int row, int col)
	        else if(choice == 4){
	        	System.out.println("Input should be in one line and separated by spaces");
	        	System.out.print("Enter (Row, Column): ");
	        	row = scan.nextInt();
	        	col = scan.nextInt();
	        	
	        	int index = (row * n_x_n) + col;
	        	
	        	try{
	        		myList.set(index, 0);
	        	}
	        	catch (IndexOutOfBoundsException e){
	        		System.out.println("ERROR: " + e.getMessage());
	        	}
	        }
	        
	        // Get Element (int row, int col)
	        else if(choice == 5){
	        	System.out.println("Input should be in one line and separated by spaces");
	        	System.out.print("Enter (Row, Column): ");
	        	row = scan.nextInt();
	        	col = scan.nextInt();
	        	
	        	int index = (row * n_x_n) + col;
	        	
	        	try{
	        		System.out.println("The element in this position is: " + myList.get(index));
	        	}
	        	catch (IndexOutOfBoundsException e){
	        		System.out.println("ERROR: " + e.getMessage());
	        	}
	        }
	        
	        // Determinant
	        else if(choice == 6){
	        	
	        	if(n_x_n == 1){
	        		det = myList.get(0);
	        	}
	        	else if(n_x_n == 2){
	        		det = ((myList.get(0))*(myList.get(3)))-((myList.get(1))*(myList.get(2)));
	        	}
	        	else if(n_x_n > 2){
	        		for (int i = 0; i < n_x_n; i++) {
	        			myListTemp = myList;

	        			for (int j = 1; j < n_x_n; j++) {
	        				for (int k = 0; k < n_x_n; k++) {

	        					if (k < i) {
	        						myListTemp.get(((j-1) * n_x_n) + k);
	        					} else if (k > i) {
	        						myListTemp.get(((j-1) * n_x_n) + (k-1));
	        					}
	        				}
	        			}
	        			det += myList.get((0 * n_x_n) + i) * (int)(Math.pow(-1, i));
	        		}
	        	}
	        	System.out.println("The Determinant of this Matrix is: " + det);
	        }
	        
	     // Minor (int row, int col)
	        else if(choice == 7){
	        	System.out.println("Input should be in one line and separated by spaces");
	        	System.out.print("Enter (Row, Column): ");
	        	int row = scan.nextInt();
	        	int col = scan.nextInt();
	        	
	        	int index = (row * n_x_n) + col;
	        	int indexRow = index / n_x_n;
	        	int indexCol = index % n_x_n;
	        	
	        	for (int i = 0; i < myList.size()-1; i++){
	        		if(i != indexRow && i != indexCol){
	        			myListTemp.add(myList.get(i));
	        		}
	            }
	        	
	        	System.out.println();
	        	System.out.println("The minor of (" + row + "," + col + "):");
	        	
	        	for(int i = 0; i <= (((n_x_n-1)*(n_x_n-1))-1); i++){
	        		System.out.print(myListTemp.get(i));
	        		System.out.print(" ");
	        		
	        		if((i+1)%(n_x_n-1) == 0){
	        			System.out.println();
	        		}
	        	}
	        	
	        }
	        
	        // toString
	        else if(choice == 8){
	        	List<String> strings = Arrays.asList(myList.toString().replaceAll("\\[(.*)\\]", "$1").split(", "));
	        	for(int i = 0; i <= ((n_x_n*n_x_n)-1); i++){
	        		System.out.print(strings.get(i));
	        		System.out.print(" ");
	        		
	        		if((i+1)%n_x_n == 0){
	        			System.out.println();
	        		}
	        	}
	        }
	        
	        // Get Size
	        else if(choice == 9){
	        	System.out.println("The size of this Matrix is " + n_x_n + " x " + n_x_n);
	        }
	        
	        // Quit
	        else if(choice == 10){
	        	System.out.println("You've exited out of the Sparse Matrix Menu!");
	        	loop = false;
	        }
	        System.out.println();
        }
        
    }
    
}
