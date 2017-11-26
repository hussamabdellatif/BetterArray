import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public class BetterArray {
	private Node head;
	
	
	
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	private Node tail; 
	private int size;
	
	
	class Node{
		
		private int data;
		private Node next;
		
		public Node(){
			this.data = 0;
			this.next = null;
		}
		
		public Node(int data, Node next){
			this.data= data;
			this.next = next;
		}
		
		public Node (int data){
			this.data = data;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		
		
	}
	
	
	class LinkedListIterator implements Iterator<Integer>{
		 private Node previous;
		 private Node current;
		 private Node previous2;
		 private boolean removeCalled;
		 public LinkedListIterator(){
			current = head; 
			previous = null;
			previous2= null;
			removeCalled= false;
		 }
		 public Integer next(){
			 if (current == null){
				 throw new NoSuchElementException();
			 }
			 int temp = current.getData();
			 previous2 = previous;
			 previous = current;
			 current = current.getNext();
			 removeCalled = false;
			 return temp;
		 }
		 public boolean hasNext(){
			 return current!=null;
		 }
		 public void remove(){
			 if (previous == null || removeCalled){
				 throw new IllegalStateException();
			
			 }
			 if (previous2 == null ){
				head = current; 
			 }else{
				 previous2.setNext(current);
			 }
			 size--;
			 removeCalled= true;
		 }
		
	 }
	
	public int size(){
		return getSize();
	}
	public BetterArray (int n){
		this.head = null; 
		this.tail= null;
		this.size = 0;
	}
	public boolean isEmpty(){
		return this.head == null;
	}
	
	
	
	
	public int  get( int index){
		if (index <0){
			throw new IndexOutOfBoundsException();
		}
		
		if (index> size()-1){
			return 0;
		}
		
		
		if (index < size()-1){
			Node current  = getHead() ;
			for (int i=0; i<index; i++){
				current = current.getNext();
			}
			
			return current.getData();
		}
		
		return tail.getData();
	}
	
	public void clear(){
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	
	public void put(int value){
		
		if (isEmpty()){
			head = new Node (value, null);
			tail = head;
		}else{
			tail.setNext(new Node (value, null));
			tail = tail.getNext();
		}
		
		size++;
		
	}
	
	
	public void delete (int index){
		Node current = head;
		for (int i=0; i<index-2; i++){
			current = current.getNext();
		}
		
		current.setNext(new Node (current.getNext().getNext().getData(), current.getNext().getNext().getNext()));
		
	}
	
	
	
	
	public void sort(BetterArray list){
		
	        Node current = head;
	        String line = null;
	        while (line == null) {
	            
	        	line = "";
	            while (current != null) {
	                
	            	if (current.getNext() != null && current.getData() > current.getNext().getData()) {
	                    int holdCurrentNode = current.getData();
	                    current.setData((current.getNext().getData()));
	                    current.getNext().setData((holdCurrentNode));
	                    line = null;
	                }
	                current = current.getNext();
	            }
	            current = head;
	        
	    } 
		
		
		 
	}
	
	
	public void insert (int value , int index){
		if (index< 0){
			throw new IndexOutOfBoundsException();
		}
		if (index == size()){
			put (value);
			return;
		}
		
		if (index ==0){
			head = new Node (value, head);
		}else{
			Node current = head;
			for (int i=0; i<index-3; i++){
				current = current.getNext();
			}
			current.setNext(new Node (value, current.getNext()));
		}
		size++;
	}

	
	public void put (int value , int index){
		if (index< 0){
			throw new IndexOutOfBoundsException();
		}
		if (index == size()){
			put (value);
			return;
		}
		
		if (index ==0){
			head = new Node (value, head);
		}else{
			Node current = head;
			for (int i=0; i<index-1; i++){
				current = current.getNext();
			}
			current.setNext(new Node (value, current.getNext()));
		}
		size++;
	}
	
	
}
