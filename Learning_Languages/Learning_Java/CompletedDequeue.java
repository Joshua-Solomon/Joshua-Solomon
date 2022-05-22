package edu.ser222.m01_03;

import java.util.NoSuchElementException;

/**
* This program provides an implementation of the Deque interface. Also provides a main that
* demonstrates it.
* 
* @author Scotty Solomon
* @version 1.0.1
*/

/* Sample Output:
Adding e, f, g, h...
h g f e 
Size: 4
Adding a, b, c, d...
    Forwards: a b c d e f g h 
    Backwards: h g f e d c b a 
Size: 8
Removing the first two letters...
h g f e d c 
Size: 6
Removing the last two letters...
f e d c 
Size: 4

Removing elements to test errors...
e d c 
Size: 3
d c 
Size: 2
d 
Size: 1
empty
Size: 0

Testing dequeBack() exception...
java.util.NoSuchElementException: Tried to remove from empty queue
Success!
Testing dequeFront() exception...
java.util.NoSuchElementException: Tried to remove from empty queue
Success!

Trying to find any remaining bugs...
contents:
1 1 1 1 1 
Removing all...
contents:
empty
contents:
empty

Testing Extreme Cases
contents:
null null 
*/

public class CompletedDeque<Item> implements Deque<Item> {

	private DoubleLinearNode<Item> head;
	private DoubleLinearNode<Item> tail;
	private int n;

	public CompletedDeque() {
	   head = tail = null;
	   n = 0;
	}
   
	@Override
	public void enqueueFront(Item element) {
		DoubleLinearNode<Item> temp = new DoubleLinearNode<Item>(element);
		if(isEmpty()) {
			head = tail = temp;
		}
		else {
			temp.setNext(head);
			head.setPrevious(temp);
			head = temp;
		}
		n++;
		
	}	

	@Override
	public void enqueueBack(Item element) {
		DoubleLinearNode<Item> temp = new DoubleLinearNode<Item>(element);
		if(isEmpty()) {
			head = tail = temp;
		}
		else {
			try {
			tail.setNext(temp);
			temp.setPrevious(tail);
			tail = temp;
			}
			catch(Exception e) {
				System.out.println("EndqueueBack issue");
			}
		}
		n++;
	}

