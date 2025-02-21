package com.datastructuresproject1;

public class DistrictNode {
	// Attributes of DistrictNode
    private Object element;
    private DistrictNode prev, next;
    private LocationLinkedList head;

    // Constructor with parameters
    public DistrictNode(Object element, DistrictNode next) {
        this.element = element;
        this.next = next;
    }
    
    // Constructor with parameters
    public DistrictNode(Object element) {
        this(element, null, null, null);
    }

    // Constructor with parameters	
    public DistrictNode(Object element, DistrictNode prev, DistrictNode next, LocationLinkedList head) {
        this.element = element;
        this.prev = prev;
        this.next = next;
        this.head = head;
    }

    // Getter method for retrieving the element
    public Object getElement() {
        return element;
    }
    
    // Setter method for setting the element
    public void setElement(Object element) {
        this.element = element;
    }

    // Getter method for retrieving the previous
    public DistrictNode getPrev() {
        return prev;
    }

 	// Setter method for setting the previous
    public void setPrev(DistrictNode prev) {
        this.prev = prev;
    }

    // Getter method for retrieving the next
    public DistrictNode getNext() {
        return next;
    }

    // Setter method for setting the next
    public void setNext(DistrictNode next) {
        this.next = next;
    }

    // Getter method for retrieving the head
    public LocationLinkedList getHead() {
        return head;
    }

    // Setter method for setting the head
    public void setHead(LocationLinkedList head) {
        this.head = head;
    }

    // Override toString method to provide a meaningful string representation of the
 	// DistrictNode object
    @Override
    public String toString() {
        return "Node [element=" + element + ", prev=" + prev + ", next=" + next + ", head=" + head + "]";
    }
}