	@Override
	public Item dequeueFront() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("Tried to remove from empty queue");
		}
		
		Item result = head.getElement();
		
		if(n == 1){
			tail.setPrevious(null);
			head = tail;
		}
		else {
			head = head.getNext();
			head.setPrevious(null);
			System.out.println("DequeueFront issue");
		}
		
		n--;
		
		if(isEmpty()) {
			tail = head = null;
		}
		
		return result;
	}

	@Override
	public Item dequeueBack() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("Tried to remove from empty queue");
		}
		
		Item result = tail.getElement();
		
		if(n == 1) {
			head = tail = null;
		}
		else {
			tail = tail.getPrevious();
			tail.setNext(null);
		}
		
		n--;
		
		if(isEmpty()) {
			tail = head = null;
		}
		
		return result;
	}

	@Override
	public Item first() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("The queue was already empty");
		}
		return head.getElement();
	}

	@Override
	public Item last() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("The queue was already empty");
		}
		
		return tail.getElement();
	}

	@Override
	public boolean isEmpty() {
		return (n == 0);
	}

	@Override
	public int size() {
		return n;
	}
	
	@Override
	public String toString() {
		if(isEmpty()) {
			return "empty";
		}
		
		DoubleLinearNode<Item> curr = tail;
		String ret = "";
		
		while(curr != null) {
			ret += curr.getElement() + " ";
			curr = curr.getPrevious();
		}
		
		return ret;
	}
	
	public String toStringFTB() {
		if(isEmpty()) {
			return null;
		}
		
		DoubleLinearNode<Item> curr = head;
		String ret = "";
		
		while(curr != null) {
			ret += curr.getElement() + " ";
			curr = curr.getNext();
		}
		
		return ret;
	}
	
	public class DoubleLinearNode<T> {
	    private DoubleLinearNode<T> next;
	    private DoubleLinearNode<T> previous;
	    private T element;
	 
	    public DoubleLinearNode() {
	        next = null;
	        previous = null;
	        element = null;
	    }
	 
	    public DoubleLinearNode(T elem) {
	        next = null;
	        previous = null;
	        element = elem;
	    }
	 
	    public DoubleLinearNode<T> getNext() {
	        return next;
	    }
	 
	    public void setNext(DoubleLinearNode<T> node) {
	        next = node;
	    }
	    
	    public DoubleLinearNode<T> getPrevious(){
	    	return previous;
	    }
	    
	    public DoubleLinearNode<T> getdPrevious(){
	    	return previous.getdPrevious();
	    }
	    
	    public void setPrevious(DoubleLinearNode<T> node) {
	    	previous = node;
	    }
	 
	    public T getElement() {
	        return element;
	    }
	 
	    public void setElement(T elem) {
	        element = elem;
	    }
	}
	
	public static void main(String[] args) {
		CompletedDeque<String> d1 = new CompletedDeque<>();
	      
		System.out.println("Adding e, f, g, h...");
		d1.enqueueBack("e");
	  	d1.enqueueBack("f");
	  	d1.enqueueBack("g");
	  	d1.enqueueBack("h");  
	 	System.out.println(d1.toString());
	 	System.out.println("Size: " + d1.size());
	      
	 	System.out.println("Adding a, b, c, d...");
	   	d1.enqueueFront("d");
	   	d1.enqueueFront("c");
	   	d1.enqueueFront("b");
	   	d1.enqueueFront("a");
	   	System.out.println("    Forwards: " + d1.toStringFTB());
	   	System.out.println("    Backwards: " + d1.toString());
	   	System.out.println("Size: " + d1.size());
	      
	   	System.out.println("Removing the first two letters...");
	   	d1.dequeueFront();
	   	d1.dequeueFront();
	   	System.out.println(d1.toString());
	   	System.out.println("Size: " + d1.size());
	      
	   	System.out.println("Removing the last two letters...");
	   	d1.dequeueBack();
	   	d1.dequeueBack();
	   	System.out.println(d1.toString());
	   	System.out.println("Size: " + d1.size());
	      

	    	System.out.println("\nRemoving elements to test errors...");
	    	d1.dequeueBack();
	    	System.out.println(d1.toString());
	    	System.out.println("Size: " + d1.size());
		      
	    	d1.dequeueBack();
	  	System.out.println(d1.toString());
		System.out.println("Size: " + d1.size());
		      
		d1.dequeueFront();
		System.out.println(d1.toString());
		System.out.println("Size: " + d1.size());
		
		//size() == 0
		d1.dequeueFront();
		System.out.println(d1.toString());
		System.out.println("Size: " + d1.size());
			
		try {     
			System.out.println("\nTesting dequeBack() exception...");
			d1.dequeueBack();
		}
		catch(NoSuchElementException e) {
			System.out.println(e.toString());
			System.out.println("Success!");
		}
		catch(Exception e) {
			System.out.println(e.toString());
			System.out.println("Hmm, something's wrong...");
		}
		
		try {     
			System.out.println("Testing dequeFront() exception...");
			d1.dequeueFront();
		}
		catch(NoSuchElementException e) {
			System.out.println(e.toString());
			System.out.println("Success!");
		}
		catch(Exception e) {
			System.out.println(e.toString());
			System.out.println("Hmm, something's wrong...");
		}
		
		
		
        
        	System.out.println("\nTrying to any other find bugs...");
		CompletedDeque<Integer> debug = new CompletedDeque<Integer>();
		debug.enqueueFront(1);
		debug.enqueueFront(1);
		debug.enqueueFront(1);
		debug.enqueueFront(1);
		debug.enqueueFront(1);
		System.out.println("contents:\n" + debug.toString()); 
        
		System.out.println("Removing all...");
		debug.dequeueBack();
		debug.dequeueBack();
		debug.dequeueBack();
		debug.dequeueBack();
		debug.dequeueBack();
		System.out.println("contents:\n" + debug.toString());

		System.out.println("\nTesting Extreme Cases");
		debug.enqueueBack(null);
		debug.enqueueFront(debug.first());
		System.out.println("contents:\n" + debug.toString());
		}
} 
